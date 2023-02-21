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
    public void add(EnrollStudent enrollStudent)
    {
        enrollStudents[size] = (enrollStudent);
    }

    public void remove(EnrollStudent enrollStudent)
    {
        int indexOfRemove;
        for(int i =0; i<enrollStudents.length; i++)
        {
            if(enrollStudents[i].equals(enrollStudent)
            {
                enrollStudents[i] = null;
                indexOfRemove = i;
            }
        }

        for(int i=indexOfRemove; i<enrollStudents.length-1; i++)
        {
            enrollStudents[indexOfRemove] = enrollStudents[i+1];
        }
    }


    public boolean contains(EnrollStudent enrollStudent)
    {
        for(int i=0; i<enrollStudent.length; i++)
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


}
