/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication18;

import java.util.Random;
import javax.microedition.lcdui.*;

/**
 *
 * @author Adam
 */
public class MyCanvas extends Canvas implements CommandListener {

    Midlet midlet;
    int x1 = 10;
    int y1 = 116;
    int x2 = 225;
    int y2 = 116;
    int xb;
    int yb;
    int sc1 = 0;
    int sc2 = 0;
    String title;
    String score1;
    String score2;
    Random r;
    int ran;
    boolean start;
    int moveRight = 0;
    int moveBottom = 0;
    int movePallet = 0;

    public MyCanvas(Midlet _midlet) {
        start = false;
        title = "Pong";
        r = new Random();
        addCommand(new Command("Koniec", Command.EXIT, 0));
        setCommandListener(this);
        midlet = _midlet;
        xb = this.getWidth() / 2 - 1;
        yb = 126;

    }

    protected void paint(Graphics g) {
        g.setColor(0, 0, 0);
        g.fillRect(0, 0, 240, 320);
        g.setColor(255, 255, 255);
        g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE));
        g.drawString(title, 120, 260, Graphics.HCENTER | Graphics.BOTTOM);

        score1 = String.valueOf(sc1);
        score2 = String.valueOf(sc2);
        g.drawString(score1, 80, 20, Graphics.HCENTER | Graphics.TOP);
        g.drawString(score2, 160, 20, Graphics.HCENTER | Graphics.TOP);
        g.setColor(255, 255, 255);
        g.fillRect(4, 64, 230, 128);
        g.setColor(0, 0, 0);
        g.fillRect(7, 67, 224, 122);
        int ym = 64;
        g.setColor(255, 255, 255);
        for (int i = 0; i < 16; i++) {
            g.fillRect(this.getWidth() / 2, ym, 1, 6);
            ym += 8;
        }

        g.fillRect(x1, y1, 3, 20);
        g.fillRect(x2, y2, 3, 20);
        g.fillRect(xb, yb, 4, 4);

    }

    protected void keyPressed(int keyCode) {

        if (keyCode == KEY_NUM5) {
        ran = r.nextInt(5);
        start = true;
        moveBottom = 0;
        moveRight = 0;
        movePallet = 0;
        }
        while(start) {
            switch (ran) {          
                case 0:
                    if (moveBottom == 0) {
                        ++yb;
                    } else if (moveBottom == 1) {
                        ++yb;
                    } else if (moveBottom == -1) {
                        --yb;
                    }
                    if (moveRight == 0) {
                        ++xb;
                    } else if (moveRight == 1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc2 += 1;
                        start = false;
                    } else if (moveRight == -1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc1 += 1;
                        start = false;
                    }
                    if (movePallet == 1) {
                        ++xb;
                        moveRight = 2;
                    } else if (movePallet == -1) {
                        --xb;
                        moveRight = 2;
                    }
                    break;
                case 1:
                    if (moveRight == 0) {
                        ++xb;
                    } else if (moveRight == 1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc2 += 1;
                        start = false;
                    } else if (moveRight == -1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc1 += 1;
                        start = false;
                    }
                    if (movePallet == 1) {
                        moveRight = 2;
                        ++xb;
                    } else if (movePallet == -1) {
                        moveRight = 2;
                        --xb;
                    }

                    break;
                case 2:
                    if (moveBottom == 0) {
                        --yb;
                    } else if (moveBottom == 1) {
                        ++yb;
                    } else if (moveBottom == -1) {
                        --yb;
                    }
                    if (moveRight == 0) {
                        ++xb;
                    } else if (moveRight == 1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc2 += 1;
                        start = false;
                    } else if (moveRight == -1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc1 += 1;
                        start = false;
                    }
                    if (movePallet == 1) {
                        ++xb;
                        moveRight = 2;
                    } else if (movePallet == -1) {
                        --xb;
                        moveRight = 2;
                    }
                    break;

                case 3:
                    if (moveBottom == 0) {
                        --yb;
                    } else if (moveBottom == 1) {
                        ++yb;
                    } else if (moveBottom == -1) {
                        --yb;
                    }
                    if (moveRight == 0) {
                        --xb;
                    } else if (moveRight == 1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc2 += 1;
                        start = false;
                    } else if (moveRight == -1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc1 += 1;
                        start = false;
                    }
                    if (movePallet == 1) {
                        ++xb;
                        moveRight = 2;
                    } else if (movePallet == -1) {
                        --xb;
                        moveRight = 2;
                    }
                    break;

                case 4:
                    if (moveBottom == 0) {
                        ++yb;
                    } else if (moveBottom == 1) {
                        ++yb;
                    } else if (moveBottom == -1) {
                        --yb;
                    }
                    if (moveRight == 0) {
                        --xb;
                    } else if (moveRight == 1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc2 += 1;
                        start = false;
                    } else if (moveRight == -1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc1 += 1;
                        start = false;
                    }
                    if (movePallet == 1) {
                        ++xb;
                        moveRight = 2;
                    } else if (movePallet == -1) {
                        --xb;
                        moveRight = 2;
                    }

                    break;
                case 5:
                    if (moveRight == 0) {
                        --xb;
                    } else if (moveRight == 1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc2 += 1;
                        start = false;
                    } else if (moveRight == -1) {
                        xb = this.getWidth() / 2 - 1;
                        yb = 126;
                        sc1 += 1;
                        start = false;
                    }
                    if (movePallet == 1) {
                        ++xb;
                        moveRight = 2;
                    } else if (movePallet == -1) {
                        --xb;
                        moveRight = 2;
                    }
                    break;
            }           
            switch (keyCode) {
                case KEY_NUM1:
                    y1 -= 2;
                    break;
                case KEY_NUM7:
                    y1 += 2;
                    break;
                case KEY_NUM3:
                    y2 -= 2;
                    break;
                case KEY_NUM9:
                    y2 += 2;
                    break;

            }
            if (xb == 7) {
                moveRight = 1;
            }
            if ((xb + 4) == 231) {
                moveRight = -1;
            }
            if (yb == 67) {
                moveBottom = 1;
            }
            if ((yb + 4) == 189) {
                moveBottom = -1;
            }
            if (xb == (x1 + 3) && (yb + 3) >= y1 && (yb + 3) <= (y1 + 20)) {
                movePallet = 1;
            }
            if ((xb + 3) == x2 && (yb + 3) >= y2 && (yb + 3) <= (y2 + 20)) {
                movePallet = -1;
            }
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
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
