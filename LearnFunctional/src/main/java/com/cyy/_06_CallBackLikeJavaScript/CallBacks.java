package com.yyc.learnfunctionalprograming._06_CallBackLikeJavaScript;

import java.util.function.Consumer;

public class CallBacks {
    public static void main(String[] args) {
        hello("yichen", null, () -> System.out.println("Runnable Callbacking....."));
    }

    static void hello(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept("LastName is missing!");
        }
    }
}
