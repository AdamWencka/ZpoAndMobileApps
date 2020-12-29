/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.filemanager;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
/**
 *
 * @author Biedras
 */
public class MyFile {

    private String name;
    private Path path;
    private String ext;
    private long size;
    private String sizeString;
    private String modified;

    public MyFile() {
        this.name = "";
        this.path = null;
        this.ext = "";
        this.size = 0;
        this.sizeString = "";
        this.modified = "";
    }

    public void setSizeString(String sizeString) {
        this.sizeString = sizeString;
    }

    public String getSizeString() {
        return sizeString;
    }
    
    public MyFile(String name, Path path, String ext, long size, String modified){
        this.name = name;
        this.path = path;
        this.ext = ext;
        this.size = size;
        this.modified = modified;
    }
    
    public MyFile(Path path){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        this.path = path;
        this.name = FilenameUtils.getBaseName(path.toString());
        this.ext = FilenameUtils.getExtension(path.toString());
        if(path.toFile().isFile()){
            this.size = path.toFile().length();
            this.modified = sdf.format(path.toFile().lastModified());
            this.sizeString = bytesConverter(size);
        }else{
            this.size = 0;
            this.modified = "";
            this.sizeString = "";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }

    public String getExt() {
        return ext;
    }

    public long getSize() {
        return size;
    }

    public String getModified() {
        return modified;
    }
    
    public void folderSize(long size){
        this.size = size;
        this.sizeString = bytesConverter(size);
    }
    
    @Override
    public String toString(){
        return path.toString()+", "+name+", "+ext+", "+sizeString+", "+modified;
    }
    
    static public String bytesConverter(long bytes){
        String result;
        BigDecimal bd = new BigDecimal(bytes);
        BigDecimal divider = new BigDecimal(1024);
        short index = 0;
        String[] letter = {"B", "KB", "MB", "GB", "TB", "PB"};
        while(bd.divide(divider.pow(index)).compareTo(divider) != -1){
            index++;
        }
        double tmp = bd.divide(divider.pow(index)).doubleValue();
        
        result = String.format("%.2f", tmp)+ letter[index];
        return result;
    }
    
    
}
