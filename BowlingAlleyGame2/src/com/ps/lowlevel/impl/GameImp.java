package com.ps.lowlevel.impl;

import com.ps.lowlevel.Game;
import com.ps.lowlevel.GameSet;
import com.ps.lowlevel.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GameImp implements Game {
    List<Player> players;

    List<GameSet> gameSets;

    boolean isGameOver = false;

    public GameImp(List<Player> players, List<GameSet> gameSets) {
        this.players = players == null ? new ArrayList<>(0) : players;
        this.gameSets = gameSets == null ? new ArrayList<>(0) : gameSets;
    }

    @Override public void startGame() {
        gameSets.forEach(x -> x.play(players));
        isGameOver = true;
    }

    @Override public void forEach(Consumer<Player> action) {
        players.forEach(action);
    }

    @Override public void getWinner(Consumer<Player> action) {
        if (isGameOver) {
            Player player = players.stream().max((a, b) -> b.getTotalScore() - a.getTotalScore())
                    .get();
            action.accept(player);
        }
    }
}
