package com.praveen.lowlevel.game;

public interface Game {
    void startGame(Player p1, Player p2);
    Player getWinner();
    void setWinner(Player p);
}
