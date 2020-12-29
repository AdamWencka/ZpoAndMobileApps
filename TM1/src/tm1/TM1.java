/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Adam
 */
public class TM1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fileInput = null;
        /*byte firstByte =0;
        byte secondByte =0;
        byte thirdByte=0;
        byte fourthByte=0;
        
        int flag=0;*/
        String s = new String();
        boolean jestOdczyt = false;
        int[] mp3bytes = new int[4];
        try {
            fileInput = new FileInputStream("C:\\Users\\Admin\\Desktop\\UTP\\Technologie multimedialne\\Lab3\\audio.mp3");
            int _byte;
            for (int i = 0; i < 3; i++) {
                _byte = fileInput.read();
                mp3bytes[i] = _byte;
                jestOdczyt = true;
                System.out.println("bajt: " + i + " = " + _byte);
            }
            fileInput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jestOdczyt) {
            int b = mp3bytes[1] & 24;
            System.out.println(mp3bytes[0] + " " + mp3bytes[1] + " " + mp3bytes[2] + " " + mp3bytes[3]);
            if (b == 0) {
                System.out.println("MPEG Version 2.5");
            } else if (b == 8) {
                System.out.println("reserved");
            } else if (b == 12) {
                System.out.println("MPEG Version 2 (ISO/IEC 13818-3)");
            } else if (b == 24) {
                System.out.println("MPEG Version 1 (ISO/IEC 11172-3)");
            }
            int c = mp3bytes[1] & 6;
            if(c==0) System.out.println("reserved");
            else if(c==2)System.out.println("Layer III");
            else if(c==4)System.out.println("Layer II");
            else if(c==6)System.out.println("Layer I");
            int d = mp3bytes[1] & 1;
            if(d==0) System.out.println("Protected by CRC (16bit crc follows header)");
            else if(d==1)System.out.println("Not protected");
            int f = mp3bytes[2] & 12;
            if(f==0) System.out.println("44100");
            else if(f==4)System.out.println("48000");
            else if(f==8)System.out.println("32000");
            else if(f==12)System.out.println("reserv.");
            int i = mp3bytes[3] & 192;
            if(i==32) System.out.println("Stereo");
            else if(i==64)System.out.println("Joint stereo (Stereo)");
            else if(i==128)System.out.println("Dual channel (Stereo)");
            else if(i==192)System.out.println(" Single channel (Mono)");            
        
        }

    }

}
