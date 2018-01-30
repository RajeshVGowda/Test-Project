package com.nineleafs.LearningRX.observable.creations;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

import java.util.concurrent.FutureTask;

public class FutureObservableCreations {

    public static void main(String[] args) {
        System.out.println("Demo on creation using FutureList ");

        FutureTask<List<Integer>> futureTask=
                new FutureTask<>(()->
                {
                    return DataGenerator.generateFibonacciList();
                });

        Observable<List<Integer>> observable = Observable.from(futureTask);
        Schedulers.computation().schedule(()->{
            futureTask.run();
        });

        observable.subscribe((list)->list.forEach((s)-> System.out.println(s)));
    }


}
