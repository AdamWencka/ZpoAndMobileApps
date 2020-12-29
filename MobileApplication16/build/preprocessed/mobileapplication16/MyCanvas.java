/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication16;

import javax.microedition.lcdui.*;

/**
 *
 * @author Adam
 */
public class MyCanvas extends Canvas implements CommandListener {

    Midlet midlet;
    int xPos;
    int yPos;
    int R;
    int G;
    int B;

    public MyCanvas(Midlet _midlet) {
        R = 10;
        G = 10;
        B = 255;
        midlet = _midlet;
        addCommand(new Command("Koniec", Command.EXIT, 0));
        setCommandListener(this);
        xPos = getWidth() / 2;
        yPos = getHeight() / 2;
    }

    protected void paint(Graphics g) {
        g.setColor(0xffffff);
        int screenWidth = getWidth();
        int screenHeight = getHeight();
        g.fillRect(0, 0, screenWidth, screenHeight);

        
        g.setColor(R, G, B);
        g.fillRect(xPos, yPos, 32, 32);
        
    }

    protected void keyRepeated(int keyCode) {
        
        switch (keyCode) {
            case KEY_NUM2:
                R = 255;
                G = 0;
                B = 0;
                --yPos;
                        repaint();
        serviceRepaints();
                break;
            case KEY_NUM8:
                R = 0;
                G = 255;
                B = 0;
                ++yPos;
                        repaint();
        serviceRepaints();
                break;
            case KEY_NUM4:
                R = 0;
                G = 0;
                B = 255;
                --xPos;
                        repaint();
        serviceRepaints();
                break;
            case KEY_NUM6:
                R = 0;
                G = 0;
                B = 0;
                ++xPos;
                        repaint();
        serviceRepaints();
                break;
        }

    }

    public void commandAction(Command c, Displayable d) {
        switch (c.getCommandType()) {
            case Command.EXIT:
                midlet.destroyApp(false);
                midlet.notifyDestroyed();
                break;
        }
    }
}
