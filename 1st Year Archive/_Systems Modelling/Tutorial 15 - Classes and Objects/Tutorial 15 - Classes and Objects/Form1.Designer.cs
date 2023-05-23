namespace Tutorial_15___Classes_and_Objects
{
    partial class Form1
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
            this.btnDisplay = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtEmp1Name = new System.Windows.Forms.TextBox();
            this.txtEmp1Sal = new System.Windows.Forms.TextBox();
            this.txtEmp2Name = new System.Windows.Forms.TextBox();
            this.txtEmp2Sal = new System.Windows.Forms.TextBox();
            this.txtEmp3Sal = new System.Windows.Forms.TextBox();
            this.txtEmp3Name = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.createEmployees = new System.Windows.Forms.Button();
            this.selectEmployee = new System.Windows.Forms.ListBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.txtSalaryBonus = new System.Windows.Forms.TextBox();
            this.txtChangeName = new System.Windows.Forms.TextBox();
            this.btnApply = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnDisplay
            // 
            this.btnDisplay.Location = new System.Drawing.Point(177, 12);
            this.btnDisplay.Name = "btnDisplay";
            this.btnDisplay.Size = new System.Drawing.Size(156, 38);
            this.btnDisplay.TabIndex = 0;
            this.btnDisplay.Text = "Update Displays";
            this.btnDisplay.UseVisualStyleBackColor = true;
            this.btnDisplay.Click += new System.EventHandler(this.btnDisplay_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 53);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(62, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Employee 1";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 118);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(62, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Employee 2";
            // 
            // txtEmp1Name
            // 
            this.txtEmp1Name.Location = new System.Drawing.Point(15, 69);
            this.txtEmp1Name.Name = "txtEmp1Name";
            this.txtEmp1Name.Size = new System.Drawing.Size(156, 20);
            this.txtEmp1Name.TabIndex = 3;
            this.txtEmp1Name.Text = " ";
            this.txtEmp1Name.TextChanged += new System.EventHandler(this.txtEmp1Name_TextChanged);
            // 
            // txtEmp1Sal
            // 
            this.txtEmp1Sal.Location = new System.Drawing.Point(15, 95);
            this.txtEmp1Sal.Name = "txtEmp1Sal";
            this.txtEmp1Sal.ReadOnly = true;
            this.txtEmp1Sal.Size = new System.Drawing.Size(156, 20);
            this.txtEmp1Sal.TabIndex = 4;
            // 
            // txtEmp2Name
            // 
            this.txtEmp2Name.Location = new System.Drawing.Point(15, 134);
            this.txtEmp2Name.Name = "txtEmp2Name";
            this.txtEmp2Name.Size = new System.Drawing.Size(156, 20);
            this.txtEmp2Name.TabIndex = 5;
            // 
            // txtEmp2Sal
            // 
            this.txtEmp2Sal.Location = new System.Drawing.Point(15, 160);
            this.txtEmp2Sal.Name = "txtEmp2Sal";
            this.txtEmp2Sal.ReadOnly = true;
            this.txtEmp2Sal.Size = new System.Drawing.Size(156, 20);
            this.txtEmp2Sal.TabIndex = 6;
            // 
            // txtEmp3Sal
            // 
            this.txtEmp3Sal.Location = new System.Drawing.Point(15, 225);
            this.txtEmp3Sal.Name = "txtEmp3Sal";
            this.txtEmp3Sal.ReadOnly = true;
            this.txtEmp3Sal.Size = new System.Drawing.Size(156, 20);
            this.txtEmp3Sal.TabIndex = 9;
            // 
            // txtEmp3Name
            // 
            this.txtEmp3Name.Location = new System.Drawing.Point(15, 199);
            this.txtEmp3Name.Name = "txtEmp3Name";
            this.txtEmp3Name.Size = new System.Drawing.Size(156, 20);
            this.txtEmp3Name.TabIndex = 8;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 183);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(62, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Employee 3";
            // 
            // createEmployees
            // 
            this.createEmployees.Location = new System.Drawing.Point(15, 12);
            this.createEmployees.Name = "createEmployees";
            this.createEmployees.Size = new System.Drawing.Size(156, 38);
            this.createEmployees.TabIndex = 10;
            this.createEmployees.Text = "Create Employees";
            this.createEmployees.UseVisualStyleBackColor = true;
            this.createEmployees.Click += new System.EventHandler(this.createEmployees_Click);
            // 
            // selectEmployee
            // 
            this.selectEmployee.FormattingEnabled = true;
            this.selectEmployee.Items.AddRange(new object[] {
            "Employee 1",
            "Employee 2",
            "Employee 3"});
            this.selectEmployee.Location = new System.Drawing.Point(177, 153);
            this.selectEmployee.Name = "selectEmployee";
            this.selectEmployee.Size = new System.Drawing.Size(156, 43);
            this.selectEmployee.TabIndex = 11;
            this.selectEmployee.SelectedIndexChanged += new System.EventHandler(this.selectEmployee_SelectedIndexChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(177, 53);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(115, 13);
            this.label4.TabIndex = 12;
            this.label4.Text = "Apply Salary Bonus (%)";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(177, 134);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(25, 13);
            this.label5.TabIndex = 13;
            this.label5.Text = "of...";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(175, 93);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(75, 13);
            this.label6.TabIndex = 14;
            this.label6.Text = "Change Name";
            // 
            // txtSalaryBonus
            // 
            this.txtSalaryBonus.Location = new System.Drawing.Point(177, 70);
            this.txtSalaryBonus.Name = "txtSalaryBonus";
            this.txtSalaryBonus.Size = new System.Drawing.Size(156, 20);
            this.txtSalaryBonus.TabIndex = 15;
            this.txtSalaryBonus.Text = "0";
            // 
            // txtChangeName
            // 
            this.txtChangeName.Location = new System.Drawing.Point(177, 108);
            this.txtChangeName.Name = "txtChangeName";
            this.txtChangeName.Size = new System.Drawing.Size(156, 20);
            this.txtChangeName.TabIndex = 16;
            // 
            // btnApply
            // 
            this.btnApply.Location = new System.Drawing.Point(177, 202);
            this.btnApply.Name = "btnApply";
            this.btnApply.Size = new System.Drawing.Size(156, 43);
            this.btnApply.TabIndex = 17;
            this.btnApply.Text = "Apply";
            this.btnApply.UseVisualStyleBackColor = true;
            this.btnApply.Click += new System.EventHandler(this.btnApply_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(348, 257);
            this.Controls.Add(this.btnApply);
            this.Controls.Add(this.txtChangeName);
            this.Controls.Add(this.txtSalaryBonus);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.selectEmployee);
            this.Controls.Add(this.createEmployees);
            this.Controls.Add(this.txtEmp3Sal);
            this.Controls.Add(this.txtEmp3Name);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtEmp2Sal);
            this.Controls.Add(this.txtEmp2Name);
            this.Controls.Add(this.txtEmp1Sal);
            this.Controls.Add(this.txtEmp1Name);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnDisplay);
            this.Name = "Form1";
            this.Text = "GUI";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnDisplay;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtEmp1Name;
        private System.Windows.Forms.TextBox txtEmp1Sal;
        private System.Windows.Forms.TextBox txtEmp2Name;
        private System.Windows.Forms.TextBox txtEmp2Sal;
        private System.Windows.Forms.TextBox txtEmp3Sal;
        private System.Windows.Forms.TextBox txtEmp3Name;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button createEmployees;
        private System.Windows.Forms.ListBox selectEmployee;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox txtSalaryBonus;
        private System.Windows.Forms.TextBox txtChangeName;
        private System.Windows.Forms.Button btnApply;
    }
}

