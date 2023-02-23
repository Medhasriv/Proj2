package StudentTuition;

import static org.junit.jupiter.api.Assertions.*;

class RosterTest {

    @org.junit.jupiter.api.Test
    public void test_add_resident() {
        //medhasri will do
        Roster ros = new Roster();
        Date d = new Date("2/2/2222");
        Profile p = new Profile("Shreya", "Cars", d);
        Resident r = new Resident(p, Major.CS,0);
        assertTrue(ros.add(r));
    }

    public void test_add_nonResident() {
        //medhasri will do
        Roster ros = new Roster();
        Date d = new Date("2/2/2222");
        Profile p = new Profile("Medhasri", "Architect", d);
        NonResident n = new NonResident(p, Major.CS,0);
        assertTrue(ros.add(n));
    }

    public void test_add_international() {
        Roster ros = new Roster();
        Date d = new Date("2/2/2222");
        Profile p = new Profile("SantiClaus", "J", d);
        International i = new International(p, Major.CS,0, false);
        assertTrue(ros.add(i));
    }

    public void test_add_TriState() {
        Roster ros = new Roster();
        Date d = new Date("2/2/2222");
        Profile p = new Profile("Funjan", "Busch", d);
        TriState t = new TriState(p, Major.CS,0, "NJ");
        assertTrue(ros.add(t));
    }

    public void test_remove_resident() {
        //medhasri will do
        Roster ros = new Roster();
        Date d = new Date("2/2/2222");
        Profile p = new Profile("Shreya", "Cars", d);
        Profile p2 = new Profile("Shreya", "NoCars", d);
        Resident r = new Resident(p, Major.CS,0);
        Resident r2 = new Resident(p2, Major.EE,0);

        ros.add(r);
        ros.add(r2);

        assrtTrue(Roster.remove(r2));
    }

    public void test_remove_nonResident() {
        //medhasri will do
        Roster ros = new Roster();
        Date d = new Date("2/2/2222");
        Profile p = new Profile("Medhasri", "Architect", d);
        NonResident n = new NonResident(p, Major.CS,0);
        Profile p2 = new Profile("Shreya", "NoCars", d);
        NonResident n2 = new NonResident(p, Major.EE,0);

        ros.add(n);
        ros.add(n2);

        assertTrue(ros.remove(n));
    }


    public void test_remove_international() {
        Roster ros = new Roster();
        Date d = new Date("2/2/2222");
        Profile p = new Profile("SantiClaus", "J", d);
        Profile p2 = new Profile("SntgClaus", "J", d);
        International i = new International(p, Major.CS,0, false);
        International i2 = new International(p2, Major.CS,0, false);

        ros.add(i);
        ros.add(i2);
        assertTrue(ros.remove(i2));
    }


    public void test_remove_TriState() {
        Roster ros = new Roster();
        Date d = new Date("2/2/2222");
        Profile p = new Profile("Funjan", "Busch", d);
        Profile p2 = new Profile("Funjan", "Commuter", d);

        TriState t = new TriState(p, Major.CS,0, "NJ");
        TriState t2 = new TriState(p2, Major.CS,0, "NJ");
        ros.add(t);
        ros.add(t2);
        assertTrue(ros.remove(t2));
    }


}