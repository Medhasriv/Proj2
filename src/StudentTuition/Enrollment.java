/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    public Enrollment()
    {
        enrollStudents = null;
        size = 0;
    }

    public Enrollment(EnrollStudent []enrollList, int s)
    {
        enrollStudents=enrollList;
        size = s;
    }

    public EnrollStudent[] getEnrollStudents() {
        return enrollStudents;
    }

    public int getSize()
    {
        return size;
    }
    public void add(EnrollStudent enrollStudent)
    {

        enrollStudents[size] = (enrollStudent);
        size++;
    }

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

    public void print()
    {
        for(int i=0; i<enrollStudents.length; i++)
        {
            System.out.print(enrollStudents[i]);
        }
    }


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



    public void updateCredits(EnrollStudent e, int updatedCredits){
        for(int i=0; i<enrollStudents.length; i++) {
            if(enrollStudents[i].equals(e)) {
                EnrollStudent tempEnrolled =  enrollStudents[i];
                tempEnrolled.setCredits(updatedCredits);
            }
        }
    }


}
