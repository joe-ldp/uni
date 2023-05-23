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
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.cbNeedComps = new System.Windows.Forms.CheckBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lbMeetingParticipants = new System.Windows.Forms.ListBox();
            this.clbExclusionSlots = new System.Windows.Forms.CheckedListBox();
            this.label2 = new System.Windows.Forms.Label();
            this.clbPreferenceSlots = new System.Windows.Forms.CheckedListBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtMeetingLocation = new System.Windows.Forms.TextBox();
            this.txtMeetingName = new System.Windows.Forms.TextBox();
            this.gbBookedMeetings.SuspendLayout();
            this.gbMeetingDetails.SuspendLayout();
            this.SuspendLayout();
            // 
            // lbMeetings
            // 
            this.lbMeetings.FormattingEnabled = true;
            this.lbMeetings.Location = new System.Drawing.Point(4, 16);
            this.lbMeetings.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.lbMeetings.Name = "lbMeetings";
            this.lbMeetings.Size = new System.Drawing.Size(175, 82);
            this.lbMeetings.TabIndex = 1;
            this.lbMeetings.SelectedIndexChanged += new System.EventHandler(this.lbMeetings_SelectedIndexChanged);
            // 
            // gbBookedMeetings
            // 
            this.gbBookedMeetings.Controls.Add(this.btnCancelMeeting);
            this.gbBookedMeetings.Controls.Add(this.lbMeetings);
            this.gbBookedMeetings.Controls.Add(this.btnEditMeeting);
            this.gbBookedMeetings.Controls.Add(this.btnBookMeeting);
            this.gbBookedMeetings.Location = new System.Drawing.Point(8, 8);
            this.gbBookedMeetings.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.gbBookedMeetings.Name = "gbBookedMeetings";
            this.gbBookedMeetings.Padding = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.gbBookedMeetings.Size = new System.Drawing.Size(181, 195);
            this.gbBookedMeetings.TabIndex = 1;
            this.gbBookedMeetings.TabStop = false;
            this.gbBookedMeetings.Text = "Booked Meetings";
            this.gbBookedMeetings.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // btnCancelMeeting
            // 
            this.btnCancelMeeting.Location = new System.Drawing.Point(4, 163);
            this.btnCancelMeeting.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.btnCancelMeeting.Name = "btnCancelMeeting";
            this.btnCancelMeeting.Size = new System.Drawing.Size(173, 27);
            this.btnCancelMeeting.TabIndex = 4;
            this.btnCancelMeeting.Text = "Cancel Meeting";
            this.btnCancelMeeting.UseVisualStyleBackColor = true;
            // 
            // btnEditMeeting
            // 
            this.btnEditMeeting.Location = new System.Drawing.Point(4, 132);
            this.btnEditMeeting.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.btnEditMeeting.Name = "btnEditMeeting";
            this.btnEditMeeting.Size = new System.Drawing.Size(173, 27);
            this.btnEditMeeting.TabIndex = 3;
            this.btnEditMeeting.Text = "Edit Meeting";
            this.btnEditMeeting.UseVisualStyleBackColor = true;
            // 
            // btnBookMeeting
            // 
            this.btnBookMeeting.Location = new System.Drawing.Point(4, 101);
            this.btnBookMeeting.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.btnBookMeeting.Name = "btnBookMeeting";
            this.btnBookMeeting.Size = new System.Drawing.Size(173, 27);
            this.btnBookMeeting.TabIndex = 2;
            this.btnBookMeeting.Text = "Book Meeting";
            this.btnBookMeeting.UseVisualStyleBackColor = true;
            // 
            // gbMeetingDetails
            // 
            this.gbMeetingDetails.Controls.Add(this.label7);
            this.gbMeetingDetails.Controls.Add(this.label6);
            this.gbMeetingDetails.Controls.Add(this.textBox1);
            this.gbMeetingDetails.Controls.Add(this.cbNeedComps);
            this.gbMeetingDetails.Controls.Add(this.label5);
            this.gbMeetingDetails.Controls.Add(this.label4);
            this.gbMeetingDetails.Controls.Add(this.lbMeetingParticipants);
            this.gbMeetingDetails.Controls.Add(this.clbExclusionSlots);
            this.gbMeetingDetails.Controls.Add(this.label2);
            this.gbMeetingDetails.Controls.Add(this.clbPreferenceSlots);
            this.gbMeetingDetails.Controls.Add(this.label3);
            this.gbMeetingDetails.Controls.Add(this.label1);
            this.gbMeetingDetails.Controls.Add(this.txtMeetingLocation);
            this.gbMeetingDetails.Controls.Add(this.txtMeetingName);
            this.gbMeetingDetails.Location = new System.Drawing.Point(195, 8);
            this.gbMeetingDetails.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.gbMeetingDetails.Name = "gbMeetingDetails";
            this.gbMeetingDetails.Padding = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.gbMeetingDetails.Size = new System.Drawing.Size(479, 272);
            this.gbMeetingDetails.TabIndex = 2;
            this.gbMeetingDetails.TabStop = false;
            this.gbMeetingDetails.Text = "Meeting Details";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(4, 216);
            this.label7.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(125, 13);
            this.label7.TabIndex = 14;
            this.label7.Text = "Equipment Requirements";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(4, 84);
            this.label6.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(71, 13);
            this.label6.TabIndex = 13;
            this.label6.Text = "Meeting Time";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(7, 99);
            this.textBox1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.textBox1.Name = "textBox1";
            this.textBox1.ReadOnly = true;
            this.textBox1.Size = new System.Drawing.Size(150, 20);
            this.textBox1.TabIndex = 12;
            // 
            // cbNeedComps
            // 
            this.cbNeedComps.AutoSize = true;
            this.cbNeedComps.Location = new System.Drawing.Point(7, 231);
            this.cbNeedComps.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.cbNeedComps.Name = "cbNeedComps";
            this.cbNeedComps.Size = new System.Drawing.Size(68, 17);
            this.cbNeedComps.TabIndex = 7;
            this.cbNeedComps.Text = "Projector";
            this.cbNeedComps.UseVisualStyleBackColor = true;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(302, 16);
            this.label5.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(103, 13);
            this.label5.TabIndex = 11;
            this.label5.Text = "Excluded Time Slots";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(159, 17);
            this.label4.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(102, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Preferred Time Slots";
            // 
            // lbMeetingParticipants
            // 
            this.lbMeetingParticipants.FormattingEnabled = true;
            this.lbMeetingParticipants.Items.AddRange(new object[] {
            "jeff",
            "john",
            "obama"});
            this.lbMeetingParticipants.Location = new System.Drawing.Point(7, 133);
            this.lbMeetingParticipants.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.lbMeetingParticipants.Name = "lbMeetingParticipants";
            this.lbMeetingParticipants.Size = new System.Drawing.Size(150, 82);
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
            this.clbExclusionSlots.Location = new System.Drawing.Point(299, 32);
            this.clbExclusionSlots.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.clbExclusionSlots.Name = "clbExclusionSlots";
            this.clbExclusionSlots.Size = new System.Drawing.Size(137, 124);
            this.clbExclusionSlots.TabIndex = 9;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(4, 118);
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
            this.clbPreferenceSlots.Location = new System.Drawing.Point(159, 32);
            this.clbPreferenceSlots.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.clbPreferenceSlots.Name = "clbPreferenceSlots";
            this.clbPreferenceSlots.Size = new System.Drawing.Size(137, 124);
            this.clbPreferenceSlots.TabIndex = 8;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(4, 51);
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
            // txtMeetingLocation
            // 
            this.txtMeetingLocation.Location = new System.Drawing.Point(7, 66);
            this.txtMeetingLocation.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.txtMeetingLocation.Name = "txtMeetingLocation";
            this.txtMeetingLocation.Size = new System.Drawing.Size(150, 20);
            this.txtMeetingLocation.TabIndex = 1;
            // 
            // txtMeetingName
            // 
            this.txtMeetingName.Location = new System.Drawing.Point(7, 32);
            this.txtMeetingName.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.txtMeetingName.Name = "txtMeetingName";
            this.txtMeetingName.Size = new System.Drawing.Size(150, 20);
            this.txtMeetingName.TabIndex = 0;
            // 
            // MeetingScheduler
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(681, 304);
            this.Controls.Add(this.gbMeetingDetails);
            this.Controls.Add(this.gbBookedMeetings);
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.Name = "MeetingScheduler";
            this.Text = "Form1";
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
        private System.Windows.Forms.TextBox txtMeetingLocation;
        private System.Windows.Forms.TextBox txtMeetingName;
        private System.Windows.Forms.CheckBox cbNeedComps;
        private System.Windows.Forms.CheckedListBox clbExclusionSlots;
        private System.Windows.Forms.CheckedListBox clbPreferenceSlots;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label label7;
    }
}

