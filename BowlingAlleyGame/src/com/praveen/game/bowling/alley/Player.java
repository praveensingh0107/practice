package com.praveen.game.bowling.alley;

import java.util.List;

public interface Player {
    int getScore();

    String getName();

    List<GameSet> getGameSets();

    void play(int setIndex);
}
