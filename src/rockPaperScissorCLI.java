/*
 *Author: Prajwal Dhungana
 *This program asks user to enter rock, paper, or scissor
 * as an input, displays the computer's random choice to the user
 * and tells the user if the user won or loose
 * At the end, it shows the user final scoreboard of total games played, total wins, total losses and total ties
 */

import java.util.*;

//method to generate random rock, paper, or scissors by the computer
public class rockPaperScissorCLI {

    //this is a method to generate random numbers as per user need
    private static Random rand = new Random();

    //this method assigns randomly generated numbers a character value
    public static char  generateComputersChoice()
    {
        int comp_play = rand.nextInt(3);

        switch (comp_play)
        {
            case 0:
                return 'r';
            case 1:
                return 'p';
            case 2:
                return 's';
        }
        return '?';
    }

    //method to get rock, paper, or scissors as input from the user
    public static char enterPlayersChoice()
    {
        Scanner keyboard = new Scanner(System.in);
        while (true)
        {
            System.out.printf("********************************************\n");
            System.out.printf("       Rock Paper or Scissors Game\n");
            System.out.printf("        Author: Prajwal Dhungana\n");
            System.out.printf("********************************************\n");
            System.out.printf("Please enter your choice:\n");
            System.out.printf("r for rock\n");
            System.out.printf("p for paper\n");
            System.out.printf("s for scissors\n");
            System.out.printf("e for exiting the game\n");
            System.out.printf("********************************************\n");
            System.out.printf("---> ");
            String choice = keyboard.next();
            System.out.printf("********************************************\n");

            choice.toLowerCase();
            choice.trim();

            if (choice.length() > 1)
            {
                System.out.printf(">> %s << is not a valid entry. Please try again!\n", choice);
                continue;
            }
            char choiceChar = choice.charAt(0);

            if (choiceChar == 'r' ||
                    choiceChar == 'p' ||
                    choiceChar == 's'||
                    choiceChar == 'e')
            {
                return choiceChar;
            }
            else
            {
                System.out.printf("%s is not a valid entry. Please try again!\n", choiceChar);
            }

        }
    }

    //method to convert computer choice character 'r','p',or 's' into a string 'rock','paper',or 'scissors'
    public  static String translateCompChar(char compChoice)
    {
        String computerChoice = "";

        if (compChoice == 'r')
        {
            computerChoice = "rock";
        }
        else if (compChoice == 'p')
        {
            computerChoice = "paper";
        }
        else if (compChoice == 's')
        {
            computerChoice = "scissors";
        }

        return computerChoice;
    }

    //method to convert user choice character 'r','p',or 's' into a string 'rock','paper',or 'scissors'
    public static String translateUserChar(char userChoice)
    {
        String userChoiceInput = "";

        if (userChoice == 'r')
        {
            userChoiceInput = "rock";
        }
        else if (userChoice == 'p')
        {
            userChoiceInput = "paper";
        }
        else if (userChoice == 's')
        {
            userChoiceInput = "scissors";
        }

        return userChoiceInput;
    }

    //begin main class
    public static void main(String[] args)
    {
        //declaring necessary variables
        int numGames = 0;

        int wins = 0;
        int losses = 0;
        int ties = 0;

        //while loop for looping the program numGames times
        while (true)
        {
            //calling compChoice and userChoice method to get computer input as well as user input
            char compChoice = generateComputersChoice();
            char userChoice = enterPlayersChoice();

            //calling translatedCompChoice and translatedUserChoice method to convert 'r','p',or's' as input into 'rock','paper',or 'scissors'
            String translatedCompChoice = translateCompChar(compChoice);
            String translatedUserChoice = translateUserChar(userChoice);

            if (userChoice == 'e')
            {
                //Printing the number of wins, draws , and losses
                System.out.printf("********************************************\n");
                System.out.printf("Final score board for %d games.\n",numGames);
                System.out.printf("Wins: %d\n", wins);
                System.out.printf("Loses: %d\n", losses);
                System.out.printf("Ties: %d\n", ties);
                System.out.printf("Game Closed Successfully!!\n");
                System.out.printf("********************************************\n");
                System.exit(0);
            }

            String message = "You chose " + translatedUserChoice + " and \n"+
                    "The computer chose " + translatedCompChoice + "!\n";

            if (compChoice == userChoice)
            {
                message += "This is a tie.";
                ties++;
                numGames++;
            }
            else if (compChoice == 'r' && userChoice == 'p')
            {
                message += "   paper wraps rock!\n";
                message += "You win!";
                wins++;
                numGames++;
            }
            else if (compChoice == 'r' && userChoice == 's')
            {
                message += "    rock crushes scissors!\n";
                message += "Computer wins!";
                losses++;
                numGames++;
            }
            else if (compChoice == 's' && userChoice == 'r')
            {
                message += "    rock crushes scissors!\n";
                message += "You win!";
                wins++;
                numGames++;
            }
            else if (compChoice == 's' && userChoice == 'p')
            {
                message += "    scissors cuts paper!\n";
                message += "Computer wins!";
                losses++;
                numGames++;
            }
            else if (compChoice == 'p' && userChoice == 'r')
            {
                message += "    paper wraps rock!\n";
                message += "Computer wins!";
                losses++;
                numGames++;
            }
            else if (compChoice == 'p' && userChoice == 's')
            {
                message += "    scissors cuts paper!\n";
                message += "You win!";
                wins++;
                numGames++;
            }

            System.out.print(message +"\n");
        }
    }
    //end of main method
}
