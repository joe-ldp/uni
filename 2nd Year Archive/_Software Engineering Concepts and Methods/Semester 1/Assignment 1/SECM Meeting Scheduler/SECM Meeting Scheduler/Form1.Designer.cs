namespace SECM_Meeting_Scheduler
{
    partial class MeetingScheduler
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lbMeetings = new System.Windows.Forms.ListBox();
            this.gbBookedMeetings = new System.Windows.Forms.GroupBox();
            this.btnCancelMeeting = new System.Windows.Forms.Button();
            this.btnEditMeeting = new System.Windows.Forms.Button();
            this.btnBookMeeting = new System.Windows.Forms.Button();
            this.gbMeetingDetails = new System.Windows.Forms.GroupBox();
            this.lblEquipmentWarning = new System.Windows.Forms.Label();
            this.btnAmendRoom = new System.Windows.Forms.Button();
            this.btnAmendTimes = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.cbMeetingImportance = new System.Windows.Forms.ComboBox();
            this.lblMeetingClash = new System.Windows.Forms.Label();
            this.lblTimeWarning = new System.Windows.Forms.Label();
            this.cbMeetingLocation = new System.Windows.Forms.ComboBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.txtMeetingTime = new System.Windows.Forms.TextBox();
            this.cbNeedProjector = new System.Windows.Forms.CheckBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lbMeetingParticipants = new System.Windows.Forms.ListBox();
            this.clbExclusionSlots = new System.Windows.Forms.CheckedListBox();
            this.label2 = new System.Windows.Forms.Label();
            this.clbPreferenceSlots = new System.Windows.Forms.CheckedListBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtMeetingName = new System.Windows.Forms.TextBox();
            this.gbBookedMeetings.SuspendLayout();
            this.gbMeetingDetails.SuspendLayout();
            this.SuspendLayout();
            // 
            // lbMeetings
            // 
            this.lbMeetings.FormattingEnabled = true;
            this.lbMeetings.Location = new System.Drawing.Point(4, 16);
            this.lbMeetings.Margin = new System.Windows.Forms.Padding(2);
            this.lbMeetings.Name = "lbMeetings";
            this.lbMeetings.Size = new System.Drawing.Size(255, 82);
            this.lbMeetings.TabIndex = 1;
            // 
            // gbBookedMeetings
            // 
            this.gbBookedMeetings.Controls.Add(this.btnCancelMeeting);
            this.gbBookedMeetings.Controls.Add(this.lbMeetings);
            this.gbBookedMeetings.Controls.Add(this.btnEditMeeting);
            this.gbBookedMeetings.Controls.Add(this.btnBookMeeting);
            this.gbBookedMeetings.Location = new System.Drawing.Point(8, 8);
            this.gbBookedMeetings.Margin = new System.Windows.Forms.Padding(2);
            this.gbBookedMeetings.Name = "gbBookedMeetings";
            this.gbBookedMeetings.Padding = new System.Windows.Forms.Padding(2);
            this.gbBookedMeetings.Size = new System.Drawing.Size(262, 195);
            this.gbBookedMeetings.TabIndex = 1;
            this.gbBookedMeetings.TabStop = false;
            this.gbBookedMeetings.Text = "Booked Meetings";
            // 
            // btnCancelMeeting
            // 
            this.btnCancelMeeting.Location = new System.Drawing.Point(4, 163);
            this.btnCancelMeeting.Margin = new System.Windows.Forms.Padding(2);
            this.btnCancelMeeting.Name = "btnCancelMeeting";
            this.btnCancelMeeting.Size = new System.Drawing.Size(254, 27);
            this.btnCancelMeeting.TabIndex = 4;
            this.btnCancelMeeting.Text = "Cancel Meeting";
            this.btnCancelMeeting.UseVisualStyleBackColor = true;
            this.btnCancelMeeting.Click += new System.EventHandler(this.btnCancelMeeting_Click);
            // 
            // btnEditMeeting
            // 
            this.btnEditMeeting.Location = new System.Drawing.Point(4, 132);
            this.btnEditMeeting.Margin = new System.Windows.Forms.Padding(2);
            this.btnEditMeeting.Name = "btnEditMeeting";
            this.btnEditMeeting.Size = new System.Drawing.Size(254, 27);
            this.btnEditMeeting.TabIndex = 3;
            this.btnEditMeeting.Text = "Edit Meeting";
            this.btnEditMeeting.UseVisualStyleBackColor = true;
            this.btnEditMeeting.Click += new System.EventHandler(this.btnEditMeeting_Click);
            // 
            // btnBookMeeting
            // 
            this.btnBookMeeting.Location = new System.Drawing.Point(4, 101);
            this.btnBookMeeting.Margin = new System.Windows.Forms.Padding(2);
            this.btnBookMeeting.Name = "btnBookMeeting";
            this.btnBookMeeting.Size = new System.Drawing.Size(254, 27);
            this.btnBookMeeting.TabIndex = 2;
            this.btnBookMeeting.Text = "Book Meeting";
            this.btnBookMeeting.UseVisualStyleBackColor = true;
            this.btnBookMeeting.Click += new System.EventHandler(this.btnBookMeeting_Click);
            // 
            // gbMeetingDetails
            // 
            this.gbMeetingDetails.Controls.Add(this.lblEquipmentWarning);
            this.gbMeetingDetails.Controls.Add(this.btnAmendRoom);
            this.gbMeetingDetails.Controls.Add(this.btnAmendTimes);
            this.gbMeetingDetails.Controls.Add(this.label8);
            this.gbMeetingDetails.Controls.Add(this.cbMeetingImportance);
            this.gbMeetingDetails.Controls.Add(this.lblMeetingClash);
            this.gbMeetingDetails.Controls.Add(this.lblTimeWarning);
            this.gbMeetingDetails.Controls.Add(this.cbMeetingLocation);
            this.gbMeetingDetails.Controls.Add(this.label7);
            this.gbMeetingDetails.Controls.Add(this.label6);
            this.gbMeetingDetails.Controls.Add(this.txtMeetingTime);
            this.gbMeetingDetails.Controls.Add(this.cbNeedProjector);
            this.gbMeetingDetails.Controls.Add(this.label5);
            this.gbMeetingDetails.Controls.Add(this.label4);
            this.gbMeetingDetails.Controls.Add(this.lbMeetingParticipants);
            this.gbMeetingDetails.Controls.Add(this.clbExclusionSlots);
            this.gbMeetingDetails.Controls.Add(this.label2);
            this.gbMeetingDetails.Controls.Add(this.clbPreferenceSlots);
            this.gbMeetingDetails.Controls.Add(this.label3);
            this.gbMeetingDetails.Controls.Add(this.label1);
            this.gbMeetingDetails.Controls.Add(this.txtMeetingName);
            this.gbMeetingDetails.Location = new System.Drawing.Point(274, 8);
            this.gbMeetingDetails.Margin = new System.Windows.Forms.Padding(2);
            this.gbMeetingDetails.Name = "gbMeetingDetails";
            this.gbMeetingDetails.Padding = new System.Windows.Forms.Padding(2);
            this.gbMeetingDetails.Size = new System.Drawing.Size(500, 290);
            this.gbMeetingDetails.TabIndex = 2;
            this.gbMeetingDetails.TabStop = false;
            this.gbMeetingDetails.Text = "Meeting Details";
            this.gbMeetingDetails.Visible = false;
            // 
            // lblEquipmentWarning
            // 
            this.lblEquipmentWarning.AutoSize = true;
            this.lblEquipmentWarning.ForeColor = System.Drawing.Color.Red;
            this.lblEquipmentWarning.Location = new System.Drawing.Point(80, 270);
            this.lblEquipmentWarning.Name = "lblEquipmentWarning";
            this.lblEquipmentWarning.Size = new System.Drawing.Size(320, 13);
            this.lblEquipmentWarning.TabIndex = 22;
            this.lblEquipmentWarning.Text = "Warning: The selected room doesn\'t have your desired equipment!";
            this.lblEquipmentWarning.Visible = false;
            // 
            // btnAmendRoom
            // 
            this.btnAmendRoom.Location = new System.Drawing.Point(367, 198);
            this.btnAmendRoom.Name = "btnAmendRoom";
            this.btnAmendRoom.Size = new System.Drawing.Size(80, 23);
            this.btnAmendRoom.TabIndex = 21;
            this.btnAmendRoom.Text = "Amend Room";
            this.btnAmendRoom.UseVisualStyleBackColor = true;
            this.btnAmendRoom.Visible = false;
            this.btnAmendRoom.Click += new System.EventHandler(this.btnAmendRoom_Click);
            // 
            // btnAmendTimes
            // 
            this.btnAmendTimes.Location = new System.Drawing.Point(229, 198);
            this.btnAmendTimes.Name = "btnAmendTimes";
            this.btnAmendTimes.Size = new System.Drawing.Size(80, 23);
            this.btnAmendTimes.TabIndex = 20;
            this.btnAmendTimes.Text = "Amend Times";
            this.btnAmendTimes.UseVisualStyleBackColor = true;
            this.btnAmendTimes.Visible = false;
            this.btnAmendTimes.Click += new System.EventHandler(this.btnAmendTimes_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(4, 86);
            this.label8.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(177, 13);
            this.label8.TabIndex = 19;
            this.label8.Text = "Meeting Importance (Higher = More)";
            // 
            // cbMeetingImportance
            // 
            this.cbMeetingImportance.FormattingEnabled = true;
            this.cbMeetingImportance.Items.AddRange(new object[] {
            "1",
            "2",
            "3",
            "4",
            "5"});
            this.cbMeetingImportance.Location = new System.Drawing.Point(7, 101);
            this.cbMeetingImportance.Margin = new System.Windows.Forms.Padding(2);
            this.cbMeetingImportance.Name = "cbMeetingImportance";
            this.cbMeetingImportance.Size = new System.Drawing.Size(192, 21);
            this.cbMeetingImportance.TabIndex = 18;
            // 
            // lblMeetingClash
            // 
            this.lblMeetingClash.AutoSize = true;
            this.lblMeetingClash.ForeColor = System.Drawing.Color.Red;
            this.lblMeetingClash.Location = new System.Drawing.Point(201, 182);
            this.lblMeetingClash.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblMeetingClash.Name = "lblMeetingClash";
            this.lblMeetingClash.Size = new System.Drawing.Size(295, 13);
            this.lblMeetingClash.TabIndex = 17;
            this.lblMeetingClash.Text = "Clash with another meeting, please try a different room or time";
            this.lblMeetingClash.Visible = false;
            // 
            // lblTimeWarning
            // 
            this.lblTimeWarning.AutoSize = true;
            this.lblTimeWarning.ForeColor = System.Drawing.Color.Red;
            this.lblTimeWarning.Location = new System.Drawing.Point(226, 163);
            this.lblTimeWarning.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblTimeWarning.Name = "lblTimeWarning";
            this.lblTimeWarning.Size = new System.Drawing.Size(230, 13);
            this.lblTimeWarning.TabIndex = 16;
            this.lblTimeWarning.Text = "Preferred and excluded time slots cannot clash!";
            this.lblTimeWarning.Visible = false;
            // 
            // cbMeetingLocation
            // 
            this.cbMeetingLocation.FormattingEnabled = true;
            this.cbMeetingLocation.Location = new System.Drawing.Point(7, 65);
            this.cbMeetingLocation.Margin = new System.Windows.Forms.Padding(2);
            this.cbMeetingLocation.Name = "cbMeetingLocation";
            this.cbMeetingLocation.Size = new System.Drawing.Size(192, 21);
            this.cbMeetingLocation.TabIndex = 15;
            this.cbMeetingLocation.SelectedIndexChanged += new System.EventHandler(this.cbMeetingLocation_SelectedIndexChanged);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(4, 254);
            this.label7.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(125, 13);
            this.label7.TabIndex = 14;
            this.label7.Text = "Equipment Requirements";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(4, 122);
            this.label6.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(71, 13);
            this.label6.TabIndex = 13;
            this.label6.Text = "Meeting Time";
            // 
            // txtMeetingTime
            // 
            this.txtMeetingTime.Location = new System.Drawing.Point(7, 137);
            this.txtMeetingTime.Margin = new System.Windows.Forms.Padding(2);
            this.txtMeetingTime.Name = "txtMeetingTime";
            this.txtMeetingTime.ReadOnly = true;
            this.txtMeetingTime.Size = new System.Drawing.Size(192, 20);
            this.txtMeetingTime.TabIndex = 12;
            // 
            // cbNeedProjector
            // 
            this.cbNeedProjector.AutoSize = true;
            this.cbNeedProjector.Location = new System.Drawing.Point(7, 269);
            this.cbNeedProjector.Margin = new System.Windows.Forms.Padding(2);
            this.cbNeedProjector.Name = "cbNeedProjector";
            this.cbNeedProjector.Size = new System.Drawing.Size(68, 17);
            this.cbNeedProjector.TabIndex = 7;
            this.cbNeedProjector.Text = "Projector";
            this.cbNeedProjector.UseVisualStyleBackColor = true;
            this.cbNeedProjector.CheckedChanged += new System.EventHandler(this.cbNeedProjector_CheckedChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(344, 16);
            this.label5.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(103, 13);
            this.label5.TabIndex = 11;
            this.label5.Text = "Excluded Time Slots";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(201, 17);
            this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(102, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Preferred Time Slots";
            // 
            // lbMeetingParticipants
            // 
            this.lbMeetingParticipants.FormattingEnabled = true;
            this.lbMeetingParticipants.Location = new System.Drawing.Point(7, 171);
            this.lbMeetingParticipants.Margin = new System.Windows.Forms.Padding(2);
            this.lbMeetingParticipants.Name = "lbMeetingParticipants";
            this.lbMeetingParticipants.Size = new System.Drawing.Size(192, 82);
            this.lbMeetingParticipants.TabIndex = 6;
            // 
            // clbExclusionSlots
            // 
            this.clbExclusionSlots.FormattingEnabled = true;
            this.clbExclusionSlots.Items.AddRange(new object[] {
            "9 am",
            "10 am",
            "11 am",
            "12 pm",
            "1 pm",
            "2 pm",
            "3 pm",
            "4 pm"});
            this.clbExclusionSlots.Location = new System.Drawing.Point(341, 32);
            this.clbExclusionSlots.Margin = new System.Windows.Forms.Padding(2);
            this.clbExclusionSlots.Name = "clbExclusionSlots";
            this.clbExclusionSlots.Size = new System.Drawing.Size(137, 124);
            this.clbExclusionSlots.TabIndex = 9;
            this.clbExclusionSlots.ItemCheck += new System.Windows.Forms.ItemCheckEventHandler(this.clbExclusionSlots_ItemCheck);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(4, 156);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(103, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Meeting Participants";
            // 
            // clbPreferenceSlots
            // 
            this.clbPreferenceSlots.FormattingEnabled = true;
            this.clbPreferenceSlots.Items.AddRange(new object[] {
            "9 am",
            "10 am",
            "11 am",
            "12 pm",
            "1 pm",
            "2 pm",
            "3 pm",
            "4 pm"});
            this.clbPreferenceSlots.Location = new System.Drawing.Point(201, 32);
            this.clbPreferenceSlots.Margin = new System.Windows.Forms.Padding(2);
            this.clbPreferenceSlots.Name = "clbPreferenceSlots";
            this.clbPreferenceSlots.Size = new System.Drawing.Size(137, 124);
            this.clbPreferenceSlots.TabIndex = 8;
            this.clbPreferenceSlots.ItemCheck += new System.Windows.Forms.ItemCheckEventHandler(this.clbPreferenceSlots_ItemCheck);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(4, 52);
            this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(89, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Meeting Location";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(4, 17);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(76, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Meeting Name";
            // 
            // txtMeetingName
            // 
            this.txtMeetingName.Location = new System.Drawing.Point(7, 32);
            this.txtMeetingName.Margin = new System.Windows.Forms.Padding(2);
            this.txtMeetingName.Name = "txtMeetingName";
            this.txtMeetingName.Size = new System.Drawing.Size(192, 20);
            this.txtMeetingName.TabIndex = 0;
            // 
            // MeetingScheduler
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(785, 396);
            this.Controls.Add(this.gbMeetingDetails);
            this.Controls.Add(this.gbBookedMeetings);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "MeetingScheduler";
            this.Text = "Meeting Scheduler";
            this.Load += new System.EventHandler(this.MeetingScheduler_Load);
            this.gbBookedMeetings.ResumeLayout(false);
            this.gbMeetingDetails.ResumeLayout(false);
            this.gbMeetingDetails.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.ListBox lbMeetings;
        private System.Windows.Forms.GroupBox gbBookedMeetings;
        private System.Windows.Forms.Button btnBookMeeting;
        private System.Windows.Forms.Button btnEditMeeting;
        private System.Windows.Forms.Button btnCancelMeeting;
        private System.Windows.Forms.GroupBox gbMeetingDetails;
        private System.Windows.Forms.ListBox lbMeetingParticipants;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtMeetingName;
        private System.Windows.Forms.CheckBox cbNeedProjector;
        private System.Windows.Forms.CheckedListBox clbExclusionSlots;
        private System.Windows.Forms.CheckedListBox clbPreferenceSlots;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox txtMeetingTime;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.ComboBox cbMeetingLocation;
        private System.Windows.Forms.Label lblTimeWarning;
        private System.Windows.Forms.Label lblMeetingClash;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.ComboBox cbMeetingImportance;
        private System.Windows.Forms.Button btnAmendRoom;
        private System.Windows.Forms.Button btnAmendTimes;
        private System.Windows.Forms.Label lblEquipmentWarning;
    }
}

