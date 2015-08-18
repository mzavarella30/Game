/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Graphics;

import com.Zav.Game.Level.Tile.Tile;

import java.util.Random;

public class Screen
{
    public int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 64;                                                                                     // x pixels^2 | If you want to make the tiles bigger or smaller, change this!
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    public int xOffset, yOffset;

    public Random random = new Random();

    public Screen (int width, int height)
    {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];                                                                               //(0, 53999) | 50,400 elements in the pixels array

        for (int i = 0; i < tiles.length; i++)
        {
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }
    }

    public void clear()
    {
        for (int i = 0; i < pixels.length; i++)
        {
            pixels[i] = 0;
        }
    }

    public void render(int xOffset, int yOffset)
    {
        for (int y = 0; y < height; y++)
        {
            int yp = y + yOffset;
            if (yp < 0 || yp >= height) continue;
            for (int x = 0; x < width; x++)
            {
                int xp = x + xOffset;
                if (xp < 0 || xp >= width) continue;
                pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
            }
        }
    }

    public void renderTile(int xp, int yp, Tile tile)
    {
        xp -= xOffset;
        yp -= yOffset;
        int sSize = tile.sprite.SIZE;
        for(int y = 0; y < sSize; y++)
        {
            int ya = y + yp;
            for(int x = 0; x < sSize; x++)
            {
                int xa = x + xp;
                if (xa < 0 || xa >= width || ya < 0 || ya >= width) break;                                              // Stop rendering tiles that aren't on the screen
                pixels[xa+ya*width] = tile.sprite.pixels[x+y+sSize];
            }
        }
    }

    public void setOffset(int xOffset, int yOffset)
    {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
