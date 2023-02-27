/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    /**
     * Default constructor for the Enrollment class
     */
    public Enrollment()
    {
        enrollStudents = null;
        size = 0;
    }
    /**
     * Overloaded constructor for the Enrollment class
     * @param enrollList the list of students to enroll
     * @param s the size of the enrollList
     */
    public Enrollment(EnrollStudent []enrollList, int s)
    {
        enrollStudents=enrollList;
        size = s;
    }

    /**
     * Get the list of students in the EnrollStudent array
     * @return enrollStudents the list of Students enrolled
     */
    public EnrollStudent[] getEnrollStudents() {
        return enrollStudents;
    }

    /**
     * Return the side of the enrollStudent array
     * @return size
     */

    public int getSize()
    {
        return size;
    }

    /**
     * Add a new student to the enrollStudent list
     * @param enrollStudent
     */
    public void add(EnrollStudent enrollStudent)
    {

        enrollStudents[size] = (enrollStudent);
        size++;
    }

    /**
     * Remove a student from the enrollStudent array
     * @param enrollStudent
     */
    public void remove(EnrollStudent enrollStudent)
    {
        int indexOfRemove=0;
        for(int i =0; i<enrollStudents.length; i++)
        {
            if(enrollStudents[i].equals(enrollStudent))
            {
                enrollStudents[i] = null;
                indexOfRemove = i;
            }
        }

        for(int i=indexOfRemove; i<enrollStudents.length-1; i++)
        {
            enrollStudents[indexOfRemove] = enrollStudents[i+1];
        }
        size--;
    }

    /**
     * Check if a student is part of the current EnrollStudent array
     * @param enrollStudent, the student that needs to be contained
     * @return true if the student is found in the EnrollStudent array
     */
    public boolean contains(EnrollStudent enrollStudent)
    {
        for(int i=0; i<enrollStudents.length; i++)
        {
            if(enrollStudents[i].equals(enrollStudent))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * print a list of students in the EnrollStudent array
     */
    public void print()
    {
        for(int i=0; i<enrollStudents.length; i++)
        {
            System.out.print(enrollStudents[i]);
        }
    }

    /**
     * Print the EnrollStudent array from the lowest to highest credits
     */
    public void printByCredits()
    {
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = 1 + i; j < size; j++) {
                if ((enrollStudents[j].compareTo(enrollStudents[min])) == -1) {
                    min = j;
                }
            }
            EnrollStudent temp = enrollStudents[min];
            enrollStudents[min] = enrollStudents[i];
            enrollStudents[i] = temp;

            for (int k = 0; k < size; k++) { //need to fix the things I'm printing here

                String output = "";
                output = enrollStudents[k] + " (" + ")";
                System.out.println(output);
            }
        }
    }

    /**
     * Print the list of students in the EnrollStudent array that a certain credit threshold
     * @param credits that the students need to have completed to be printed
     */
    public void printPastCredits(int credits)
    {
        for(int i =0; i<size; i++)
        {
            if ((enrollStudents[i].getCreditsEnrolled() >= 120))
            {
                System.out.println(enrollStudents[i].toString());
            }
        }
    }


    /**
     * Update the number of credits that a student has
     * @param e the student whose credits are being updated from the EnrollStudent array
     * @param updatedCredits the number of credits being added to the student
     */
    public void updateCredits(EnrollStudent e, int updatedCredits){
        for(int i=0; i<enrollStudents.length; i++) {
            if(enrollStudents[i].equals(e)) {
                EnrollStudent tempEnrolled =  enrollStudents[i];
                tempEnrolled.setCredits(updatedCredits);
            }
        }
    }


}
