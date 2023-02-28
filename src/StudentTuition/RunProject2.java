/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RunProject2 {
    public static void main(String[] args) throws FileNotFoundException {
        try{
            new StudentTuition.TuitionManager().run();

        }
        catch(IOException e)
        {
            System.out.println("no file found");
        }

    }

}
