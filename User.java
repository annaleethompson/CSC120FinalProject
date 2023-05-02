import java.util.ArrayList;

public class User {
    /**Stores strings for the name and type of the bug, and integers for the x_positon, y_position, size, and energy. Also stores an ArrayList for all the items that the bug is holding.  */
    public ArrayList<String> items;
    static int x_position=0;
    static int y_position=0;


    /**Constructor */ 
    public User() {
        this.items = new ArrayList<String>();
    }
    
    /**Manipulator to grab an item by adding it to the items arraylist if the bug has enough energy and can hold another object. Reduces the bugs energy if it can grab the item. 
     * @param item item to be grabbed (item to be added to the items ArrayList)
     */
    public void grab(String item) {
        if (this.items.size() ==2) {
            throw new RuntimeException("You cannot hold more than two items");
        }
        if (this.items.size() < 2){
            items.add(item);
        }
    }

    /**Manipulator to drop an item by removing it from the items arraylist if the bug is holding the item. 
     * @param item item to be dropped (item to be removed from the items Arraylist)
     */
    public String drop(String item) {
        if (this.items.size() ==0) {
            throw new RuntimeException("You arent holding any items");
        }
        if (!this.items.contains(item)) {
            throw new RuntimeException("You aren't holding " + item);
        }
        else {
            this.items.remove(item);
            return item;
        }
    }

    /**Function that examines an item if the bug has enough energy. Reduces the bugs energy if it can examine the item. 
     * @param item item to be examined
     */
    public void examine(String item) {
        grab(item);
        //Get clue
        drop(item);
    }
    
    public void inventory() {
        System.out.println("Current inventory:");
        System.out.println(this.items.toString()
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
                System.out.println("\nProfessor Plum waves to you, offers you food, and asks how you are doing with everything going on. You explain that you are trying to solve the crime and he begins telling his account of what happened. He says that he went to the conservatory earlier to drop something off and then came back to the dining room. While he had been here he saw Mustard pass by carrying a knife and said he was using it to cut some herbs because he couldn't find scissors.\n");
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
                System.out.println("\nYou interupt Mustard from his cooking and inquire if he has noticed anything odd lateley. He says that earlier he went to the conservatory to get some thyme for his dish and saw Scarlet in the eastern hallway swiftly heading north with a candlestick. At the conservatory, he claims to have talked with Peacock for a little and then fixed a broken pipe used to water the plants using a wrench there. After getting the thyme he says he came back to the kitchen and has been cooking since then.\n");
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
                System.out.println("\nMustard saw Professor Plum in the dining room on the way back to the kitchen");
            } else {
                throw new RuntimeException("Colonel Mustard isn't in this room");
            }
        }
        else if ((response.contains("Plum") || response.contains("plum")) && (response.contains("Conservatory") || response.contains("conservatory"))) {
            if (x_position == 2 && y_position == -2) {
                System.out.println("\nPeacock says that Professor Plum did pop into the conservatory for a minute to bring a wrench to fix the broken pipe. ");
            } else {
                throw new RuntimeException("Peacock isn't in this room");
            }
        }
        else if ((response.contains("Green") || response.contains("green")) && (response.contains("Dining room") || response.contains("dining room"))) {
            if (x_position == 2 && y_position == 0) {
                System.out.println("\nProfessor Plum says that he does recall seeing Mr. Green headed south past the dining room.");
            } else {
                throw new RuntimeException("Professor Plum isn't in this room");
            }
        }
        else if ((response.contains("Peacock") || response.contains("peacock")) && (response.contains("Conservatory") || response.contains("conservatory"))) {
            if (x_position == 2 && y_position == 0) {
                System.out.println("\nProfessor Plum says that he did see Peacock conservatory when he went there.");
            } else {
                throw new RuntimeException("Professor Plum isn't in this room");
            }
        }
        else if ((response.contains("Green") || response.contains("green")) && (response.contains("Study") || response.contains("study"))) {
            if (x_position ==-2 && y_position == 2) {
                System.out.println("\nScarlet says that she did not see Mr.Green in the study.");
            } else {
                throw new RuntimeException("Scarlet isn't in this room");
            }
        }
        else if ((response.contains("White") || response.contains("white")) && (response.contains("Cut") || response.contains("cut"))) {
            if (x_position == 2 && y_position == 2) {
                System.out.println("\nMustard says that White did cut herself at breakfast and that he helped her bandage her arm.");
            } else {
                throw new RuntimeException("Colonel Mustard isn't in this room");
            }
        }
        else if ((response.contains("Rope") || response.contains("rope")) && (response.contains("Hall") || response.contains("hall"))) {
            if (x_position == 0 && y_position == -2) {
                System.out.println("\nMr.Green says the rope was there when he got there.");
            } else {
                throw new RuntimeException("Mr.Green isn't in this room");
            }
        }
        else if ((response.contains("Pistol") || response.contains("pistol")) && (response.contains("Hall") || response.contains("hall"))) {
            if (x_position == 0 && y_position == -2) {
                System.out.println("\nMr.Green says he didn't see one but that he wouldn't have noticed it because he wasn't looking for it.");
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
            //read Peacocks journal
        }
        else {
            System.out.println("There is nothing to read in this room.");
        }
    }

    public static void main(String[] args) {
        User myHouse = new User();
        myHouse.grab("pen");
        myHouse.grab("pencil");
        myHouse.inventory();
        //regj
    }

}