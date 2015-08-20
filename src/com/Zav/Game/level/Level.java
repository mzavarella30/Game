/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Level;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Level.Tile.Tile;

public class Level {
    protected int width, height;
    protected int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();                                                                                                // Generates a random level
    }

    public Level(String path) {
        loadLevel(path);
    }


    protected void generateLevel() {
    }

    private void loadLevel(String path) {
    }


    public void update() {
    }

    public void time() {
    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        // Setting up the corner pins of the screen! This defines the render region of our screen
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x << 4, y << 4, screen);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        if (tiles[x + y * width] == 0) return Tile.grass;
        if (tiles[x + y * width] == 1) return Tile.flower;
        if (tiles[x + y * width] == 2) return Tile.rock;
        return Tile.voidTile;

    }
}