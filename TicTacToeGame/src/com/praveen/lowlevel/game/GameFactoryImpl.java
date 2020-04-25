package com.praveen.lowlevel.game;

public class GameFactoryImpl implements GameFactory {
    @Override public Game createTicTacToeGameWithoutChildGame() {
        TicTacToeGame game = new TicTacToeGame(false);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c< 3; c++) {
                game.initializeBoard(r, c, new DummyGame());
            }
        }
        return game;
    }

}
