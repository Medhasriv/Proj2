package StudentTuition;

import static org.junit.Assert.*;

public class InternationalTest {

    @org.junit.Test
    public void tuitionDue_isStudyAbroad() {
        Date d = new Date("10/10/s2003")
        Profile p = new Profile("SantiClaus", "J", d);
        International i = new International(p, Major.CS,12, false);
        assertEquals(5918, i.tuitionDue(i.returnCredits()));
    }

    public void tuitionDue_isNotStudyAbroad() {
        Date d = new Date("10/10/2003")
        Profile p = new Profile("SantiClaus", "J", d);
        International i = new International(p, Major.CS,12, true);
        assertEquals(35655, i.tuitionDue(i.returnCredits()));

    }
}