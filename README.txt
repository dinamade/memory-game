=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 1200 Game Project README
PennKey: _______
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

  1. 2D Arrays - it's better to represent data the way it appears to the user so it's easier to make changes. Therefore, I decided to store my buttons as a 2D array. 

  2. Collections - I used collections to store the front pictures of my "cards" since I wanted to shuffle them every time a user plays a game. Collections have a useful prebuilt feature of shuffling their elements. 

  3. File I/O - The game allows to save the progress of the user (writing a file) and start from that progress (reading a file).

  4. Inheritance and Subtyping - I extended such classes as JFrame and JPanel and I also implemented an interface Serializable.

=========================
=: Your Implementation :=
=========================

	CardPanel - contains the card buttons as well as their functionalities
	
	AppFrame - contains CardPanel with the card buttons as well as the menu of the game that allows to save the progress.
	
	LaunchApp - the first window that the user sees. It includes instructions and two buttons that allows either to launch a new game or start from where the user finished last time.

	Game - runs the game.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
	I was a bit confused how to resize the pictures based on the size of the button, so I just manually resized each picture in Photoshop based on the sizes of the buttons that I set in my app.


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
	I'm not sure if using 2D arrays is that justified so maybe I would've just made a 1D array of my buttons and spread them using GridLayout.
	


========================
=: External Resources :=
========================

- Cite any external resources (images, tutorials, etc.) that you may have used 
  while implementing your game.
	I had troubles understanding the basics of GUI, so I watched this tutorial, which was very helpful: https://www.youtube.com/watch?v=Kmgo00avvEw
