package com.nineleafs.LearningRX.filter;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

public class PositionalFilterUsingElement {

    public static void main(String[] args) {
        System.out.println("using element ....");


        Observable.from(DataGenerator.generateGreekAlphabet())
                .elementAt(0)
                .subscribe((i)-> System.out.println(i));
        System.out.println("Demo on elementAtOrDefault");
        Observable.from(DataGenerator.generateGreekAlphabet())
                .elementAtOrDefault(50,"No Element present at that position")
                .subscribe((i)-> System.out.println(i));
        System.out.println("Demo on Distinct...");

        Observable.from(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
                .distinct()
                .subscribe((i)-> System.out.println(i));


    }
}
