package com.snakesladders;

public class Player {
    private final String name;
    private int position;
    private boolean skipNextTurn;

    public Player(String name) {
        this.name = name;
        this.position = 1; // start at tile 1
        this.skipNextTurn = false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int steps) {
        this.position += steps;
    }

    public boolean isSkipNextTurn() {
        return skipNextTurn;
    }

    public void setSkipNextTurn(boolean skipNextTurn) {
        this.skipNextTurn = skipNextTurn;
    }

    @Override
    public String toString() {
        return name + "(" + position + ")";
    }
}
