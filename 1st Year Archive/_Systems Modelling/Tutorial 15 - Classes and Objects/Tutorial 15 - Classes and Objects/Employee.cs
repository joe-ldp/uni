using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tutorial_15___Classes_and_Objects
{
    class Employee
    {
        private string name;
        private double salary = 30000;

        public Employee(string name_, double salary_)
        {
            name = name_;
            salary = salary_;
        }

        public Employee(string name_)
        {
            name = name_;
            salary = 25000;
        }

        public string GetName()
        {
            return name;
        }

        public double GetSalary()
        {
            return salary;
        }

        public void SetName(string name_)
        {
            name = name_;
        }

        public void SetSalary(double salary_)
        {
            salary = salary_;
        }

        public void ApplyBonus(double bonusPercent)
        {
            if (bonusPercent < 0) bonusPercent = Math.Abs(bonusPercent);
            salary *= (100 + bonusPercent) / 100;
        }
    }
}