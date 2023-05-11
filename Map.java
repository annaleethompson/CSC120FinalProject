/** 
 * Filename: Map.java
 * Decription: class that adds rooms to a house, adds weapons to rooms, allows the user to enter specific rooms, and navigaates the user through different hallways. Contains functions enterRoom() and hallways().
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, Final Project
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: May 10, 2023
 */

 /**Map Class */
public class Map {
    
    /**Stores the house */
    public House house;
    /**Stores the User */
    public User user;
    /**Adds the clue/center room to the house*/
    public static Room clue = new Room("Clue Room", 0, 0);
    /**Adds the kitchen to the house */
    public static Room kitchen = new Room("Kitchen", 2, 2);
    /**Adds the dining room to the house */
    public static Room dining  = new Room("Dining Room", 2, 0);
    /**Adds the conservatory to the house */
    public static Room conservatory = new Room("Conservatory", 2, -2);
    /**Adds the hall to the house */
    public static Room hall = new Room("Hall", 0, -2);
    /**Adds the theatre to the house */
    public static Room theatre = new Room("Theatre", -2, 0);
    /**Adds the library to the house */
    public static Room library = new Room("Library", -2, 2);
    /**Adds the lounge to the house */
    public static Room lounge = new Room("Lounge", 0, 2);
    /**Adds the study to the house */
    public static Room study = new Room("Study", -2, -2);
    /**Creates a knife */
    public static Weapon knife = new Weapon("knife", 2, 2);
    /**Creates a wrench */
    public static Weapon wrench = new Weapon("wrench", 2, -2);
    /**Creates a rope */
    public static Weapon rope = new Weapon("rope", 0, -2);
    /**Creates a pistol */
    public static Weapon pistol = new Weapon("pistol", -2, -2);
    /**Creates a lead pipe */
    public static Weapon lead_pipe = new Weapon("lead Pipe", 0, 2);
    /**Creates a candlestick*/
    public static Weapon candlestick = new Weapon("candlestick", -2, 2);

    /**Constructor */
    public Map() {
        this.house = new House("Clue", "1 Mystery Lane");
        this.user = new User();
        this.house.addRoom(clue);
        this.house.addRoom(kitchen);
        this.house.addRoom(dining);
        this.house.addRoom(conservatory);
        this.house.addRoom(hall);
        this.house.addRoom(study);
        this.house.addRoom(theatre); 
        this.house.addRoom(library);
        this.house.addRoom(lounge);
        kitchen.weapons.add(knife);
        conservatory.weapons.add(wrench);
        hall.weapons.add(rope);
        study.weapons.add(pistol);
        lounge.weapons.add(lead_pipe);
        library.weapons.add(candlestick);
    }

    /**Function that 'enters' the user into different rooms based on their coordinates 
     * @param x_position the x-coordinate of the users current position
     * @param y_position the y-coordinate of the users current position
    */
    public static void enterRoom(int x_position, int y_position) {
        if (x_position ==-2 && y_position == 0) {
            theatre.enterRoom();
        }
        if (x_position == 0 && y_position == 0) {
            clue.enterRoom();
        }
        if (x_position == 2 && y_position == 0) {
            dining.enterRoom();
        }
        if (x_position ==-2 && y_position == 2) {
            library.enterRoom(); 
        }
        if (x_position ==0 && y_position == 2) {
            lounge.enterRoom();
        }
        if (x_position ==2 && y_position == 2) {
            kitchen.enterRoom();
        }
        if (x_position ==-2 && y_position == -2) {
            study.enterRoom();
        }
        if (x_position ==0 && y_position == -2) {
            hall.enterRoom();
        }
        if (x_position ==2 && y_position == -2) {
            conservatory.enterRoom();
        }
        if (x_position ==-1 || x_position ==1 || y_position ==-1 ||y_position ==1) {
            hallways(x_position, y_position);
        }
    }

    /**Function that prints statements based on which hallway the user is in. 
     * @param x_position the x-coordinate of the users current position
     * @param y_position the y-coordinate of the users current position
     */
    public static void hallways(int x_position, int y_position) {
        if (x_position ==-1 && y_position ==2) {
            System.out.println("This is a deadend. South of you is the hallway you came from.");
            System.out.println("In this corner there is a a chair beside a window looking out onto the yard. You notice a crumpled up napkin in the cushion of the chair. ");
        }
        if (x_position ==-1 && y_position ==1) {
            System.out.println("The hallway continues in all directions from here. ");
        }
        if (x_position ==-1 && y_position ==0) {
            System.out.println("North and south of you the hallway continues. To your west and east there are rooms");
        }
        if (x_position ==-1 && y_position ==-1) {
            System.out.println("The hallway continues in all directions from here.");
        }
        if (x_position ==-1 && y_position ==-2) {
            System.out.println("This is a deadend. North of you is the hallway you came from.");
        }
        if (x_position ==1 && y_position ==2) {
            System.out.println("This is a deadend. South of you is the hallway you came from.");
        }
        if (x_position ==1 && y_position ==1) {
            System.out.println("The hallway continues in all directions from here.");
        }
        if (x_position ==1 && y_position ==0) {
            System.out.println("North and south of you the hallway continues. To your west and east there are rooms");
        }
        if (x_position ==1 && y_position ==-1) {
            System.out.println("The hallway continues in all directions from here.");
        }
        if (x_position ==1 && y_position ==-2) {
            System.out.println("This is a deadend. North of you is the hallway you came from.");
            System.out.println("To you right, close to the northern hallway you spot a hankerchief on the ground. ");
        }
        if (x_position ==-2 && y_position==1) {
            System.out.println("To your north there is a room and to your east is the hallway you came from.");
        }
        if (x_position ==0 && y_position==1) {
            System.out.println("West and east of you the hallway continues. To your north and south there are rooms");
        }
        if (x_position ==2 && y_position==1) {
            System.out.println("To your north there is a room and to your west is the hallway you came from.");
        }
        if (x_position ==-2 && y_position==-1) {
            System.out.println("To your south there is a room and to your east is the hallway you came from.");
            System.out.println("On the ground you spot a red piece of hair");
        }
        if (x_position ==0 && y_position==-1) {
            System.out.println("West and east of you the hallway continues. To your north and south there are rooms");
        }
        if (x_position ==2 && y_position==-1) {
            System.out.println("To your south there is a room and to your west is the hallway you came from.");
            System.out.println("You spot a bookmark on the floor in a dark corner besides a window.");
        }
    } 
}