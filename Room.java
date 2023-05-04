import java.util.ArrayList;

public class Room {
    
    public String name;
    public int x_position;
    public int y_position;
    public ArrayList<String> residents;
    public ArrayList<String> items;
    public ArrayList<Weapon> weapons;
    
    public Room(String name, int x_position, int y_positon) {
        this.name = name;
        this.x_position = x_position; 
        this.y_position = y_positon;
        //this.residents = new ArrayList<String>();
        this.items = new ArrayList<String>();
        this.weapons = new ArrayList<Weapon>();
    }

    public void addWeapon(Weapon weapon) {
        if (this.weapons.contains(weapon)) {
            throw new RuntimeException(weapon.name + " is already in the " + this.name);
        }
        else {
            this.weapons.add(weapon);
        }
    }
    public void removeWeapon(Weapon weapon) {
        if (this.weapons.size() == 0) {
            throw new RuntimeException("There are no weapons in " + this.name);
        }
        if (!this.weapons.contains(weapon)) {
            throw new RuntimeException(weapon.name + " is not in the " + this.name);
        }
        this.weapons.remove(weapon);
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
            System.out.println("There is a table with an envelope.");
            System.out.println("Do you want to accuse?");
            
        }
        if (x_position == 2 && y_position == 0) {
            //dining.enterRoom();
            System.out.println("You are now in the dining room.");
            System.out.println("Professor Plum is sitting at the dining room table eating a meal by himself.");
        }
        if (x_position ==-2 && y_position == 2) {
            //library.enterRoom(); 
            System.out.println("You are now in the library.");
            System.out.print("Sitting on a couch to your left is Scarlet who is reading Turn of the Screw by Henry James. The room is lit by a fire going in the fireplace");
            if (Map.candlestick.x_pos==-2 && Map.candlestick.y_pos==2) {
                System.out.println(" and a candlestick on a sidetable near Scarlet.");
            }
        }
        if (x_position ==0 && y_position == 2) {
            //lounge.enterRoom();
            System.out.println("You are now in the lounge.");
            System.out.println("Inside to your right is a couch with a sidetable and a lamp. On the table is a book whose title you don't recognize. In the left most corner there is a door that leads to a closet. ");
        }
        if (x_position ==2 && y_position == 2) {
            //kitchen.enterRoom();
            System.out.println("You are now in the kitchen.");
            System.out.print("Colonel Mustard is on the far right corner plating a dish that he just made.");
            if (Map.knife.x_pos==2 && Map.knife.y_pos==2) {
                System.out.println(" He is chopping up some thyme to use as a garnish with a sharp knife before he notices you enter.");
            }

        }
        if (x_position ==-2 && y_position == -2) {
            //study.enterRoom();
            System.out.println("You are now in the study.");
            System.out.println("Inside there is a large desk and you walk over to it. On one corner you see some hardened candle wax and then notice that one of the desks drawers is slightly open. ");
        }
        if (x_position ==0 && y_position == -2) {
            //hall.enterRoom();
            System.out.println("You are now in the hall.");
            System.out.print("Green is sitting at a table doing some work straight ahead of you. ");
            if (Map.rope.x_pos==0 && Map.rope.y_pos==-2) {
                System.out.println("To your left there is a stack of rope.");
            }
        }
        if (x_position ==2 && y_position == -2) {
            //conservatory.enterRoom();
            System.out.println("You are now in the conservatory.");
            System.out.print("Peacock is sitting in the right most corner largely hidden by a big plant. They are writing in a journal and smile at you when you enter.");
            if (Map.rope.x_pos==2 && Map.rope.y_pos==-2) {
                System.out.println(" To your left there is a wrench near a hose. ");
            }
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
