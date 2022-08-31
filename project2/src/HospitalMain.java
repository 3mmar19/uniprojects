import java.util.*;  // Importing the whole utility library
public class HospitalMain extends HospitalSystem{  //----- our main class taking inheritance from father class (Banking System)
    static Scanner input = new Scanner(System.in); // asking the user to enter a number to choose from option

    public static void main(String[] args) throws DuplicateServiceIdException
    {
        pNames();  // print the student names
        existingEmployees(); // calling the method or the database for employees
        int i = 1;
        while(i!=0) {
            System.out.println("Enter your last name (to use the system) : ");
            String lastName = input.nextLine();
            for(int j=0;j<AllEmployees.size();j++){
                if(lastName.equals(AllEmployees.elementAt(j).getLastName())){
                    System.out.println("Welcome");
                    i=0;
                }
            } // End for loop
            if(i!=0) {
                System.err.println("Error : Wrong Name!! , Please Try Again ");
            } //end if statement
        }// End while loop
        int option = 0;
        while(option!=9) { //starting a do while loop for our option
            Option(); // calling the option method to show the user all the possible choices
            option = input.nextInt();
            switch (option) { // calling all the option depending on user choice
                case 1: // Add a doctor
                    AddDoctor();
                    break;
                case 2: // add a service
                    AddService();
                    break;
                case 3: // add a patient
                    AddPatient();
                    break;
                case 4: // Print all doctors information
                    for ( i=0;i<AllDoctors.size();i++){
                        System.out.println(AllDoctors.elementAt(i));
                    }
                    System.out.println("Success : Doctors Information Is Displayed Successfully");
                    break;
                case 5: //Print all patients information
                    for ( i=0;i<AllPatients.size();i++){
                        System.out.println(AllPatients.elementAt(i));
                    }
                    System.out.println("Success : Patients Information Is Displayed Successfully");
                    break;
                case 6: // Display specific patient data
                    System.out.println("Enter doctor's unique ID");
                    int drID = input.nextInt();
                    int DoctorID = checkForDoctor(drID);
                    if(DoctorID>=0){
                        System.out.println(AllDoctors.elementAt(DoctorID));
                        System.out.println("Success : Doctor's Information Is Displayed Successfully");
                    }
                    else {
                        System.err.println("Error : Doctor is not found !!");
                    }

                    break;
                case 7: // Print a specific patient’s bill
                    System.out.println("Enter patient's unique ID");
                    int uniqueID= input.nextInt();
                    int patientIndex = checkPatientID(uniqueID);
                    if(patientIndex>=0){
                        System.out.println(AllPatients.elementAt(patientIndex));
                        System.out.println("Success : Patient's Information Is Displayed Successfully");
                    }
                    else{
                        System.err.println("Error : Patient is not found !!");
                    }

                    break;
                case 8: //Print a specific patient’s bill
                    System.out.println("Enter patient's unique ID");
                     uniqueID= input.nextInt();
                     patientIndex = checkPatientID(uniqueID);
                    if(patientIndex>=0){
                        AllPatients.elementAt(patientIndex).patientBill();
                        System.out.println("Success : Patient's Bill Is Displayed Successfully");
                    }
                    else System.err.println("Error : Patient is not found !!");
                    break;
                case 9:
                    System.out.println("Good bye, see you again");
                    break;
                default: // when the user enter a wrong number it will appear this message for him
                    System.err.println("Error: Please choose a valid option");
                    break;
            }
        } // to end the loop

    }  //------------------------------------------ End main method --------------------------------------///////////////////

    private static void pNames(){
        System.out.println("******************************************************\n" +
                "*           Welcome to Our  Hospital System          *\n" +
                "*    Student #1: Ammar Hussain Ahmed, 441017869      *\n" +
                "*    Student #2: Ammar Ibrahim FalLatah, 442014605   *\n" +
                "******************************************************");
    } //------------------------------------------ End print names method --------------------------------------///////////////////
    private static void Option(){
        System.out.println("\nPlease Enter a number of your choice (enter 9 to exit) \n------------------------------------------------------");
        System.out.println("1. Add a doctor");
        System.out.println("2. Add a service");
        System.out.println("3. Add a patient");
        System.out.println("4. Print all doctors information");
        System.out.println("5. Print all patients information");
        System.out.println("6. Display specific doctor data");
        System.out.println("7. Display specific patient data");
        System.out.println("8. Print a specific patient’s bill");
        System.out.println("9. Exit the program");
        System.out.print("\nPlease a choose a choice from 1 to 9: ");
    } //------------------------------------------ End option method --------------------------------------///////////////////

} //---