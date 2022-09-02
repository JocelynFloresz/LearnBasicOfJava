package com.cyy.javabox.basic_of_thread.DeepInSynchronized;

/**
 * @author yinyichen
 * @date 2022/9/2 15:17
 */
    public class SynchronizedDemo2 {
    Object object = new Object();
    public void method1() {
        synchronized (object) {

        }
        method2();
    }
    private static void method2() {

    }
}