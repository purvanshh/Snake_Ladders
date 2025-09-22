package com.snakesladders;

public class Snake extends SpecialTile {
    public Snake(int headIndex, int tailIndex) {
        super(headIndex, tailIndex);
        if (tailIndex >= headIndex) throw new IllegalArgumentException("Snake tail must be lower than head");
    }

    @Override
    public String toString() {
        return "Snake(" + index + "->" + endIndex + ")";
    }
}
