package com.cyy.javabox.basic_of_thread.createThread;

/**
 * @author yinyichen
 * @date 2022/9/2 10:00
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("In my Runnable");
    }
}
