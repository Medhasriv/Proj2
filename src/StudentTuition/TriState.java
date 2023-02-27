/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class TriState extends Student{
    private String state;

    /**
     * Creates a tri state student given a profile, major and credits
     *
     * @param p Student's profile with a student's full name and DOB
     * @param m Student's current major
     * @param cc Student's current credits
     * */
    public TriState(Profile p, Major m, int cc)
    {
        super(p,m,cc);
    }

    /**
     * Creates a tri state student given a profile, major and credits and also the state
     *
     * @param p Student's profile with a student's full name and DOB
     * @param m Student's current major
     * @param cc Student's current credits
     * @param State the state the student is from
     * */
    public TriState(Profile p, Major m, int cc, String State)
    {
        super(p,m,cc);
        this.state = State;
    }

    /**
     * Returns the discount a tri state student recieves based on the state a student is from
     * */
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

    /**
     * Returns the student's tuition
     * @param creditsEnrolled is the current student's number of credits
     * */
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

    /**
     * Returns true if a student is a resident
     * */
    @Override
    public boolean isResident() {
        return false;
    }

    /**
     * Returns whether a student is a part time or full time student
     * @param creditsEnrolled is the current student's number of credits
     * */
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
