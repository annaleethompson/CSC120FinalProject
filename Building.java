/** 
 * Filename: Building.java
 * Decription: class that creates a building with parameters name and address. 
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, Final Project
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: May 10, 2023
 */

/**Building Class */
public class Building {

    /**Stores the string containing the buildings name. */
    private String name = "<Name Unknown>";
    /**Stores the string containing the buildings address. */
    private String address = "<Address Unknown>";

    /**Constructor
     * @param name the name of the building
     * @param address the address of the building
     */
    public Building(String name, String address) {
        
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
    }

}