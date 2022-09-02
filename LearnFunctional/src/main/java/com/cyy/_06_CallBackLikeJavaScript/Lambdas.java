package com.cyy._06_CallBackLikeJavaScript;

import java.util.function.BiFunction;

public class Lambdas {
    //在PSVM外可以有Static, 在PSMV里不可以有
    static BiFunction<String, Integer, String> upperCaseName = (name, age) -> {
        if (name.isBlank()) {
            throw new IllegalArgumentException("");
        }
        System.out.println(age);
        return name.toUpperCase();
    };

    public static void main(String[] args) {
        //int不可以为NULL
        int age = 0;
        Integer ageOfInteger = null;
        String result = upperCaseName.apply("yinyichen", ageOfInteger);
        System.out.println(result);
    }
}
