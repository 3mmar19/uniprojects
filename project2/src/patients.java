import java.util.*;
public class patients {
    private  int uniqueID; // to give all patient a unique ID
    private  String firstName;// first name for all patient
    private  String lastName; // last name for all patient
    private  String phoneNumber;// get phone number for all  patient
    private  String Email; // emails for all patient
    private  Doctors myDoctor; // to add doctor with every patient
    enum type {A, B, C}  // enum its like insurance A is the best insurance
    type Types; // create it from enum

    private Vector<services> AllServices;  // to add services for patient

    // constructor to initialize all data member
    public patients(int uniqueID, String firstName, String lastName, type types, String phoneNumber, String email, Doctors doctor, services service) {
        this.uniqueID = uniqueID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Types = types;
        this.phoneNumber = phoneNumber;
        this.Email = email;
        myDoctor = doctor;
        AllServices = new Vector<services>();
        AllServices.add(service);
    }
    // this method for bill
    public void patientBill(){
        System.out.println("Your Bill Details : ");
        double totalPrice=0;
        for (int i =0;i<AllServices.size();i++){
            totalPrice+=AllServices.elementAt(i).getPrice();
        }
        for(int i =0;i<AllServices.size();i++){
            System.out.println(AllServices.elementAt(i));
        }
        if(Types == type.A){ // if the user from A type it will give him a 40% discount
            totalPrice -= totalPrice*0.4;
            System.out.println("Since you are from type A, you have a 40% discount");
        }
        else{
            System.out.println("You are from type : "+ Types);
        }
        System.out.println("Total Price : SAR "+totalPrice);
    }

    public void addServiceToPatient(services newService){
        AllServices.add(newService);
    }
    public Vector<services> getMyServices() {
        return AllServices;
    }
    public int getUniqueID() {
        return uniqueID;
    }

//----------------------------------- (to string) to print all doctor information---------///////////////////////////
    public String toString(){
        String services = "";
        for(int i =0;i<AllServices.size();i++){
            services += i+1+"- "+AllServices.elementAt(i).getServiceName()+"\t";
        }
        return "Patient "+firstName+" "+lastName+"'s Information :"+"\nFull Name : "+firstName+" "+lastName
                +"\nUnique ID : "+uniqueID+"\nPhone Number : "+phoneNumber+"\nEmail Address : "+Email
                +"\nPatient's Doctor : "+myDoctor.getFirstName()+" "+myDoctor.getLastName()+"\t Rank : "+myDoctor.getRank()+"\tSpeciality : "+myDoctor.getSpecialty()
                +"\nPatient's Services : "+services
                +"\n-------------------------------------------------------------------------------------------------";

    }  //====================------------------------------- End  to string method ---------------------------======================//////////////

} //====================------------------------------- End patient class---------------------------======================//////////////
