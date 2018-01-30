package com.nineleafs.LearningRX.transfermation;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

public class ConditionalDemo {

    public static void main(String[] args) {

        System.out.println("Condtional operations using defaultIfEmpty...");

        Observable.from(DataGenerator.generateGreekAlphabet())
                .defaultIfEmpty("No values are present")
                .first()
                .subscribe((s)->{
                    System.out.println(s);
                });

        Observable.empty()
                .defaultIfEmpty("No Values are present ....")
                .subscribe((s)-> System.out.println(s));

        System.out.println("Takewhile() demo ");
        Observable.from(DataGenerator.generateFibonacciArray())
                .skipWhile((i)->{
                    return i<8;
                }).subscribe((s)-> System.out.println(s));
    }
}
