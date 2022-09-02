package com.yyc.learnfunctionalprograming._01_Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AboutFunction {
    public static void main(String[] args) {
        System.out.println(increment(1));
        System.out.println(incrementFunction.apply(1));
        System.out.println(incrementAndMultipleFunction.apply(1, 10));
        //*
        System.out.println(incrementFunction.andThen(multipleFunction).apply(1));
    }

    public static BiFunction<Integer, Integer, Integer> incrementAndMultipleFunction = (i, j) -> (i + 1)*j;
    public static Function<Integer, Integer> incrementFunction = i -> i + 1;
    public static Function<Integer, Integer> multipleFunction = i -> i * 10;
    static int increment(int i) {
        return i + 1;
    }
}
