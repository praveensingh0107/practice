package com.praveen.game.bowling.alley.impl;

import com.praveen.game.bowling.alley.Game;
import com.praveen.game.bowling.alley.Lane;

import java.util.List;

public class GameImpl implements Game {
    private List<Lane> lanes;

    public GameImpl(List<Lane> lanes) {
        this.lanes = lanes;
    }

    @Override public Lane getLane(int index) {
        return lanes.get(index);
    }
}
