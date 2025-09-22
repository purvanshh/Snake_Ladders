package com.snakesladders;

public abstract class SpecialTile extends Tile {
    protected final int endIndex;

    public SpecialTile(int index, int endIndex) {
        super(index);
        this.endIndex = endIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    @Override
    public boolean isSpecial() { return true; }
}
