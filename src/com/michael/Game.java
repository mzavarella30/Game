package com.michael;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1L;

    public static int width = 300;
    public static int height = width/16 * 9;
    public static int scale = 3;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    // Game constructor
    // All of this code runs whenever a new Game is created!
    public Game() {
        Dimension size = new Dimension(width*scale, height*scale);
        setPreferredSize(size);

        frame = new JFrame();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop()
    {
        running = false;
        try {
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (running) {
            update();
            render();
        }
    }

    public void update() {}

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
    }

    // Entry point of the program. Genesis. Inception. Life!
    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);                                                                                 // Having a resizable window creates a ton of problems
        game.frame.setTitle("Game");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                      // Closes the window
        game.frame.setLocationRelativeTo(null);                                                                         // Centers the window on the screen
        game.frame.setVisible(true);

        game.start();                                                                                                   // Starts the game
    }

}
