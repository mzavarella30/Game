/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Level.Tile;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Graphics.Sprite;

public class Tile
{
    public int x, y;
    public Sprite sprite;

    public Tile(Sprite sprite)
    {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen){}

    public boolean solid()
    {
        return false;
    }
}