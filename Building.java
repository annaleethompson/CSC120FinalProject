public class Building {

    private String name = "<Name Unknown>";
    private String address = "<Address Unknown>";
    //private int nFloors = 1;

    public Building(String name, String address) {
        
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String toString() {
        return this.name + " is a " + "building located at " + this.address+".";
    }

    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063");
        System.out.println(fordHall);
    }

}