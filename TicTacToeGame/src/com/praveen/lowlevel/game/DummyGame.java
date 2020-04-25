package com.praveen.lowlevel.game;

public class DummyGame implements  Game{
    private Player winner;
    @Override public void startGame(Player p1, Player p2) {

    }

    @Override public Player getWinner() {
        return winner;
    }

    @Override public void setWinner(Player p) {
        this.winner = p;
    }
}
