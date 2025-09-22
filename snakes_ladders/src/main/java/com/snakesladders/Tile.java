package com.snakesladders;

public abstract class Tile {
    protected final int index;

    public Tile(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public boolean isSpecial() { return false; }
}
