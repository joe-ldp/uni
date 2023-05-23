using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Windows.Forms;

namespace SECM_Meeting_Scheduler
{
    public partial class MeetingScheduler : Form
    {
        private string[] times; // an array of time names for logic purposes
        private List<Meeting> meetings; // the main list of meetings
        private Location[] locations; // the main array of locations (rooms)
        private Meeting pendingMeeting; // variable to store pending meeting

        public MeetingScheduler()
        {
            InitializeComponent();
        }

        #region EVENTS

        private void MeetingScheduler_Load(object sender, EventArgs e)
        {
            // initialise a bunch of locations...
            locations = new Location[5];

            locations[0] = new Location("Cantor 9234",                     1,  true);
            locations[1] = new Location("Cantor 9235",                     2, false);
            locations[2] = new Location("Cantor 9128",                     3,  true);
            locations[3] = new Location("Dorothy Fleming Lecture Theatre", 4,  true);
            locations[4] = new Location("Charles Street 123 ",             5, false);

            // ... and add them to the appropriate checked list box
            foreach (Location loc in locations)
            {
                cbMeetingLocation.Items.Add(loc);
            }

            // initialise the array of times
            times = new string[] { "9 am", "10 am", "11 am", "12 pm", "1 pm", "2 pm", "3 pm", "4 pm" };

            // initialise list of meetings
            meetings = new List<Meeting>();

            // create some example/default meetings
            meetings.Add(new Meeting(1, "Meeting 1", "1", locations[0], new Participant[3],  new List<int>() { 0, 1 },    new List<int>() { 3, 4 },    "9 am", false));
            meetings.Add(new Meeting(2, "Meeting 2", "2", locations[2], new Participant[5],  new List<int>() { 1, 4, 5 }, new List<int>() { 0, 2, 3 }, "10 am", true));
            meetings.Add(new Meeting(3, "Lecture 1", "4", locations[3], new Participant[20], new List<int>() { 3, 4 },    new List<int>() { 6, 7 },    "12 pm", true));

            // update the list of meetings in the form
            updateMeetingList();
        }

        private void btnBookMeeting_Click(object sender, EventArgs e)
        {
            // when the "book meeting" button is pressed
            // if the meeting details on the right are not already visible...
            if (gbMeetingDetails.Visible == false)
            {
                // ... make them visible, and reset the form (to book a new meeting)
                clearForm();
                gbMeetingDetails.Visible = true;
                btnBookMeeting.Text = "Confirm Meeting";
            }
            else
            {
                // ... but if they're already visible, this means we're already...
                // ... in the process of creating or editing a meeting, so save it!

                // create a new meeting object based on the info the user has selected
                pendingMeeting = new Meeting
                (
                    meetings.Last().ID + 1,
                    txtMeetingName.Text,
                    (string)cbMeetingImportance.SelectedItem,
                    (Location)cbMeetingLocation.SelectedItem,
                    new Participant[lbMeetingParticipants.Items.Count],
                    clbPreferenceSlots.CheckedIndices.Cast<int>().ToList(),
                    clbExclusionSlots.CheckedIndices.Cast<int>().ToList(),
                    txtMeetingTime.Text,
                    cbNeedProjector.Checked
                );

                // add the new meeting
                addMeeting(pendingMeeting);
            }
        }

        private void btnEditMeeting_Click(object sender, EventArgs e)
        {
            if (lbMeetings.SelectedItem != null)
            {
                //lbMeetings.ClearSelected();

                // Show the meeting details on the right
                gbMeetingDetails.Visible = true;

                // Get the meeting object from the listbox and remove it, so we can easily re-add once done editing
                Meeting m = (Meeting)lbMeetings.SelectedItem;
                meetings.Remove(m);

                // load the meeting info into the form
                loadMeetingIntoForm(m);
                // wait for a sec then...
                this.BeginInvoke(new Action(() =>
                {
                    // change the btn text
                    btnBookMeeting.Text = "Confirm Meeting";
                }));
            }
        }

        private void btnCancelMeeting_Click(object sender, EventArgs e)
        {
            if (lbMeetings.SelectedItem != null)
            {
                // clear the form,
                clearForm();
                // hide the meeting details,
                gbMeetingDetails.Visible = false;
                // remove the meeting from the list,
                meetings.Remove((Meeting)lbMeetings.SelectedItem);
                // and update it
                updateMeetingList();
            }

        }

        private void clbPreferenceSlots_ItemCheck(object sender, EventArgs e)
        {
            // user updated their preferred times; check to see they don't clash with excluded times

            // BeginInvoke is used to make sure the method runs AFTER form properties are updated, so we get the new values
            this.BeginInvoke(new Action(() =>
            {
                checkExclusionClash();
            }));
        }
        
        private void clbExclusionSlots_ItemCheck(object sender, EventArgs e)
        {
            // user updated their excluded times; check to see they don't clash with preferred times

            // BeginInvoke is used to make sure the method runs AFTER form properties are updated, so we get the new values
            this.BeginInvoke(new Action(() =>
            {
                checkExclusionClash();
            }));
        }

        private void btnAmendTimes_Click(object sender, EventArgs e)
        {
            bool success = false; // tracks whether the amendment is successful

            foreach (Meeting meeting in meetings) // iterate through existing meetings
            {
                if (meeting.location == pendingMeeting.location) // check existing locations against proposed location
                {
                    if (meeting.time == pendingMeeting.time) // check existing times against proposed time
                    {
                        if (meeting.importance > pendingMeeting.importance) // if the existing meeting is more important...
                        {
                            success = pendingMeeting.FindNewTime(); // ... the new meeting has to budge over and find a new spot
                            loadMeetingIntoForm(pendingMeeting); // load the edited meeting back into the form
                        }
                        else
                        {
                            success = meeting.FindNewTime(); // ... if not, the existing meeting has to move
                            updateMeetingList(); // update the list to show any change
                        }
                    }
                }
            }

            if (success)
            {
                // we have resolved the problem, so hide the warnings
                lblMeetingClash.Visible = false;
                btnAmendTimes.Visible = false;
                btnAmendRoom.Visible = false;
            }
        }

        private void btnAmendRoom_Click(object sender, EventArgs e)
        {
            bool success = false; // tracks whether the amendment is successful

            foreach (Meeting meeting in meetings) // iterate through existing meetings
            {
                if (meeting.location == pendingMeeting.location) // check existing locations against proposed location
                {
                    if (meeting.time == pendingMeeting.time) // check existing times against proposed time
                    {
                        if (meeting.importance > pendingMeeting.importance) // if the existing meeting is more important...
                        {
                            success = pendingMeeting.FindNewLocation(locations); // ... the new meeting has to budge over and find a new spot
                            loadMeetingIntoForm(pendingMeeting); // load the edited meeting back into the form
                        }
                        else
                        {
                            success = meeting.FindNewLocation(locations); // ... if not, the existing meeting has to move
                            updateMeetingList(); // update the list to show any change
                        }
                    }
                }
            }

            if (success)
            {
                // we have resolved the problem, so hide the warnings
                lblMeetingClash.Visible = false;
                btnAmendTimes.Visible = false;
                btnAmendRoom.Visible = false;
            }
        }

        private void cbMeetingLocation_SelectedIndexChanged(object sender, EventArgs e)
        {
            // re-check required equipment to see if the selected room has it
            checkEquipment();
        }

        private void cbNeedProjector_CheckedChanged(object sender, EventArgs e)
        {
            // re-check required equipment to see if the selected room has it
            checkEquipment();
        }

        #endregion

        #region METHODS

        private void checkEquipment()
        {
            // small function to check if the selected room has the required equipment & show a warning if it doesn't
            // quit if there is no selected location; this would throw an error when we try to read from it
            if (cbMeetingLocation.SelectedItem == null) return;

            // get the selected location
            Location loc = (Location)cbMeetingLocation.SelectedItem;

            // this is the same as an if/else with the right hand logic statement seen here
            // if the meeting needs a projector AND the room doesn't have one, show the warning
            lblEquipmentWarning.Visible = cbNeedProjector.Checked && !loc.hasProjector;
        }

        private void clearForm()
        {
            // reset ALL the things!
            this.BeginInvoke(new Action(() =>
            {
                txtMeetingName.Text = string.Empty;
                cbMeetingImportance.Text = string.Empty;
                cbMeetingLocation.Text = string.Empty;
                txtMeetingTime.Text = string.Empty;
                cbNeedProjector.Checked = false;
                btnBookMeeting.Enabled = true;
                btnBookMeeting.Text = "Book Meeting";

                clbPreferenceSlots.ClearSelected();
                for (int i = 0; i < clbPreferenceSlots.Items.Count; i++)
                {
                    clbPreferenceSlots.SetItemChecked(i, false);
                }

                clbExclusionSlots.ClearSelected();
                for (int i = 0; i < clbExclusionSlots.Items.Count; i++)
                {
                    clbExclusionSlots.SetItemChecked(i, false);
                }
            }));
        }

        private void loadMeetingIntoForm(Meeting m)
        {
            // first of all, reset the form
            clearForm();

            this.BeginInvoke(new Action(() =>
            {
                // Set the form values from the selected meeting's data
                txtMeetingName.Text = m.name;
                cbMeetingImportance.Text = m.importance.ToString();
                cbMeetingLocation.Text = m.location.ToString();
                txtMeetingTime.Text = m.time;
                cbNeedProjector.Checked = m.needsProjector;

                for (int i = 0; i < 7; i++)
                {
                    if (m.preferredTimes.Contains(i))
                        clbPreferenceSlots.SetItemChecked(i, true);
                }

                for (int i = 0; i < 7; i++)
                {
                    if (m.excludedTimes.Contains(i))
                        clbExclusionSlots.SetItemChecked(i, true);
                }
            }));
        }

        private void checkExclusionClash()
        {
            // create a bool to track the presence of a clash
            bool clash = false;

            // only bother checking if they've actually selected any times!
            if (clbPreferenceSlots.CheckedIndices.Count > 0)
            {
                // iterate through times
                for (int i = 0; i < clbPreferenceSlots.Items.Count; i++)
                {
                    // check if both preferred and excluded times are enabled here
                    if (clbPreferenceSlots.GetItemChecked(i) == true && clbExclusionSlots.GetItemChecked(i) == true)
                    {
                        // if so... clash!
                        clash = true;
                    }
                }

                if (clash)
                {
                    // we got a problem
                    // disable the book meeting button, and show a warning
                    btnBookMeeting.Enabled = false;
                    lblTimeWarning.Visible = true;
                }
                else
                {
                    // all good
                    // re-enable the button and hide the warning
                    btnBookMeeting.Enabled = true;
                    lblTimeWarning.Visible = false;

                    // set the time to be the earliest available out of their preferred slots
                    txtMeetingTime.Text = times[clbPreferenceSlots.CheckedIndices[0]];
                }
            }
        }

        private void updateMeetingList()
        {
            // re-order the list of meetings
            meetings = meetings.OrderBy(meeting => meeting.ID).ToList();
            // clear the listbox and re-add all the meetings to it
            lbMeetings.Items.Clear();
            foreach (Meeting m in meetings)
            {
                lbMeetings.Items.Add(m);
            }
        }

        private void addMeeting(Meeting newMeeting)
        {
            // bool for tracking if there is a clash
            bool clash = false;

            // iterate through existing meetings
            foreach (Meeting meeting in meetings)
            {
                // if the locations match, we are interested...
                if (meeting.location == newMeeting.location)
                {
                    // if the times also match, there's a clash!
                    if (meeting.time == newMeeting.time)
                    {
                        // record this fact
                        clash = true;
                    }
                }
            }

            if (clash)
            {
                // uh oh. show a warning and the buttons that can be used to attempt to resolve the clash(es)
                lblMeetingClash.Visible = clash;
                btnAmendTimes.Visible = clash;
                btnAmendRoom.Visible = clash;
            }
            else
            {
                // all good. add the meeting, update list, and reset & hide the form ready for the next action
                meetings.Add(newMeeting);
                updateMeetingList();
                clearForm();
                btnBookMeeting.Text = "Book Meeting";
                gbMeetingDetails.Visible = false;
            }
        }

        #endregion
    }
}