package com.cyy.javabox.basic_of_thread.mutually_exclusive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yinyichen
 * @date 2022/9/2 13:50
 */
public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("Before");
        notify();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        executorService.execute(() ->waitNotifyExample.after());
        executorService.execute(() ->waitNotifyExample.before());
    }
}
