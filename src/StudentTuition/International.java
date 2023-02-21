/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class International extends NonResident{
    private boolean isStudyAbroad;


    public International(Profile p, Major m, int cc, boolean abroad) {
        super(p, m, cc);
        isStudyAbroad = abroad;
    }
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


    public boolean isStudyAbroad(boolean studentAbroad)
    {
        if(studentAbroad == true)
        {
            return true;
        }
        return false;
    }



}
