package com.praveen.game.bowling.alley.impl;

import com.praveen.game.bowling.alley.GameSet;
import com.praveen.game.bowling.alley.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player {
    private int score;

    private String name = "0";

    private List<GameSet> gameSets = new ArrayList<>(0);

    public PlayerImpl(String name, List<GameSet> gameSets) {
        this.name = name;
        this.gameSets = gameSets;
    }

    @Override public int getScore() {
        return score;
    }

    @Override public String getName() {
        return name;
    }

    @Override public List<GameSet> getGameSets() {
        return gameSets;
    }

    @Override public void play(int setIndex) {
        System.out.println("Player: " + name + " Set: " + setIndex);
        GameSet gameSet = gameSets.get(setIndex);
        gameSet.play();
        score += gameSet.getScore();
    }

    public String toString() {
        return "Player: " + name + ", Score: " + score;
    }
}
