package com.praveen.game.bowling.alley.impl;

import com.praveen.game.bowling.alley.Factory;
import com.praveen.game.bowling.alley.Game;
import com.praveen.game.bowling.alley.GameSet;
import com.praveen.game.bowling.alley.Lane;
import com.praveen.game.bowling.alley.Player;
import com.praveen.game.bowling.alley.Rolls;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FactoryImpl implements Factory {
    @Override public Game createGame(BufferedReader br) {
        List<Rolls> rolls = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rolls.add(createRollsImpl(br));
        }
        rolls.add(createLastRollsImpl(br));
        List<GameSet> sets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sets.add(createGameSet(rolls.get(i)));
        }
        Player player1 = createPlayer("Player 0", sets);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        List<Lane> lanes = new ArrayList<>();
        lanes.add(createLane(players));
        Game game = new GameImpl(lanes);
        return game;
    }

    private Rolls createRollsImpl(BufferedReader br) {
        return new RollsImpl(br);
    }

    private Rolls createLastRollsImpl(BufferedReader br) {
        return new LastRollsImpl(br);
    }

    private GameSet createGameSet(Rolls rolls) {
        return new GameSetImpl(rolls);
    }

    private Player createPlayer(String name, List<GameSet> gameSets) {
        return new PlayerImpl(name, gameSets);
    }

    private Lane createLane(List<Player> players) {
        return new LaneImpl(players);
    }

}
