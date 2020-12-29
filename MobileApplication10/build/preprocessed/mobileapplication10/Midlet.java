/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication10;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private Plotno plotno;
    private Command cmd;
    private Command cmdPowtorz;
    private Display ekran;

    public Midlet() {
        plotno = new Plotno();
        cmd = new Command("Koniec", Command.EXIT, 1);
        cmdPowtorz = new Command("Powtórz", Command.EXIT, 0);
        plotno.addCommand(cmd);
        plotno.addCommand(cmdPowtorz);
        plotno.setCommandListener(this);
    }

    public void startApp() {
        ekran = Display.getDisplay(this);
        ekran.setCurrent(plotno);

    }

    public void pauseApp() {
    }


    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdPowtorz) {
            
                plotno.repaint();
                plotno.serviceRepaints();

            

        }
        if (c == cmd) {
            notifyDestroyed();
        }
    }
}
