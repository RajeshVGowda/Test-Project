package com.nineleafs.LearningRX.java8;

import java.io.File;
import java.io.FileFilter;

public class LamdaDemo {

    public static void main(String[] args) {

        //Using anonymous class
        /*FileFilter fileFilter=new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };
*/

        //Using Lamda Expressions
        FileFilter fileFilter=(File file)->file.getName().endsWith(".java");

        File file=new File("/home/nineleaps/Downloads/Learning-RX/src/main/java/com/nineleafs/LearningRX");
        File[] files = file.listFiles(fileFilter);
        for(File fil:files){
            System.out.println(fil);
        }
    }
}
