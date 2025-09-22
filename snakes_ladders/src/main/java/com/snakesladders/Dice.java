package com.snakesladders;

import java.util.Random;

public class Dice implements IRollable {
    private final int sides;
    private final Random random;

    public Dice(int sides) {
        if (sides < 2) throw new IllegalArgumentException("Dice must have at least 2 sides");
        this.sides = sides;
        this.random = new Random();
    }

    public Dice() {
        this(6);
    }

    @Override
    public int roll() {
        return random.nextInt(sides) + 1;
    }

    public int getSides() {
        return sides;
    }
}
