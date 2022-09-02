package com.cyy.javabox.basic_of_thread.mutually_exclusive;

/**
 * @author yinyichen
 * @date 2022/9/2 13:41
 */
public class JoinExample {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("Thread A is running");
        }
    }

    private class B extends Thread {
        private A a;

        public B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread B is running");
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }
}
