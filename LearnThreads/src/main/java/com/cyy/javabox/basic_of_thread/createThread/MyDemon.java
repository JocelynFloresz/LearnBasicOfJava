package com.cyy.javabox.basic_of_thread.createThread;

/**
 * @author yinyichen
 * @date 2022/9/2 10:33
 */
public class MyDemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
    }
}
