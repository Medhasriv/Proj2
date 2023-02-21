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

    public boolean isStudyAborad(boolean studentAbroad)
    {
        if(studentAbroad == true)
        {
            return true;
        }
        return false;
    }
}
