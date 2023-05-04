import java.util.Scanner;

public class Conversation {
    
    public static boolean won;
    public static String response;
    public static String accusation;
    private static boolean ac_murderer = false;
    private static boolean ac_murder_weapon = false;
    private static boolean ac_murder_room = false;
    //private String murderer = "Green";
    //private Weapon murder_weapon = Map.lead_pipe;
    //private Room murder_room = Map.library;

    public static void accuse(String accusation) {
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
        win();
    }

    public static void win() {
        if (ac_murder_room==true && ac_murder_weapon==true && ac_murderer==true) {
            System.out.println("Conratulations you solved the crime!");
        }
        else if ((ac_murder_room==true && ac_murder_weapon==true) || (ac_murder_weapon==true && ac_murderer==true) || (ac_murder_room==true && ac_murderer==true)) {
            System.out.println("You have two aspects of the crime correct and one incorrect.");
        }
        else if (ac_murder_room==true || ac_murder_weapon==true || ac_murderer==true) {
            System.out.println("You have one aspect of the crime correct and two incorrect");
        }
        else {
            System.out.println("You have all aspects of the crime incorrect :(");
        }
        
    }

    public static void main(String[] arguments) {
        //User user = new User();
        System.out.println("Clue: A Murder Mystery");
        System.out.println("You find yourself in a room at the center of a house. There is a table with an envelope.");
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
            else if (response.contains("West") || response.contains("west")) {
                try {
                    User.goWest();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("East") || response.contains("east")) {
                try {
                    User.goEast();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("North") || response.contains("north")) {
                try {
                    User.goNorth();
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (response.contains("South") || response.contains("south")) {
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
            else if (response.contains("Talk") || response.contains("talk")|| response.contains("Hi") || response.contains("hi")) {
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
            else {
                System.out.println("I don't know what this means.");
            }
        }
        scanner.close();
    }

}
//3wrj

