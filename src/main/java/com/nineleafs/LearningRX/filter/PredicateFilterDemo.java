package com.nineleafs.LearningRX.filter;

import com.nineleafs.LearningRX.util.DataGenerator;
import com.nineleafs.LearningRX.util.ThreadUtils;
import rx.Observable;
import rx.schedulers.Schedulers;

public class PredicateFilterDemo {

    public static void main(String[] args) {


        Object objectLock=new Object();

        synchronized (objectLock){
            Observable.from(DataGenerator.generateBigIntegerList())
                    .filter((i)->{
                        return i%3==0 && i<20;
                    })
                    .last()
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(
                            (i)->{
                        System.out.println(i);
                    },(t)->{
                                t.printStackTrace();
                            },
                            ()->{
                                System.out.println("On Completed....");
                                synchronized (objectLock){
                                    objectLock.notify();
                                }

                            }
                    );

            ThreadUtils.wait(objectLock);
        }
    }
}
