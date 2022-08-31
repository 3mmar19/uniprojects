public class employees {
     // this class will be super class for doctors and administration
    private  int UniqueID; // to give all employees a unique ID
    private  String firstName; // first name for all employees
    private  String lastName; // last name for all employees
    private  String phoneNumber; // get phone number for all  employees
    private  String Email; // emails for all employees
    private  Double Salary; // salary

    // constructor to initialize all data member
    public employees(int uniqueID, String firstName, String lastName, String phoneNumber, String email, Double salary) {
        this.UniqueID = uniqueID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.Email = email;
        this.Salary = salary;

    }
//===================--------------------- Getters for all data member------------============================================
    public int getUniqueID() {
        return UniqueID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public Double getSalary() {
        return Salary;
    }


} //End the class
