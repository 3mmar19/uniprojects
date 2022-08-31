public class Doctors extends employees {
    // two more data member after inheriting
    private String rank;
    private String specialty;

    //-------------------------  constructor to initialize all data member
    public Doctors(int uniqueID, String firstName, String lastName, String phoneNumber, String email, Double salary, String rank, String specialty) {
        super(uniqueID, firstName, lastName, phoneNumber, email, salary);
        this.rank = rank;
        this.specialty = specialty;
    }

    public String getRank() {
        return rank;
    }
    public String getSpecialty() {
        return specialty;
    }
//----------------------------------- (to string) to print all doctor information---------///////////////////////////
    @Override
    public String toString(){
        return"Doctor "+getFirstName()+" "+getLastName()+" information : \n"+"Full name : "+getFirstName()+" "+getLastName()
                +"\nUnique ID : "+getUniqueID()+"\nPhone Number : "+getPhoneNumber()+"\nEmail Address : "+getEmail()
                +"\nRank : "+getRank()+"\tSpecialty : "+getSpecialty()+"\nSalary : "+getSalary() + " SAR"
                +"\n-------------------------------------------------------------------------------------------------";
    }
} // End Doctors class

