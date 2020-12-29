/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication4;


import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author Adam
 */
public class Midlet extends MIDlet implements CommandListener {

    private Form okno;
    private TextField tf1, tf2, tf3;
    private Ticker komunikat;
    private Command cmdPrzelicz;
    private Command cmdKoniec;
       private StringItem tekst1,tekst2; 
        

    public Midlet() {
        okno = new Form("Wyliczanie pierwiastka");
        tf1 = new TextField("Podaj a:", null, 5,
                TextField.ANY);
        tf2 = new TextField("Podaj b:", null, 5,
                TextField.ANY);
        tf3 = new TextField("Podaj c:", null, 5, TextField.ANY);
        tekst1 = new StringItem("Delta ","");
        tekst2 = new StringItem("Wynik ","");
        komunikat = new Ticker("Wyliczanie równań kwadratowych");


        cmdPrzelicz = new Command("Przelicz",
                Command.ITEM, 0);
        cmdKoniec = new Command("Koniec", Command.ITEM,
                1);
        okno.append(tf1);
        okno.append(tf2);
        okno.append(tf3);
        okno.append(tekst1);
        okno.append(tekst2);
        okno.setTicker(komunikat);
    }

    public void startApp() {
        Display ekran = Display.getDisplay(this);
        ekran.setCurrent(okno);
        okno.addCommand(cmdPrzelicz);
        okno.addCommand(cmdKoniec);
        okno.setCommandListener(this);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command cmd, Displayable s) {
        if (cmd == cmdPrzelicz) {
            try {
                String t1,t2;
                double a = Double.parseDouble(tf1.getString());
                double b = Double.parseDouble(tf2.getString());
                double c = Double.parseDouble(tf3.getString());
                if(a==0){
                    if(b==0)
                        komunikat.setString("Równanie tożsamościowe");
                    else
                         komunikat.setString("Równanie sprzeczne");
                }
                else {
                    double delta;
                    delta = b*b-4*a*c;
                        t1 = String.valueOf(delta);
                        tekst1.setText(t1);
                    if (delta<0){
                        tekst2.setText("Brak rozwiązań");
                    }
                    else
                        if(delta==0){
                            double x;
                            x=-b/(2*a); 
                            t2 = String.valueOf(x);
                            tekst2.setText("X=" +t2);
                            
                        }
                        else {
                                double x1, x2;
                            x1 = (-b - Math.sqrt(delta)) / (2 * a);
                            x2 = (-b + Math.sqrt(delta)) / (2 * a);
                            t1 = String.valueOf(x1);
                            t2 = String.valueOf(x2);
                            
                            tekst2.setText("X1="+t1 +"; X2=" +t2);
                        }
                }


            } catch (NumberFormatException e) //catch (IOException e)
            {
                komunikat.setString("Błąd w podanej wartości");
                e.printStackTrace();
            }
        }

        if (cmd == cmdKoniec) {
            //destroyApp(false);
            notifyDestroyed();
        }

    }
    
}
