import java.util.ArrayList;

public class User {
    /**Stores strings for the name and type of the bug, and integers for the x_positon, y_position, size, and energy. Also stores an ArrayList for all the items that the bug is holding.  */
    public static ArrayList<String> items = new ArrayList<String>();
    public static ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    static int x_position=0;
    static int y_position=0;


    /**Constructor */ 
    public User() {
        //items = new ArrayList<String>();
        //weapons = new ArrayList<Weapon>(); 
    }
    
    /**Manipulator to grab an item by adding it to the items arraylist if the bug has enough energy and can hold another object. Reduces the bugs energy if it can grab the item. 
     * @param item item to be grabbed (item to be added to the items ArrayList)
     */
    public static void grab(String response) {
        if ((weapons.size() ==2) || (items.size() ==2) || ((weapons.size()==1) && (items.size()==1))) {
            throw new RuntimeException("You cannot hold more than two items");
        }
        if (items.size() < 2) {
            if ((response.contains("Knife") || response.contains("knife"))){
                if ((Map.knife.x_pos==x_position) && (Map.knife.y_pos==y_position)) {
                    weapons.add(Map.knife);
                    System.out.println("You grabbed the knife.");
                    for (int i = 0; i < User.weapons.size();i++) { 		      
	                    System.out.println(User.weapons.get(i).name); 	;
                    }
                }
                else {
                    throw new RuntimeException("The knife isn't in this room.");
                }
            }
            else if ((response.contains("Wrench") || response.contains("wrench"))){
                if ((Map.wrench.x_pos==x_position) && (Map.wrench.y_pos==y_position)) {
                    weapons.add(Map.wrench);
                    System.out.println("You grabbed the wrench.");
                }
                else {
                    throw new RuntimeException("The wrench isn't in this room.");
                }
            }
            else if ((response.contains("Rope") || response.contains("rope"))){
                if ((Map.rope.x_pos==x_position) && (Map.rope.y_pos==y_position)) {
                    weapons.add(Map.rope);
                    System.out.println("You grabbed the rope.");
                }
                else {
                    throw new RuntimeException("The rope isn't in this room.");
                }
            }
            else if ((response.contains("Pistol") || response.contains("pistol"))){
                if ((Map.pistol.x_pos==x_position) && (Map.pistol.y_pos==y_position)) {
                    weapons.add(Map.pistol);
                    System.out.println("You grabbed the pistol.");
                } 
                else {
                    throw new RuntimeException("The pistol isn't in this room.");
                }
            }
            else if ((response.contains("Pipe") || response.contains("pipe"))){
                if ((Map.lead_pipe.x_pos==x_position) && (Map.lead_pipe.y_pos==y_position)) {
                    weapons.add(Map.lead_pipe);
                    System.out.println("You grabbed the lead pipe.");
                } 
                else {
                    throw new RuntimeException("The lead pipe isn't in this room.");
                }
            }
            else if ((response.contains("Candlestick") || response.contains("candlestick"))){
                if ((Map.candlestick.x_pos==x_position) && (Map.candlestick.y_pos==y_position)) {
                    weapons.add(Map.candlestick);
                    System.out.println("You grabbed the candlestick.");
                }
                else {
                    throw new RuntimeException("The candlestick isn't in this room.");
                }
            }
        }
    
    }


    /**Manipulator to drop an item by removing it from the items arraylist if the bug is holding the item. 
     * @param item item to be dropped (item to be removed from the items Arraylist)
     */
    public static void drop(String response) {
        if ((items.size() ==0) && (weapons.size() ==0)) {
            throw new RuntimeException("You aren't holding any items.");
        }
        else {
            if ((response.contains("Knife") || response.contains("knife"))){
                if (User.weapons.contains(Map.knife)) {
                    Map.knife.changeCoordinates(x_position, y_position);
                    weapons.remove(Map.knife);
                    System.out.println("You dropped the knife");
                }
                else {
                    throw new RuntimeException("You aren't holding the knife.");
                }
            }
            else if ((response.contains("Wrench") || response.contains("wrench"))){
                if (User.weapons.contains(Map.wrench)) {
                    Map.wrench.changeCoordinates(x_position, y_position);
                    weapons.remove(Map.wrench);
                    System.out.println("You dropped the wrench");
                }
                else {
                    throw new RuntimeException("You aren't holding the wrench.");
                }
            }
            else if ((response.contains("Rope") || response.contains("rope"))){
                if (User.weapons.contains(Map.rope)) {
                    Map.rope.changeCoordinates(x_position, y_position);
                    weapons.remove(Map.rope);
                    System.out.println("You dropped the rope");
                }
                else {
                    throw new RuntimeException("You aren't holding the rope.");
                }
            }
            else if ((response.contains("Pistol") || response.contains("pistol"))){
                if (User.weapons.contains(Map.pistol)) {
                    Map.pistol.changeCoordinates(x_position, y_position);
                    weapons.remove(Map.pistol);
                    System.out.println("You dropped the pistol");
                }
                else {
                    throw new RuntimeException("You aren't holding the pistol.");
                }
            }
            else if ((response.contains("Pipe") || response.contains("pipe"))){
                if (User.weapons.contains(Map.lead_pipe)) {
                    Map.lead_pipe.changeCoordinates(x_position, y_position);
                    weapons.remove(Map.lead_pipe);
                    System.out.println("You dropped the lead pipe");
                }
                else {
                    throw new RuntimeException("You aren't holding the lead pipe.");
                }
            }
            else if ((response.contains("Candlestick") || response.contains("candlestick"))){
                if (User.weapons.contains(Map.candlestick)) {
                    Map.candlestick.changeCoordinates(x_position, y_position);
                    weapons.remove(Map.candlestick);
                    System.out.println("You dropped the candlestick");
                }
                else {
                    throw new RuntimeException("You aren't holding the candlestick.");
                }
            }
        }
        
        // if (!items.contains(item)) {
        //     throw new RuntimeException("You aren't holding " + item);
        // }
    
    }

    /**Function that examines an item if the bug has enough energy. Reduces the bugs energy if it can examine the item. 
     * @param item item to be examined
     */
    public static void examine(String response) {
        if (response.contains("Pistol") || response.contains("pistol")) {
            if (x_position ==-2 && y_position == -2) {
                System.out.println("The pistol is stored neatly in a box and appears to have no fingerprints. ");
            } 
            else {
                System.out.println("There is nothing to examine. ");
            }
        }
        else if (response.contains("Book") || response.contains("book")) {
            if (x_position ==0 && y_position == 2) {
                System.out.println("You flip through the pages in the book and inside you see a book plate indicating that the book belongs to Ms. White. ");
            }
        }
        else if (response.contains("Napkin") || response.contains("napkin")) {
            if (x_position ==-1 && y_position == 2) {
                System.out.println("You uncrumple the napkin and see a small blood stain.");
            }
        }
        else if (response.contains("Bookmark") || response.contains("bookmark")) {
            if (x_position ==2 && y_position ==-1) {
                System.out.println("The bookmark is purple and has a floral design.");
            }
        }
        else if (response.contains("Hankerchief") || response.contains("hankerchief")) {
            if (x_position ==1 && y_position ==-2) {
                System.out.println("The hankerchief is dark green.");
            }
        }
        else {
            throw new RuntimeException("What do you want to examine?");
        }
    }
    
    public static void inventory() {
        System.out.println("Current inventory:");
        System.out.println(items.toString()
                            .replace("[","")
                            .replace("]","")
                            .replace(", ", "\n"));
        System.out.println(weapons.toString()
                            .replace("[","")
                            .replace("]","")
                            .replace(", ", "\n"));

    }

    public static void goWest() {
        if (y_position == 2 || y_position ==-2 || x_position ==-2) {
            throw new RuntimeException("There is no door or hallway to your west.");
        }
        else {
            x_position-=1;
            try {
                Map.enterRoom(x_position, y_position);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                x_position+=1;
            }
        }
    }

    public static void goEast() {
        if (y_position == 2 || y_position ==-2 || x_position ==2) {
            throw new RuntimeException("There is no door or hallway to your east.");
        }
        else {
            x_position+=1;
            try {
                Map.enterRoom(x_position, y_position);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                x_position-=1;
            }
        }
    }

    public static void goNorth() {
        if (y_position == 2 || (x_position ==-2 && y_position ==0) || (x_position ==2 && y_position ==0)|| (x_position==-2 && y_position==-1) || (x_position==2 && y_position==-1)) {
            throw new RuntimeException("There is no door or hallway to your north.");
        }
        else {
            y_position+=1;
            try {
                Map.enterRoom(x_position, y_position);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                x_position-=1;
            }
        }
    }

    public static void goSouth() {
        if (y_position == -2 || (x_position ==-2 && y_position ==0) || (x_position ==2 && y_position ==0) || (x_position==2 && y_position==1) || (x_position==-2 && y_position==1)) {
            throw new RuntimeException("There is no door or hallway to your south.");
        }
        else {
            y_position-=1;
            try {
                Map.enterRoom(x_position, y_position);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                x_position+=1;
            }
        }
    }

    public static void watch() {
        if (x_position ==-2 && y_position == 0) {
            System.out.println("You sit down next to Mrs. White and watch some of the film. The movie is Vertigo, a Hitchcock film. ");
        }
        else {
            throw new RuntimeException("There is nothing to watch in this room");
        }
    }

    public static void talk(String response) {
        if (response.contains("Peacock") || response.contains("peacock")) {
            if (x_position ==2 && y_position == -2) {
                System.out.println("You greet Peacock and ask them if anything suspicious has happened. They tell you that they aren't sure because they have been in the consevatory for the entire time. They say that Mustard stopped by earlier to fix the broken pipe and that Plum stopped by quickly but they don't know if he saw them there. ");
            } else {
                System.out.println("Mrs.Peacock isn't in this room");
            }
        }
        else if (response.contains("Plum") || response.contains("plum")) {
            if (x_position == 2 && y_position == 0) {
                System.out.println("\nProfessor Plum waves to you, offers you food, and asks how you are doing with everything going on. You explain that you are trying to solve the crime and he begins telling his account of what happened. He says that he went to the conservatory earlier to drop something off and then came back to the dining room. While he had been here he saw Mustard pass by carrying a knife who said he was using the knife to cut some herbs because he couldn't find scissors.\n");
            } else {
                System.out.println("Professor Plum isn't in this room");
            }
        }
        else if (response.contains("White") || response.contains("white")) {
            if (x_position ==-2 && y_position == 0) {
                System.out.println("\nYou greet Ms.White and ask her if you know anything about the murder. She says that she came from the lounge earlier and has been watching films in the theatre since then. However, she did note that she saw Mr.Green headed west in the northern hallway and later on saw Scarlet go north past the theatre. Towards the end of the conversation you notice that her hand is in a bandage which you hadn't seen because she was holding her hands behind her back.\n");
            } else {
                throw new RuntimeException("Ms.White isn't in this room");
            }
        }
        else if (response.contains("Mustard") || response.contains("mustard")) {
            if (x_position ==2 && y_position == 2) {
                System.out.println("\nYou interupt Mustard from his cooking and inquire if he has noticed anything odd lateley. He says that earlier he went to the conservatory to get some thyme for his dish and saw Scarlet in the eastern hallway swiftly heading north with a lit candlestick. At the conservatory, he claims to have talked with Peacock for a little and then fixed a broken hose used to water the plants with a wrench there. After getting the thyme he says he came back to the kitchen and has been cooking since then.\n");
            } else {
                System.out.println("Colonel Mustard isn't in this room");
            }
        }
        else if (response.contains("Green") || response.contains("green")) {
            if (x_position ==0 && y_position == -2) {
                System.out.println("\nMr.Green looks up at you, says hi, and ask what you think of everything going on. You reply that you have been trying to decipher what could have happened. He says that he was in the study for a little bit and then came to the hall to continue his work. He also mentions that he saw Plum walking towards the conservatory with a wrench as he entered the hall but that Plum didn't see him. You notice that he is wearing a brace on his dominant hand. \n");
            } else {
                System.out.println("Mr.Green isn't in this room");
            }
        }
        else if (response.contains("Scarlet") || response.contains("scarlet")) {
            if (x_position ==-2 && y_position == 2) {
            System.out.println("\nScarlet says hi to you and starts explaining how she has been really scared ever since the murder occured. She says she saw a pistol in the study and immediately left because she'd never seen one in there before. Afterwards, she came to the library because she thought reading would help calm her down.\n");
            } else {
                System.out.println("Scarlet isn't in this room");
            }
        }
        else {
            System.out.println("Talk to whom?");
        }
    }

    public static void ask(String response) {
        if ((response.contains("Lead pipe") || response.contains("lead pipe")) && (response.contains("Lounge") || response.contains("lounge"))) {
            if  (x_position ==-2 && y_position == 0) {
                System.out.println("\nMs.White says she dosn't recall seeing a lead pipe in the lounge when she left");
            } else {
                throw new RuntimeException("Ms.White isn't in this room");
            }
        }
        else if ((response.contains("White") || response.contains("white")) && (response.contains("Theatre") || response.contains("theatre"))) {
            if (x_position ==-2 && y_position == 2) {
                System.out.println("\nScarlet says that she remembers seeing Ms. White is the theatre.");
            } else {
                throw new RuntimeException("Scarlet isn't in this room");
            }
        }
        else if ((response.contains("Plum") || response.contains("plum")) && (response.contains("Dining room") || response.contains("dining room"))) {
            if (x_position == 2 && y_position == 2) {
                System.out.println("\nMustard saw Professor Plum in the dining room on the way back to the kitchen.\n");
            } else {
                throw new RuntimeException("Colonel Mustard isn't in this room");
            }
        }
        else if ((response.contains("Plum") || response.contains("plum")) && (response.contains("Conservatory") || response.contains("conservatory"))) {
            if (x_position == 2 && y_position == -2) {
                System.out.println("\nPeacock says that Professor Plum did pop into the conservatory for a minute to bring a wrench to fix the broken pipe.\n");
            } else {
                throw new RuntimeException("Peacock isn't in this room");
            }
        }
        else if ((response.contains("Green") || response.contains("green")) && (response.contains("Dining room") || response.contains("dining room"))) {
            if (x_position == 2 && y_position == 0) {
                System.out.println("\nProfessor Plum says that he does recall seeing Mr. Green headed south past the dining room.\n");
            } else {
                throw new RuntimeException("Professor Plum isn't in this room");
            }
        }
        else if ((response.contains("Peacock") || response.contains("peacock")) && (response.contains("Conservatory") || response.contains("conservatory"))) {
            if (x_position == 2 && y_position == 0) {
                System.out.println("\nProfessor Plum says that he did see Peacock conservatory when he went there.\n");
            } else {
                throw new RuntimeException("Professor Plum isn't in this room");
            }
        }
        else if ((response.contains("Green") || response.contains("green")) && (response.contains("Study") || response.contains("study"))) {
            if (x_position ==-2 && y_position == 2) {
                System.out.println("\nScarlet says that she did not see Mr.Green in the study.\n");
            } else {
                throw new RuntimeException("Scarlet isn't in this room");
            }
        }
        else if ((response.contains("White") || response.contains("white")) && (response.contains("Cut") || response.contains("cut"))) {
            if (x_position == 2 && y_position == 2) {
                System.out.println("\nMustard says that White did cut herself at breakfast and that he helped her bandage her arm.\n");
            } else {
                throw new RuntimeException("Colonel Mustard isn't in this room");
            }
        }
        else if ((response.contains("Rope") || response.contains("rope")) && (response.contains("Hall") || response.contains("hall"))) {
            if (x_position == 0 && y_position == -2) {
                System.out.println("\nMr.Green says the rope was there when he got there.\n");
            } else {
                throw new RuntimeException("Mr.Green isn't in this room");
            }
        }
        else if ((response.contains("Pistol") || response.contains("pistol")) && (response.contains("Hall") || response.contains("hall"))) {
            if (x_position == 0 && y_position == -2) {
                System.out.println("\nMr.Green says he didn't see one but that he wouldn't have noticed it because he wasn't looking for it.\n");
            } else {
                throw new RuntimeException("Mr.Green isn't in this room");
            }
        }
        else {
            System.out.println("Ask what?");
        }
        
    }

    public static void what(String response) {
        if ((response.contains("Arm") || response.contains("arm")) && (response.contains("Happened") || response.contains("happened"))) {
            if  (x_position ==-2 && y_position == 0) {
                System.out.println("\nMs.White says that she cut herself accidentally while making breakfast with Mustard before the murder occured.");
            } else {
                throw new RuntimeException("Ms.White isn't in this room");
            }
        }
        if ((response.contains("Hand") || response.contains("hand")) && (response.contains("Happened") || response.contains("happened"))) {
            if  (x_position ==0 && y_position == -2) {
                System.out.println("\nMr.Green says that he fell while he was playing basketball and sprained his wrist.");
            } else {
                throw new RuntimeException("Mr.Green isn't in this room");
            }
        }
    }

    public static void eat(String response) {
        if (x_position ==2 && y_position == 2) {
            System.out.println("Mustard gives you a plate of the dish he just made and you sit down to eat for a bit. ");
        }
        if (x_position ==2 && y_position == 0) {
            System.out.println("Professor Plum serves you a plate of __ and you eat with him. You converse with him and he tells you that he lost his favorite bookmark somewhere and doesn't know where it could have gone.  ");
        }
    }

    public static void read() {
        if (x_position ==2 && y_position == -2) {
            //read Peacocks journal in the conservatory
        }
        else if (x_position ==0 && y_position == 2) {
            //read White's book in the lounge
        }
        else {
            System.out.println("There is nothing to read in this room.");
        }
    }

    public static void open(String response) {
        if (response.contains("Envelope") || response.contains("envelope")) {
            if (x_position ==0 && y_position == 0) {
                System.out.println("\nWelcome to the Clue House. A murder has occured and we need your help to solve the crime. The murder was committed in one the rooms in this house, by someone in one of the rooms, and using a weapon that we suspect is still in the house. It is your job to investigate the crime and determine what happened. Once you are sure about your suspicions return here to reveal your findings, but be careful because the murderer is still on the loose.\n");
            }
        }
        else if (response.contains("Drawer") || response.contains("drawer")) {
            if (x_position ==-2 && y_position == -2) {
                if (Map.pistol.x_pos==-2 && Map.pistol.y_pos==-2) {
                    System.out.println("You open the drawer and inside you see a pistol.");
                }
                else {
                    System.out.println("There is nothing in this drawer");
                }
            } 
            else {
                System.out.println("There is no drawer to open in this room. ");
            }
        }
        else if (response.contains("Closet") || response.contains("closet"))  {
            if (x_position ==0 && y_position == 2) {
                if (Map.lead_pipe.x_pos==0 && Map.lead_pipe.y_pos==2) {
                    System.out.println("Inside the closet you find a lead pipe on the floor.");
                }
                else {
                    System.out.println("There is nothing in this closet.");
                }
            }
            else {
                System.out.println("There is no closet to open in this room.");
            }
        }
        else {
            throw new RuntimeException("What do you want to open?");
        }
    }

    public static void main(String[] args) {
       
        
        //regj
    }

}