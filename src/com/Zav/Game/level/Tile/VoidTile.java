package com.Zav.Game.Level.Tile;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Graphics.Sprite;

public class VoidTile extends Tile
{
    public VoidTile(Sprite voidSprite) {super();}

    public void render(int x, int y, Screen screen)
    {
        screen.renderTile(x, y, this);
    }
}
