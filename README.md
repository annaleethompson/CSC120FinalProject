# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Design Justification
        My text-adventure game that is adapted from the premise of the game Clue. In the game, the user will solve a murder mystery by moving to different rooms in the house and will receive clues from suspects and items in the rooms themselves. Once the user has figured out who committed the crime, where it was committed, and with what weapon, they will go to a room in the center of the house and accuse someone for the crime. If they are correct on all three categories, then they have won and if they are completely incorrect on all three they can go back and search through the house again. The twist that I added is that if the user accuses and is incorrect but has at least one aspect of the the crime correct then the character that committed the crime will start to come after the user and the user will only have 20 minutes to solve the crime before the murderer gets to them next. The user will not know what aspect of the crime they got incorrect or correct, which makes that game even harder. However, even if the user loses, the solution is fixed so they will be ahead when they try to play again. 

        One alternative design that I considered was making the the solution unfixed but this would have made it so that the clues weren't as specialized, which I didn't want. However, in the future I think it would be interesting to see how this could be implemented in a randomized manner. 

## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?

        My overall approch to tackling this project was to start by doing the groundwork which in this case was making the base of the house including all the rooms. For this step I started the foundations of my Building, House, Room, and Map classes. My next step was to make it so that the User could move around the map I had created which is when I started the conversation class and figured out how to take in the users input on a loop. Next I started to create the story behind my game and began writing clues and drafting plot points and then I imbedded these clues into various rooms that the user would see once they went in each room. I then wanted to make the game a little more interactive so I thought it would be fun to have the user pick up and carry weapons and do other random things like eat or watch a movie. After that I decided to have a twist where the user would be timed under certain circumstances so I figured out how to create a timer. My final steps were to revise current clues and add more clues to make the game more interactive. 

 - What **new thing(s)** did you learn / figure out in completing this project?

        One new thing that I learned while working on this project is how to make a timer and implement time in a game. I spend a lot of time trying to figure out how make a timer on its own and then it was difficult putting it into my code at the correct points. 

 - Is there anything that you wish you had **implemented differently**?

        One thing that I wish I had implemented differently is my coordinate system. I had already written most of the code to move around points manually before we had learned Guava in class so I didn't want to switch. However, I think it would have been interesting to see how this could have been done using Guava as a grid instead of my manually built coordinate system. 

 - If you had **unlimited time**, what additional features would you implement?
    
        Due to time, I was not able to make it so that the user could pick up items such as books etc. but I think this would have been cool to add. Aside from that, I had initially wanted to make it so that the solution to the game would be random every time it was played but as I was writing the clues it turned out to be a lot more difficult so I just stuck to keeping one solution. However, if I had more time I think I would try to make it randomized. 

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?

        The most helpful feedback that I received was from my friend Tejas. She is not in CSC120 but she was the first person to test out my game. She gave me a lot of ideas surrounding alternative user inputs that helped my create new commands and she also reccomended that I have something that can help to user know what to type such as a formatting guide. 

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?

        I would tell myself to work on the project more consistently. I would say that I started the project pretty early but I took big chucks inbetween where I didn't work on it at all. I think that if I had worked more consistently in these chuncks I would have been done sooner, but overall I think I did a good job throughout. 

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

        I worked on this project independently.
