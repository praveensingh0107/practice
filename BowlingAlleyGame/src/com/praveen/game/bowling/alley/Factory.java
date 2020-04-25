package com.praveen.game.bowling.alley;

import java.io.BufferedReader;

public interface Factory {
    Game createGame(BufferedReader br);
}
