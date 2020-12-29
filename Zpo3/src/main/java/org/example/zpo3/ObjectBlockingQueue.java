/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.zpo3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Adam
 */
public class ObjectBlockingQueue {
        private BlockingQueue<Item> items;
    
    public ObjectBlockingQueue(int size){
        items = new ArrayBlockingQueue<>(size);
        fillQueueWithItems(size);
    }
    
    private void fillQueueWithItems(int size){
        for(int i = 0; i<size; i++){
            items.add(new Item());
        }
    }
    
    public BlockingQueue getBlockingQueue(){
        return items;
    } 
}
