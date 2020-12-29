/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication5;

import java.util.Random;
import java.util.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {
    
    private Form okno;
    int sum;
    private StringItem t1, t2, t3, t4, t5;
    private Command cmdJeszczeRaz;
    private Command cmdKoniec;
    
    public Midlet() {
        okno = new Form("Losowe wypełnienie tablicy");
        t1 = new StringItem("Tablica: ", "");
        t2 = new StringItem("Minimalna: ", "");
        t3 = new StringItem("Maksymalna: ", "");
        t4 = new StringItem("Suma: ", "");
        t5 = new StringItem("Średnia: ", "");
        cmdJeszczeRaz = new Command("Jeszcze raz", Command.ITEM, 1);
        cmdKoniec = new Command("Koniec", Command.ITEM, 0);
        okno.append(t1);
        okno.append(t2);
        okno.append(t3);
        okno.append(t4);
        okno.append(t5);
        
    }
    
    public void startApp() {
        Display ekran = Display.getDisplay(this);
        ekran.setCurrent(okno);
        okno.addCommand(cmdJeszczeRaz);
        okno.addCommand(cmdKoniec);
        okno.setCommandListener(this);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    public void commandAction(Command cmd, Displayable s) {
        if (cmd == cmdJeszczeRaz) {
            String mint = null;
            String maxt = null;
            String tablica = "";
            String suma = null;
            String srednia = null;
            int[] tab = new int[10];
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                tab[i] = Math.abs(r.nextInt(50));
                tablica += String.valueOf(tab[i]) + ";";
            }
            t1.setText(tablica);
            int min = tab[0];
            int max = tab[0];
            for (int j = 1; j < tab.length; j++) {
                if (tab[j] > max) {
                    max = tab[j];
                    maxt = String.valueOf(max);
                }
            }
            for (int j = 1; j < tab.length; j++) {
                if (tab[j] < min) {
                    min = tab[j];
                    mint = String.valueOf(min);
                }
            }
            t2.setText(mint);
            t3.setText(maxt);            
            sum = 0;
            double avg = 0;
            for (int i = 0; i < tab.length; i++) {
                sum += tab[i];
                avg = 1.0d * sum / tab.length;
                suma = String.valueOf(sum);
                srednia = String.valueOf(avg);
            }
            t4.setText(suma);
            t5.setText(srednia);      
        }
        if (cmd == cmdKoniec) {
            notifyDestroyed();
        }   
    }
}
