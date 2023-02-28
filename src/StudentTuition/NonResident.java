/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class NonResident extends Student{

    /**
     * return Default constructor of the NonResident class
     * @param p the profile
     * @param m Major
     * @param cc credits completed
     */
    public NonResident(Profile p, Major m, int cc)
    {
        super(p, m, cc);
    }

    /**
     * Calculate the tuitionDue for the nonresident student
     * @param creditsEnrolled is the number of credits the student currently has
     * @return the tuition, as a double
     */
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

    }
    /**
     * Check if the student is a parttime or full time student
     * @return the student's status as a string
     */
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
     * return if the student is a resident or not
     * @return true if the student is a resident
     */
    @Override
    public boolean isResident() {
        return false;
    }


}
