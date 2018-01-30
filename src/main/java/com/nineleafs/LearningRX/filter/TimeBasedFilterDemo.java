package com.nineleafs.LearningRX.filter;

import com.nineleafs.LearningRX.util.ThreadUtils;
import com.nineleafs.LearningRX.util.TimeTicker;

import java.util.concurrent.TimeUnit;

public class TimeBasedFilterDemo {

    public static void main(String[] args) {
        System.out.println("******************");

        TimeTicker timeTicker=new TimeTicker(100);

        timeTicker.start();
        try{
            timeTicker.toObservable()
                    .timeout(3,TimeUnit.SECONDS)
                    .subscribe((i)->
                    {
                        System.out.println(i);
                    },
                            (exception)->{
                        exception.printStackTrace();
                            });
            ThreadUtils.sleep(1000);
            System.out.println("Time puased");
            timeTicker.pause();
            ThreadUtils.sleep(5000);
        }finally {
            timeTicker.stop();
        }
        System.out.println("******************");
    }
}
