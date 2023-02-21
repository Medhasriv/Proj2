/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class TriState extends Student{
    private String state;
    public TriState(Profile p, Major m, int cc)
    {
        super(p,m,cc);
    }



    public double triStateDiscount()
    {
        if(state.equals("NY"))
        {
            return 4000;
        }
        if(state.equals("CN"))
        {
            return 5000;
        }


        return 0;
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {

        String status = studentStatus(creditsEnrolled);
        double tuition = 0;
        if(status.equals("parttime"))
        {
            tuition= creditsEnrolled*966;
            tuition = (3268 * 0.80) + tuition;
        }
        if(status.equals("fulltime"))
        {
            tuition= 29737;
            tuition = tuition + 3268;
        }

        return tuition - triStateDiscount();

    }

    @Override
    public boolean isResident() {
        return false;
    }

    public String studentStatus(int creditsEnrolled)
    {
        String status = "";
        if(creditsEnrolled>=3 && creditsEnrolled<=12)
        {
            status = "partime";
        }
        else if(creditsEnrolled>12 && creditsEnrolled <=24)
        {
            status = "fulltime";
        }
        return status;
    }


}
