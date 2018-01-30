package com.nineleafs.LearningRX.connectable;

import com.nineleafs.LearningRX.util.ThreadUtils;
import com.nineleafs.LearningRX.util.TimeTicker;
import rx.observables.ConnectableObservable;

public class ConnectableObservDemo {

    public static void main(String[] args) {

        TimeTicker timeTicker=new TimeTicker(500);
        timeTicker.start();

        ConnectableObservable<Long> connectableObservable=timeTicker.toObservable().publish();


        connectableObservable.subscribe((time)-> {
            System.out.println("Tick1..."+ThreadUtils.currentThreadName()+" : "+time);
        });

        connectableObservable.subscribe((time)-> {
            System.out.println("Tick2..."+ThreadUtils.currentThreadName()+" : "+time);
        });

        System.out.println("Thread is going to sleep state...");
        ThreadUtils.sleep(3000);

        System.out.println("Thread is up");
        System.out.println("Connecting...");
        connectableObservable.connect();
        ThreadUtils.sleep(5000);

        timeTicker.stop();
    }
}
