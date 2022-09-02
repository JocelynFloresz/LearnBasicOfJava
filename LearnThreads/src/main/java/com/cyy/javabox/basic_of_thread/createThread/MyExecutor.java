package com.cyy.javabox.basic_of_thread.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yinyichen
 * @date 2022/9/2 10:30
 */
public class MyExecutor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.execute(() -> System.out.println("in the thread " + Thread.currentThread().getName()));
        }
        service.shutdown();
    }
}
