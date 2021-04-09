package com.Flappy_game.flappy_bird;

import java.awt.*;
import  java.util.concurrent.ExecutorService;
import  java.util.concurrent.Executors;
import  java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.lang.Thread;

public class mainFrame extends JFrame implements KeyListener
{
    private mainDraw draw;
    public void keyPressed(KeyEvent e)
    {
        System.out.println(" keyPressed!\n ");
        System.out.print("\nx: "+draw.x+" y: "+draw.y+"\n first wall position: "+draw.mxu+" secons wall position: "+draw.mxus+"\n");

    }

    public void keyReleased(KeyEvent e)
    {
        int c=e.getKeyCode();
        switch(c)
        {
            case KeyEvent.VK_RIGHT:{
                draw.moveRight();
                draw.movewall();
            };break;
            case KeyEvent.VK_LEFT: {
                draw.moveLeft();
                draw.movewall();
            };break;
            case KeyEvent.VK_DOWN:
            {
                draw.moveDown();
                draw.movewall();
            };break;
            case KeyEvent.VK_UP:
            {
                draw.moveUp();
                draw.movewall();
            };break;
        }
    }
    public void keyTyped(KeyEvent e) {
        System.out.println("Press the direction arrows!");
    }

    public mainFrame()
    {

        this.draw=new mainDraw();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    public static void main(String[] args)
    {

        mainFrame frame = new mainFrame();
        frame.setTitle("Good luck!");
        frame.setResizable(false);
        frame.setSize(600, 600);
        frame.setMinimumSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(frame.draw);
        frame.pack();
        frame.setVisible(true);

    }
}
