package com.snakesladders;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(100);
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        List<Player> players = Arrays.asList(p1, p2);
        Dice dice = new Dice();
        DefaultRuleEngine engine = new DefaultRuleEngine();

        Game game = new Game(players, board, dice, engine);
        game.start();
    }
}
