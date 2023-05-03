

public class Map {
    
    public House house;
    public User user;
    public static Room clue = new Room("Clue Room", 0, 0);
    public static Room kitchen = new Room("Kitchen", 2, 2);
    public static Room dining  = new Room("Dining Room", 2, 0);
    public static Room conservatory = new Room("Conservatory", 2, -2);
    public static Room hall = new Room("Hall", 0, -2);
    public static Room theatre = new Room("Theatre", -2, 0);
    public static Room library = new Room("Library", -2, 2);
    public static Room lounge = new Room("Lounge", 0, 2);
    public static Room study = new Room("Study", -2, -2);
    public static Weapon knife = new Weapon("Knife", 2, 2);
    public static Weapon wrench = new Weapon("Wrench", 2, -2);
    public static Weapon rope = new Weapon("Rope", 0, -2);
    public static Weapon pistol = new Weapon("Pistol", -2, -2);
    public static Weapon lead_pipe = new Weapon("Lead Pipe", 0, 2);
    public static Weapon candlestick = new Weapon("Candlestick", -2, 2);

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
        //if ((x_position==-1 && y_position==-2) || (x_position==-1 && y_position==2) || (x_position==1 && y_position==-2) || (x_position==1 && y_position==2)) {
            //throw new RuntimeException("There is no room or hallway in this direction");
        //}
    }

    public static void hallways(int x_position, int y_position) {
        if (x_position ==-1 && y_position ==2) {
            System.out.println("This is a deadend. South of you is the hallway you came from.");
            System.out.println("In this corner there is a a chair beside a window looking out onto the yard. You notice a crumpled up napkin in the cushion of the chair. ");
        }
        if (x_position ==-1 && y_position ==1) {
            System.out.println("The hallway continues in all directions from here. ");
        }
        if (x_position ==-1 && y_position ==0) {
            System.out.println("North and south of you the hallway continues. To your west and east there are doors");
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
            System.out.println("North and south of you the hallway continues. To your west and east there are doors");
        }
        if (x_position ==1 && y_position ==-1) {
            System.out.println("The hallway continues in all directions from here.");
        }
        if (x_position ==1 && y_position ==-2) {
            System.out.println("This is a deadend. North of you is the hallway you came from.");
            System.out.println("To you right, close to the northern hallway you spot a hankerchief on the ground. ");
        }
        if (x_position ==-2 && y_position==1) {
            System.out.println("To your north there is a doorway and to your east is the hallway you came from.");
        }
        if (x_position ==0 && y_position==1) {
            System.out.println("West and east of you the hallway continues. To your north and south there are doors");
        }
        if (x_position ==2 && y_position==1) {
            System.out.println("To your north there is a doorway and to your west is the hallway you came from.");
        }
        if (x_position ==-2 && y_position==-1) {
            System.out.println("To your south there is a doorway and to your east is the hallway you came from.");
            System.out.println("On the ground you spot a red piece of hair");
        }
        if (x_position ==0 && y_position==-1) {
            System.out.println("West and east of you the hallway continues. To your north and south there are doors");
        }
        if (x_position ==2 && y_position==-1) {
            System.out.println("To your south there is a doorway and to your west is the hallway you came from.");
            System.out.println("You spot a bookmark on the floor in a dark corner besides a window.");
        }
    } 
}
//rj