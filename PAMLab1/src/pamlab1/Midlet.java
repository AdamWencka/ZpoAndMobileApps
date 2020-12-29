/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pamlab1;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet {
    
    private Form okno;
    
    public Midlet(){
        okno = new Form("To jest nasz własny MIDlet");
        String tekst = "Witaj";
        okno.append(tekst);


    }

    public void startApp() {
         Display ekran = Display.getDisplay(this);
         ekran.setCurrent(okno);

    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
