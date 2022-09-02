package com.cyy.javabox.basic_of_thread.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yinyichen
 * @date 2022/9/2 11:19
 */
public class InterruptExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdownNow();
    }
}
