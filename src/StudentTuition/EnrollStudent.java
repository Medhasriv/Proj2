/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    public EnrollStudent()
    {
        this.profile = null;
        this.creditsEnrolled = 0;
    }

    public EnrollStudent(Profile p, int creditsEnrolled){
        this.profile = p;
        this.creditsEnrolled = creditsEnrolled;
    }
    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Student)
        {
            Student student = (Student) other;

            return this.profile.equals(((Student) other).getProfile());
        }
        return false;
        //this doesnt feel right
        //        if(other instanceof EnrollStudent)
//        {
//            EnrollStudent enrollStudent = (EnrollStudent) other;
//
//            return this.profile.equals(((EnrollStudent) other));
//        }
//        return false;
    }


    @Override
    public String toString() {
        return "" + creditsEnrolled;
    }

    public void setCredits(int c){this.creditsEnrolled = c;}

    public int getCreditsEnrolled()
    {
        return creditsEnrolled;
    }
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
