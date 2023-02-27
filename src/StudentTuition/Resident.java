/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class Resident extends Student{
    private int scholarship;

    /**
     * Makes a resident
     *
     * @param p Student's profile with a student's full name and DOB
     * @param m Student's major
     * @param credits Student's number of credits
     * */
    public Resident(Profile p, Major m, int credits) {

        super(p, m, credits);
    }


    /**
     * Calculates a student's tuition based on their credits
     *
     * @param creditsEnrolled is the number of credits a student currently has
     * */
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

    /**
     * If a student has 3-12 credits, returns part-time student.
     * If a student has 12-24 credits they are a full time student.
     * */
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

    /**
     * Returns true if the student is a resident
     * */
    @Override
    public boolean isResident() {
        return true;
    }

    /**
     * If the student is a resident, this assigns a scholarship
     * @param scholarship is the scholarship amount
     * */
    public void setScholarship(int scholarship){
        this.scholarship = scholarship;
    }
}
