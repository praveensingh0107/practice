package com.praveen.game.bowling.alley;

import java.io.BufferedReader;
import java.io.IOException;

public interface Rolls {
    void play();

    void setGameSet(GameSet set);

    default public int getValue(int rollNumber, int pinValue, BufferedReader br) {
        while (true) {
            System.out.println("Please enter rollNumber: " + rollNumber);
            try {
                String rollValue = br.readLine();
                int value = Integer.valueOf(rollValue);
                if (value > pinValue) {
                    System.out.println("Wrong entry, value cannot be more than: " + pinValue);
                } else {
                    return value;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
