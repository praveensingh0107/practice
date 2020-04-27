package com.ps.lowlevel.client;

import com.ps.lowlevel.Game;
import com.ps.lowlevel.GameSet;
import com.ps.lowlevel.Player;
import com.ps.lowlevel.impl.GameImp;
import com.ps.lowlevel.impl.GameSetImpl;
import com.ps.lowlevel.impl.LastGameSetImpl;
import com.ps.lowlevel.impl.PlayerImpl;
import com.ps.lowlevel.util.ConsoleOutputWriter;
import com.ps.lowlevel.util.InputReader;
import com.ps.lowlevel.util.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (InputReader reader = new InputReader()) {
            OutputWriter writer = new ConsoleOutputWriter();
            List<Player> players = List.of(new PlayerImpl("Player1"));
            List<GameSet> gameSets = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                gameSets.add(new GameSetImpl(reader, writer));
            }
            gameSets.add(new LastGameSetImpl(reader, writer));
            Game game = new GameImp(players, gameSets);
            game.startGame();
            game.forEach(System.out::println);
            game.getWinner(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
