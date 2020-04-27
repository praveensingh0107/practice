package com.ps.lowlevel;

import java.util.function.Consumer;

public interface Game {
    /**
     * to Start the Game
     */
    void startGame();

    /**
     * perform action on each players
     *
     * @param action
     */
    void forEach(Consumer<Player> action);

    /**
     * get Winner and perform the action
     *
     * @param action
     */
    void getWinner(Consumer<Player> action);
}
