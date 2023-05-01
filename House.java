/**Imports ArrayList from the java.util package */
import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building{

  /**Store House ArrayList of residents and a boolean for whether the house has a dining room. */
  private ArrayList<Room> rooms;
  
  /**Constructor */
  public House(String name, String address) {
    
    super(name, address);
    this.rooms = new ArrayList<Room>();
  }

  /**Accessor for the number of rooms in the house
   * @return the length of the Array List containing all the rooms = the number of residents
   */
  public int nRooms(){
    return rooms.size();
  }

  /**Accessor for whether or not a person is a resident of the house
   * @param person person to be determined if they are a resident of the house
   * @return boolean describing if person is a resident (true = resident, false = not a resident)
   */
  public boolean isRoom(String room) {
    if (this.rooms.size() == 0){
      throw new RuntimeException("Sorry, there are no rooms in this house");
    }
    if (this.rooms.contains(room)){
      System.out.println(room + " is a room in this house");
      return true;
    }
    else {
      System.out.println(room + " is not a room in this house");
      return false;
    }
  }

  public void addRoom(Room room) {
    this.rooms.add(room);
  }

   /*House Extention of the Building toString() method */
  public String toString() {
    String description = super.toString();
    description+=" There are " +this.rooms.size()+ " rooms in this house.";
    return description;
  }

  public static void main(String[] args) {
    House myHouse = new House("Egg", "1 Chapin Way");
    //myHouse.addRoom();
    System.out.println(myHouse.toString());
  }

}