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
    boolean start;
    int move=0;
    boolean finished;
    boolean end;
    long timeStart;
    long timeEnd;
    long timeLimit;
    
   
    Image img[]=new Image[9];
    Image temp;
    public MyCanvas(Midlet _midlet) 
    {
	midlet = _midlet;
        addCommand( new Command( "Losowanie", Command.ITEM, 0 ));
        addCommand( new Command( "Koniec", Command.EXIT, 0 ));
        setCommandListener(this);
        try {
            for (int i=0;i<9;i++){
            img[i]=Image.createImage("/"+i+".png");
            
            }
            //zad8
            /*for (int i=0;i<9;i++){
            img[i]=Image.createImage("/"+i+"m.png");
            
            }*/
        } catch (IOException ex) {
           System.out.println("błąd wczytania obrazka");
        }
        start =false;
        finished=false;
        end = false;
        timeLimit=120000;
        HeartBeat t = new HeartBeat();
	isAlive=true;
        t.start(); 
    }
    
    protected void paint(Graphics g) {    
	int screenWidth  = getWidth();
	int screenHeight = getHeight();
	g.setColor(0xffffff);	
	g.fillRect(0,0,screenWidth, screenHeight);
        //zad1
        if(!start){
            g.setColor(0,0,255);
            g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE));
            g.drawString("Układanka", screenWidth/2, screenHeight/3, Graphics.TOP|Graphics.HCENTER);
            g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
            g.drawString("By rozpocząć grę wciśnij losowanie", screenWidth/2, screenHeight/2, Graphics.TOP|Graphics.HCENTER);
        }
        if(start){
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
        g.setColor(0,0,255);
        //zad3
        g.drawString("Liczba ruchów: " +move, screenWidth/2, screenHeight- 40, Graphics.BOTTOM|Graphics.HCENTER);
        //zad6
        g.drawString("Czas: " +timeEnd +" ms", screenWidth/2, 10, Graphics.TOP|Graphics.HCENTER);
        g.drawString("Limit czasowy to: 120000 ms", screenWidth/2, 40, Graphics.TOP|Graphics.HCENTER);
        }
        }
        if(finished){
        g.drawString("Brawo wygrałeś w : " +move + " ruchach", screenWidth/2, screenHeight- 20, Graphics.BOTTOM|Graphics.HCENTER);
        }
        //zad5
        if(end){
            for(int j =0; j<100;j++){
            g.setColor(0xffffff);	
            g.fillRect(0,0,screenWidth, screenHeight);
            g.setColor(0,0,255);
            g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE));
            g.drawString("Dziękujemy za granie", screenWidth/2, screenHeight/3, Graphics.TOP|Graphics.HCENTER);              
            }
        }
    }
    
    protected void keyPressed(int keyCode)
    {
	int gameAction = getGameAction(keyCode);
	
	switch(gameAction)
	{
	    case UP:    yMove=-1; move+=1; break;
	    case DOWN:  yMove=+1; move+=1; break;
	    case LEFT:  xMove=-1; move+=1; break;
	    case RIGHT: xMove=+1; move+=1; break;
            
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
        timeEnd = System.currentTimeMillis() - timeStart;
        //zad7
        if(timeEnd == 120000){
            end=true;
            losowanie();
            isAlive= false;
	    midlet.destroyApp( false );
	    midlet.notifyDestroyed();
        }
	int oldxPos=xPos;
        int oldyPos=yPos;
        
        xPos+=xMove;
	yPos+=yMove;
	
        if (xPos>=2) xPos=2; if (xPos<=0) xPos=0;
        if (yPos>=2) yPos=2; if (yPos<=0) yPos=0;
        temp=img[yPos*3+xPos];
        img[yPos*3+xPos]=img[oldyPos*3+oldxPos];
        img[oldyPos*3+oldxPos]=temp;
        check();
	repaint();
	serviceRepaints();
    }
    //zad4
    protected void check(){
        try {
            if(start &&img[0].equals(Image.createImage("/0.png"))&&img[1].equals(Image.createImage("/1.png"))
                    &&img[2].equals(Image.createImage("/2.png"))&&img[3].equals(Image.createImage("/3.png"))
                    &&img[4].equals(Image.createImage("/4.png"))&&img[5].equals(Image.createImage("/5.png"))
                    &&img[6].equals(Image.createImage("/6.png"))&&img[7].equals(Image.createImage("/7.png"))
                    &&img[2].equals(Image.createImage("/8.png"))){
                finished=true;
            }
            else{
                finished=false;
            }
                } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void commandAction(Command c, Displayable d)
    {
        switch( c.getCommandType() ) {
            case Command.EXIT:
                //zad2
                end=true;
	    losowanie();
            	    isAlive	= false;
	    midlet.destroyApp( false );
	    midlet.notifyDestroyed();
            break;
            case Command.ITEM:
                timeStart = System.currentTimeMillis();
                start=true;
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

