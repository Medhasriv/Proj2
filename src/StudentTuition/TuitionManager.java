/**
 * @author Shreya Pandey
 * @author Medhasri Veldurthi
 */
package StudentTuition;
import StudentTuition.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class TuitionManager {
    Scanner input  = new Scanner(System.in);
    Roster newRoster = new Roster();
    Enrollment enrollmentList = new Enrollment();

    /**
     * Reads all the line commands until the user types Q
     */
    public void run() throws FileNotFoundException {

        System.out.print("Roster Manager running...\n");
        String inputString;
        boolean checkQuit = false;


        while((input.hasNext()) && !checkQuit) {
            inputString = input.nextLine();
            if(inputString.equals("Q")) {
                System.out.print("Roster Manager terminated");
                checkQuit = true;
                break;
            }else if(inputString.equals("LS")){

                try{
                    Scanner fileScanner = new Scanner(new File("studentList.txt"));
                    while(fileScanner.hasNextLine())
                    {
                        String line = fileScanner.nextLine();
                        String inputStringValue = inputString.replace(',', ' ');
                        assignValues("A" + inputStringValue);
                    }
                }
                catch(FileNotFoundException e)
                {
                    System.out.println("no file found");
                }

            }else{
                assignValues(inputString); //we also need to print updated list once before Q
            }
        }
        input.close();
    }

    /**
     * Helper method to the run() class that takes in the input and performs the command needed
     * @param inputString String that is the input letter, (EX: "A")
     */
    public void assignValues(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString, " ");

        //this list will be used
        String[] majorList = {"CS", "EE","ITI", "BAIT","MATH"};
        String action = st.nextToken();


//        if(action.equals("A")) {
//            //string tokenizer to divide up the string
//
//            String firstName = st.nextToken();
//            String lastName = st.nextToken();
//            String dob = st.nextToken();
//            String major = st.nextToken().toUpperCase();
//            int credits = Integer.parseInt((st.nextToken()));
//
//            //current date + checking if valid
//            Date d = new Date(dob);
//            boolean isValid = d.isValid();
//
//            //making a student profile and age is valid
//            Profile thisStudent = new Profile(lastName, firstName, d);
//            int age = thisStudent.getAge();
//
//            //checking if major exists
//            boolean containsMajor = false;
//            for(int i=0; i<majorList.length; i++){
//                if(majorList[i].equals(major)){
//                    containsMajor = true;
//                }
//            }
//
//            //checking for valid DOB + age, adding an ENUM if this exists
//            if(age > 16){
//                if (isValid) {
//                    if (containsMajor) {
//                        Major studentMajorEnum = Major.valueOf(major);
//                        //making sure credits are positive
//                        if (credits >= 0) {
//                            //checking if student is in the roster, then adding student meeting all requirements
//                            Student newStudent;
////                            newStudent = new Student(thisStudent, studentMajorEnum, credits);
////                            if (!newRoster.contains(newStudent)) {
////                                newRoster.add(newStudent);
//                                System.out.println(thisStudent.toString() + " added to the roster.");
//                            }else{
//                                System.out.println(thisStudent.toString()+" is already in the roster.");
//                            }
//                        }else{
//                            System.out.println("Credits completed invalid: cannot be negative!");
//                        }
//                    }else{
//                        System.out.println("Major code invalid:" + major.toString());
//                    }
//                }else{
//                    System.out.println("DOB invalid: " + dob.toString() + " not a valid calendar date!");
//                }
//            }else{
////                System.out.println("DOB invalid: " + dob.toString() + " is younger than 16 years old.");
//            }

        if(action.equals("AR")){
                String firstName = st.nextToken();
                String lastName = st.nextToken();
                String dob = st.nextToken();
                String major = st.nextToken().toUpperCase();
                int credits = Integer.parseInt((st.nextToken()));

                //current date + checking if valid
                Date d = new Date(dob);
                boolean isValid = d.isValid();

                //making a student profile and age is valid
                Profile thisStudent = new Profile(lastName, firstName, d);
                int age = thisStudent.getAge();

                //checking if major exists
                boolean containsMajor = false;
                for(int i=0; i<majorList.length; i++){
                    if(majorList[i].equals(major)){
                        containsMajor = true;
                    }
                }

                //checking for valid DOB + age, adding an ENUM if this exists
                if(age > 16){
                    if (isValid) {
                        if (containsMajor) {
                            Major studentMajorEnum = Major.valueOf(major);
                            //making sure credits are positive
                            if (credits >= 0) {
                                //checking if student is in the roster, then adding student meeting all requirements
                                Resident newResident = new Resident(thisStudent, studentMajorEnum, credits);
                                if (!newRoster.contains(newResident)) {
                                    newRoster.add(newResident);
                                    System.out.println(thisStudent.toString() + " added to the roster.");
                                }else{
                                    System.out.println(thisStudent.toString()+" is already in the roster.");
                                }
                            }else{
                                System.out.println("Credits completed invalid: cannot be negative!");
                            }
                        }else{
                            System.out.println("Major code invalid:" + major.toString());
                        }
                    }else{
                        System.out.println("DOB invalid: " + dob.toString() + " not a valid calendar date!");
                    }
                }else{
                    System.out.println("DOB invalid: " + dob.toString() + " is younger than 16 years old.");
                }
        }else if(action.equals("AN")) {
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            String major = st.nextToken().toUpperCase();
            int credits = Integer.parseInt((st.nextToken()));

            //current date + checking if valid
            Date d = new Date(dob);
            boolean isValid = d.isValid();

            //making a student profile and age is valid
            Profile thisStudent = new Profile(lastName, firstName, d);
            int age = thisStudent.getAge();

            //checking if major exists
            boolean containsMajor = false;
            for (int i = 0; i < majorList.length; i++) {
                if (majorList[i].equals(major)) {
                    containsMajor = true;
                }
            }

            //checking for valid DOB + age, adding an ENUM if this exists
            if (age > 16) {
                if (isValid) {
                    if (containsMajor) {
                        Major studentMajorEnum = Major.valueOf(major);
                        //making sure credits are positive
                        if (credits >= 0) {
                            //checking if student is in the roster, then adding student meeting all requirements
                            Resident newNonResident = new Resident(thisStudent, studentMajorEnum, credits);
                            if (!newRoster.contains(newNonResident)) {
                                newRoster.add(newNonResident);
                                System.out.println(thisStudent.toString() + " added to the roster.");
                            } else {
                                System.out.println(thisStudent.toString() + " is already in the roster.");
                            }
                        } else {
                            System.out.println("Credits completed invalid: cannot be negative!");
                        }
                    } else {
                        System.out.println("Major code invalid:" + major.toString());
                    }
                } else {
                    System.out.println("DOB invalid: " + dob.toString() + " not a valid calendar date!");
                }
            } else {
                System.out.println("DOB invalid: " + dob.toString() + " is younger than 16 years old.");
            }
        }else if(action.equals("AT")){
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            String major = st.nextToken().toUpperCase();
            int credits = Integer.parseInt((st.nextToken()));
            String state = st.nextToken().toUpperCase();

            //current date + checking if valid
            Date d = new Date(dob);
            boolean isValid = d.isValid();

            //making a student profile and age is valid
            Profile thisStudent = new Profile(lastName, firstName, d);
            int age = thisStudent.getAge();

            //checking if major exists
            boolean containsMajor = false;
            for (int i = 0; i < majorList.length; i++) {
                if (majorList[i].equals(major)) {
                    containsMajor = true;
                }
            }

            //checking for valid DOB + age, adding an ENUM if this exists
            if (age > 16) {
                if (isValid) {
                    if (containsMajor) {
                        Major studentMajorEnum = Major.valueOf(major);
                        //making sure credits are positive
                        if (credits >= 0) {
                            //checking if student is in the roster, then adding student meeting all requirements
                            TriState newTriState = new TriState(thisStudent, studentMajorEnum, credits, state);
                            if (!newRoster.contains(newTriState)) {
                                newRoster.add(newTriState);
                                System.out.println(thisStudent.toString() + " added to the roster.");
                            } else {
                                System.out.println(thisStudent.toString() + " is already in the roster.");
                            }
                        } else {
                            System.out.println("Credits completed invalid: cannot be negative!");
                        }
                    } else {
                        System.out.println("Major code invalid:" + major.toString());
                    }
                } else {
                    System.out.println("DOB invalid: " + dob.toString() + " not a valid calendar date!");
                }
            } else {
                System.out.println("DOB invalid: " + dob.toString() + " is younger than 16 years old.");
            }
        }else if(action.equals("AI")){
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            String major = st.nextToken().toUpperCase();
            int credits = Integer.parseInt((st.nextToken()));
            boolean abroad = Boolean.parseBoolean((st.nextToken()));

            //current date + checking if valid
            Date d = new Date(dob);
            boolean isValid = d.isValid();

            //making a student profile and age is valid
            Profile thisStudent = new Profile(lastName, firstName, d);
            int age = thisStudent.getAge();

            //checking if major exists
            boolean containsMajor = false;
            for (int i = 0; i < majorList.length; i++) {
                if (majorList[i].equals(major)) {
                    containsMajor = true;
                }
            }

            //checking for valid DOB + age, adding an ENUM if this exists
            if (age > 16) {
                if (isValid) {
                    if (containsMajor) {
                        Major studentMajorEnum = Major.valueOf(major);
                        //making sure credits are positive
                        if (credits >= 0) {
                            //checking if student is in the roster, then adding student meeting all requirements
                            International i = new International(thisStudent, studentMajorEnum, credits, abroad);
                            if (!newRoster.contains(i)) {
                                newRoster.add(i);
                                System.out.println(thisStudent.toString() + " added to the roster.");
                            } else {
                                System.out.println(thisStudent.toString() + " is already in the roster.");
                            }
                        } else {
                            System.out.println("Credits completed invalid: cannot be negative!");
                        }
                    } else {
                        System.out.println("Major code invalid:" + major.toString());
                    }
                } else {
                    System.out.println("DOB invalid: " + dob.toString() + " not a valid calendar date!");
                }
            } else {
                System.out.println("DOB invalid: " + dob.toString() + " is younger than 16 years old.");
            }

        }else if(action.equals("E")){
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            int credits = Integer.parseInt((st.nextToken()));

            //Checking date + making profile
            Date d = new Date(dob);
            boolean isValid = d.isValid();
            Profile enrollProfile = new Profile(lastName, firstName, d);

            //making enrollStudent and adding/updating credits
            EnrollStudent newEnroll = new EnrollStudent(enrollProfile, credits);
            if(enrollmentList.contains(newEnroll)){
                //updating the credits if student already enrolled
                enrollmentList.updateCredits(newEnroll, credits);
            }else{
                enrollmentList.add(newEnroll);
            }

        }else if(action.equals("D")){
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            int credits = Integer.parseInt((st.nextToken()));

            //Checking date + making profile
            Date d = new Date(dob);
            boolean isValid = d.isValid();
            Profile enrollProfile = new Profile(lastName, firstName, d);

            //making enrollStudent and removing if present
            EnrollStudent newEnroll = new EnrollStudent(enrollProfile, credits);
            if(enrollmentList.contains(newEnroll)){
                enrollmentList.remove(newEnroll);
            }else {
                System.out.println("Your student is not enrolled");
            }

        }else if(action.equals("S")){
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            int scholarshipAmt = Integer.parseInt((st.nextToken()));

            //temporary profile to search for the resident
            Date d = new Date(dob);
            boolean isValid = d.isValid();
            Profile findRes = new Profile(lastName, firstName, d);

            //find if resident is in the roster
            Resident r = newRoster.findResident(findRes);
            if(r!=null){
                //if yes then award scholarship
                r.setScholarship(scholarshipAmt);
            }else{
                System.out.println("Resident not found.");
            }

        }else if(action.equals("PE")) //display the current enrollment list, based on their order in the array
        {

            if(enrollmentList.getSize() == 0)
            {
                System.out.println("Student enrollment list is empty");
            }
            else
            {
                enrollmentList.print();
            }

        }
        else if(action.equals("PT")) //display the tuition based on credits
        {
            if(enrollmentList.getSize() == 0)
            {
                System.out.println("Student enrollment list is empty");
            }
            else
            {
                enrollmentList.printByCredits();
            }

        }else if(action.equals("SE"))
            //semester end to add the enrolled credits to the credit
            //completed in the roster and print out students who have already
            //completed 120 credits or more.
        {
            if(enrollmentList.getSize() == 0)
            {
                System.out.println("Student enrollment list is empty");
            }
            else
            {
                //add enrolled credits to credit completed in the roster
                for(int i =0; i<enrollmentList.getSize(); i++)
                {
                    //updateCredits(EnrollStudent e, int creditsCompleted)
                    EnrollStudent[] enrollmentStudentsList = enrollmentList.getEnrollStudents();
                    enrollmentList.updateCredits(enrollmentStudentsList[i], enrollmentStudentsList[i].getCreditsEnrolled());
                }

                enrollmentList.printPastCredits(120);
            }


        }else if(action.equals("R")) {
            //string tokenizer takes in first name, last name, date of birth
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();

            //making the Date, Profile, and Student
            Date RMDate = new Date(dob);
            Profile RMProfile = new Profile(lastName, firstName, RMDate);
            Student RMStudent = newRoster.ProfileToStudent(RMProfile);
            boolean isRemoved = newRoster.remove(RMStudent);
            if(isRemoved) {
                System.out.println(RMProfile.toString() + " removed from the roster.");
            }else{
                System.out.println(RMProfile.toString() + " is not in the roster.");
            }
        } else if(action.equals("P")) {
            if(newRoster.getSize() == 0)
            {
                System.out.println("Student roster is empty");
            }
            else
            {
                newRoster.print();
            }
        } else if(action.equals("PS")) {
            if(newRoster.getSize() == 0)
            {
                System.out.println("Student roster is empty!");
            }
            else
            {
                newRoster.printByStanding();
            }
        } else if(action.equals("PC")) {
            if(newRoster.getSize() == 0)
            {
                System.out.println("Student roster is empty!");
            }
            else
            {
                newRoster.printBySchoolMajor();
            }
        } else if(action.equals("L")) {
            if(newRoster.getSize() == 0)
            {
                System.out.println("Student roster is empty!");
            }
            else
            {
                String schoolName = st.nextToken().toUpperCase();
                newRoster.printBySchool(schoolName);
            }

        } else if(action.equals("C")) {
            //takes in info about student
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dob = st.nextToken();
            String newMajor = st.nextToken();

            //making the Date & Profile
            Date CDate = new Date(dob);
            Profile CProfile = new Profile(lastName, firstName, CDate);
            Major MajorEnum = Major.valueOf(newMajor);

            //Changing the major of the student
            boolean isChanged = newRoster.ChangeMajor(CProfile, MajorEnum);
            if(isChanged){
                System.out.println(CProfile.toString() +" major changed to " + newMajor.toString());
            }else{
                System.out.println("Student not found");
            }
        } else if(action.equals("Q")) {
            System.out.println("Roster Manager terminated.");
            return;
        }else {
            System.out.println(action.toString() + " is an invalid command!");
        }

    }
}

