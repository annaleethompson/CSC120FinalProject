/** 
 * Filename: House.java
 * Decription: class that extends building and creates a house with an arraylist containing all the rooms. Contains function addRoom().
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, Final Project
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: May 10, 2023
 */

/**Imports ArrayList from the java.util package */
import java.util.ArrayList;

/*House class */
public class House extends Building{

  /**Stores House ArrayList of rooms. */
  private ArrayList<Room> rooms;
  
  /**Constructor */
  public House(String name, String address) {
    super(name, address);
    this.rooms = new ArrayList<Room>();
  }

  /**Function that adds a room to the houses arraylist of rooms
   * @param room room that is added to the arraylist of rooms
   */
  public void addRoom(Room room) {
    this.rooms.add(room);
  }
}