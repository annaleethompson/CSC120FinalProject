/** 
 * Filename: Weapon.java
 * Decription: class that can create different types of weapons. Contains function changeCoordinates().
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, Final Project
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: May 10, 2023
 */

/**Weapon class */
public class Weapon {

    /**Stores the name of the weapon */
    String name;
    /**Stores the x-coordinate of the weapon */
    int x_pos;
    /**Stores the y-coordinate of the weapon */
    int y_pos;

    /**Constructor
     * @param name the name/weapon type
     * @param x_pos the x-coordinate of the weapon
     * @param y_pos the y-coordinate of the weapon
     */
    public Weapon(String name, int x_pos, int y_pos) {
        this.name = name;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    /**Function that changes the x and y coordinate to ones that are passed in.
     * @param x_pos the x-coordinate of the weapon
     * @param y_pos the y-coordinate of the weapon
     */
    public void changeCoordinates(int x_pos, int y_pos) {
        this.x_pos = x_pos;
        this.y_pos=y_pos;
    }

}