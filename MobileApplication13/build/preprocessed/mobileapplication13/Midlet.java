/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication13;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private final Form okno;
    private final TextField tf1;
    public static final int errors = 9;
    String word = "student";
    private int nbErrors;
    private final StringItem szukane;
    private final StringItem litery;
    char[] filler;
    private final Vector letters = new Vector();
    private final Command cmdNastepnaGra;
    private final Command cmdNastepne;
    private final Command cmdKoniec;
    ImageItem it;
    Image img;

    public Midlet() {
        okno = new Form("Wisielec ver.1.5");

        szukane = new StringItem("Szukane słowo: ", " ");
        tf1 = new TextField("Podaj literę ", null, 1, TextField.ANY);
        litery = new StringItem("Litery: ", " ");

        cmdNastepne = new Command("Następna próba", Command.ITEM, 2);
        cmdKoniec = new Command("Koniec", Command.ITEM, 0);
        cmdNastepnaGra = new Command("Następna gra", Command.ITEM, 1);
        okno.append(szukane);
        okno.append(tf1);
        okno.append(litery);
        try {
            img = Image.createImage("/wisielec0.png");
            it = new ImageItem(null, img, ImageItem.LAYOUT_BOTTOM | ImageItem.LAYOUT_NEWLINE_AFTER | ImageItem.LAYOUT_CENTER, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        okno.append(it);

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
            try {
                img = Image.createImage("/wisielec0.png");
                it.setImage(img);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
                    if (nbErrors == 1) {
                        try {
                            img = Image.createImage("/wisielec1.png");
                            it.setImage(img);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (nbErrors == 2) {
                        try {
                            img = Image.createImage("/wisielec2.png");
                            it.setImage(img);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (nbErrors == 3) {
                        try {
                            img = Image.createImage("/wisielec3.png");
                            it.setImage(img);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (nbErrors == 4) {
                        try {
                            img = Image.createImage("/wisielec4.png");
                            it.setImage(img);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (nbErrors == 5) {
                        try {
                            img = Image.createImage("/wisielec5.png");
                            it.setImage(img);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (nbErrors == 6) {
                        try {
                            img = Image.createImage("/wisielec6.png");
                            it.setImage(img);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (nbErrors == 7) {
                        try {
                            img = Image.createImage("/wisielec7.png");
                            it.setImage(img);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (nbErrors == 8) {
                        try {
                            img = Image.createImage("/wisielec8.png");
                            it.setImage(img);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                String string = new String(filler);
                szukane.setText(string);
                if (word.equals(string)) {

                }
            }
            if (nbErrors == errors) {
                szukane.setText(word);
                try {
                    img = Image.createImage("/wisielec9.png");
                    it.setImage(img);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
        if (cmd == cmdKoniec) {
            notifyDestroyed();
        }

    }

}
