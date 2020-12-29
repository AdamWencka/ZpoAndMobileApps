/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.zpo3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 *
 * @author Adam
 */
public class ItemThreads {
    private List<Thread> producerThreads;
    private List<Thread> consumerThreads;
    private BlockingQueue<Item> itemsToProduce;
    private BlockingQueue<Item> itemsToConsume;
    private Timer timer;

    public ItemThreads(int numberOfProducerThreads, int numberOfConsumingThreads, BlockingQueue items) {
        initThreads(numberOfProducerThreads, numberOfConsumingThreads);
        this.itemsToProduce = items;
        this.itemsToConsume = new ArrayBlockingQueue<>(items.size());
        this.timer = new Timer();
    }

    private void initThreads(int numberOfProducerThreads, int numberOfConsumerThreads) {
        producerThreads = new ArrayList<>();
        for(int i=0; i<numberOfProducerThreads; i++){
            producerThreads.add(newProducerThread());
        }
        consumerThreads = new ArrayList<>();
        for(int i=0; i<numberOfConsumerThreads; i++){
            consumerThreads.add(newConsumerThread());
        }
    }

    private Thread newProducerThread() {
        Thread result = new Thread(() -> {
            Item currentItem = null;
            while(!itemsToProduce.isEmpty()){
                currentItem = itemsToProduce.poll();
                if(currentItem != null) {
                    currentItem.produceMe();
                    itemsToConsume.add(currentItem);
                }
            }
        });
        return result;
    }
    
    private Thread newConsumerThread(){
        Thread result = new Thread(() -> {
            Item currentItem = null;
            while(!itemsToConsume.isEmpty() || anyProducerThreadAlive()){
                currentItem = itemsToConsume.poll();
                if(currentItem != null) currentItem.consumeMe();
            }
        });
        return result;
    }
    
    private boolean anyProducerThreadAlive(){
        return producerThreads.stream()
                .anyMatch(t -> t.isAlive());
    }
    
    private boolean anyConsumerThreadAlive(){
        return consumerThreads.stream()
                .anyMatch(t -> t.isAlive());
    }
    
    private boolean anyThreadAlive(){
        return anyProducerThreadAlive() || anyConsumerThreadAlive();
    }
    
    public long runThreadsWithTimer(){
        timer.start();
        runThreads();
        while(anyThreadAlive())
        timer.stop();
        return timer.getDuration();
    }   
    
    public void runThreads(){
        producerThreads.stream()
                .forEach(t -> t.start());
        consumerThreads.stream()
                .forEach(t -> t.start());
    }
}
