package com.praveen.game.bowling.alley.impl;

import com.praveen.game.bowling.alley.Lane;
import com.praveen.game.bowling.alley.Player;

import java.util.ArrayList;
import java.util.List;

public class LaneImpl implements Lane {
    private List<Player> players = new ArrayList<>(0);

    private boolean isGameOver = false;

    public LaneImpl(List<Player> players) {
        this.players = players;
    }

    @Override public void startGame() {
        int numberOfSets = players.get(0).getGameSets().size();
        for (int set = 0; set < numberOfSets; set++) {
            for (Player player : players) {
                player.play(set);
            }
        }
        isGameOver = true;
    }

    @Override public Player getWinner() {
        if (!isGameOver)
            return null;
        return players.stream().max((a, b) -> b.getScore() - a.getScore()).get();
    }

    @Override public boolean isGameOver() {
        return isGameOver;
    }
}
