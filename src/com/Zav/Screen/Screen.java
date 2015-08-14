/**
 * Created by Michael Zavarella
 */
package com.Zav.Screen;

import java.awt.*;

public class Screen
{
    private int width, height;
    public int[] pixels;

    int xTime = 0, yTime = 0;
    int counter = 0;

    public Screen (int width, int height)
    {
        this.width = width;
        this.height = height;
        pixels = new int[width * height]; //50,400 elements in the pixels array
    }

    public void clear()
    {
        for (int i = 0; i < pixels.length; i++)
        {
            pixels[i] = 0;
        }
    }

    public void render()
    {
        counter++;
        if (counter % 2 == 0) xTime++;
        if (counter % 20 == 0) yTime++;

        for (int y = 0; y < height; y++)
        {
            if (yTime >= height) break;
            for (int x = 0; x < width; x++)
            {
                if (xTime >= width) break;
                pixels[xTime + yTime * width] = 0xff00ff;
            }
        }
    }
}
