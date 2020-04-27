package com.ps.lowlevel.impl;

import com.ps.lowlevel.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score {
    List<Integer> points = new ArrayList<>();

    @Override public void add(int value) {
        points.add(value);
    }

    @Override public int getScore() {
        int prev = 0;
        int totalScore = 0;
        for (int point : points) {
            totalScore += point;
            if (point == 10) {
                totalScore += 10;
            } else if (prev + point == 10) {
                totalScore += 5;
            }
            prev = point;
        }
        return totalScore;
    }

    @Override public String toString() {
        return points.toString();
    }
}
