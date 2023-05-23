namespace Tutorial_16___Constructors
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
            this.txtNumber = new System.Windows.Forms.TextBox();
            this.txtLine1 = new System.Windows.Forms.TextBox();
            this.txtLine2 = new System.Windows.Forms.TextBox();
            this.txtLine3 = new System.Windows.Forms.TextBox();
            this.txtPostcode = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.btnCreateAddress = new System.Windows.Forms.Button();
            this.btnShowAddresses = new System.Windows.Forms.Button();
            this.txtShowAddresses = new System.Windows.Forms.TextBox();
            this.btnClearTextBoxes = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtNumber
            // 
            this.txtNumber.Location = new System.Drawing.Point(94, 41);
            this.txtNumber.Name = "txtNumber";
            this.txtNumber.Size = new System.Drawing.Size(100, 20);
            this.txtNumber.TabIndex = 0;
            // 
            // txtLine1
            // 
            this.txtLine1.Location = new System.Drawing.Point(94, 68);
            this.txtLine1.Name = "txtLine1";
            this.txtLine1.Size = new System.Drawing.Size(100, 20);
            this.txtLine1.TabIndex = 1;
            // 
            // txtLine2
            // 
            this.txtLine2.Location = new System.Drawing.Point(94, 94);
            this.txtLine2.Name = "txtLine2";
            this.txtLine2.Size = new System.Drawing.Size(100, 20);
            this.txtLine2.TabIndex = 2;
            // 
            // txtLine3
            // 
            this.txtLine3.Location = new System.Drawing.Point(94, 120);
            this.txtLine3.Name = "txtLine3";
            this.txtLine3.Size = new System.Drawing.Size(100, 20);
            this.txtLine3.TabIndex = 3;
            // 
            // txtPostcode
            // 
            this.txtPostcode.Location = new System.Drawing.Point(94, 146);
            this.txtPostcode.Name = "txtPostcode";
            this.txtPostcode.Size = new System.Drawing.Size(100, 20);
            this.txtPostcode.TabIndex = 4;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 44);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(76, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "House number";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(36, 149);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(52, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Postcode";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(52, 123);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(36, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Line 3";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(52, 97);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(36, 13);
            this.label4.TabIndex = 8;
            this.label4.Text = "Line 2";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(52, 71);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(36, 13);
            this.label5.TabIndex = 9;
            this.label5.Text = "Line 1";
            // 
            // btnCreateAddress
            // 
            this.btnCreateAddress.Location = new System.Drawing.Point(94, 172);
            this.btnCreateAddress.Name = "btnCreateAddress";
            this.btnCreateAddress.Size = new System.Drawing.Size(100, 23);
            this.btnCreateAddress.TabIndex = 10;
            this.btnCreateAddress.Text = "Create Address";
            this.btnCreateAddress.UseVisualStyleBackColor = true;
            this.btnCreateAddress.Click += new System.EventHandler(this.btnCreateAddress_Click);
            // 
            // btnShowAddresses
            // 
            this.btnShowAddresses.Location = new System.Drawing.Point(94, 415);
            this.btnShowAddresses.Name = "btnShowAddresses";
            this.btnShowAddresses.Size = new System.Drawing.Size(100, 23);
            this.btnShowAddresses.TabIndex = 11;
            this.btnShowAddresses.Text = "Show Addresses";
            this.btnShowAddresses.UseVisualStyleBackColor = true;
            this.btnShowAddresses.Click += new System.EventHandler(this.btnShowAddresses_Click);
            // 
            // txtShowAddresses
            // 
            this.txtShowAddresses.Location = new System.Drawing.Point(212, 12);
            this.txtShowAddresses.Multiline = true;
            this.txtShowAddresses.Name = "txtShowAddresses";
            this.txtShowAddresses.Size = new System.Drawing.Size(576, 426);
            this.txtShowAddresses.TabIndex = 12;
            // 
            // btnClearTextBoxes
            // 
            this.btnClearTextBoxes.Location = new System.Drawing.Point(94, 12);
            this.btnClearTextBoxes.Name = "btnClearTextBoxes";
            this.btnClearTextBoxes.Size = new System.Drawing.Size(100, 23);
            this.btnClearTextBoxes.TabIndex = 13;
            this.btnClearTextBoxes.Text = "Clear text boxes";
            this.btnClearTextBoxes.UseVisualStyleBackColor = true;
            this.btnClearTextBoxes.Click += new System.EventHandler(this.btnClearTextBoxes_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.btnClearTextBoxes);
            this.Controls.Add(this.txtShowAddresses);
            this.Controls.Add(this.btnShowAddresses);
            this.Controls.Add(this.btnCreateAddress);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtPostcode);
            this.Controls.Add(this.txtLine3);
            this.Controls.Add(this.txtLine2);
            this.Controls.Add(this.txtLine1);
            this.Controls.Add(this.txtNumber);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtNumber;
        private System.Windows.Forms.TextBox txtLine1;
        private System.Windows.Forms.TextBox txtLine2;
        private System.Windows.Forms.TextBox txtLine3;
        private System.Windows.Forms.TextBox txtPostcode;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button btnCreateAddress;
        private System.Windows.Forms.Button btnShowAddresses;
        private System.Windows.Forms.TextBox txtShowAddresses;
        private System.Windows.Forms.Button btnClearTextBoxes;
    }
}

