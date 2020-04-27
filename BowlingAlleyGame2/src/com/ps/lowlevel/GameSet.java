package com.ps.lowlevel;

import java.util.List;

public interface GameSet {
    void play(List<Player> players);

    Score play();
}
