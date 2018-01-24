package com.nineleafs.LearningRX;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.*;

public class SimpleObsevableCreation {

    public static void main(String[] args){

        Observable<Integer> integerObservable=null;
        List<Integer> list=new ArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        integerObservable=Observable.from(list);
        integerObservable.subscribeOn(Schedulers.newThread()).
                subscribe(
                (i)->{
           System.out.println("In Thread Name : "+Thread.currentThread().getName());
            System.out.println(i);
            System.out.println("Out Thread Name : "+Thread.currentThread());
        },
        (t)->{
            t.printStackTrace();
        },
         ()->{
             System.out.println("On Completed");
          }
        );
    }
}
