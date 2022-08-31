import java.util.*;  // Importing the whole utility library
public class HospitalSystem {  //----- this class its like a system for hospital has all important methods
    static Scanner input = new Scanner(System.in);
    static Vector<Doctors> AllDoctors = new Vector<>(); // to store all doctors data in this Vector
    static Vector<patients> AllPatients = new Vector<>(); // to store all Patients' data in this Vector
    static Vector<services> AllServices = new Vector<>(); // to store all services data in this Vector
    static Vector<administrationStaff> AllEmployees = new Vector<administrationStaff>(); // to store all Employees data in this Vector

    //------- Add five employees to do the operation with them
    public static void existingEmployees(){
        administrationStaff first = new administrationStaff(1, "ammar" , "ahmed", "055446"
                ,"ammar@email.com", 1500.00, "support ");
        administrationStaff second = new administrationStaff(2, "ahmed" , "bashar", "059822"
                ,"ahmed@email.com", 5000.00, "Secretary ");
        administrationStaff third = new administrationStaff(3, "omer" , "noor", "056466"
                ,"omer@email.com", 2500.00, "Manager ");
        AllEmployees.add(first);
        AllEmployees.add(second);
        AllEmployees.add(third);
        Doctors d1st = new Doctors(11, "Mohammed", "adnan", "057855", "moha@gmail.com", 50000.0,
                "specialist", "Medical laboratory");
        Doctors d2nd = new Doctors(12, "Mohammed", "Ahmed", "057855", "moha@gmail.com", 25000.0,
                "Technician", "dentist");
        AllDoctors.add(d1st); AllDoctors.add(d2nd);
}
//--------------------------------------  for adding a new doctor to the system ----------------------------------//////////////////////////
    public static void AddDoctor(){
        System.out.print("Enter Doctors ID: ");   // Enter The  id
        int uniqueID = input.nextInt();//Enter from the keyboard
        if (checkDoctorID(uniqueID)){
            System.out.print("Enter Doctors First Name: "); //Enter  doctor first name
            String firstName = input.next();   //Enter from the keyboard
            System.out.print("Enter Doctors Last Name: "); //Enter  doctor second name
            String lastName = input.next(); //Enter from the keyboard
            System.out.print("Enter Doctors Phone Number: ");//Enter the phone number
            String phoneNumber = input.next(); //Enter from the keyboard
            System.out.print("Enter Doctors Email: "); //Enter the email
            String email = input.next();
            System.out.print("Enter Doctors Salary: ");  // Enter the salary
            Double salary = input.nextDouble(); //Enter from the keyboard
            System.out.print("Enter Doctors Rank: ");  // Enter the rank
            String rank = input.next();  //Enter from the keyboard
            System.out.print("Enter Doctors Specialty: ");
            String specialty = input.next(); //Enter from the keyboard
            Doctors newDoctor = new Doctors(uniqueID, firstName, lastName, phoneNumber, email, salary, rank, specialty);
            AllDoctors.add(newDoctor);
            System.out.println("Success : new Doctor's added Successfully.");
        }else{
            System.err.println("Error : Duplicated unique ID !!");
        }
    }
    //--------------------------------------  for adding a new patient to the system ----------------------------------//////////////////////////
    public static void AddPatient(){
        System.out.println("Enter your Unique ID:");
        int uniqueID = input.nextInt();
        input.nextLine();
        if(checkPatient(uniqueID)) { // to check if there is a Duplicate or not
            System.out.println("Enter your first name : ");
            String firstName = input.nextLine();
            System.out.println("Enter your last name : ");
            String lastName = input.nextLine();
            int type=0;
            patients.type types = patients.type.C;
            while(type!=1&&type!=2&&type!=3) {         // this loop for make they admin choose a type for patient
                System.out.println("Choose your type's number :\n1-A\n2-B\n3-C");
                type = input.nextInt();
                input.nextLine();//To Avoid Stack OverFlow
                switch (type) {
                    case 1: {
                        types = patients.type.A;
                        break;
                    }
                    case 2: {
                        types = patients.type.B;
                        break;
                    }
                    case 3: {
                        types = patients.type.C;
                        break;
                    }
                    default:
                        System.err.println("Invalid Number!!");
                        break;
                }
            }
            System.out.println("Enter your phone number : ");
            String phoneNumber = input.nextLine();
            System.out.println("Enter your email address : ");
            String email = input.nextLine();
            System.out.println("Enter your doctor's unique ID :");
            int doctorID = input.nextInt();  // add a doctor for the patient
            int doctorIndex = checkForDoctor(doctorID);
            if (doctorIndex >= 0) {
                System.out.println("Enter the unique ID for the service that you want to get");
                int serviceID = input.nextInt();
                int serviceIndex = checkForAnExistingService(serviceID);  // add a service for patient
                if (serviceIndex >= 0) {
                    patients newPatient = new patients(uniqueID, firstName, lastName, types, phoneNumber, email, AllDoctors.elementAt(doctorIndex),AllServices.elementAt(serviceIndex));
                    AllPatients.add(newPatient);
                    int newServiceOption = 0;
                    while (newServiceOption!=2){
                        System.out.println("1- Add another service \n2- Finish");
                        newServiceOption = input.nextInt();
                        switch (newServiceOption) {
                            case 1 -> {
                                System.out.println("Enter the unique ID for the service that you want to get :");
                                serviceID = input.nextInt();
                                serviceIndex = checkForAnExistingService(serviceID);
                                if (serviceIndex >= 0) {
                                    for (int i = 0; i < newPatient.getMyServices().size(); i++) {
                                        if (serviceID == newPatient.getMyServices().elementAt(i).getUniqueID()) {
                                            System.err.println("Error : You already have this service");
                                            //newServiceOption=0;
                                            break;
                                        }
                                    }
                                    newPatient.addServiceToPatient(AllServices.elementAt(serviceIndex));
                                } else {
                                    System.err.println("Error : Service is Not Found !!");
                                }
                            }
                            case 2 -> {
                                System.out.println("Success : Patient's Account Is Created Successfully.");
                            }
                            default -> {
                                System.err.println("Error : Wrong Option !!");
                            }
                        }
                    }
                }
                else{
                    System.err.print("Error : This Service is not found !!");
                }
            }
            else {
                System.err.println("Error : This doctor is not found !!");

            }
        }
        else
            System.err.println("Error : Duplicated unique ID !!");
    }
//--------------------------------------  for adding a new service ----------------------------------//////////////////////////
    public static void AddService()throws DuplicateServiceIdException {
        System.out.println("Enter Services ID: ");
        int uniqueID = input.nextInt();
        input.nextLine();
        if (checkServiceID(uniqueID)){ 
        System.out.println("Enter Services name: ");
        String name = input.next();
        System.out.println("Enter Services Price: ");
        double price = input.nextDouble();
        services newService = new services(uniqueID, name, price);
        AllServices.add(newService);
            System.out.println("Success: you added a new service successfully");
        } // end if statement
        else {
            throw new DuplicateServiceIdException("Invalid service ID. This service ID is already utilized");
        }
    }
    ///////////===--------------------------------- For checking Id -----------------------------------=============================
    public static boolean checkDoctorID(int doctorID){
        for(int i =0;i<AllDoctors.size();i++){
            if(doctorID==AllDoctors.elementAt(i).getUniqueID())
                return false;
        }
        return true;
    }

    public static boolean checkServiceID(int serviceID){
        for(int i=0;i<AllServices.size();i++){
            if(serviceID==AllServices.elementAt(i).getUniqueID()){
                return false;
            }
        }
        return true;
    }
    public static boolean checkPatient(int patientID){
        for(int i=0;i<AllPatients.size();i++){
            if(patientID ==AllPatients.elementAt(i).getUniqueID()){
                return false;
            }
        }
        return true;
    }
    public static int checkForDoctor(int doctorID){

        for(int i =0;i<AllDoctors.size();i++){
            if(doctorID==AllDoctors.elementAt(i).getUniqueID()){
                return i;
            }
        }
        return -1;
    }
    public static int checkForAnExistingService(int serviceID){
        for(int i=0;i<AllServices.size();i++){
            if(serviceID ==AllServices.elementAt(i).getUniqueID()){
                return i;
            }
        }
        return -1;
    }
    public static int checkPatientID(int patientID){
        for (int i=0;i<AllPatients.size();i++){
            if(patientID ==AllPatients.elementAt(i).getUniqueID()){
                return i;
            }
        }
        return -1;
    }

} //------------------------------------------ End the class --------------------------------------//////////////////