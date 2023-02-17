/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public enum Standing {
    MIN_Freshmen(0, "Freshmen"),
    MIN_Sophomore(30, "Sophomore"),
    MIN_Junior(60,"Junior" ),
    MIN_Senior(90, "Senior");

    public final int minCredits;
    public final String year;

    private Standing(int minCredits, String year) {
        this.minCredits = minCredits;
        this.year = year;
    }


}
