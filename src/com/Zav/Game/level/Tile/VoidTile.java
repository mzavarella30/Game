/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Level.Tile;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Graphics.Sprite;

public class VoidTile extends Tile {
    public VoidTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
