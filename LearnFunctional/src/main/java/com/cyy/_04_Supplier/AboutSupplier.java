package com.cyy._04_Supplier;

import java.util.List;
import java.util.function.Supplier;

public class AboutSupplier {
    public static void main(String[] args) {
        System.out.println(getConnectionUrl());
        System.out.println(getConnectionUrlOfSupplier.get());
    }
    static Supplier<List<String>> getConnectionUrlOfSupplier = () -> List.of("jdbc://localhost:2333?sys");
    static String getConnectionUrl() {
        return "jdbc://localhost:2333?sys";
    }
}
