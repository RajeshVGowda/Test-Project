package com.nineleafs.LearningRX.observable.creations;


import com.nineleafs.LearningRX.util.DataGenerator;
import com.nineleafs.LearningRX.util.ThreadUtils;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class SubcribesSameThread {

    public static void main(String[] args) {
        System.out.println("Demo on driving single thread for both subscriber and observer");

        System.out.println("Driving By : " + Thread.currentThread().getName());
        Object objectLock=new Object();

        synchronized (objectLock) {

            Observable.from(DataGenerator.generateBigIntegerList())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            (i) -> {
                                System.out.println("onNext() thread entry: " + Thread.currentThread().getName());
                                System.out.println(i);
                                System.out.println("onNext() thread exit: " + Thread.currentThread().getName());
                            },
                            (t) -> {
                                t.printStackTrace();

                            },
                            () -> {
                                System.out.println("On completed()...");
                                synchronized (objectLock) {
                                    objectLock.notify();
                                }
                            }


                    );
            ThreadUtils.wait(objectLock);
        }
    }
}