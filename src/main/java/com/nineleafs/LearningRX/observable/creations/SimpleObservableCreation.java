package com.nineleafs.LearningRX.observable.creations;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

public class SimpleObservableCreation {


    public static void main(String[] args) {

        System.out.println("Demo on Observable Creations....");
        System.out.println("Observable creations using single Object");

        Observable<Integer> integerObservable=null;

        integerObservable=Observable.just(1);

        integerObservable.subscribe((value)->{
            System.out.println(value);
        });

        System.out.println("Observable creation using Iterable ");

        integerObservable=Observable.from(DataGenerator.generateBigIntegerList());
        integerObservable.subscribe((value)-> System.out.println(value));

        System.out.println("Observable creationusing Arrays...");
        integerObservable=Observable.from(DataGenerator.generateFibonacciArray());
        integerObservable.subscribe((value)-> System.out.println(value));
    }

}
