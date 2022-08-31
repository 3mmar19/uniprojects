public class services {
    private int uniqueID;  // Unique id for services
    private String serviceName; // service Name
    private double price; // service price

    // constructor to initialize all data member
    public services(int uniqueID, String name, double price) {
        this.uniqueID = uniqueID;
        this.serviceName = name;
        this.price = price;
    }
//===================--------------------- Getters for all data member------------============================================
    public int getUniqueID() {
        return uniqueID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
    public String toString(){
        return "Service Name : "+serviceName+"\tService ID : "+uniqueID+"\tService Price : SAR"+price;
    }
}
