package com.nineleafs.LearningRX.composition;

import com.nineleafs.LearningRX.util.ThreadUtils;
import rx.Observable;
import rx.schedulers.Schedulers;

public class CompositionDemo {

    public static void main(String[] args) {

        System.out.println("Composition Demo...");
        UserService userService=new UserService();

        Object objectLock=new Object();

        synchronized (objectLock){
            Observable.from(userService.fetchUserList())
                    .parallel((userList)->{
                        return userList.filter((users)->{
                            return users.getSecurityStatus()!=UserSecurityStatus.ADMINISTRATOR;
                        });
                    })
                    .toSortedList((user1,user2)->
                    {
                        return user1.getSecurityStatus().compareTo(user2.getSecurityStatus());
                    })
                    .subscribeOn(Schedulers.io())
                    .doOnCompleted(()->{
                        synchronized (objectLock){
                            objectLock.notify();
                        }
                    })
                    .subscribe((list)->{
                        list.forEach(user -> System.out.println(user.getSecurityStatus()));
                    });
            ThreadUtils.wait(objectLock);
        }

    }
}
