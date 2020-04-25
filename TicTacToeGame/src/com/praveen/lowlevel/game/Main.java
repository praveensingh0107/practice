package com.praveen.lowlevel.game;

public class Main {
    public static void main(String[] args) {
        Player p1 = () -> "John";
        Player p2 = () -> "Sean";
        GameFactory factory = new GameFactoryImpl();
        Game game = factory.createTicTacToeGameWithoutChildGame();
        game.startGame(p1, p2);
        System.out.println(game.getWinner().getName());
    }
}
