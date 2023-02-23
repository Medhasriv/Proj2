/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class Roster {
    private Student[] roster;
    private int size;

    public Roster() {
        this.roster = roster;
        this.size = size;
    }

    /**
     * Making a roster of students
     *
     * @param r Array of students
     * @param s size of the student array
     */
    public Roster(Student[] r, int s) {
        this.roster = r;
        this.size = s;
    }

    /**
     * Finds the index of a student we are looking for
     *
     * @param student student we are searching for
     * @return index of the student that is being searched
     */
    private int find(Student student) {
        int NOT_FOUND = -1;
        for (int i = 0; i < size; i++) {
            if (roster[i].equals(student)) {
                return i;
            }
        }
        return NOT_FOUND;
    } //search the given student in roster



    /**
     * Grows the size of the student array by 4
     */
    private void grow() {
        Student[] newArray = new Student[size + 4];

        if (roster != null) {
            for (int i = 0; i <= size; i++) {
                newArray[i] = roster[i];
            }
        }


        roster = newArray;
    } //increase the array capacity by 4

    /**
     * Gives the number of students in the array
     *
     * @return Number of students in the array
     */
    public int getSize() {
        return size;
    }


    /**
     * Adds a student to the roster
     *
     * @param student Student to be added
     * @return True of student has been added
     */
    public boolean add(Student student) {
        if (roster == null) {
            grow();
        }
        if (roster.length - 1 == size) {
            grow();
        }
        roster[size] = student;
        size++;

        return true;
    } //add student to end of array

    /**
     * @param student Student we are removing
     * @return true if student successfully removed
     */
    public boolean remove(Student student) {
        for (int i = 0; i <= size - 1; i++) {
            if (roster[i].equals(student)) {
                roster[i] = null;
                for (int j = i; j < size - 1; j++) {
                    roster[j] = roster[j + 1];
                }
                roster[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }//maintain the order after remove

    /**
     * Checks if student is in the roster
     *
     * @param student Student we are searching for
     * @return boolean which is true if student is in the array
     */
    public boolean contains(Student student) {
        for (int i = 0; i < size - 1; i++) {
            if (find(student) != -1) {
                return true;
            }
        }
        return false;
    } //if the student is in roster

    /**
     * Finds the student in the roster given a profile
     *
     * @param p profile of the student
     * @return profile of the student given the profile
     */
    public Student ProfileToStudent(Profile p) {
        for (int i = 0; i < size; i++) {
            if (roster[i].getProfile().toString().equals(p.toString())) {
                return roster[i];
            }
        }
        return null;
    }

    /**
     * Prints the student roster
     */
    public void print() {
        //selection sort on print...not sure if this works
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = 1 + i; j < size; j++) {
                if ((roster[j].compareTo(roster[min])) == -1) {
                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }
        for (int k = 0; k < size; k++) {
            System.out.println(roster[k]);
        }

    } //print roster sorted by profiles


    /**
     * Prints students first by their School, then by their Major
     */
    public void printBySchoolMajor() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = 1 + i; j < size; j++) {
                String schoolMajorJ = roster[j].getSchool() + roster[j].getMajor().toString();
                String schoolMajorMin = roster[min].getSchool() + roster[min].getMajor().toString();
                if (schoolMajorJ.compareTo(schoolMajorMin) < 0) {
                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }
        for (int k = 0; k < size; ++k) {
            System.out.println(roster[k]);
        }


    } //print roster sorted by school major

    /**
     * Prints students for a specific school
     *
     * @param school Given a specific school to print for
     */
    public void printBySchool(String school)  //ex L SAS
    {
        for (int i = 0; i < size; i++) {
            if (roster[i].getSchool().equals(school)) {
                System.out.println((roster[i]));
            }
        }

    }


    /**
     * Prints students by their standing(Freshman, sophomore, junior, senior)
     */
    public void printByStanding() {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = 1 + i; j < size; j++) {
                if ((roster[j].compareTo(roster[min])) == -1) {
                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }

        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = 1 + i; j < size; j++) {

                if (roster[j].getYear().compareTo((roster[min].getYear())) < 0) {

                    min = j;
                }
            }
            Student temp = roster[min];
            roster[min] = roster[i];
            roster[i] = temp;
        }

        //first take this class ordered tog by all years
        //then create another loop and order tog by names
        for (int k = 0; k < size; k++) {

            String output = "";
            output = roster[k] + " (" + roster[k].getYear() + ")";
            System.out.println(output);
        }

    } //print roster sorted by standing

    /**
     * Changes the major of the Student
     *
     * @param p        Given a profile of a student who's major to change
     * @param newMajor Assigning a new major to the student
     * @return true if major has successfully been changed
     */
    public boolean ChangeMajor(Profile p, Major newMajor) {
        //find in roster based on profile
        for (int i = 0; i < size; i++) {
            if (roster[i].getProfile().toString().equals(p.toString())) {
                roster[i].setMajor(newMajor);
                return true;
            }
        }
        return false;
    }

    public Resident findResident(Profile p){
        int NOT_FOUND = -1;
        for (int i = 0; i < size; i++) {
            if (roster[i].getProfile().equals(p)) {
                return (Resident) roster[i];
            }
        }
        return null;
    }

}
