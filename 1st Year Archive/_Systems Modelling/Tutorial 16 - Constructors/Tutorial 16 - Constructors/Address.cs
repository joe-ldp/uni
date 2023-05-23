using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tutorial_16___Constructors
{
    class Address
    {
        private string number;
        private string line1;
        private string line2;
        private string line3;
        private string postcode;

        private string addressType;

        public Address(string number_, string postcode_)
        {
            number = number_;
            postcode = postcode_;

            addressType = "Minimal";
        }

        public Address(string number_, string street_, string city_, string postcode_)
        {
            number = number_;
            line1 = street_;
            line2 = city_;
            postcode = postcode_;

            addressType = "City";
        }

        //public Address(string number_, string street_, string town_, string county_, string postcode_)
        //{
        //    number = number_;
        //    line1 = street_;
        //    line2 = town_;
        //    line3 = county_;
        //    postcode = postcode_;

        //    addressType = "Town";
        //}

        public Address(string number_, string line1_, string line2_, string line3_, string postcode_)
        {
            number = number_;
            line1 = line1_;
            line2 = line2_;
            line3 = line3_;
            postcode = postcode_;

            addressType = "Generic";
        }

        public string GetFormattedAddress()
        {
            switch (addressType)
            {
                case "Minimal":
                    return (number + ", " + postcode).ToString();
                    //break;
                case "City":
                    return (number + ", " + line1 + ", " + line2 + ", " + postcode).ToString();
                    //break;
                case "Town":
                    return (number + ", " + line1 + ", " + line2 + ", " + line3 + ", " + postcode).ToString();
                    //break;
                default: // Generic
                    return (number + ", " + line1 + ", " + line2 + ", " + line3 + ", " + postcode).ToString();
                    //break;
            }
        }
    }
}