/** 
 * Filename: Conversation.java
 * Decription: Class that takes in user input and calls on certain user functions. Contains functions accuse(), win(), and main(). 
 * A part of CSC 120-02: Object-Oriented Programming, Smith College Spring 2023, Final Project
 * @author Anna-Lee Thompson (@annaleethompson)
 * Date: May 10, 2023
 */

/**Imports Scanner from the java.util package */
import java.util.Scanner;
/**Imports TimeUnit from the java.util.concurrent package */
import java.util.concurrent.TimeUnit;

/**Conversation class */
public class Conversation {
    
    /**Stores the boolean that describes whether the user has won, true=user continues playing, false=user won the game */
    public static boolean won;
    /**Stores the resopnses that the user inputs as strings */
    public static String response;
    /**Stores that contains the users accusation. */
    public static String accusation;
    /**Stores the boolean that describes whether the user has the murderer correct in their accusation. */
    private static boolean ac_murderer = false;
    /**Stores the boolean that describes whether the user has the murder weapon correct in their accusation. */
    private static boolean ac_murder_weapon = false;
    /**Stores the boolean that describes whether the user has the room where the murder occured correct in their accusation. */
    private static boolean ac_murder_room = false;
    /**Stores the starting time to be used in a timer if the user gets their accusation partially wrong. */
    static long startTime;
    /**Stores the amount of time that has passed since the timer has started. */
    static long elapsedTime;
    /**Stores an integer that is equal to the number of times the user has accused. */
    private static int numAccuse=0;
   
    /**Function that is called when the user is trying to accuse someone of the murder. Throws exeptions if the user trys to enter multiple responses and otherwise changes the boolean values for each aspect of the murder if the user inputted it and then calls win() to see if the user won. 
    *@param accusation the string containing the accusation that the user inputted. 
    *@return boolean describing if the user has won the game.
    */
    public static boolean accuse(String accusation) {
        if (accusation.contains("green")) {
            if (accusation.contains("peacock") || accusation.contains("white") || accusation.contains("plum") || accusation.contains("mustard") || accusation.contains("scarlet")) {
                throw new RuntimeException("You cannot accuse more than one person");
            }
            else {
                ac_murderer = true;
            }
        }
        if (accusation.contains("pipe")) {
            if (accusation.contains("knife") || accusation.contains("wrench") || accusation.contains("pistol") ||accusation.contains("rope") ||accusation.contains("candlestick")) {
                throw new RuntimeException("You cannot suspect multiple weapons.");
            }
            else {
                ac_murder_weapon = true;
            }
        }
        if (accusation.contains("library")) {
            if (accusation.contains("kitchen") || accusation.contains("dining") || accusation.contains("conservatory") ||accusation.contains("hall") ||accusation.contains("study") ||accusation.contains("lounge") ||accusation.contains("theatre")) {
                throw new RuntimeException("You cannot suspect multiple room");
            }
            else {
                ac_murder_room = true;
            }
        }
        return win();
    }

    /** Function that determines if the user will win the game. If the user gets all aspects of the crime correct they win, if they get all aspect wrong they can go back and continue playing. However if they get some but not all of the crime correct then they only have 20 minuted to determine the rest of the crime otherwise the murderer gets them next. 
     * @return boolean describing if the user has won the game. 
     */
    public static boolean win() {
        if (ac_murder_room==true && ac_murder_weapon==true && ac_murderer==true) {
            System.out.println("Conratulations you solved the crime!");
            won=false;
        }
        if (ac_murder_room==false && ac_murderer==false && ac_murder_weapon==false) {
            System.out.println("You have all aspects of the crime incorrect :(");
            System.out.println("You may continue searching the rooms for clues.");
        }
        else {
            if ((ac_murder_room==true && ac_murder_weapon==true) || (ac_murder_weapon==true && ac_murderer==true) || (ac_murder_room==true && ac_murderer==true)) {
                System.out.println("You have two aspects of the crime correct and one incorrect.");
            }
            else if (ac_murder_room==true || ac_murder_weapon==true || ac_murderer==true) {
                System.out.println("You have one aspect of the crime correct and two incorrect");
            }
            if (numAccuse==0) {
                numAccuse+=1;
                long startTime = System.currentTimeMillis();
                System.out.println("The murder has found out that you have some of the crime figured out. You only have twenty minutes to solve the crime before the killer gets you next. ");
                Scanner scanner = new Scanner(System.in);
                while (won=true) {
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    if (elapsedTime >= 60000) { //1,200,000 = 20 min
                        System.out.println("\nTime is up and the killer approches you.");
                        if (User.weapons.size()==0) {
                            System.out.println("You have nothing defend yourself and die. ");
                            won=false;
                            break;
                        }
                        else {
                            System.out.println("You use the " +User.weapons.get(0).name + " you were carrying to defeat the murderer. \nCongratulations! You were able to survive the investigation, but were unable to solve the mystery.");
                            won=false;
                            break;
                        }
                    }
                    if (elapsedTime<60000) {
                        response = scanner.nextLine();
                        if (response.contains("Pick") || response.contains("pick") || response.contains("Grab") || response.contains("grab")) {
                            try {
                                User.grab(response);
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Drop") || response.contains("drop") || response.contains("Leave") || response.contains("leave")) {
                            try {
                                User.drop(response);
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Open") || response.contains("open")) {
                            try {
                                User.open(response);
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("West") || response.contains("west") || response.contains("Left") || response.contains("left")) {
                            try {
                                User.goWest();
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("East") || response.contains("east") || response.contains("Right") || response.contains("right")) {
                            try {
                                User.goEast();
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("North") || response.contains("north")|| response.contains("Up") || response.contains("up")) {
                            try {
                                User.goNorth();
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("South") || response.contains("south") || response.contains("Down") || response.contains("down")) {
                            try {
                                User.goSouth();
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Watch") || response.contains("watch")) {
                            try {
                                User.watch();
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Talk") || response.contains("talk")|| response.contains("Say hi") || response.contains("Say hi")) {
                          try {
                                User.talk(response);
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Ask") || response.contains("ask")) {
                            try {
                                  User.ask(response);
                            }catch (Exception e) {
                                  System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Eat") || response.contains("eat")) {
                            try {
                                  User.eat(response);
                            }catch (Exception e) {
                                  System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Read") || response.contains("read")) {
                            try {
                                  User.read();
                            }catch (Exception e) {
                                  System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Examine") || response.contains("examine") || response.contains("Look") || response.contains("look") || response.contains("Uncrumple") || response.contains("uncrumple")) {
                            try {
                                  User.examine(response);
                            }catch (Exception e) {
                                  System.out.println(e.getMessage());
                            }
                        }
                        else if (response.contains("Yes") || response.contains("yes")) {
                            if (User.x_position==0 && User.y_position==0) {
                                //scanner.close();
                                System.out.println("Enter your accusation:");
                                accusation = scanner.nextLine();
                                try {
                                    accuse(accusation.toLowerCase());
                                    //Scanner scanner = new Scanner(System.in);
                              }catch (Exception e) {
                                    System.out.println(e.getMessage());
                              }
                            }
                            else {
                                System.out.println("You cannot accuse in this room. ");
                            }
                        }
                        else if (response.contains("Time") || response.contains("time")) {
                            if (elapsedTime==0) {
                                throw new RuntimeException("There is currently no ongoing timer. ");
                            }
                            else {
                                System.out.println("Time remaining: " +(20-(TimeUnit.MILLISECONDS.toMinutes(elapsedTime))) + " minutes");
                            }
                        }
                        else if (response.contains("Format") || response.contains("format")) {
                            System.out.println("Here is some important formatting information:");
                            System.out.println("\n-In order to move around the hallways and enter rooms you need to type the direction you want to go: North, South, West, East or Up, Down, Left, Right");
                            System.out.println("\n-When asking characters for clues do not include the characters name who you are talking to. For example, you should say 'ask if they saw the student in the classroom' not 'ask the teacher if they saw the student in the classroom'.");
                            System.out.println("\n-When attempting to interact with objects or characters you must mention their/its name. Ex: 'open envelope'");
                            System.out.println("\n-All text should be lower case or title case\n");
                        }
                        else if (response.contains("Help") || response.contains("help")) {
                            System.out.println("Here is a list of all the possible actions and if they coorespond to user/objects/weapons/characters.");
                            System.out.println("\nPick/Grab - weapon");
                            System.out.println("Drop/Leave - weapon; if you drop a weapon in room or hallway that is not its original location, when you come back it won't tell you its there. Therefore, you must remember where you drop weapons if you want to pick them up again. ");
                            System.out.println("Open - envelope, book, drawer, closet");
                            System.out.println("North/Up - user");
                            System.out.println("South/Down - user");
                            System.out.println("East/Right - user");
                            System.out.println("West/Left - user");
                            System.out.println("Watch - movie");
                            System.out.println("Talk - character");
                            System.out.println("Ask - character");
                            System.out.println("What happened - body part");
                            System.out.println("Eat - food");
                            System.out.println("Examine/Look/Uncrumple - weapons, objects\n");
                            System.out.println("Thank - character");
                            System.out.println("Inventory - user");
                            System.out.println("List - character, weapons, rooms; prints a list of all elements");
                        }
                        else if (response.contains("List") || response.contains("list")) {
                            if (response.contains("Weapon") || response.contains("weapon")) {
                                System.out.println("\nWeapons:");
                                System.out.println("\nCandlestick");
                                System.out.println("Knife");
                                System.out.println("Lead pipe");
                                System.out.println("Pistol");
                                System.out.println("Rope");
                                System.out.println("Wrench\n"); 
                            }
                            else if (response.contains("Room") || response.contains("room")) {
                                System.out.println("\nRooms:");
                                System.out.println("\nConservatory");
                                System.out.println("Dining Room");
                                System.out.println("Hall");
                                System.out.println("Kitchen");
                                System.out.println("Library");
                                System.out.println("Lounge");
                                System.out.println("Study");
                                System.out.println("Theatre");
                                System.out.println("Wrench\n"); 
                            }
                            else if (response.contains("Characters") || response.contains("characters") || response.contains("Suspects") || response.contains("suspects") || response.contains("People")|| response.contains("people")) {
                                System.out.println("\nSuspects:");
                                System.out.println("\nMr.Green");
                                System.out.println("Colonel Mustard");
                                System.out.println("Peacock");
                                System.out.println("Professor Plum");
                                System.out.println("Scarlet");
                                System.out.println("Ms. White\n");
                                
                            }
                            else {
                                System.out.println("List of what? Formatting: 'list of ____'");
                            }
                        }
                        else if (response.contains("Thank") || response.contains("thanks")) {
                            try {
                                User.thank();
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                          }
                        }
                        else if (response.contains("Inventory") || response.contains("inventory")) {
                            try {
                                User.inventory();
                            }catch (Exception e) {
                                System.out.println(e.getMessage());
                          }
                        }
                        else {
                            System.out.println("I don't know what this means.");
                        }
                    
                    }
                
                }
                
            }
         
        }  
        return won;
    }

    /**Main function that begins the game, takes in the users input using a scanner, and calls on functions in the User class depending on the users input. */
    public static void main(String[] arguments) {
        //User user = new User();
        System.out.println("Clue: A Murder Mystery");
        
        
        System.out.println("████████████████████████████████████████████████████████████████████");
        System.out.println("█░░░░░░░░░░░░░░█░░░░░░█████████░░░░░░██░░░░░░█░░░░░░░░░░░░░░████████");
        System.out.println("█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░████████");
        System.out.println("█░░▄▀░░░░░░░░░░█░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░█░░░░░░█");
        System.out.println("█░░▄▀░░█████████░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░█████████░░▄▀░░█");
        System.out.println("█░░▄▀░░█████████░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░█░░░░░░█");
        System.out.println("█░░▄▀░░█████████░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░████████");
        System.out.println("█░░▄▀░░█████████░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░█░░░░░░█");
        System.out.println("█░░▄▀░░█████████░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░█████████░░▄▀░░█");
        System.out.println("█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░░░░░█░░░░░░█");
        System.out.println("█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░████████");
        System.out.println("█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░████████");
        System.out.println("███████████████████████████████████████████████████████████████████████████████████████████████");
        
        System.out.println("█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.println("█░█▀▀█░░░▒█▀▄▀█░▒█░▒█░▒█▀▀█░▒█▀▀▄░▒█▀▀▀░▒█▀▀█░░░▒█▀▄▀█░▒█░░▒█░▒█▀▀▀█░▀▀█▀▀░▒█▀▀▀░▒█▀▀█░▒█░░▒█░█ ");
        System.out.println("█▒█▄▄█░░░▒█▒█▒█░▒█░▒█░▒█▄▄▀░▒█░▒█░▒█▀▀▀░▒█▄▄▀░░░▒█▒█▒█░▒█▄▄▄█░░▀▀▀▄▄░░▒█░░░▒█▀▀▀░▒█▄▄▀░▒█▄▄▄█░█ ");
        System.out.println("█▒█░▒█░░░▒█░░▒█░░▀▄▄▀░▒█░▒█░▒█▄▄▀░▒█▄▄▄░▒█░▒█░░░▒█░░▒█░░░▒█░░░▒█▄▄▄█░░▒█░░░▒█▄▄▄░▒█░▒█░░░▒█░░░█");
        System.out.println("█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█");
        System.out.println("███████████████████████████████████████████████████████████████████████████████████████████████");
    
        
        System.out.println("\nType 'format' if you want help formatting your responses. Type 'help' for a list of all actions.");
        System.out.println("\nYou find yourself in a room at the center of a house. There is a table with an envelope.");
        
        Scanner scanner = new Scanner(System.in);
        while (won = true) {
            response = scanner.nextLine();
            if (response.contains("Pick") || response.contains("pick") || response.contains("Grab") || response.contains("grab")) {
                try {
                    User.grab(response);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Drop") || response.contains("drop") || response.contains("Leave") || response.contains("leave")) {
                try {
                    User.drop(response);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Open") || response.contains("open")) {
                try {
                    User.open(response);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("West") || response.contains("west") || response.contains("Left") || response.contains("left")) {
                try {
                    User.goWest();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("East") || response.contains("east") || response.contains("Right") || response.contains("right")) {
                try {
                    User.goEast();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("North") || response.contains("north")|| response.contains("Up ") || response.contains("up ")) {
                try {
                    User.goNorth();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("South") || response.contains("south") || response.contains("Down") || response.contains("down")) {
                try {
                    User.goSouth();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Watch") || response.contains("watch")) {
                try {
                    User.watch();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Talk") || response.contains("talk")|| response.contains("Say hi") || response.contains("Say hi")) {
              try {
                    User.talk(response);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Ask") || response.contains("ask")) {
                try {
                      User.ask(response);
                }catch (Exception e) {
                      System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Eat") || response.contains("eat")) {
                try {
                      User.eat(response);
                }catch (Exception e) {
                      System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Read") || response.contains("read")) {
                try {
                      User.read();
                }catch (Exception e) {
                      System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Examine") || response.contains("examine") || response.contains("Look") || response.contains("look") || response.contains("Uncrumple") || response.contains("uncrumple")) {
                try {
                      User.examine(response);
                }catch (Exception e) {
                      System.out.println(e.getMessage());
                }
            }
            else if (response.contains("Yes") || response.contains("yes")) {
                if (User.x_position==0 && User.y_position==0) {
                    //scanner.close();
                    System.out.println("Enter your accusation:");
                    accusation = scanner.nextLine();
                    try {
                        if (accuse(accusation.toLowerCase())==false) {
                            break;
                        }
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    System.out.println("You cannot accuse in this room. ");
                }
            }
            else if (response.contains("Time ") || response.contains("time ")) {
                System.out.println("There is currently no ongoing timer. ");
            }
            else if (response.contains("Format") || response.contains("format")) {
                System.out.println("Here is some important formatting information:");
                System.out.println("\n-In order to move around the hallways and enter rooms you need to type the direction you want to go: North, South, West, East or Up, Down, Left, Right");
                System.out.println("\n-When asking characters for clues do not include the characters name who you are talking to. For example, you should say 'ask if they saw the student in the classroom' not 'ask the teacher if they saw the student in the classroom'.");
                System.out.println("\n-When attempting to interact with objects or characters you must mention their/its name. Ex: 'open envelope'");
                System.out.println("\n-All text should be lower case or title case\n");
            }
            else if (response.contains("Help") || response.contains("help")) {
                System.out.println("Here is a list of all the possible actions and if they coorespond to user/objects/weapons/characters.");
                System.out.println("\nPick/Grab - weapon");
                System.out.println("Drop/Leave - weapon; if you drop a weapon in room or hallway that is not its original location, when you come back it won't tell you its there. Therefore, you must remember where you drop weapons if you want to pick them up again. ");
                System.out.println("Open - envelope, book, drawer, closet");
                System.out.println("North/Up - user");
                System.out.println("South/Down - user");
                System.out.println("East/Right - user");
                System.out.println("West/Left - user");
                System.out.println("Watch - movie");
                System.out.println("Talk - character");
                System.out.println("Ask - character");
                System.out.println("What happened - body part");
                System.out.println("Eat - food");
                System.out.println("Examine/Look/Uncrumple - weapons, objects\n");
                System.out.println("Thank - character");
                System.out.println("Inventory - user");
            }
            else if (response.contains("List") || response.contains("list")) {
                if (response.contains("Weapon") || response.contains("weapon")) {
                    System.out.println("\nWeapons:");
                    System.out.println("\nCandlestick");
                    System.out.println("Knife");
                    System.out.println("Lead pipe");
                    System.out.println("Pistol");
                    System.out.println("Rope");
                    System.out.println("Wrench\n"); 
                }
                else if (response.contains("Room") || response.contains("room")) {
                    System.out.println("\nRooms:");
                    System.out.println("\nConservatory");
                    System.out.println("Dining Room");
                    System.out.println("Hall");
                    System.out.println("Kitchen");
                    System.out.println("Library");
                    System.out.println("Lounge");
                    System.out.println("Study");
                    System.out.println("Theatre");
                    System.out.println("Wrench\n"); 
                }
                else if (response.contains("Characters") || response.contains("characters") || response.contains("Suspects") || response.contains("suspects") || response.contains("People")|| response.contains("people")) {
                    System.out.println("\nSuspects:");
                    System.out.println("\nMr.Green");
                    System.out.println("Colonel Mustard");
                    System.out.println("Peacock");
                    System.out.println("Professor Plum");
                    System.out.println("Scarlet");
                    System.out.println("Ms. White\n");
                    
                }
                else {
                    System.out.println("List of what? Formatting: 'list of ____'");
                }
            }
            else if (response.contains("Thank") || response.contains("thanks")) {
                try {
                    User.thank();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
              }
            }
            else if (response.contains("Inventory") || response.contains("inventory")) {
                try {
                    User.inventory();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
              }
            }
            else {
                System.out.println("I don't know what this means.");
            }
        }
        scanner.close();
    }

}


