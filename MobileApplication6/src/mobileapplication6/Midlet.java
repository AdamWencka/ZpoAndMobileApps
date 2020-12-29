/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication6;

import java.util.Random;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private Form okno;
    private TextField tf1;
    int n = 0;
    Random r = new Random();
    int num = Math.abs(r.nextInt(50));
    private StringItem result;

    private Command cmdZgadnij;
    private Command cmdKoniec;

    public Midlet() {
        okno = new Form("Zgadywanka");
        result = new StringItem("Wynik: "," ");
        tf1 = new TextField("Odgadnij liczbę od 1 do 50 ", null, 2, TextField.ANY);
        cmdZgadnij = new Command("Zgadnij", Command.ITEM, 0);
        cmdKoniec = new Command("Koniec", Command.ITEM, 1);
        okno.append(tf1);
        okno.append(result);

    }

    public void startApp() {
        Display ekran = Display.getDisplay(this);
        ekran.setCurrent(okno);
        okno.addCommand(cmdZgadnij);
        okno.addCommand(cmdKoniec);
        okno.setCommandListener(this);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command cmd, Displayable s) {
        if (cmd == cmdZgadnij) {  
            int x = Integer.parseInt(tf1.getString());
            if (x == num){
                n += 1;
                result.setText("Brawo. Odgadłeś liczbę w " + n +" ruchach");
            }
            else if (x < num){
                n += 1;
                result.setText("Za mała");
            }
            else if( x>num){
                n += 1;
                result.setText("Za duża");
            }
        }
        if (cmd == cmdKoniec) {
            //destroyApp(false);
            notifyDestroyed();
        }

    }

}
