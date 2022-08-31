public class administrationStaff extends employees {
    private String position;

    // constructor to initialize all data member
    public administrationStaff(int uniqueID, String firstName, String lastName, String phoneNumber, String email, Double salary, String position) {
        super(uniqueID, firstName, lastName, phoneNumber, email, salary);
        this.position = position;

    }
    //===================--------------------- Getters for all data member------------============================================
    public String getPosition() {
        return position;
    }
}
