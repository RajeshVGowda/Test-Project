package com.nineleafs.LearningRX.transfermation;

import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class TransformationGroupBy1Demo {

    public static void main(String[] args) {

        System.out.println("Group by demo...");
        List<Integer> evenNumbers=new ArrayList<>();
        List<Integer> oddNumbers=new ArrayList<>();

        Observable.from(DataGenerator.generateBigIntegerList())
                .groupBy((i)->i%2==0?"Even":"Odd")
                .subscribe((groupList)
                ->{
                    groupList.subscribe((value)->{
                        if(groupList.getKey().equals("Even"))
                            evenNumbers.add(value);
                        else
                            oddNumbers.add(value);
                    });

                });

        System.out.println("Even numbers are : ");
        evenNumbers.forEach(System.out::println);
        System.out.println("Odd Numbers are : ");
        oddNumbers.forEach(System.out::println);

    }
}
