/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.zpo3;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Adam
 */
public class ItemStream {
    
    private BlockingQueue<Item> items;
    private Timer timer;

    public ItemStream(BlockingQueue items) {
        this.items = items;
        this.timer = new Timer();
    }

    private void runParallel() {
        items.stream()
                .parallel()
                .forEach(i -> {
                    i.produceMe();
                    i.consumeMe();
                });
    }
    
    public long runWithTimer(){
        timer.start();
        runParallel();
        timer.stop();
        return timer.getDuration();
    }
}
