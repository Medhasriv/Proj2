 /**
     * @author Shreya Pandey
     * @author Medhasri Veldurthi
  */
package StudentTuition;
    public class Profile implements Comparable<Profile>{
        private String lname;
        private String fname;
        private Date dob;

        /**
         * Makes a profile given student's full name and DOB
         *
         * @param last Student's last name
         * @param first Student's first name
         * @param d Student's date of birth
         * */
        public Profile(String last, String first, Date d)
        {
            this.lname = last;
            this.fname = first;
            this.dob = d;
        }

        /**
         * Gets the age of the student given the date of birth
         * @return integer which is the age
         * */
        public int getAge()
        {
            int m = dob.getMonth();
            int y = dob.getYear();
            int d = dob.getDay();

            Date today = new Date();
            int monthToday = today.getMonth();
            int yearToday = today.getYear();
            int dayToday = today.getDay();


            int age = yearToday - y;

            if(m > monthToday)
            {
                age--;
            }
            else if(m == monthToday)
            {
                if(d > dayToday)
                {
                    age--;
                }
            }
            return age;

        }

        /**
         * Returns true if two profiles are equal
         *
         * @param p Profile of the student to chedck
         * @return returns true if equal
         * */
        @Override
        public boolean equals(Object p)
        {
            if(p instanceof Profile)
            {
                Profile profile = (Profile) p;
                return this.fname.equals(profile.fname)
                        && this.lname.equals(profile.lname)
                        && this.dob.equals(profile.dob);
            }
            return false;

        }

        /**
         * @return string of the profile
         * */
        @Override
        public String toString()
        {

            return fname + " " +  lname + " " + dob.toString();
        }


        /**
         * @param other profile to compare for
         * @return positive if the first profile is bigger, negative if first profile smaller, zero if they are equal
         * */
        @Override
        public int compareTo(Profile other) {
            if((this.lname.compareTo(other.lname))> 0) //pos means greater than 0; here we're comparing string compareTo
            {
                return -1;
            }
            else if((this.lname.compareTo(other.lname))< 0) //pos means greater than 0; here we're comparing string compareTo
            {
                return 1;
            }
            else if ((this.fname.compareTo(other.fname))> 0)
            {
                return -1;
            }
            else if((this.fname.compareTo(other.fname))< 0)
            {
                return 1;
            }
            else if ((this.dob.compareTo(other.dob))< 0)
            {
                return -1;
            }
            else if ((this.dob.compareTo(other.dob))> 0)
            {
                return 1;
            }
            else
                return 0;

        }
    }


