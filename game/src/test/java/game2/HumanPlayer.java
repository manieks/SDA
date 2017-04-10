package game2;

import java.util.Scanner;

public class HumanPlayer implements Player {

    @Override
    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wartosc poczatkowa");
        return scanner.nextInt();
    }

    @Override
    public int getGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nastepna liczbe");
        return scanner.nextInt();
    }

    @Override
    public void updateStatus(String value) {
        System.out.println(value);
    }
}
