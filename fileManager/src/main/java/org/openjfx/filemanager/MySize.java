/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.filemanager;

import java.nio.file.Path;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Biedras
 */
public class MySize extends Thread{
    
    private MyFile mf;
    private Path path;
    private long size = 0;
    
    public MySize(MyFile mf, Path path){
        this.mf = mf;
        this.path = path;
    }
    
    @Override
    public void run(){
        this.size = FileUtils.sizeOfDirectory(this.path.toFile());
        mf.folderSize(this.size);
    }
    
}
