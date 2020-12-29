/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.zpo3;

/**
 *
 * @author Adam
 */
public class Timer {
    
    private long startTime;
    private long stopTime;
    private long duration;

    public Timer() {
        this.startTime = 0;
        this.stopTime = 0;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
    }

    public long getDuration() {
        duration = stopTime - startTime;
        return duration;
    }
}
