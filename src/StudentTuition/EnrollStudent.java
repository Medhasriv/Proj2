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
        profile = null;
        creditsEnrolled = 0;
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
    }


    @Override
    public String toString() {
        return "" + creditsEnrolled;
    }

}
