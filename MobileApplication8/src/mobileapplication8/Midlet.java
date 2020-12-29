/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication8;

import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private final Form okno;
    private final TextField tf1;
    public static final int errors = 8;
    String word = "student";
    private int nbErrors;
    private final StringItem proba;
    private final StringItem szukane;
    private final StringItem litery;
    private final StringItem ilProb;
    char[] filler;
    private final Vector letters = new Vector();
    private final Command cmdNastepnaGra;
    private final Command cmdNastepne;
    private final Command cmdKoniec;

    public Midlet() {
        okno = new Form("Wisielec ver.1.0");
        proba = new StringItem("Próba: ", " ");
        szukane = new StringItem("Szukane słowo: ", " ");
        litery = new StringItem("Litery: ", " ");
        tf1 = new TextField("Podaj literę ", null, 1, TextField.ANY);
        ilProb = new StringItem("Pozostało prób: ", " ");
        cmdNastepne = new Command("Następna próba", Command.ITEM, 2);
        cmdKoniec = new Command("Koniec", Command.ITEM, 0);
        cmdNastepnaGra = new Command("Następna gra", Command.ITEM, 1);
        okno.append(proba);
        okno.append(szukane);

        okno.append(tf1);
        okno.append(litery);
        okno.append(ilProb);
    }

    public void startApp() {
        Display ekran = Display.getDisplay(this);
        ekran.setCurrent(okno);
        okno.addCommand(cmdNastepne);
        okno.addCommand(cmdKoniec);
        okno.addCommand(cmdNastepnaGra);
        okno.setCommandListener(this);

    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command cmd, Displayable s) {
        if (cmd == cmdNastepnaGra) {
            proba.setText(String.valueOf(nbErrors));
            ilProb.setText(String.valueOf(errors - nbErrors));
            filler = new char[word.length()];
            int i = 0;
            while (i < word.length()) {
                filler[i] = '-';
                if (word.charAt(i) == ' ') {
                    filler[i] = ' ';
                }
                i++;
            }
            String string = new String(filler);
            szukane.setText(string);
        }
        if (cmd == cmdNastepne) {
            String str = tf1.getString();
            litery.setText(str);
            char a = str.charAt(0);
            if (nbErrors < errors) {
                letters.addElement(str);
                String r = letters.toString();
                litery.setText(r);
                if (word.indexOf(str) >= 0) {
                    for (int y = 0; y < word.length(); y++) {
                        if (word.charAt(y) == a) {
                            filler[y] = a;
                        }
                    }
                } else {
                    nbErrors++;
                    ilProb.setText(String.valueOf(errors - nbErrors));
                    proba.setText(String.valueOf(nbErrors));
                }
                String string = new String(filler);
                szukane.setText(string);
                if (word.equals(string)) {
                    proba.setText(String.valueOf(nbErrors));
                    ilProb.setText("Wygrałeś");
                }
            }
            if (nbErrors == errors) {
                proba.setText(String.valueOf(nbErrors));
                ilProb.setText("Przegrałeś");
                szukane.setText(word);
            }
        }
        if (cmd == cmdKoniec) {
            notifyDestroyed();
        }

    }

}
