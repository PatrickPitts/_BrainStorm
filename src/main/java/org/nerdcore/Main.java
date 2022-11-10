package org.nerdcore;

import java.io.CharArrayReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void RPSLS() {
        Scanner key = new Scanner(System.in);
        String[] options = {"rock", "paper", "scissors", "lizard", "spock"};
        // import java.util.Random; //add this to the top of your file
        Random random = new Random();
        String compThrow = options[random.nextInt(options.length)];


        System.out.println("Will you throw Rock, Paper, Scissors, Lizard, or Spock?");
        String playerThrow = key.nextLine();
        System.out.printf("You threw '%s', and the computer threw '%s'.%n", playerThrow, compThrow);
        int playerWins = -1;//player loses
        //"ROCK"
        switch ( playerThrow.toLowerCase() ) {
            case "rock":
                    //false                          //true
                if (compThrow.equals("scissors") || compThrow.equals("lizard")) {
                    playerWins = 1; //Player wins
                } else if (compThrow.equals("rock")) {
                    playerWins = 0; // tie
                }
                break;
            case "paper":
                if (compThrow.equals("rock") || compThrow.equals("spock")) {
                    playerWins = 1;
                } else if (compThrow.equals("paper")) {
                    playerWins = 0;
                }
                break;
            case "scissors":
                if (compThrow.equals("lizard") || compThrow.equals("paper")) {
                    playerWins = 1;
                } else if (compThrow.equals("scissors")) {
                    playerWins = 0;
                }
                break;
            case "lizard":
                if (compThrow.equals("paper") || compThrow.equals("spock")) {
                    playerWins = 1;
                } else if (compThrow.equals("lizard")) {
                    playerWins = 0;
                }
                break;
            case "spock":
                if (compThrow.equals("scissors") || compThrow.equals("rock")) {
                    playerWins = 1;
                } else if (compThrow.equals("spock")) {
                    playerWins = 0;
                }
                break;
            default:
                System.out.printf("You can't throw '%s'!%nGame over!", playerThrow);
                return;
        }

        if(playerWins == -1){
            System.out.printf("'%s' beats '%s'.%nYou Lose!", compThrow, playerThrow);
        } else if (playerWins == 1){
            System.out.printf("'%s' beats '%s'.%nYou Win!", playerThrow, compThrow);
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void RPS() {
        Scanner key = new Scanner(System.in);

        String[] options = {"rock", "paper", "scissors"};
        // import java.util.Random; //add this to the top of your file
        Random random = new Random();
        String compThrow = options[random.nextInt(options.length)];


        System.out.println("Will you throw Rock, Paper, or Scissors?");
        String playerThrow = key.nextLine();

        System.out.printf("You threw %s%n", playerThrow);
        System.out.printf("The computer throws %s%n", compThrow);


        if (playerThrow.equalsIgnoreCase("rock")) {

            if (compThrow.equals("scissors")) {
                System.out.println("Rock beats Scissors");
                System.out.println("You win!");
            } else if (compThrow.equals("paper")) {
                System.out.println("Paper beats Rock");
                System.out.println("You lose!");
            } else {
                System.out.println("It's a tie!");
            }

        } else if (playerThrow.equalsIgnoreCase("paper")) {
            if (compThrow.equals("rock")) {
                System.out.println("Paper beats Rock");
                System.out.println("You win!");
            } else if (compThrow.equals("scissors")) {
                System.out.println("Scissors beats Paper");
                System.out.println("You lose!");
            } else {
                System.out.println("It's a tie!");
            }
        } else if (playerThrow.equalsIgnoreCase("scissors")) {
            if (compThrow.equals("paper")) {
                System.out.println("Scissors beats Paper");
                System.out.println("You win!");
            } else if (compThrow.equals("rock")) {
                System.out.println("Rock beats Scissors");
                System.out.println("You lose!");
            } else {
                System.out.println("It's a tie!");
            }
        } else {
            System.out.printf("You can't throw '%s'. Game over!", playerThrow);
        }

    }

    public static void madlibs() {
        Scanner key = new Scanner(System.in);

        System.out.println("Give me a proper noun:\n");
        String noun1 = key.nextLine();

        System.out.println("Give me a person's name:\n");
        String name1 = key.nextLine();

        System.out.println("Give me a whole number:\n");
        int numPosters = Integer.parseInt(key.nextLine());

        System.out.println("Give me a noun:\n");
        String posterNoun = key.nextLine();

        System.out.println("Give me another noun:\n");
        String classNoun = key.nextLine();

        System.out.println("Give me a person's full name:\n");
        String founderName = key.nextLine();

        System.out.println("Give me a whole number:\n");
        int hours = key.nextInt();


        System.out.printf("I'll never forget my first year at %s University. %n", noun1);
        System.out.printf("When I first moved in to my dorm, my roommate %s really made me feel at home.%n", name1);
        System.out.printf("They put up %d posters, all of them depicting %s in spectacular technicolor. %n", numPosters, posterNoun);
        System.out.printf("My first college class was %s 101. ", classNoun);
        System.out.printf("In that class, we learned about the subjects' founding member, %s.%n", founderName);
        System.out.printf("The course was interesting, but the professor gave us %d hours of homework every night!%n", hours);


    }

    public static void main(String[] args) {

        String[] x = new String[]{"Zero", "One"};//, "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
                        //i < 10
        for(int i = 0; i < x.length ; i++){
            System.out.println(x[i]);
        }

        for(int i = 2; i < 10; i++);
        {1, 2, 3, 4, 5, 6}

    }
}

class YuGiOhCard{
    private int attackpoints;
    private int defensepoints;
    private String cardName;

    public YuGiOhCard(int A, int D, String cardName){
        this.attackpoints = A;
        this.defensepoints = D;
        this.cardName = cardName;
    }

    public void card_combat(YuGiOhCard enemy){
        //the "this" keyword acts as a variable that represents the Object that is "calling" (or using) this method

        if(this.getAttackpoints() > enemy.getAttackpoints()){
            System.out.println("This card has higher attack points!");
        } else if (this.getAttackpoints() < enemy.getAttackpoints()){
            System.out.println("The enemy card has higher attack points!");
        } else {
            System.out.println("The combat is a draw! (I think, I haven't played this game in over a decade.)");
        }
    }

    //"Setters" and "Getters"
    //AKA
    //"Accessors" and "Mutators"
    public int getAttackpoints(){
        return this.attackpoints;
    }

    public int getDefensepoints(){
        return this.defensepoints;
    }

    public String getCardName(){
        return this.cardName;
    }

    public void setAttackpoints(int attackpoints){
        this.attackpoints = attackpoints;
    }

    public void setDefensepoints(int defensepoints){
        this.defensepoints = defensepoints;
    }

    public void setCardName(String cardName){
        this.cardName = cardName;
    }

}
class Polygon{
    private int sides;
    private double sideLength;

    public Polygon(int sides, double sideLength){
        this.sides = sides;
        this.sideLength = sideLength;
    }
    public void description(){
        System.out.printf("This is a %s-sided regular polygon.%n", sides);
        System.out.printf("Each angle measures %d degrees.%n", getInteriorAngle());
        System.out.printf("Each vertex has an exterior angle of %d degrees.%n", 180 - getInteriorAngle());
        System.out.printf("The sum of all interior angles is %d degrees.%n", getInteriorAngle() * sides);
        System.out.printf("The perimeter of the polygon is %.2f.%n", perimeter());
        System.out.printf("The area of the polygon is %.2f.%n", area());

    }

    public int getInteriorAngle(){
        return 180 * (sides-2) / sides;
    }

    public double perimeter(){
        return sideLength * sides;
    }

    public double area(){
        double ap = sideLength/(2 * Math.tan(Math.PI/sides));
        return ap * perimeter() / 2.0;
    }
}
