/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication9;
import javax.microedition.lcdui.*;
/**
 *
 * @author Adam
 */
public class Plotno  extends Canvas {

    String napis;
    String napis2;
    String napis3;
    public Plotno(){
        napis = "Grafika";
        napis2 = "Programowanie urządzeń mobilnych";
        napis3 = "Użyj klawiszy 4,8,6,2";
    }
    protected void paint(Graphics g) {
        g.setColor(0,0,255);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(255,0,0);
        g.drawArc(0,0,this.getWidth()-1,this.getHeight()-1,0,360);
        g.setColor(255, 255, 0);
        g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        g.drawString(napis, this.getWidth()/2, this.getHeight()/2,Graphics.BASELINE | Graphics.HCENTER);
        g.drawString(napis2, this.getWidth()/2, (this.getHeight()/2)-15,Graphics.BASELINE | Graphics.HCENTER);
        g.setColor(255, 255, 255);
        g.drawString(napis3, this.getWidth()/2, (this.getHeight()/2)+15,Graphics.BASELINE | Graphics.HCENTER);
    }
    protected void keyPressed(int kod){
        switch(kod){
            case KEY_NUM2: napis = "góra"; break;
            case KEY_NUM8: napis = "dół"; break;
            case KEY_NUM4: napis = "lewo"; break;
            case KEY_NUM6: napis = "prawo"; break;
        }
        this.repaint();
        serviceRepaints();
    }
    
    
}
