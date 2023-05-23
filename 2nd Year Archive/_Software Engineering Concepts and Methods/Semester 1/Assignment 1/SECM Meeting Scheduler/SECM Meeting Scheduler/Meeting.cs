using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SECM_Meeting_Scheduler
{
    class Meeting
    {
        public int ID;
        public string name;
        public int importance;
        public Location location;
        public Participant[] participants;
        public List<int> preferredTimes;
        public List<int> excludedTimes;
        public string time;
        public bool needsProjector;

        private static string[] times = new string[] { "9 am", "10 am", "11 am", "12 pm", "1 pm", "2 pm", "3 pm", "4 pm" };

        public Meeting(int ID, string name, string importance, Location location, Participant[] participants, List<int> preferredTimes, List<int> excludedTimes, string time, bool needsProjector)
        {
            this.ID = ID;
            this.name = name;
            this.importance = int.Parse(importance);
            this.location = location;
            this.participants = participants;
            this.preferredTimes = preferredTimes;
            this.excludedTimes = excludedTimes;
            this.time = time;
            this.needsProjector = needsProjector;
        }

        public override string ToString()
        {
            return String.Format("{0} @\t {1}", name, time);
        }

        public bool FindNewTime()
        {
            bool success = false;
            int timeIndex = Array.IndexOf(times, time);
            int[] possibleTimes = new int[8];

            preferredTimes.Remove(timeIndex);
            excludedTimes.Add(timeIndex);

            for (int i = times.Count()-1; i >= 0; i--)
            {
                if (preferredTimes.Contains(i)) possibleTimes[i]++;
                if (excludedTimes.Contains(i))
                {
                    possibleTimes[i] = 0;
                }
                else
                {
                    possibleTimes[i]++;
                    success = true;
                }
            }

            if (success)
            {
                time = times[possibleTimes.Max()];
            }

            return success;
        }

        public bool FindNewLocation(Location[] locations)
        {
            bool success = false;
            foreach (Location loc in locations)
            {
                if (needsProjector)
                {
                    if (loc.hasProjector)
                    {
                        location = loc;
                        success = true;
                        break;
                    }
                }
                else
                {
                    location = loc;
                    success = true;
                    break;
                }
            }

            return success;
        }
    }
}