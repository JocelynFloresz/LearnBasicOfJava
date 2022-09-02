package com.cyy.javabox.basic_of_thread.createThread;

import org.elasticsearch.action.support.ThreadedActionListener;

/**
 * @author yinyichen
 * @date 2022/9/2 10:35
 */
public class SleepOrYieldOfThread implements Runnable {
    @Override
    public void run() {
//        Thread.yield();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
