/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class International extends NonResident{
    private boolean isStudyAbroad;

    /**
     * Default constructor
     * @param p the profile
     * @param m the major
     * @param cc the credits completed
     * @param abroad boolean if the International student is abroad or not
     */
    public International(Profile p, Major m, int cc, boolean abroad) {
        super(p, m, cc);
        isStudyAbroad = abroad;
    }

    /**
     * Calculates the amount of tuition
     * @param creditsEnrolled is the number of credits the student currently has
     * @return return the number amount of tuition that needs to be submitted
     */
    @Override
    public double tuitionDue(int creditsEnrolled) {

        double tuition = 0;
        if(!(isStudyAbroad))
        {
            if(creditsEnrolled>=12 && creditsEnrolled <=24)
            {
                 tuition = 29737 + 3268 + 2650;
            }
        }
        else
        {
            tuition = 3268 + 2650;
        }
        return tuition;

    }

    /**
     * Checks to see if the international student is studying abroad
     * @param studentAbroad
     * @return true if the student is studyAbroad
     */
    public boolean isStudyAbroad(boolean studentAbroad)
    {
        if(studentAbroad == true)
        {
            return true;
        }
        return false;
    }



}
