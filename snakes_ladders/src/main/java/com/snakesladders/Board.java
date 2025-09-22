package com.snakesladders;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Tile> tiles;
    private final int size;

    public Board(int size) {
        if (size < 10) throw new IllegalArgumentException("Board size must be at least 10");
        this.size = size;
        this.tiles = new ArrayList<>(size + 1); // 1-based indexing
        setupBoard();
    }

    private void setupBoard() {
        tiles.clear();
        tiles.add(null); // index 0 unused
        for (int i = 1; i <= size; i++) {
            tiles.add(new NormalTile(i));
        }
        // default snakes and ladders - small preset
        addSpecial(new Ladder(2, 38));
        addSpecial(new Ladder(7, 14));
        addSpecial(new Ladder(8, 31));
        addSpecial(new Ladder(15, 26));
        addSpecial(new Ladder(21, 42));
        addSpecial(new Ladder(28, 84));
        addSpecial(new Ladder(36, 44));

        addSpecial(new Snake(16, 6));
        addSpecial(new Snake(46, 25));
        addSpecial(new Snake(49, 11));
        addSpecial(new Snake(62, 19));
        addSpecial(new Snake(64, 60));
        addSpecial(new Snake(74, 53));
        addSpecial(new Snake(89, 68));
        addSpecial(new Snake(92, 88));
    }

    private void addSpecial(SpecialTile st) {
        if (st.getIndex() < 1 || st.getIndex() > size) return;
        tiles.set(st.getIndex(), st);
    }

    public Tile getTile(int index) {
        if (index < 1 || index > size) return null;
        return tiles.get(index);
    }

    public int getSize() {
        return size;
    }
}
