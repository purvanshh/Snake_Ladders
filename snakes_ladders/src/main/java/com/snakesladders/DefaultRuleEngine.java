package com.snakesladders;

public class DefaultRuleEngine implements IRuleEngine {
    @Override
    public void applyRules(Player player, Board board) {
        int pos = player.getPosition();
        Tile t = board.getTile(pos);
        if (t == null) return;
        if (t.isSpecial()) {
            SpecialTile st = (SpecialTile) t;
            player.setPosition(st.getEndIndex());
        }
    }
}
