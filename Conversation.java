import java.util.Scanner;

public class Conversation {
    
    public static boolean won;
    public static String response;

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
            else if (response.contains("Talk") || response.contains("talk")) {
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
            else {
                System.out.println("I don't know what this means.");
            }
        }
        scanner.close();
    }

}
//3wrj

