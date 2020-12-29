/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication2;

import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private TextBox tb;
    private Command cmdKoniec;

    public Midlet() {
        tb = new TextBox("Programowanie Java ME", "Tekst"
                + " do edycji", 50, 0); // tytuł, text, maxsize znaków, ograniczenia
        cmdKoniec = new Command("Koniec", Command.EXIT, 0);
    }

    public void startApp() {

        Display ekran = Display.getDisplay(this);
        ekran.setCurrent(tb);
        tb.addCommand(cmdKoniec);
        tb.setCommandListener(this);

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
