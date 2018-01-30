package com.nineleafs.LearningRX.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLamda {

    public static void main(String[] args) {
        System.out.println("Lamda Demo using comparator...");

        //using anonymous class for Comparator interface
        /*Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(s.length(),t1.length());
            }
        };*/

        Comparator<String> comparatorLamda=(String s,String t1)->{
            return Integer.compare(s.length(),t1.length());
        };



        List<String> lists= Arrays.asList("*","***","****","**");
        Collections.sort(lists,comparatorLamda);
        for(String list:lists){
            System.out.println(list);
        }
    }
}
