using System;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Tutorial_16___Constructors
{
    public partial class Form1 : Form
    {
        private ArrayList addresses = new ArrayList();

        public Form1()
        {
            InitializeComponent();
        }

        private void btnClearTextBoxes_Click(object sender, EventArgs e)
        {
            txtNumber.Text = "";
            txtLine1.Text = "";
            txtLine2.Text = "";
            txtLine3.Text = "";
            txtPostcode.Text = "";
        }

        private void btnCreateAddress_Click(object sender, EventArgs e)
        {
            if (txtNumber.Text != "")
            {
                if (txtPostcode.Text != "")
                {
                    if (txtLine1.Text == "")
                    {
                        addresses.Add(new Address(txtNumber.Text, txtPostcode.Text));
                    }
                    else
                    {
                        if (txtLine2.Text == "")
                        {
                            
                        }
                        else
                        {
                            if (txtLine3.Text == "")
                            {
                                addresses.Add(new Address(txtNumber.Text, txtLine1.Text, txtLine2.Text, txtPostcode.Text));
                            }
                            else
                            {
                                addresses.Add(new Address(txtNumber.Text, txtLine1.Text, txtLine2.Text, txtLine3.Text, txtPostcode.Text));
                            }
                        }
                    }
                }
            }
        }

        private void btnShowAddresses_Click(object sender, EventArgs e)
        {
            txtShowAddresses.Text = "";
            string newLine = Environment.NewLine;
            foreach (Address a in addresses)
            {
                txtShowAddresses.Text += a.GetFormattedAddress() + newLine;
                
            }
        }
    }
}
