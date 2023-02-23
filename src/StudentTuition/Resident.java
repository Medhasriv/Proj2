/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class Resident extends Student{
    private int scholarship;

    public Resident(Profile p, Major m, int credits) {
        super(p, m, credits);
    }


    @Override
    public double tuitionDue(int creditsEnrolled) {
        double tuition = 0;
        if(studentStatus().equals("parttime"))
        {
            tuition= returnCredits() *404;
            tuition = (3268 * 0.80) + tuition;
        }
        if(studentStatus().equals("fulltime"))
        {
            tuition= 12536;
            tuition = tuition + 3268;

        }

        return tuition;

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
        return true;
    }

    public void setScholarship(int scholarship){
        this.scholarship = scholarship;
    }
}
