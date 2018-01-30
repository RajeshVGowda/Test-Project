package com.nineleafs.LearningRX.filter;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

public class PositionalFilterDemo {

    public static void main(String[] args) {
        System.out.println("Positional Demo using first and last....");

        System.out.println("first() demo....");

        Observable.from(DataGenerator.generateBigIntegerList())
                .first()
                .subscribe((i)->{
                    System.out.println(i);
                });

        System.out.println("-------------------");
        Observable.from(DataGenerator.generateBigIntegerList())
                .take(4)
                .subscribe((i)-> System.out.println(i));
        System.out.println("-------------------");
        Observable.from(DataGenerator.generateBigIntegerList())
                .last()
                .subscribe((i)-> System.out.println(i));
        System.out.println("-------------------");
        Observable.from(DataGenerator.generateBigIntegerList())
                .takeLast(4).subscribe((i)-> System.out.println(i));

        System.out.println("-------------------");
        Observable.empty()
                .lastOrDefault("No Last Value")
                .subscribe((i)-> System.out.println(i));
        System.out.println("-----------------------------");
        Observable.from(DataGenerator.generateBigIntegerList())
                .lastOrDefault(3)
                .subscribe((i)-> System.out.println(i));


    }
}
