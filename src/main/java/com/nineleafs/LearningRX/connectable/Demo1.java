package com.nineleafs.LearningRX.connectable;

import com.nineleafs.LearningRX.util.ThreadUtils;
import com.nineleafs.LearningRX.util.TimeTicker;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

public class Demo1 {

    public static void main(String[] args) {

        TimeTicker timeTicker=new TimeTicker(500);
        timeTicker.start();

        ConnectableObservable<Long> connectableObservable=timeTicker.toObservable().publish();


        connectableObservable
                .observeOn(Schedulers.computation())
                .subscribe((time)-> {
            System.out.println("Tick1..."+ ThreadUtils.currentThreadName()+" : "+time);
                    ThreadUtils.sleep(2000);
        });

        connectableObservable
                .observeOn(Schedulers.computation())
                .subscribe((time)-> {
            System.out.println("Tick2..."+ThreadUtils.currentThreadName()+" : "+time);
            ThreadUtils.sleep(1000);
        });

        System.out.println("Thread is going to sleep state...");
        ThreadUtils.sleep(3000);

        System.out.println("Thread is up");
        System.out.println("Connecting...");
        connectableObservable.connect();
        ThreadUtils.sleep(5000);
        System.out.println("Calling stop() method....");
        timeTicker.stop();
        System.out.println("Sleeping again");
        System.out.println();
        ThreadUtils.sleep(5000);
        System.out.println("Notice what happen...");
    }
}
