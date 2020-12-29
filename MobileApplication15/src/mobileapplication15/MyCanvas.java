/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication15;
import javax.microedition.lcdui.*;

/**
 *
 * @author Adam
 */
public class MyCanvas extends Canvas implements CommandListener {

    Midlet midlet;
    int xPos;
    int yPos;
    public MyCanvas(Midlet _midlet){
        midlet = _midlet;
        addCommand( new Command("Koniec", Command.EXIT, 0));
        setCommandListener(this);
        xPos= getWidth()/2;
        yPos= getHeight()/2;     
    } 
    protected void paint(Graphics g) {
        g.setColor(0xffffff);
        int screenWidth = getWidth();
        int screenHeight = getHeight();
        g.fillRect(0, 0, screenWidth, screenHeight);
        
        g.setColor(10,10,255);
        
        g.fillRect(xPos, yPos, 32, 32);
        System.out.println("repaint");    
    }
    protected void keyPressed(int keyCode){
        switch(keyCode)
        {
            case KEY_NUM2: --yPos; break;
            case KEY_NUM8: ++yPos; break;
            case KEY_NUM4: --xPos; break;
            case KEY_NUM6: ++xPos; break;
        }
        repaint();
        serviceRepaints();
    }

    public void commandAction(Command c, Displayable d) {
        switch(c.getCommandType()){
        case Command.EXIT:
            midlet.destroyApp(false);
            midlet.notifyDestroyed();
            break;
    }
    }
    
}
