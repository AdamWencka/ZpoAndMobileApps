/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.zpo4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Adam
 */
public class Item {

    public Item(String name) {
        this.name = name;
    }

    
    private final String name;

    public String getName() {
        return name;
    }


    
}
