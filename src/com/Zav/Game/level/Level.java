/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Level;

import com.Zav.Game.Graphics.Screen;

public class Level
{
    protected int width, height;
    protected int[] tiles;

    public Level(int width, int height)
    {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();                                                                                                // Generates a random level
    }

    public Level(String path) { loadLevel(path); }


    protected void generateLevel(){}

    private void loadLevel(String path){}


    public void update(){}

    public void time(){}

    public void render(int xScroll, int yScroll, Screen screen)
    {
        // Setting up the corner pins of the screen! This defines the render region of our screen
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height) >> 4;
    }
}