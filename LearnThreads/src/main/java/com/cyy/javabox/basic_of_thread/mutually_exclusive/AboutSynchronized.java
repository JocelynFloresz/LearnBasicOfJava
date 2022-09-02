package com.cyy.javabox.basic_of_thread.mutually_exclusive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yinyichen
 * @date 2022/9/2 11:24
 */
public class AboutSynchronized {

    private int a = 0 ;

    public void setA(int a) {
        this.a = a;
    }

    synchronized static void staticFunc() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
    public void func() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                    System.out.println(a + " " + Thread.currentThread().getName());
                    a++;
            }
        }
    }

    public static void main(String[] args) {
        AboutSynchronized aboutSynchronized1 = new AboutSynchronized();
        aboutSynchronized1.setA(10);
        AboutSynchronized aboutSynchronized2 = new AboutSynchronized();
        aboutSynchronized2.setA(100);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> aboutSynchronized1.func());
//        executorService.execute(() -> aboutSynchronized1.func());

//        executorService.execute(() -> aboutSynchronized2.func());
//        executorService.execute(() -> aboutSynchronized1.func());

        executorService.execute(() -> staticFunc());
        executorService.execute(() -> staticFunc());
        executorService.execute(() -> staticFunc());
    }
}
