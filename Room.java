import java.util.ArrayList;

public class Room {
    
    public String name;
    public int x_position;
    public int y_position;
    public ArrayList<String> residents;
    public ArrayList<String> items;
    
    public Room(String name, int x_position, int y_positon) {
        this.name = name;
        this.x_position = x_position; 
        this.y_position = y_positon;
        //this.residents = new ArrayList<String>();
        this.items = new ArrayList<String>();
    }
    /**
     * Adds a passenger to a car and throws a RunTimeException if the passenger is on the car already or if the car is at maximum capacity.
     * @param p the passenger to be added
     */
    public void enterRoom () {
    
        if (x_position ==-2 && y_position == 0) {
            //theatre.enterRoom();
            System.out.println("You are now in the theatre.");
            System.out.println("Mrs. White is sitting and watching a movie by herself.");
        }
        if (x_position == 0 && y_position == 0) {
            //clue.enterRoom();
            System.out.println("You are now in the clue room.");
        }
        if (x_position == 2 && y_position == 0) {
            //dining.enterRoom();
            System.out.println("You are now in the dining room.");
            System.out.println("Professor Plum is sitting at the dining room table eating a meal by himself.");
        }
        if (x_position ==-2 && y_position == 2) {
            //library.enterRoom(); 
            System.out.println("You are now in the library.");
            System.out.println("Sitting on a couch to your left is Scarlet who is reading Turn of the Screw by Henry James. The room is lit by a fire going in the fireplace and a candlestick on a sidetable near Scarlet.");
        }
        if (x_position ==0 && y_position == 2) {
            //lounge.enterRoom();
            System.out.println("You are now in the lounge.");
        }
        if (x_position ==2 && y_position == 2) {
            //kitchen.enterRoom();
            System.out.println("You are now in the kitchen.");
            System.out.println("Colonel Mustard is on the far right corner plating a dish that he just made called ____. He is chopping up some thyme to use as a garnish with a sharp knife before he notices you enter. ");
        }
        if (x_position ==-2 && y_position == -2) {
            //study.enterRoom();
            System.out.println("You are now in the study.");
        }
        if (x_position ==0 && y_position == -2) {
            //hall.enterRoom();
            System.out.println("You are now in the hall.");
            System.out.println("Green is sitting at a table doing some work straight ahead of you. To your left there is a stack of rope. ");
        }
        if (x_position ==2 && y_position == -2) {
            //conservatory.enterRoom();
            System.out.println("You are now in the conservatory.");
            System.out.println("Peacock is sitting in the right most corner largely hidden by a big plant. They are writing in a journal and smile at you when you enter. To your left there is a wrench near a hose and exposed pipes. ");
        }
    }

    
    /**
     * Removes a passenger from a car and throws a RunTimeException if the passenger isn't in the car or if there are no passengers on the car.
     * @param p the passenger to be removed
     */
    public void exitRoom(String p) {
        //this.residents.remove(p);
        //3rffh
    } 
    

}
