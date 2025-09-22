package com.snakesladders;

public class Ladder extends SpecialTile {
    public Ladder(int bottomIndex, int topIndex) {
        super(bottomIndex, topIndex);
        if (topIndex <= bottomIndex) throw new IllegalArgumentException("Ladder top must be higher than bottom");
    }

    @Override
    public String toString() {
        return "Ladder(" + index + "->" + endIndex + ")";
    }
}
