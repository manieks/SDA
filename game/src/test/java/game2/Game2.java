package game2;

public class Game2 {

    private Player firstPlayer;
    private Player secondPlayer;


    public Game2() {
        //TODO: zamienic
        firstPlayer = new CpuPlayer();
        secondPlayer = new HumanPlayer();
    }

    public void start() {

        int choice = firstPlayer.getChoice();
        int guess = 1;
        int attempts = 0;

        while (choice != guess) {
            guess = secondPlayer.getGuess();
            ++attempts;
            if (guess < choice) {
                secondPlayer.updateStatus("more");
            } else if (guess > choice) {
                secondPlayer.updateStatus("less");
            }

        }

        System.out.println("Koniec gry potrzbene bylo " + attempts+" ruchow");
    }
}
