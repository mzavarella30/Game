/**
 * Created by Michael Zavarella
 */
package com.Zav.Game.Entity.Mob;

import com.Zav.Game.Entity.Entity;
import com.Zav.Game.Graphics.Sprite;

public abstract class Mob extends Entity {
    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move() {
    }

    public void update() {
    }

    private boolean collision() {
        return false;
    }

    public void render() {

    }
}
