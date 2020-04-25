package com.praveen.game.bowling.alley.impl;

import com.praveen.game.bowling.alley.GameSet;
import com.praveen.game.bowling.alley.Rolls;

import java.io.BufferedReader;

public class GameSetImpl implements GameSet {
    private int score = 0;

    private BufferedReader br;

    private Rolls rolls;

    public GameSetImpl(Rolls rolls) {
        this.rolls = rolls;
        this.rolls.setGameSet(this);
    }

    @Override public int getScore() {
        return score;
    }

    @Override public void play() {
        rolls.play();
    }

    @Override public void setScore(int score) {
        this.score = score;
    }
}
