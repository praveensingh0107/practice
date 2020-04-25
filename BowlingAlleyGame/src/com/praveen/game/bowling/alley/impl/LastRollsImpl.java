package com.praveen.game.bowling.alley.impl;

import com.praveen.game.bowling.alley.GameSet;
import com.praveen.game.bowling.alley.Rolls;

import java.io.BufferedReader;

public class LastRollsImpl implements Rolls {
    private final BufferedReader br;

    private GameSet set;

    public LastRollsImpl(BufferedReader br) {
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
            pin = 10;
        }
        value = getValue(1, pin, br);
        score += value;
        pin -= value;
        if (pin == 0) {
            if (value == 10) {
                score += 10;
                System.out.println("It's a Strike");
            } else {
                score += 5;
                System.out.println("It's a spare");
            }
            pin = 10;
        }
        if (pin == 10) {
            value = getValue(2, pin, br);
            score += value;
            pin -= value;
            if (pin == 0) {
                score += 10;
                System.out.println("It's a strike");
            }
        }
        set.setScore(score);
    }

    @Override public void setGameSet(GameSet set) {
        this.set = set;
    }
}
