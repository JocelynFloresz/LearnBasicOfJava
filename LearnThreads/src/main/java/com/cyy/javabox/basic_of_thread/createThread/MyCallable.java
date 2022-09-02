package com.cyy.javabox.basic_of_thread.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yinyichen
 * @date 2022/9/2 10:00
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("In my Callable !");
        return "This is result of Callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> target = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(target);
        System.out.println("Thread has started!");
        thread.start();
        System.out.println(target.get());
    }
}
