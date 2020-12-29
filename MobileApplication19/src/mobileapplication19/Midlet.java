/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication19;

import javax.microedition.midlet.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;

/**
 * @author Adam
 */
public class Midlet extends MIDlet {

    Display ekran;
    PadajacySnieg zamiec = new PadajacySnieg();

    Grawitacja padaSnieg = new Grawitacja();

    Timer timer = new Timer();

    public Midlet() {
        ekran = Display.getDisplay(this);
    }

    protected void destroyApp(boolean unconditional) {
    }

    protected void startApp() {
        ekran.setCurrent(zamiec);

        timer.schedule(padaSnieg, 10, 10);

    }

    protected void pauseApp() {
    }

    public void exit() {
        timer.cancel();

        destroyApp(true);
        notifyDestroyed();
    }

    class Grawitacja extends TimerTask {

        public void run() {
            zamiec.scroll();

        }
    }

    class PadajacySnieg extends Canvas {

        int height;
        int width;
        int z = 0;
        int x2;
        int y2;
        

        int[] snieg;
        int[] pokrywa;
        int[] snieg2;
        int[] pokrywa2;
        Random generator = new Random();
        Random r = new Random();
        int ran;
        int ran2;
        boolean painting = false;
        boolean move;
        boolean move2;

        public PadajacySnieg() {
            height = getHeight();
            width = getWidth();
            snieg = new int[height];
            //zad1
            pokrywa = new int[width];//
            //zad2
            snieg2 = new int[height];
            pokrywa2 = new int[width];//

            for (int i = 0; i < height; ++i) {
                snieg[i] = -1;
            }
            //zad1
            for (int i = 0; i < width; i++) {
                pokrywa[i] = 0;
            }//
            //zad2
            for (int i = 0; i < height; ++i) {
                snieg2[i] = -1;
            }
            for (int i = 0; i < width; i++) {
                pokrywa2[i] = 0;
            }//
        }

        public void scroll() {
            if (painting) {
                return;
            }
            //zad3
            ran = r.nextInt() % 2;//-1, 0 ,1
            

            for (int i = height - 1; i > 0; --i) {

                snieg[i] = snieg[i - 1];
                

            }
            snieg[0] = Math.abs((generator.nextInt() % (2 * width)) / 2);
            

            //zad2
            if (z % 2 == 0) {

                for (int i = height - 1; i > 0; --i) {

                    snieg2[i] = snieg2[i - 1];

                }
            }
            z++;

            snieg2[0] = Math.abs((generator.nextInt() % (2 * width)) / 2);//

            repaint();
        }

        protected void paint(Graphics g) {
            painting = true;
            g.setColor(128, 128, 128);
            g.fillRect(0, 0, width, height);
            g.setColor(255, 255, 255);

            for (int y = 0; y < height; ++y) {

                int x = snieg[y];
                 
                //System.out.println("X "+ x);
                if (x == -1) {
                    continue;
                }
                //zad3
                if(snieg[y] >0&&snieg[y]<width-1){    
                    x+=ran;      
                }//

                //zad 1
                if (y < height - 1 - pokrywa[x]) {
                    g.drawLine(x, y, x, y); 
                } else if (y == height - 1 - pokrywa[x]) {  
                    pokrywa[x]++; 
                }

            }
            for (int i = 0; i < width; i++) {
                g.drawLine(i, height, i, height - pokrywa[i]);//
                //zad4
                for (int j = 0; j < 10; j++) {
                    g.drawLine(i - j, height, i - j, height - pokrywa[i] + j);
                    g.drawLine(i + j, height, i + j, height - pokrywa[i] + j);
                }//
            }

            //zad2
            for (int y2 = 0; y2 < height; ++y2) {

                int x2 = snieg2[y2];

                if (x2 == -1) {
                    continue;
                }
                //zad3
                if(snieg2[y2]>0&&snieg2[y2]<width-1){    
                    x2+=ran;      
                }//
                if (y2 < height - 1 - pokrywa2[x2]) {

                    g.drawLine(x2, y2, x2, y2);
                } else if (y2 == height - 1 - pokrywa2[x2]) {
                    pokrywa2[x2]++;
                }

            }

            for (int i2 = 0; i2 < width; i2++) {
                g.drawLine(i2, height, i2, height - pokrywa2[i2]);
                //zad4
                for (int j2 = 0; j2 < 10; j2++) {
                    g.drawLine(i2 - j2, height, i2 - j2, height - pokrywa[i2] + j2);
                    g.drawLine(i2 + j2, height, i2 + j2, height - pokrywa[i2] + j2);
                }//
            }//

            painting = false;
        }

        protected void keyPressed(int keyCode) {
            exit();
        }
    }
}
