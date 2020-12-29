/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.zpo3;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class Main {

    static int producerThreads;
    static int consumerThreads;
    static int maxThreads;
    static ObjectBlockingQueue task1;
    static ObjectBlockingQueue task2;
    static ObjectBlockingQueue task3;
    static int amountOfItems;

    public static void runThreads(BlockingQueue queue) {
        ItemThreads threads = new ItemThreads(producerThreads, consumerThreads, queue);
        long duration = threads.runThreadsWithTimer();
        System.out.println("Zadanie wykonane przy pomocy wątków\n"
                + "Czas wykonania: " + duration + " ms");
    }

    public static void runThreadPool(BlockingQueue queue){
        ItemThreadPool threadPool = new ItemThreadPool(maxThreads, queue);
        long duration = threadPool.runThredPoolWithTimer();
        System.out.println("Zadanie wykonane przy pomocy puli wątków\n"
                +"Czas wykonania: "+duration+" ms");
    }

    public static void runParallelStream(BlockingQueue queue) {
        ItemStream stream = new ItemStream(new ArrayBlockingQueue(queue.size(), false, queue));
        long duration = stream.runWithTimer();
        System.out.println("Zadanie wykonane przy pomocy strumieni równoległych\n"
                +"Czas wykonania: "+duration+" ms");
    }
    public static void main(String[] args) throws InterruptedException {
        producerThreads = 4;
        consumerThreads = 3;
        maxThreads = 7;
        amountOfItems = 100;
        
        task1 = new ObjectBlockingQueue(amountOfItems);
        task2 = new ObjectBlockingQueue(amountOfItems);
        task3 = new ObjectBlockingQueue(amountOfItems);
        
       //runThreads(task1.getBlockingQueue());
        //runThreadPool(task2.getBlockingQueue());
       //runParallelStream(task3.getBlockingQueue());
       
    }
}
