package com.ps.lowlevel.impl;

import com.ps.lowlevel.Score;
import com.ps.lowlevel.util.InputReader;
import com.ps.lowlevel.util.OutputWriter;

public class LastGameSetImpl extends AbstractGameSet {

    public LastGameSetImpl(InputReader reader, OutputWriter writer) {
        super(reader, writer);
    }

    @Override public Score play() {
        Score score = new ScoreImpl();
        int value1 = getReader().getValue();
        score.add(value1);
        int value2 = getReader().getValue();
        score.add(value2);
        if (value1 + value2 >= 10)
            score.add(getReader().getValue());
        return score;
    }
}
