/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Entity;

import com.Zav.Game.Graphics.Screen;
import com.Zav.Game.Level.Level;

import java.util.Random;

public abstract class Entity
{
    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    public void update()
    {
    }

    public void render(Screen screen)
    {
    }

    public void remove()
    {
        removed = true;
    }

    public boolean isRemoved()
    {
        return removed;
    }


}
