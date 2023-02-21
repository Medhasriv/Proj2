/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

//Enrollment
// nonResident
//international
public abstract class Student implements Comparable<Student>{
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;


    /**
     * Makes a student given profile, major, and credits
     *
     * @param p Profile of the student
     * @param m Major of the student
     * @param credits Number of credits of the student
     * */
    public Student(Profile p, Major m, int credits)
    {
        this.profile = p;
        this.major = m;
        this.creditCompleted = credits;
    }

    /**
     * Makes a Student given a profile
     * @param p Profile of the student
     * */
    public Student(Profile p)
    {
        this.profile = p;
        this.major = null;
        this.creditCompleted = 0;
    }


    /**
     * Returns the school of the student
     * @return String with the school of the student
     * */
    public String getSchool()
    {
        return major.getSchool();
    }

    /**
     * Returns major of the student
     * @return Major of the student
     *  */
    public Major getMajor()
    {
        return major;
    }

    /**
     * Sets new major for the student
     * @param m new Major of the student
     * */
    public void setMajor(Major m){
        this.major = m;
    }

    /**
     * Gets the profile of the student
     * @return Profile of the student
     * */
    public Profile getProfile(){
        return profile;
    }


    /**
     * Provides student's number of credits
     * @return number of credits
     * */
    public int returnCredits(){
        return creditCompleted;
    }


    /**
     * Gets the student's standing, Freshman, Sophomore, Junior, Senior
     * @return String with the year of the student
     * */
    public String getYear()
    {
        if(creditCompleted >= Standing.MIN_Freshmen.minCredits && creditCompleted <= Standing.MIN_Sophomore.minCredits )  //junior
        {
            return Standing.MIN_Freshmen.year;
        }
        if(creditCompleted >= Standing.MIN_Sophomore.minCredits && creditCompleted <= Standing.MIN_Junior.minCredits )  //junior
        {
            return Standing.MIN_Sophomore.year;  //senior = d
        }
        if(creditCompleted >= Standing.MIN_Junior.minCredits && creditCompleted <= Standing.MIN_Senior.minCredits )  //junior
        {
            return Standing.MIN_Junior.year; //senior = d
        }
        else
        {
            return Standing.MIN_Senior.year; //senior = d
        }
    }

    /**
     * Returns string of the Student
     * @return String containing Student info
     * */
    @Override
    public String toString()
    {

        return profile.toString() +  " (" + this.major.getCourseId() + " " + this.major + " " + this.major.getSchool() + ") credits completed: " + creditCompleted; //add major to this
    }

    /**
     * Checks if student is equal to another
     * @param other the student to compare to
     * @return returns true if they are equal
     * */
    @Override
    public boolean equals(Object other)
    {

        if(other instanceof Student)
        {
            Student student = (Student) other;

            return this.profile.equals(student.profile)
                    && this.major.equals(student.major)
                    && this.creditCompleted == student.creditCompleted;
        }
        return false;



    }

    /** Compares student to another student
     * @param other the student to compare to
     * @return positive if the first student is bigger(alphabetically), negative if first student smaller, zero if they are equal
     * */
    @Override
    public int compareTo(Student other)
    {
        if((this.profile.compareTo(other.profile))> 0)
        {
            return -1;
        }
        if((this.profile.compareTo(other.profile))< 0)
        {
            return 1;
        }

        return 0;

    }

    public boolean isValid(int creditEnrolled)
    {
        if(creditCompleted>=3 && creditCompleted <=24)
        {
            return true;
        }
        return false;
    }



    public abstract double tuitionDue(int creditsEnrolled);

    public abstract boolean isResident();


    public static void main()
    {
//       Student test1 = new Student(new Profile("Pandey", "Shreya", new Date(2003, 8, 18)), Major.EE, 100);
//        test1.getSchool();
//        test1.getMajor();
//        test1.setMajor(Major.CS);
//        test1.getProfile();
//        test1.toString();
//        test1.equals(test1);
      //  Student test2 = new Student(new Profile("Veldurthi", "Medhasri", new Date(2003, 8, 5)), Major.CS, 99);
     //   test1.compareTo(test2);
    }
}

