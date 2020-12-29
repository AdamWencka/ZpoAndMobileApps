/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication17;

import java.util.Random;
import javax.microedition.lcdui.*;

/**
 *
 * @author Adam
 */
public class MyCanvas extends Canvas implements CommandListener {

    Midlet midlet;
    int xPos;
    int yPos;
    int R;
    int G;
    int B;
    Random r;
    int ran;
    boolean start;
    int moveRight = 0;
    int moveBottom = 0;

    public MyCanvas(Midlet _midlet) {
        start = false;
        R = 10;
        G = 10;
        B = 255;
        r = new Random();
        midlet = _midlet;
        addCommand(new Command("Koniec", Command.EXIT, 0));
        setCommandListener(this);
        xPos = getWidth() / 2;
        yPos = getHeight() / 2;
    }

    protected void paint(Graphics g) {
        g.setColor(0xffffff);
        int screenWidth = getWidth();
        int screenHeight = getHeight();
        g.fillRect(0, 0, screenWidth, screenHeight);
        g.setColor(R, G, B);
        g.fillRect(xPos, yPos, 32, 32);
    }

    protected void keyPressed(int keyCode) {
        if (keyCode == KEY_NUM5) {
            ran = r.nextInt(7);
            start = true;
        }
        while (start) {
            switch (ran) {
                case 0:
                    if (moveBottom == 0) {
                        ++yPos;
                    } else if (moveBottom == 1) {
                        ++yPos;
                    } else if (moveBottom == -1) {
                        --yPos;
                    }
                    break;
                case 1:
                    if (moveBottom == 0) {
                        ++yPos;
                    } else if (moveBottom == 1) {
                        ++yPos;
                    } else if (moveBottom == -1) {
                        --yPos;
                    }
                    if (moveRight == 0) {
                        ++xPos;
                    } else if (moveRight == 1) {
                        ++xPos;
                    } else if (moveRight == -1) {
                        --xPos;
                    }
                    break;
                case 2:
                    if (moveRight == 0) {
                        ++xPos;
                    } else if (moveRight == 1) {
                        ++xPos;
                    } else if (moveRight == -1) {
                        --xPos;
                    }
                    break;
                case 3:
                    if (moveBottom == 0) {
                        --yPos;
                    } else if (moveBottom == 1) {
                        ++yPos;
                    } else if (moveBottom == -1) {
                        --yPos;
                    }
                    if (moveRight == 0) {
                        ++xPos;
                    } else if (moveRight == 1) {
                        ++xPos;
                    } else if (moveRight == -1) {
                        --xPos;
                    }
                    break;
                case 4:
                    if (moveBottom == 0) {
                        --yPos;
                    } else if (moveBottom == 1) {
                        ++yPos;
                    } else if (moveBottom == -1) {
                        --yPos;
                    }
                    break;
                case 5:
                    if (moveBottom == 0) {
                        --yPos;
                    } else if (moveBottom == 1) {
                        ++yPos;
                    } else if (moveBottom == -1) {
                        --yPos;
                    }
                    if (moveRight == 0) {
                        --xPos;
                    } else if (moveRight == 1) {
                        ++xPos;
                    } else if (moveRight == -1) {
                        --xPos;
                    }
                    break;
                case 6:
                    if (moveRight == 0) {
                        --xPos;
                    } else if (moveRight == 1) {
                        ++xPos;
                    } else if (moveRight == -1) {
                        --xPos;
                    }
                    break;
                case 7:
                    if (moveBottom == 0) {
                        ++yPos;
                    } else if (moveBottom == 1) {
                        ++yPos;
                    } else if (moveBottom == -1) {
                        --yPos;
                    }
                    if (moveRight == 0) {
                        --xPos;
                    } else if (moveRight == 1) {
                        ++xPos;
                    } else if (moveRight == -1) {
                        --xPos;
                    }
                    break;
            }
            if (xPos == 0) {
                moveRight = 1;
            }
            if ((xPos + 32) == this.getWidth()) {
                moveRight = -1;
            }
            if (yPos == 0) {
                moveBottom = 1;
            }
            if ((yPos + 32) == this.getHeight()) {
                moveBottom = -1;
            }
            if (keyCode != KEY_NUM5) {

                start = false;
            }
            repaint();
            serviceRepaints();
        }

    }

    public void commandAction(Command c, Displayable d) {
        switch (c.getCommandType()) {
            case Command.EXIT:
                midlet.destroyApp(false);
                midlet.notifyDestroyed();
                break;
        }
    }
}
