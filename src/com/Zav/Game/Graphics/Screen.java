/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Graphics;

import java.util.Random;

public class Screen
{
    private int width, height;
    public int[] pixels;

    public final int MAP_SIZE = 64;                                                                                     // x pixels^2 | If you want to make the tiles bigger or smaller, change this!
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];


    public Screen (int width, int height)
    {
        Random random = new Random();
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
}
