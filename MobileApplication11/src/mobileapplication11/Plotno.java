/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication11;

import javax.microedition.lcdui.*;

/**
 *
 * @author Adam
 */
public class Plotno extends Canvas {
    int yl= 20;
    int xr;
    int xt;
    int xa;
    int xo;
    int r =3;
    int ang=60;
    public Plotno() {
    }
    protected void paint(Graphics g) {
        g.setColor(0,0,255);    
        for(int j = 0;j<5;j++){      
        g.drawLine(this.getWidth()/2 -5, this.getHeight()/2 +yl, this.getWidth()/2 + 10, this.getHeight()/2 +yl);
        yl-=4;
        }
        g.setColor(0,255,0);    
        for(int j = 0;j<5;j++){      
        g.fillRect(this.getWidth()/2 +xr, this.getHeight()/2 - 50, 5, 5);
        xr+=10;              
        }
        g.setColor(255,0,0);
        for(int j = 0;j<5;j++){      
        g.fillTriangle(this.getWidth()/2 -10+ xt, this.getHeight()/2 +60, this.getWidth()/2 -5+xt, this.getHeight()/2+60,
                this.getWidth()/2 +xt, this.getHeight()/2+40);
        xt+=10;              
        }
        g.setColor(255,255,255);
        for(int j = 0;j<5;j++){ 
        g.drawArc(this.getWidth()/2 -40+ xa, this.getHeight()/2 -60, r, r, 0, 360);
        r+=2;
        xa+=5;              
        }
        g.setColor(255,255,255);
        r=5;
        for(int j = 0;j<5;j++){ 
        g.fillArc(this.getWidth()/2 -40+ xo, this.getHeight()/2 -100, r, r, 0, ang);
        r+=2;
        xo+=15;
        ang+=60;
        }
    }
    protected void keyPressed(int kod){
        this.repaint();
        serviceRepaints();
    }


}
