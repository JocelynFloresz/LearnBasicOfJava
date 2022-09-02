package com.cyy.javabox.basic_of_thread.createThread;

/**
 * @author yinyichen
 * @date 2022/9/2 10:24
 */
public class InheritFromThread extends Thread {
    public void run() {
        System.out.println("hello thread!");
    }

    public static void main(String[] args) {
        InheritFromThread thread = new InheritFromThread();
        thread.run();
    }
}
