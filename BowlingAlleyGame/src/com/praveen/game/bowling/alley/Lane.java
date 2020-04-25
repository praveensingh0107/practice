package com.praveen.game.bowling.alley;

public interface Lane {
    void startGame();

    Player getWinner();

    boolean isGameOver();
}
