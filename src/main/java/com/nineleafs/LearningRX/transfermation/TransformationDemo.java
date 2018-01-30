package com.nineleafs.LearningRX.transfermation;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

public class TransformationDemo {

    public static void main(String[] args) {
        System.out.println("Map Demo One -to- One ");

        Observable.from(DataGenerator.generateGreekAlphabet())
                .map((greek)->greek.toUpperCase())
                .subscribe((s)-> System.out.println(s));

        System.out.println("Illustrate for one to Many Mapping");

        Observable.from(DataGenerator.generateGreekAlphabet())
                .flatMap((greekLetters)->{
                    String[] returnStrings={greekLetters.toUpperCase(),greekLetters.toLowerCase()
                    };
                    return Observable.from(returnStrings);
                })
                .subscribe((s)-> System.out.println(s));
    }
}
