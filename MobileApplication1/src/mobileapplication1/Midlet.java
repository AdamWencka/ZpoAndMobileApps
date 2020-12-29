/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication1;

import javax.microedition.lcdui.*;
import java.util.*;
import javax.microedition.midlet.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private Form okno;
    private Command cmdKoniec;
    private static final String[] POWITANIE
            = {"Dzień dobry", "Good morning", "Guten morgen",
                "Bonjour", "Buenos dias"};

    public Midlet() {
        okno = new Form("To jest nasz MIDlet");
        cmdKoniec = new Command("Koniec", Command.EXIT,
                0);
        Random r = new Random(System.currentTimeMillis());
        int liczba = Math.abs(r.nextInt() % 5);
        String tekst = POWITANIE[liczba];
        okno.append(tekst);
    }

    public void startApp() {
        Display ekran = Display.getDisplay(this);
        ekran.setCurrent(okno);
        okno.addCommand(cmdKoniec);
        okno.setCommandListener(this);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command cmd, Displayable s) {
        if (cmd == cmdKoniec) // zamkniecie aplikacji
        {
            //destroyApp(false);
            notifyDestroyed();
        }
    }

}
