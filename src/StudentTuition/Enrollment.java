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
        this.enrollStudents = enrollStudents;
        this.size = size;
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

        if (enrollStudents == null) {
            grow();
        }
        if (enrollStudents.length - 1 == size) {
            grow();
        }

        enrollStudents[size] = enrollStudent;
        size++;

    }
    /**
     * Grows the size of the student array by 4
     */
    private void grow() {
        EnrollStudent[] newArray = new EnrollStudent[size + 4];

        if (enrollStudents != null) {
            for (int i = 0; i <= size; i++) {
                newArray[i] = enrollStudents[i];
            }
        }


        enrollStudents = newArray;
    } //increase the array capacity by 4

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
        if(size==0)
        {
            return false;
        }
        for(int i=0; i<enrollStudents.length; i++)
        {
            if (find(enrollStudent) != -1) {
                return true;
            }
        }
        return false;

    }

    /**
     * Finds the index of a student we are looking for
     *
     * @param student student we are searching for
     * @return index of the student that is being searched
     */
    private int find(EnrollStudent student) {
        int NOT_FOUND = -1;
        for (int i = 0; i < size; i++) {
            if (enrollStudents[i].equals(student)) {
                return i;
            }
        }
        return NOT_FOUND;
    } //search the given student in roster


    /**
     * print a list of students in the EnrollStudent array
     */
    public void print()
    {
        for(int i=0; i<size; i++)
        {
            System.out.println(enrollStudents[i].toString());
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
         int index= find(e);
         if(index ==-1)
         {
             return;
         }
         //EnrollStudent tempEnrolled =  enrollStudents[index];
         e.setCredits(updatedCredits);
        }
    }



