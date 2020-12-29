/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Adam
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        FileInputStream fileInput = null;
        int[] mp3bytes = new int[4];
        boolean sprawdz = false;

        try {
            fileInput = new FileInputStream("C:\\Users\\Admin\\Desktop\\UTP\\Technologie multimedialne\\Lab3\\audio.mp3");
            int _byte;

            for (int i = 0; i < 4; i++) {
                _byte = fileInput.read();
                mp3bytes[i] = _byte;
                System.out.println("bajt: " + i + " = " + _byte);
            }
            fileInput.close();
            sprawdz = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(sprawdz) {
            int b = mp3bytes[1] & 24;
            int c = mp3bytes[1] & 6;
            int d = mp3bytes[1] & 1;
            int f = mp3bytes[2] & 12;
            int licznik = 0;
            int i = mp3bytes[3] & 192;
            int k = mp3bytes[3] & 8;
            int l = mp3bytes[3] & 4;

            switch (b) {
                case 0:
                    System.out.println("MPEG Version 2.5");
                    break;
                case 8:
                    System.out.println("reserved");
                    break;
                case 16:
                    System.out.println("MPEG Version 2 (ISO/IEC 13818-3)");
                    break;
                case 24:
                    System.out.println("MPEG Version 1 (ISO/IEC 11172-3)");
            }
            switch (c) {
                case 0:
                    System.out.println("reserved");
                    break;
                case 2:
                    System.out.println("Layer III");
                    break;
                case 4:
                    System.out.println("Layer II");
                    break;
                case 6:
                    System.out.println("Layer I");
            }
            switch (d) {
                case 0:
                    System.out.println("Protected by CRC (16bit crc follows header)");
                    break;
                case 1:
                    System.out.println("Not protected");
                    break;
            }
            switch (f) {
                case 0:
                    licznik = 11025;
                    break;
                case 4:
                    licznik = 12000;
                    break;
                case 8:
                    licznik = 8000;
                    break;
                case 12:
                    System.out.println("reserv.");
                    break;
            }

            if(licznik > 0)
            {
                if(b == 16)
                    System.out.println(licznik * 2 + "Hz");
                if(b == 24)
                    System.out.println(licznik * 4 + "Hz");
                if(b == 0)
                    System.out.println(licznik + "Hz");
            }

            switch (i) {
                case 0:
                    System.out.println("Stereo");
                    break;
                case 64:
                    System.out.println("Joint stereo (Stereo)");
                    break;
                case 128:
                    System.out.println("Dual channel (Stereo)");
                    break;
                case 192:
                    System.out.println("Single channel (Mono)");
            }

            switch (k) {
                case 0:
                    System.out.println("Audio is not copyrighted");
                    break;
                case 8:
                    System.out.println("Audio is copyrighted");
                    break;
            }

            switch (l) {
                case 0:
                    System.out.println("Copy of original media");
                    break;
                case 4:
                    System.out.println("Original media");
                    break;
            }



        }
    }    
}
