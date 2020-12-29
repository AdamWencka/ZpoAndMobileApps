/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication12;
import javax.microedition.lcdui.*;

/**
 *
 * @author Adam
 */
public class Plotno extends Canvas {
    
    String napis;
    public Plotno() {
            napis = "Rio De Janeiro 2016";
    }

    protected void paint(Graphics g) {
        g.setColor(255,255,255);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(0,0,255);
        g.drawString(napis, this.getWidth()/2, this.getHeight()/2,Graphics.BASELINE | Graphics.HCENTER);
        g.setColor(0,0,0);
        g.drawArc(this.getWidth()/2 -20, this.getHeight()/2 - 70, 30, 30, 0, 360);
        g.setColor(0,0,255);
        g.drawArc(this.getWidth()/2 -40, this.getHeight()/2 - 70, 30, 30, 0, 360);
        g.setColor(255,0,0);
        g.drawArc(this.getWidth()/2 , this.getHeight()/2 - 70, 30, 30, 0, 360);
        g.setColor(0,255,0);
        g.drawArc(this.getWidth()/2 -10, this.getHeight()/2 - 50, 30, 30, 0, 360);
        g.setColor(255,255,0);
        g.drawArc(this.getWidth()/2 -30, this.getHeight()/2 - 50, 30, 30, 0, 360);
    }
    protected void keyPressed(int kod){
        this.repaint();
        serviceRepaints();
    }


}