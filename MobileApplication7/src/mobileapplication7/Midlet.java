/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication7;

import java.util.Random;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private final Form okno;
    private final TextField tf1;
    int n = 0;
    int p = 0;
    private final StringItem punkty;
    private final StringItem wyraz;
    private final StringItem slowo;
    private final StringItem ostatniaOdp;
    Random RANDOM = new Random();
    String[] slowa = {
        "jabłko", "gruszka", "kajak", "ryba", "wędka", "owca"
    };
    private Command cmdNastepneSlowo;
    private Command cmdTlumacz;
    private Command cmdKoniec;

    public Midlet() {
        okno = new Form("Test");
        punkty = new StringItem("Punkty: ", " ");
        wyraz = new StringItem("Wyraz: ", " ");
        slowo = new StringItem("Slowo: ", " ");
        tf1 = new TextField("Podaj angielskie tłumaczenie słowa ", null, 15, TextField.ANY);
        ostatniaOdp = new StringItem("Ostatnia odpowiedź: ", " ");
        cmdNastepneSlowo = new Command("Następne słowo", Command.ITEM, 2);
        cmdKoniec = new Command("Koniec", Command.ITEM, 0);
        cmdTlumacz = new Command("Tłumacz", Command.ITEM, 1);
        okno.append(punkty);
        okno.append(wyraz);
        okno.append(slowo);
        okno.append(tf1);
        okno.append(ostatniaOdp);
    }

    public void startApp() {
        Display ekran = Display.getDisplay(this);
        ekran.setCurrent(okno);
        okno.addCommand(cmdNastepneSlowo);
        okno.addCommand(cmdKoniec);
        okno.addCommand(cmdTlumacz);
        okno.setCommandListener(this);

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command cmd, Displayable s) {
        if (cmd == cmdNastepneSlowo) {
            String res = slowa[RANDOM.nextInt(slowa.length)];
            slowo.setText(res);
            n++;
            wyraz.setText(String.valueOf(n));

        }
        if (cmd == cmdTlumacz) {
            String y = tf1.getString();
            String res = slowo.getText();
            if (res.equals(slowa[0]) && y.equals("apple")) {
                p++;
                ostatniaOdp.setText("Poprawna");
                punkty.setText(""+p);
            }
            else if (res.equals(slowa[1]) && y.equals("pear")) {
                p++;
                ostatniaOdp.setText("Poprawna");
                punkty.setText(""+p);
            }
            else if (res.equals(slowa[2]) && y.equals("kayak")) {
                p++;
                ostatniaOdp.setText("Poprawna");
                punkty.setText(""+p);
            }
            else if (res.equals(slowa[3]) && y.equals("fish")) {
                p++;
                ostatniaOdp.setText("Poprawna");
                punkty.setText(""+p);
            }
            else if (res.equals(slowa[4]) && y.equals("fishing rod")) {
                p++;
                ostatniaOdp.setText("Poprawna");
                punkty.setText(""+p);
            }
            else if (res.equals(slowa[5]) && y.equals("sheep")) {
                p++;
                ostatniaOdp.setText("Poprawna");
                punkty.setText(""+p);
            }
            else{
                ostatniaOdp.setText("Zła");
            }
            
        }
        if (cmd == cmdKoniec) {
            notifyDestroyed();
        }

    }
}
