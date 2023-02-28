/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;
import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /**
     * default constructor for the Date class
     */
    public Date() {
        Calendar today = Calendar.getInstance();
        this.year = today.get(Calendar.YEAR);
        this.month = today.get(Calendar.MONTH) +1;
        this.day = today.get(Calendar.DATE);


    }//create an object with today’s date (see Calendar class)

    /**
     * Gets today's date
     * @return today's date
     */
    public Date getToday()
    {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH) +1;
        int day = today.get(Calendar.DATE);
        Date t = new Date(month, day, year);
        return t;
    }

    /**
     *Saves the month, day, and year, if the Date object was created with the parameter as a String
     * @param date as a String
     */
    public Date(String date) {
        String[] arrOfStr = date.split("/", 3);

        String m = (arrOfStr[0]);
        String d= (arrOfStr[1]);
        String y = (arrOfStr[2]);

        month = Integer.parseInt(m);
        day = Integer.parseInt(d);
        year = Integer.parseInt(y);
    }

    /**
     *@param y the year
     *@param m the month
     * @param d the day
     */
    public Date(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }
    /**
     * Returns the year of the date
     * @return the year
     */
    public int getYear(){
        return year;
    }

    /**
     * Returns the month of the year
     * @return the month
     */
    public int getMonth(){
        return month;
    }

    /**
     * Returns the day of the date
     * @return the day
     */
    public int getDay(){
        return day;
    }

    /**
     * Returns if the month is a valid date
     * @return a boolean true is it's a valid date; false if it's not a valid date
     */
    public boolean isValidMonth() {
        if(month >= 1 && month <=12) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the day of date is valid
     * @return true if the day a valid day for a particular month, and is valid
     */
    public boolean isValidDay() {
        if ( (month == (Calendar.JANUARY+1) || month == (Calendar.MARCH+1) || month == (Calendar.MAY+1) || month == (Calendar.JULY+1)|| month == (Calendar.AUGUST+1) || month == (Calendar.OCTOBER+1) || month == (Calendar.DECEMBER+1)) && ((day<=31) && (day>=1)) )
        {
            return true;
        }
        else if ( (month == (Calendar.APRIL+1) || month == (Calendar.JUNE+1) || month == (Calendar.SEPTEMBER+1) || month == (Calendar.NOVEMBER+1)) && ((day<=30) && (day>=1)) )
        {
            return true;
        }
        else if ( (month == (Calendar.FEBRUARY+1)) && ( isLeapYear()) && ((day<=29) && (day>=1)) )
        {
            return true;
        }
        else if ( (month == (Calendar.FEBRUARY+1)) && ( !isLeapYear()) && ((day<=28) && (day>=1)) )
        {
            return true;
        }
        else
        {
            return false;
        }


    }

    /**
     * Checks if the year is a leap year
     * @return true is the year is a leap year; false otherwise
     */
    public boolean isLeapYear() {

        final int QUADRENNIAL = 4;
        final int CENTENNIAL = 100;
        final int QUATERCENTENNIAL = 400;
        boolean isLeapYear = false;

        if(year/QUADRENNIAL == 1) {
            isLeapYear = false;
        }
        if(year/CENTENNIAL == 1) {
            isLeapYear = true;
        }

        if(year/QUATERCENTENNIAL == 1) {
            isLeapYear = false;
        }
        return isLeapYear;

    }

    /**
     * Checks if the date is valid overall
     * @return true if the date is a valid date
     */
    public boolean isValid() {
        if(this.isValidDay() && this.isValidMonth() ) {
            return true;
        }
        return false;
    } //check if a date is a valid calendar date

    /**
     * Returns the string containing the month, day, and year
     * @return the month, day, and year
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Checks if the current Date is equal to another object, if also of type Date
     * @param other the other date to check
     * @return returns true if dates equal
     */
    @Override
    public boolean equals(Object other) {

        if(other instanceof Date)
        {
            Date date = (Date) other;
            return  (this.day == date.day &&
                    this.month == date.month &&
                    this.year == date.year);
        }
        return false;

    }
    //ASK HER - do I need to remove override command here? Why am I having problems with equal override method


    /**
     * Compares the current date object to another date object to see if current date is before or after
     * @param other the object to be compared.
     * @return -1 if before than, 1 if after, and 0 if equal
     */
    @Override
    public int compareTo(Date other) {
        if(this.year> other.year)
        {
            return 1;
        }
        else if(this.year<other.year)
        {
            return -1;
        }
        else if(this.month> other.month)
        {
            return 1;
        }
        else if(this.month < other.month)
        {
            return -1;
        }
        else if (this.day>other.month)
        {
            return 1;
        } else if (this.day<other.month) {
            return 1;
        }
        return 0;
    }

    /**
     * Tests the Date class
     */
    public static void Main() {
        Date test1 = new Date(2003, 8,18);
        test1.isValid();
        test1.isLeapYear();
        test1.toString();

        Date test2 = new Date(2003, 8, 5);
        test1.equals(test1);
        test1.equals(test2);

        test1.compareTo(test1);
        test1.compareTo(test2);
    }
}


