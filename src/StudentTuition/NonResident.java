/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class NonResident extends Student{

    public NonResident(Profile p, Major m, int cc)
    {
        super(p, m, cc);
    }

    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuition = 0;
        if(studentStatus().equals("parttime"))
        {
            tuition= returnCredits() *966;
            tuition = (3268 * 0.80) + tuition;
        }
        if(studentStatus().equals("fulltime"))
        {
            tuition= 29737;
            tuition = tuition + 3268;
        }

        return tuition;

        //still need to add tristate area discounts
        //use tristate class
    }

    public String studentStatus()
    {
        String status = "";
        if(this.returnCredits()>=3 && this.returnCredits() <=12)
        {
            status = "partime";
        }
        else if(this.returnCredits()>12 && this.returnCredits() <=24)
        {
            status = "fulltime";
        }
        return status;
    }

    @Override
    public boolean isResident() {
        return false;
    }


}
