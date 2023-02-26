package StudentTuition;

import static org.junit.Assert.*;

public class DateTest {

    @org.junit.Test


    public void isValid_LeapYear29thFeb() {
        //shreya will do
        Date date = new Date("2/29/2008");
        assertTrue(date.isValid());
    }

    public void isValid_31Dec() {
        //shreya will do
        Date date = new Date("12/31/2003");
        assertTrue(date.isValid());
    }

    public void isValid_notValid_31April() {
        //shreya will do
        Date date = new Date("4/31/2011");
        assertFalse(date.isValid());
    }

    public void isValid_notValid_30Feb() {
        //shreya will do
        Date date = new Date("2/30/2011");
        assertFalse(date.isValid());
    }
    public void isValid_notValid_30Jun() {
        //shreya will do
        Date date = new Date("6/30/2001");
        assertFalse(date.isValid());
    }
    public void isValid_notValid_31Nov() {
        //shreya will do
        Date date = new Date("11/31/2019");
        assertFalse(date.isValid());
    }
    public void isValid_daysInFeb_nonLeap() {
        //shreya will do
        Date date = new Date("2/29/2011");
        assertFalse(date.isValid());
    }



}