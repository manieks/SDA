package game;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by mariusz.przybysz on 2017-04-08.
 */
public class Game {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int number, toGuess, min, max;
        String type;
        min = 0;
        max = 100;

        toGuess = randInt(min, max);

        System.out.println("Kto zgaduje H=Human, C=Computer");
        type = sc.nextLine();


        if (type.equalsIgnoreCase("h")) {
            do {
                System.out.println("podaj liczbe od 0 do 100");
                number = sc.nextInt();
                if (number < toGuess) {
                    System.out.println("za mało");
                } else if (number > toGuess) {
                    System.out.println("za duzo");
                } else if (number == toGuess) {
                    System.out.println("you win. Number was:" + number);
                }
            } while (number != toGuess);
        }
        else if (type.equalsIgnoreCase("c")){
            System.out.println("Type number to guess: ");
            number= sc.nextInt();
            do {
                randInt(min, max);

            }while (number != toGuess);



        }
        else { System.out.println("Kto zgaduje H=Human, C=Computer");}
    }



    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}

