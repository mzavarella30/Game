/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Graphics;

import com.Zav.Game.Entity.Mob.Player;
import com.Zav.Game.Level.Tile.Tile;

import java.util.Random;

public class Screen {
    public int width, height;
    public int[] pixels;

    public final int MAP_SIZE = 64;                                                                                     // x pixels^2 | If you want to make the tiles bigger or smaller, change this!
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    public int xOffset, yOffset;

    public Screen(int width, int height) {
        Random random = new Random();
        this.width = width;
        this.height = height;
        pixels = new int[width * height];                                                                               //(0, 53999) | 50,400 elements in the pixels array

        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = random.nextInt(0xffffff);
            tiles[0] = 0;
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderTile(int xp, int yp, Tile tile) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xa = x + xp;
                if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void renderPlayer(int xp, int yp, Sprite sprite) {
        xp -= xOffset;
        yp -= yOffset;
        int playerSize = sprite.SIZE;
        for (int y = 0; y < playerSize; y++) {
            int ya = y + yp;
            for (int x = 0; x < playerSize; x++) {
                int xa = x + xp;
                if (xa < -playerSize || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                int col = sprite.pixels[x + y * playerSize];
                if (col != 0xFFFF00FF) pixels[xa + ya * width] = col;
            }
        }
    }


    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
