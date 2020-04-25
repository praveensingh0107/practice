package com.praveen.lowlevel.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TicTacToeGame implements Game{
    private Game[][] boards;
    private Player winner;
    private boolean hasChildGames;
    private BufferedReader br;
    public TicTacToeGame(boolean hasChildGames) {
        boards = new Game[3][3];
        this.hasChildGames = hasChildGames;
        InputStream in;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean initializeBoard(int x, int y, Game game) {
        if (x >= 0 && x < 3 && y >=0 && y < 3) {
            boards[x][y] = game;
            return true;
        } else {
            return false;
        }
    }
    @Override public void startGame(Player p1, Player p2) {
        if (hasChildGames) {
            for (int i = 0; i < boards.length; i++) {
                for (int j = 0; j < boards[0].length; j++) {
                    System.out.println("Game Level: " + i + " x " + "j");
                    boards[i][j].startGame(p1, p2);
                }
            }
        } else {
            boolean isFirstPlayer = true;
            for (int i = 0; i < 9; i++) {
                Player p = isFirstPlayer?p1:p2;
                processTurn(p, i + 1);
                if (evaluateWinner())
                    break;
                isFirstPlayer = isFirstPlayer? false:true;
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean evaluateWinner() {
        return evaluateRows() || evaluateCols() || evaluateDiagonals();
    }

    private boolean evaluateDiagonals() {
        if (boards[0][0].getWinner() != null && (boards[0][0].getWinner() == boards[1][1].getWinner()
                && boards[0][0].getWinner() == boards[2][2].getWinner())) {
            setWinner(boards[0][0].getWinner());
            return true;
        } else if (boards[2][0].getWinner() != null && (boards[2][0].getWinner() == boards[1][1].getWinner()) &&
                boards[2][0].getWinner() == boards[0][2].getWinner()) {
            setWinner(boards[2][0].getWinner());
            return true;
        }
        return false;
    }

    private boolean evaluateRows() {
        for (int r = 0; r < 3; r++) {
            if (boards[r][0].getWinner() != null && (boards[r][0].getWinner() == boards[r][1]
                    .getWinner()) && (boards[r][0].getWinner() == boards[r][2].getWinner())) {
                setWinner(boards[r][0].getWinner());
                return true;
            }
        }
        return false;
    }

    private boolean evaluateCols() {
        for (int c = 0; c < 3; c++) {
            if (boards[0][c].getWinner() != null && (boards[0][c].getWinner() == boards[1][c]
                    .getWinner()) && (boards[0][c].getWinner() == boards[2][c].getWinner())) {
                setWinner(boards[0][c].getWinner());
                return true;
            }
        }
        return false;
    }

    @Override public Player getWinner() {
        return winner;
    }

    @Override public void setWinner(Player p) {
        this.winner = p;
    }

    private void processTurn(Player p, int count) {
        try {
            boolean flag = true;
            while (flag) {
                System.out.println("Count: " + count + ", Enter coordinate for Player: " + p.getName());
                String line = br.readLine();
                String[] coordinates = line.split(" ");
                int r = Integer.parseInt(coordinates[0]);
                int c = Integer.parseInt(coordinates[1]);
                if ( r < 0 || r > 2 || c < 0 || c > 2 || boards[r][c].getWinner() != null) {
                    System.out.println("Wrong entry, Please enter the coordinate.");
                    flag = true;
                } else {
                    boards[r][c].setWinner(p);
                    flag = false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
