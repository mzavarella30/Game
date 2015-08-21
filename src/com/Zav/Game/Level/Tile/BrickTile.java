package com.Zav.Game.Level.Tile;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Graphics.Sprite;

public class BrickTile extends Tile {
    public BrickTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

    public boolean solid() {
        return true;
    }
}
