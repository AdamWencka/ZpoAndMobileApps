/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.zpo3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Adam
 */
public class ItemThreadPool {
    private final ExecutorService executorService;
    private final BlockingQueue<Item> items;
    private final Timer timer;
    private final int maxThreads;

    public ItemThreadPool(int maxThreads, BlockingQueue items) {
        this.maxThreads = maxThreads;
        executorService = Executors.newFixedThreadPool(maxThreads);
        this.timer = new Timer();
        this.items = items;
    }

    private void submitToThreadPool() {
        for (int i = 0; i < maxThreads; i++) {
            executorService.submit(new Producer(items.poll()));
        }
    }
    
    private void submitToThreadPoolStream(){
        items.stream()
                .forEach(i -> executorService.execute(() -> i.produceMe()));
        items.stream()
                .forEach(i -> executorService.execute(() -> i.consumeMe()));
        executorService.shutdown();
    }

    public void runThreadPool() {
       submitToThreadPoolStream();
        //submitToThreadPool();
    }

    public long runThredPoolWithTimer(){
        timer.start();
        runThreadPool();
        while(!executorService.isTerminated())
        timer.stop();
        return timer.getDuration();
    }

    private class Producer implements Runnable {

        private final Item item;

        public Producer(Item item) {
            this.item = item;
        }

        @Override
        public void run() {
            if (item != null) {
                item.produceMe();
                executorService.submit(new Consumer(item));
            }else{
                executorService.shutdown();
            }
        }
    }

    private class Consumer implements Runnable {

        private Item item;

        public Consumer(Item item) {
            this.item = item;
        }

        @Override
        public void run() {
            if(item != null){
                item.consumeMe();
                item = items.poll();
                executorService.submit(new Producer(item));
            }
        }
    }
}
