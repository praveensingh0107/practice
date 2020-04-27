package com.ps.lowlevel.impl;

import com.ps.lowlevel.GameSet;
import com.ps.lowlevel.Player;
import com.ps.lowlevel.Score;
import com.ps.lowlevel.util.InputReader;
import com.ps.lowlevel.util.OutputWriter;

import java.util.List;

public abstract class AbstractGameSet implements GameSet {
    private final InputReader reader;

    private final OutputWriter writer;

    public AbstractGameSet(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override public void play(List<Player> players) {
        players.forEach(p -> {
            //to print the player
            getWriter().println(p.getName());
            Score score = play();
            p.addScores(score);
        });
    }

    public InputReader getReader() {
        return reader;
    }

    public OutputWriter getWriter() {
        return writer;
    }
}
