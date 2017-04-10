package game2;

import game2.Game2;

import java.util.Random;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

   /*     Scanner scanner = new Scanner(System.in);

        System.out.println("Kto gra H/C ?");
        String whoGuess = scanner.nextLine();

        if (whoGuess.equals("H")) {
            humanGuess();
        } else {
            computerGuess();
        }*/


        Game2 game = new Game2();
        game.start();

    }


    public static void humanGuess() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int userGuess = 0;
        int attempts = 0;

        while (userGuess != numberToGuess) {
            System.out.println("Podaj liczbe calkowita [1-100]");
            userGuess = scanner.nextInt();
            ++attempts;

            if (userGuess < numberToGuess) {
                System.out.println("Wylosowana liczba jest wieksza");
            } else if (userGuess > numberToGuess) {
                System.out.println("Wylosowana liczba jest mniejsza");
            }

        }

        System.out.println("Gratulacje wygrałeś potrzebowałeś " + attempts + " prob");
    }


    public static void computerGuess() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        int begin = 1;
        int end = 100;
        int attempts = 0;

        while (!input.equals("win")) {

            int computerGuess = (begin + end) / 2;
            System.out.println(computerGuess);
            ++attempts;

            input = scanner.nextLine();
            if (input.equals("less")) {
                end = computerGuess - 1;
            } else if (input.equals("more")) {
                begin = computerGuess + 1;
            }
        }

        System.out.println("Komputer zgadl w " + attempts + " ruchach");
    }
}
