package com.nineleafs.LearningRX.transfermation;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

public class TransformationGroupByDemo {

    public static void main(String[] args) {
        System.out.println("Demo on group by ....");

        Observable.from(DataGenerator.generateBigIntegerList())
                .groupBy((i)->i%2==0?"even":"odd")
                .subscribe((groupList)->{
                    System.out.println("Key : "+groupList.getKey());

                    groupList.subscribe((list)->{
                        System.out.println(groupList.getKey()+" : "+list);
                    });
                });
    }
}
