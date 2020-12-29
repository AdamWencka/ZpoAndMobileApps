/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication14;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet {

    private Plotno plotno;
    
    private Display ekran;
    
    public Midlet(){
        plotno = new Plotno();
        
    }

    public void startApp() {
        ekran = Display.getDisplay(this); 
        ekran.setCurrent(plotno);
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

}
