/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    /**
     * Default constructor for the EnrollStudent class
     */
    public EnrollStudent()
    {
        this.profile = null;
        this.creditsEnrolled = 0;
    }

    /**
     * Overloaded constructor for the EnrollStudent class
     * @param p the profile of the Student
     * @param creditsEnrolled the number of credits that the student is enrolled to
     */
    public EnrollStudent(Profile p, int creditsEnrolled){
        this.profile = p;
        this.creditsEnrolled = creditsEnrolled;
    }

    /**
     * Compares two EnrollStudent objects to check if they are equal
     * @param other the Object of the other student
     * @return true if the two Students are equal
     */
    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Student)
        {
            Student student = (Student) other;

            return this.profile.equals(((Student) other).getProfile());
        }
        return false;

    }

    /**
     * Return string of the EnrollStudent class
     * @return the profile and creditsEnrolled as string
     */
    @Override
    public String toString() {
        return profile.toString() + ": credits enrolled: " + creditsEnrolled;
    }

    /**
     * Sets the number of credits for Student
     * @param c the number of credits for this class
     */
    public void setCredits(int c){this.creditsEnrolled = c;}

    /**
     * Return the number of credits that the student is enrolled to, as an int
     * @return creditsEnrolled
     */
    public int getCreditsEnrolled()
    {
        return creditsEnrolled;
    }

    /**
     * Compare two students to see if they are less than or equal
     * @param enrollStudentOther
     * @return -1 they are less than and 1 if more than
     */
    public int compareTo(EnrollStudent enrollStudentOther) {
        if((this.profile.compareTo(enrollStudentOther.profile))> 0)
        {
            return -1;
        }
        if((this.profile.compareTo(enrollStudentOther.profile))< 0)
        {
            return 1;
        }

        return 0;
    }


}
