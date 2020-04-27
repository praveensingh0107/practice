package com.ps.lowlevel.impl;

import com.ps.lowlevel.Player;
import com.ps.lowlevel.Score;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player {
    private List<Score> scores = new ArrayList<>();

    private String name;

    public PlayerImpl(String name) {
        this.name = name;
    }

    @Override public void addScores(Score score) {
        scores.add(score);
    }

    @Override public String getName() {
        return name;
    }

    @Override public int getTotalScore() {
        return scores.stream().mapToInt(Score::getScore).sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Player: " + name + " { ");
        scores.forEach(sb::append);
        sb.append(" }");
        return sb.toString();
    }
}
