package gamemidlet;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

public class Midlet extends MIDlet {

    public void startApp() {
         Display.getDisplay(this).setCurrent(new MyCanvas(this));
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
