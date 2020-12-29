/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication16;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet {

    public void startApp() {
        Display.getDisplay(this).setCurrent(new MyCanvas(this));
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
