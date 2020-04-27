package com.ps.lowlevel.impl;

import com.ps.lowlevel.Score;
import com.ps.lowlevel.util.InputReader;
import com.ps.lowlevel.util.OutputWriter;

public class GameSetImpl extends AbstractGameSet {

    public GameSetImpl(InputReader reader, OutputWriter writer) {
        super(reader, writer);
    }

    @Override public Score play() {
        Score score = new ScoreImpl();
        int value = getReader().getValue();
        score.add(value);
        if (value != 10) {
            value = getReader().getValue();
            score.add(value);
        }
        return score;
    }
}
