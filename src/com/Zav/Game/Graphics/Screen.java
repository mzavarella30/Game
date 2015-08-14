/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Graphics;

import java.util.Random;

public class Screen
{
    private int width, height;
    public int[] pixels;

    public final int MAP_SIZE = 64;  // x pixels^2 | If you want to make the tiles bigger or smaller, change this!
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    private Random random = new Random();

    public Screen (int width, int height)
    {
        this.width = width;
        this.height = height;
        pixels = new int[width * height]; //(0, 53999) | 50,400 elements in the pixels array

        for (int i = 0; i < tiles.length; i++)
        {
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }
    }

    public void clear()
    {
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++)
        {
            pixels[i] = 0;
        }
    }

    public void render(int xOff, int yOff)
    {
        for (int y = 0; y < height; y++)
        {
            int yy = y+yOff;
            //if (yy < 0 || yy >= height) break;
            for (int x = 0; x < width; x++)
            {
                int xx = x+xOff;
                int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
                //if (xx < 0 || xx >= width) break;
                pixels[x + y * width] = tiles[tileIndex];
            }
        }
    }
}
