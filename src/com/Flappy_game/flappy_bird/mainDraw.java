package com.Flappy_game.flappy_bird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import  java.awt.Color;
import  java.awt.FlowLayout;
import  java.awt.Frame;
import  java.awt.Graphics;
import  java.awt.event.WindowEvent;
import  java.awt.Dimension;
import java.awt.*;
import java.awt.Window;
import java.awt.event.WindowListener;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class mainDraw extends JComponent
{
    public int p=0;
    public int x = 50;
    public int y = 160;
    public int mxu=200;
    public int myd=320;
    public int mxus=360;
    public int xl=0;
    public int yl=0;
    public boolean over=false;
    public void paintComponent(Graphics g)
    {

        super.paintComponent(g);
        g.drawRect(x, y, 50, 50);
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.RED);
        g.fillRect(mxu, 0, 50, 150+xl);
        g.fillRect(mxu, myd, 50, 320);
        g.fillRect(mxus, 0, 50, 150+yl);
        g.fillRect(mxus, myd, 50, 250);

        if(x>(mxu+xl)-50 && x<(mxu+xl)+50 &&  (y>270 || y<150))
        {
            g.drawString("Game Over!", 260, 190);
            g.drawString(Integer.toString(p)+" points", 260, 210);
            over=true;
        }
        if(x>mxus-50 && x<mxus+50 &&  (y>270 || y<150))
        {
            g.drawString("Game Over!", 260, 190);
            g.drawString(Integer.toString(p)+" points", 260, 210);
            over=true;
        }
    }

    public void movewall()
    {
        if(mxu<=0)
            mxu=450;
        if(mxus<=0)
            mxus=450;
        mxu-=5;
        mxus-=5;
        xl+=5;
        yl+=5;
        if(xl>50 || yl>50)
        {
            xl=yl=0;
        }
    }

    public void moveRight()
    {
        if(!over)
        {
            x = x + 10;
            p+=5;
            repaint();
        }
    }

    public void moveLeft() {
        if(!over)
        {
            x = x - 10;
            p+=5;
            repaint();
        }
    }

    public void moveDown() {

        if(!over)
        {
            y = y + 10;
            p+=5;
            repaint();
        }
    }

    public void moveUp()
    {
        if(!over)
        {
            y = y - 10;
            p+=5;
            repaint();
        }
    }
}
