package com.praveen.game.bowling.alley.impl;

import com.praveen.game.bowling.alley.GameSet;
import com.praveen.game.bowling.alley.Rolls;

import java.io.BufferedReader;

public class RollsImpl implements Rolls {
    private final BufferedReader br;

    private GameSet set;

    public RollsImpl(BufferedReader br) {
        this.br = br;
    }

    @Override public void play() {
        int score = 0;
        int pin = 10;
        int value = getValue(0, pin, br);
        score += value;
        pin -= value;
        if (pin == 0) {
            score += 10;
            set.setScore(score);
            System.out.println("It's a strike.");
            return;
        }
        value = getValue(1, pin, br);
        score += value;
        pin -= value;
        if (pin == 0) {
            score += 5;
            System.out.println("It's a spare");
        }
        set.setScore(score);
    }

    @Override public void setGameSet(GameSet set) {
        this.set = set;
    }

}
