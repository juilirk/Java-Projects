package com.company;

import java.io.FileNotFoundException;
import java.lang.NullPointerException;
import java.util.Scanner;

/**
 * Main class to implement game logic and interact with the player to play the game - "Guess the Movie"
 */
public class Main {
    /**
     * Main function to interact with player
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            //Create Game class object to call methods
            Game game = new Game();
            //Generate random movie title
            String randomMovie = game.generateRandomMovie(game.getMovieList("movies.txt"));
            //Let Game class know the random movie title
            game.setRandomMovie(randomMovie);
            //Encrypt movie title
            String encryptedMovie = game.encryptMovie(randomMovie);
            //Let Game class know the encrypted movie title
            game.setEncryptedMovie(encryptedMovie);
            //Create Scanner object to read user input
            Scanner input = new Scanner(System.in);
            char guess;
            //Initialize number of wrong attempts to 0
            int wrongAttempts = 0;
            //Let Game class know the number of wrong attempts
            game.setWrongAttempts(wrongAttempts);
            //Game instructions
            System.out.println("\nWelcome to \"Guess the movie\"! The game will randomly pick a movie title " +
                    "and show you how many letters it's made up of. \n" +
                    "Your goal is to try to figure out the movie by guessing one letter at a time. \n" +
                    "If a letter is indeed in the title, the computer will reveal its correct position in the word, \n" +
                    "if not, you lose a point. If you lose 10 points, game over!\n" +
                    "Let's begin!\n");
            //Play until game is over
            while (!game.gameOver()) {
                System.out.print("You are guessing: ");
                //Display encrypted movie title
                System.out.println(game.getEncryptedMovie());
                //Display number of wrong attempts made so far
                System.out.print("You have guessed (" + game.getWrongAttempts() + ") wrong letters: ");
                //Display all wrongly guessed letters so far
                System.out.println(game.getWrongGuesses());
                //Display number of wrong attempts left
                System.out.println("You have (" + game.getAttemptsLeft() + ") wrong guesses left.");
                //Prompt for input
                System.out.print("Guess a letter: ");
                //Read player's guess and convert it to lowercase
                guess = input.next().toLowerCase().charAt(0);
                //Check if player's guess is valid
                if (game.isValidGuess(guess)) {
                    //Check if guess was already made
                    if (!game.hasAlreadyGuessed(guess)) {
                        //Check if player's guess is right or wrong and update fields accordingly
                        game.checkGuess(guess);
                    } else {
                        System.out.println("You have already guessed '" + guess + "'.");
                    }
                } else {
                    System.out.println("Please enter a letter only.");
                }
                //New line for each guess
                System.out.println();
            }

            //Check if player won
            if (game.gameWon()) {
                System.out.println("CORRECT...YOU WIN!");
                System.out.println("You have guessed '" + randomMovie + "' correctly.");
            } else {
                System.out.println("GAME OVER...YOU LOSE!");
                System.out.println("The movie was '" + randomMovie + "'.");
            }

            //Close input scanner
            input.close();
        } catch(FileNotFoundException fnf) {
            System.out.println("Movie database not found.");
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
}