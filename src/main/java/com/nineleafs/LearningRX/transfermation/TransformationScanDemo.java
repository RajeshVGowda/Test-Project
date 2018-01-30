package com.nineleafs.LearningRX.transfermation;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

public class TransformationScanDemo{

    public static void main(String[] args) {
        System.out.println("Scan Demo ");
        System.out.println("If u want carry information from previous result to next event we will use scan operations");

       /* Observable.from(DataGenerator.generateGreekAlphabet())
                .scan(new StringBuilder(),(accum,nextLetter)->{
                    return accum.append(nextLetter);
                }).subscribe((s)-> System.out.println(s));*/

        System.out.println("Last() demo....");
        System.out.println("----------------------------------------");
        Observable.from(DataGenerator.generateGreekAlphabet())
                .scan(new StringBuilder(),((stringBuilder, s) ->{
                    return stringBuilder.append(s);
                })).last()
                .subscribe((s)-> System.out.println(s));

        System.out.println("----------------------------------------");
        Observable.from(DataGenerator.generateGreekAlphabet())
                .scan(new StringBuilder(),((stringBuilder, s) ->{
                    return stringBuilder.append(s);
                })).takeLast(1)
                .subscribe((s)-> System.out.println(s));
   }

}
