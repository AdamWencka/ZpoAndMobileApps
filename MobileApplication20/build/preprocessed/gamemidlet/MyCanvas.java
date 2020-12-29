/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemidlet;

import java.io.IOException;
import java.util.Random;
import javax.microedition.lcdui.*;

public class MyCanvas extends Canvas implements CommandListener{
    
    Midlet midlet;    
    boolean isAlive = false;
    int xPos=0;
    int yPos=0;
    int xMove=0;
    int yMove=0;
   
    Image img[]=new Image[9];
    Image temp;
    public MyCanvas(Midlet _midlet) 
    {
	midlet = _midlet;
        addCommand( new Command( "Losowanie", Command.ITEM, 0 ));
        addCommand( new Command( "Koniec", Command.EXIT, 0 ));
        setCommandListener(this);

        try {
            for (int i=0;i<9;i++)
            img[i]=Image.createImage("/"+i+".png");
    
        } catch (IOException ex) {
           System.out.println("błąd wczytania obrazka");
        }

        HeartBeat t = new HeartBeat();
	isAlive=true;
        t.start();
    }
    
    protected void paint(Graphics g) {
	
	int screenWidth  = getWidth();
	int screenHeight = getHeight();
	g.setColor(0xffffff);	
	g.fillRect(0,0,screenWidth, screenHeight);
	
        int xp=40;
        int yp=70;
        if(img[0]!=null){
        g.drawImage(img[0], xp+0,yp+0,Graphics.TOP|Graphics.LEFT);
        g.drawImage(img[1], xp+55,yp+0,Graphics.TOP|Graphics.LEFT);
        g.drawImage(img[2], xp+110,yp+0,Graphics.TOP|Graphics.LEFT);
        
        g.drawImage(img[3], xp+0,yp+55,Graphics.TOP|Graphics.LEFT);
        g.drawImage(img[4], xp+55,yp+55,Graphics.TOP|Graphics.LEFT);
        g.drawImage(img[5], xp+110,yp+55,Graphics.TOP|Graphics.LEFT);
        
        g.drawImage(img[6], xp+0,yp+110,Graphics.TOP|Graphics.LEFT);
        g.drawImage(img[7], xp+55,yp+110,Graphics.TOP|Graphics.LEFT);
        g.drawImage(img[8], xp+110,yp+110,Graphics.TOP|Graphics.LEFT);
        
        }
    }
    
    protected void keyPressed(int keyCode)
    {
	int gameAction = getGameAction(keyCode);
	
	switch(gameAction)
	{
	    case UP:    yMove=-1; break;
	    case DOWN:  yMove=+1; break;
	    case LEFT:  xMove=-1; break;
	    case RIGHT: xMove=+1; break;
	}
    }
    
    protected void keyReleased(int keyCode)
    {
	int gameAction = getGameAction(keyCode);
	
	switch(gameAction)
	{
	    case UP:   case DOWN:  yMove=0; break;
	    case LEFT: case RIGHT: xMove=0; break;
	}
    }
    protected void losowanie()
    {        Random r = new Random();
        for (int i=1;i<50;i++){
         xMove=-1; if (r.nextInt(2)==1) xMove=1;
         yMove=-1; if (r.nextInt(2)==1) yMove=1;
         try {
            Thread.sleep(i*2);
                } catch (Exception ex) {}
         update();
     
        }
    }
    
    protected void update()
    {
	int oldxPos=xPos;
        int oldyPos=yPos;
        
        xPos+=xMove;
	yPos+=yMove;
	
        if (xPos>=2) xPos=2; if (xPos<=0) xPos=0;
        if (yPos>=2) yPos=2; if (yPos<=0) yPos=0;
        temp=img[yPos*3+xPos];
        img[yPos*3+xPos]=img[oldyPos*3+oldxPos];
        img[oldyPos*3+oldxPos]=temp;
	repaint();
	serviceRepaints();
    }
    
    
    public void commandAction(Command c, Displayable d)
    {
        switch( c.getCommandType() ) {
            case Command.EXIT:
	    isAlive	= false;
	    midlet.destroyApp( false );
	    midlet.notifyDestroyed();
	    losowanie();
            break;
            case Command.ITEM:
            losowanie();
            break;    
        }
    }
    
    private class HeartBeat extends Thread 
    {    
        public void run() {            
	    while(isAlive==true)
	    {
		try 
		{
		    sleep(100);
		    update();
		}
		catch(Exception e)
		{
		    isAlive = false;
		    System.out.println("Exception on update thread");
		}
	    }
	    System.out.println("Leaving update thread!");
        }
    }
}    