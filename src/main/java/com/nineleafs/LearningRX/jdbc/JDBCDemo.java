package com.nineleafs.LearningRX.jdbc;

import com.nineleafs.LearningRX.jdbcdemo.MyJDBCDemo;
import rx.Observable;
import rx.util.functions.Func0;
import rx.util.functions.Func1;

public class JDBCDemo {


    public static void main(String[] args) {

        System.out.println("********************");
        System.out.println("Demo on using() method...");

        MyJDBCDemo.init();
        Func0<ConnectionSubscription> resourceFactory
                =()->{
            return new ConnectionSubscription(MyJDBCDemo.createConnection());
        };

        Func1<ConnectionSubscription,Observable<String>> observableConnectionSubscriptionFunc
                =(connectionSubscription)->{
                    return MyJDBCDemo.selectAllLetter(connectionSubscription);
        };

        Observable.using(resourceFactory,observableConnectionSubscriptionFunc)
                .map((toLowercase)->{
                    return toLowercase.toLowerCase();
                })
                .subscribe((letter)->{
                    System.out.println(letter);
                });
    }
}
