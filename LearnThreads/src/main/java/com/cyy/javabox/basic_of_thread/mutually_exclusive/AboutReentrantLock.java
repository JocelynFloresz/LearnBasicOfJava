package com.cyy.javabox.basic_of_thread.mutually_exclusive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yinyichen
 * @date 2022/9/2 12:35
 */
public class AboutReentrantLock {
    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 1500; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AboutReentrantLock aboutReentrantLock = new AboutReentrantLock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> aboutReentrantLock.func());
        executorService.execute(() -> aboutReentrantLock.func());
    }
}
