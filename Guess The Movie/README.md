# Guess The Movie

Project Summary
---------------
The goal of the project was to build a simple text game where the player gets to guess the movie name given the number of letters in it (pretty much like hangman but with movies). <br>

The rules are simple; the game randomly picks a movie title, and shows the player how many letters it's made up of. The player's goal is to try to figure out the movie by guessing one letter at a time. If a letter is indeed in the title, the game will reveal its correct position in the word, if not, they lose a point. If they lose 10 points, the game is over.

The project is implemented through two classes and one text file:
<ul>
  <li> <b> <i> Game.java </i> </b> that contains the game logic and methods </li>
  <li> <b> <i> Main.java </i> </b> that implements game logic and handles user interaction </li>
  <li> <b> <i> movies.txt </i> </b> that contains the list of movies to be considered for the game </li>
 </ul>
