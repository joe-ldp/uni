using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Tutorial_15___Classes_and_Objects
{
    public partial class Form1 : Form
    {
        private Employee[] employees;
        private int selectedEmployee;

        public Form1()
        {
            InitializeComponent();
        }

        private void createEmployees_Click(object sender, EventArgs e)
        {
            employees = new Employee[3];

            if (txtEmp1Name.Text != "")
            {
                employees[0] = new Employee(txtEmp1Name.Text);
            }
            else employees[0] = new Employee("Rhiannon Confitures");

            if (txtEmp2Name.Text != "")
            {
                employees[1] = new Employee(txtEmp2Name.Text);
            }
            else employees[1] = new Employee("Marion Saucisses");

            if (txtEmp3Name.Text != "")
            {
                employees[2] = new Employee(txtEmp3Name.Text);
            }
            else employees[2] = new Employee("Geoffrey Jefferson");

            txtEmp1Name.ReadOnly = true;
            txtEmp2Name.ReadOnly = true;
            txtEmp3Name.ReadOnly = true;

            //employees[0] = new Employee("Rhiannon Confitures");
            //employees[1] = new Employee("Marion Saucisses");
            //employees[2] = new Employee("Geoffrey Jefferson");
        }

        private void btnDisplay_Click(object sender, EventArgs e)
        {
            UpdateDisplays();
        }
        
        private void UpdateDisplays()
        {
            // Populate the display from employee objects' data
            txtEmp1Name.Text = "Name: "   + employees[0].GetName();
            txtEmp1Sal.Text  = "Salary: " + employees[0].GetSalary();
            txtEmp2Name.Text = "Name: "   + employees[1].GetName();
            txtEmp2Sal.Text  = "Salary: " + employees[1].GetSalary();
            txtEmp3Name.Text = "Name:   " + employees[2].GetName();
            txtEmp3Sal.Text  = "Salary: " + employees[2].GetSalary();
        }

        private void selectEmployee_SelectedIndexChanged(object sender, EventArgs e)
        {
            ListBox lb = (ListBox)sender;

            selectedEmployee = lb.SelectedIndex;

            if (lb.SelectedIndex >= 0)
            {
                txtChangeName.Text = employees[selectedEmployee].GetName();
                txtSalaryBonus.Text = "0";
            }
        }

        private void btnApply_Click(object sender, EventArgs e)
        {
            int succeed = 0;

            if (txtChangeName.Text != "")
            {
                employees[selectedEmployee].SetName(txtChangeName.Text);
                succeed++;
            }

            try
            {
                employees[selectedEmployee].ApplyBonus(Int32.Parse(txtSalaryBonus.Text));
                succeed++;
            }
            catch
            {
                txtSalaryBonus.Text = "0";
            }

            if (succeed == 2)
            {
                selectEmployee.ClearSelected();
            }

            UpdateDisplays();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void txtEmp1Name_TextChanged(object sender, EventArgs e)
        {

        }
    }
}