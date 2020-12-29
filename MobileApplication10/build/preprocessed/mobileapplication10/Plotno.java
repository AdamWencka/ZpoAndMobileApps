/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication10;


import java.util.Random;
import javax.microedition.lcdui.*;

/**
 *
 * @author Adam
 */
public class Plotno extends Canvas {
    Random random = new Random();
    String napis;
    String time;
    
    long millis;
    long millis2;

    public Plotno() {
        
        napis = "Czas rysowania: ";
    }

    protected void paint(Graphics g) {
        
        millis =System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
        int R = random.nextInt(255);
        int G = random.nextInt(255);
        int B = random.nextInt(255);
        g.setColor(R, G, B);
        g.fillTriangle(random.nextInt(this.getWidth()), random.nextInt(this.getHeight()), random.nextInt(this.getWidth()), random.nextInt(this.getHeight()), random.nextInt(this.getWidth()), random.nextInt(this.getHeight()));
        }
        g.setColor(0,0,255);
        g.fillRect(this.getWidth()/5,this.getHeight()/6, 150, 25);
        g.setColor(0,0,0);
        millis2=System.currentTimeMillis()-millis;
        time = String.valueOf(millis2);
        napis = "Czas rysowania: "+ time +"ms";
        g.drawString(napis, this.getWidth()/2 , this.getHeight()/5 + 6, Graphics.BASELINE | Graphics.HCENTER);
    }



}
