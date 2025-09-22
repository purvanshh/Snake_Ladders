package com.snakesladders;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players;
    private final Board board;
    private final IRollable roller;
    private final IRuleEngine ruleEngine;
    private int currentPlayerIndex;
    private Player winner;

    public Game(List<Player> players, Board board, IRollable roller, IRuleEngine ruleEngine) {
        if (players == null || players.size() < 2) throw new IllegalArgumentException("Need at least 2 players");
        this.players = new ArrayList<>(players);
        this.board = board;
        this.roller = roller;
        this.ruleEngine = ruleEngine;
        this.currentPlayerIndex = 0;
        this.winner = null;
    }

    public void start() {
        while (!hasWinner()) {
            Player p = players.get(currentPlayerIndex);
            playTurn(p);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        System.out.println("Winner: " + winner.getName());
    }

    public void playTurn(Player p) {
        if (p.isSkipNextTurn()) {
            System.out.println(p.getName() + " skips this turn.");
            p.setSkipNextTurn(false);
            return;
        }
        int roll = roller.roll();
        System.out.println(p.getName() + " rolled " + roll);
        int tentative = p.getPosition() + roll;
        if (tentative > board.getSize()) {
            System.out.println(p.getName() + " overshoots and stays at " + p.getPosition());
            return; // overshoot rule: stay in place
        }
        p.setPosition(tentative);
        ruleEngine.applyRules(p, board);
        System.out.println(p.getName() + " moved to " + p.getPosition());
        if (p.getPosition() == board.getSize()) {
            winner = p;
        }
    }

    public boolean hasWinner() {
        return winner != null;
    }
}
