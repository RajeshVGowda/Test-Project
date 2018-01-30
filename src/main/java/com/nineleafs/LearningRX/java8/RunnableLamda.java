package com.nineleafs.LearningRX.java8;

public class RunnableLamda {

    public static void main(String[] args) {
        System.out.println("Lamda Demo...");

       /* //Using anonymous class to implement Runnable interface
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(i+ " Current Thread Name : "+Thread.currentThread().getName());
                }
            }
        };*/

       Runnable runnableLamda=()->{
           for (int i=0;i<10;i++){
               System.out.println(i+ " Current Thread Name : "+Thread.currentThread().getName());
           }
       };

        Thread thread=new Thread(runnableLamda);
        thread.start();
    }
}
