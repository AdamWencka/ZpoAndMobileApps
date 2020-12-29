/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication3;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private Form okno;
    private TextField tf1, tf2;
    private Ticker komunikat;
    private Command cmdPrzelicz;
    private Command cmdKoniec;

    public Midlet() {
        okno = new Form("Przeliczanie temperatury");
        tf1 = new TextField(" Celsjusz:", "0", 5,
                TextField.DECIMAL);
        tf2 = new TextField("Fahrenheit:", null, 5,
                TextField.DECIMAL);
        komunikat = new Ticker("Celsjusz => Fahrenheit");
        cmdPrzelicz = new Command("Przelicz",
                Command.ITEM, 0);
        cmdKoniec = new Command("Koniec", Command.ITEM,
                1);
        okno.append(tf1);
        okno.append(tf2);
        okno.setTicker(komunikat);
    }

    public void startApp() {
        Display ekran = Display.getDisplay(this);
        ekran.setCurrent(okno);
        okno.addCommand(cmdPrzelicz);
        okno.addCommand(cmdKoniec);
        okno.setCommandListener(this);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command cmd, Displayable s) {
        if (cmd == cmdPrzelicz) // przeliczenie temperatury
        {
            try {
                double x
                        = Double.parseDouble(tf1.getString());
                double y = 9.0 / 5.0 * x + 32.0;
                Double wynik = new Double(y);
                tf2.setString(wynik.toString());
                komunikat.setString(
                        "PrzeliczanieCelsjusz =  > Fahrenheit");
            } catch (NumberFormatException e) //catch (IOException e)
            {
                komunikat.setString("Błąd wpodanej wartości");
                e.printStackTrace();
            }
        }
        if (cmd == cmdKoniec) // zamkniecie aplikacji
        {
            //destroyApp(false);
            notifyDestroyed();
        }
    }

}
