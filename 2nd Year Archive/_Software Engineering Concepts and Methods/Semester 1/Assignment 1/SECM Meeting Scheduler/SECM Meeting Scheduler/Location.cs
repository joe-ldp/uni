using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SECM_Meeting_Scheduler
{
    class Location
    {
        public string name;
        public int locationID;
        public bool hasProjector;

        public Location(string name_, int ID_, bool hasProjector_)
        {
            name = name_;
            locationID = ID_;
            hasProjector = hasProjector_;
        }

        public override string ToString()
        {
            return name;
        }
    }
}
