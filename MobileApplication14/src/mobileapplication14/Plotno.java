/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication14;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author Adam
 */
public class Plotno extends Canvas {

    private int R;
    private int G;
    private int B;
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Plotno() {
        R = 0;
        G = 0;
        B = 0;
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;

    }

    protected void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        x1=0;
        x2=this.getWidth();
        y1 = this.getHeight();
        y2 = 0;
        R = 0;
        G = 0;
        B = 255;
        for (int i = 0; i < 10; i++) {
            g.setColor(R, G, B);
            g.drawLine(x1, y1, x2, y2);
            y1 -= this.getHeight() / 10;
            y2 += this.getHeight() / 10;
            R += 25;
            G += 25;
            B -= 5;
        }
        x1 = this.getWidth() / 10;
        x2 = 0;
        y1 = this.getHeight();
        y2 = 0;
        R = 0;
        G = 0;
        B = 255;
        for (int i = 0; i < 10; i++) {
            g.setColor(R, G, B);
            g.drawLine(x1, y1, x2, y2);
            x1 += this.getWidth() / 10;
            y2 += this.getHeight() / 10;
            R += 25;
            G += 25;
            B -= 5;
        }
        x1 = 0;
        x2 = this.getWidth();
        y1 = 0;
        y2 = this.getHeight() / 10;
        R = 0;
        G = 0;
        B = 255;
        for (int i = 0; i < 10; i++) {
            g.setColor(R, G, B);
            g.drawLine(x1, y1, x2, y2);
            x1 += this.getWidth() / 10;
            y2 += this.getHeight() / 10;
            R += 25;
            G += 25;
            B -= 5;
        }

    }

}
