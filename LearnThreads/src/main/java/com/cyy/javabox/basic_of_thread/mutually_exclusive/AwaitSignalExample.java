package com.cyy.javabox.basic_of_thread.mutually_exclusive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yinyichen
 * @date 2022/9/2 13:57
 */
public class AwaitSignalExample {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AwaitSignalExample awaitSignalExample = new AwaitSignalExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> awaitSignalExample.after());
        executorService.execute(() -> awaitSignalExample.before());
    }
}
