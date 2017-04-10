package game2;

import java.util.Random;

public class CpuPlayer implements game2.Player {

    private int begin;
    private int end;
    private int computerGuess;

    public CpuPlayer() {
        begin = 1;
        end = 100;
        computerGuess = (begin + end) / 2;
    }

    @Override
    public int getChoice() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    @Override
    public int getGuess() {
        return (begin + end) / 2;
    }

    @Override
    public void updateStatus(String value) {
        if (value.equals("less")) {
            end = computerGuess - 1;
        } else if (value.equals("more")) {
            begin = computerGuess + 1;
        }
    }
}
