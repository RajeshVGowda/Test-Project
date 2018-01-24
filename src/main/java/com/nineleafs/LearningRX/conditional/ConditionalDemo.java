package com.nineleafs.LearningRX.conditional;

import rx.Observable;

public class ConditionalDemo {

    public static void main(String[] args){
        System.out.println("********");
        Observable.just("How are you").defaultIfEmpty(" hello")
                .subscribe((i)->{ System.out.println(i);}
                );

        System.out.println("****************************");

        System.out.println("skip demo ...");
        Observable.just(1,2,3,4,5)
                .skipWhile((i)->{
                    return i<3;
                }).subscribe((i)-> System.out.println(i));

        System.out.println("takeWhile() demo");
        Observable.just(1,2,3,4,5)
                .takeWhile((i)->{
                    return  i<3;
                }).subscribe((i)-> System.out.println(i));

        System.out.println("first() Demo ....");
        Observable.just(1,2,3,4)
                .first()
                .subscribe((i)-> System.out.println(i));
    }
}
