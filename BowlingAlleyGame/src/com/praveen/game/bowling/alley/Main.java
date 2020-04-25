package com.praveen.game.bowling.alley;

import com.praveen.game.bowling.alley.impl.FactoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Factory factory = new FactoryImpl();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Game game = factory.createGame(br);
            game.getLane(0).startGame();
            System.out.println(game.getLane(0).isGameOver());
            System.out.println(game.getLane(0).getWinner());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
