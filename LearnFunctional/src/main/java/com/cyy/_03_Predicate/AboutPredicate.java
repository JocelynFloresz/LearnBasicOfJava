package com.cyy._03_Predicate;

import java.util.function.Predicate;

public class AboutPredicate {
    public static void main(String[] args) {
        String string1 = "18075761585";//true
        String string2 = "18275761585";//false
        System.out.println("Predicate (谓词):");
        System.out.println(isPhoneNumberByPredicate.test(string1));
        System.out.println(isPhoneNumberByPredicate.test(string2));
        System.out.println("and (且):");
        System.out.println(isPhoneNumberByPredicateStep1.and(isPhoneNumberByPredicateStep2).test(string1));
        System.out.println(isPhoneNumberByPredicateStep1.and(isPhoneNumberByPredicateStep2).test(string2));
        System.out.println("or (或):");
        System.out.println(isPhoneNumberByPredicateStep1.or(isPhoneNumberByPredicateStep2).test(string1));
        System.out.println(isPhoneNumberByPredicateStep1.or(isPhoneNumberByPredicateStep2).test(string2));
        System.out.println("not (逻辑非):");
        System.out.println(Predicate.not(isPhoneNumberByPredicateStep1).test("123"));
        System.out.println(Predicate.not(isPhoneNumberByPredicateStep2).test(string2));
        System.out.println("isEqual( Equal里的值和Test()的值是否相等 ):");
        System.out.println(Predicate.isEqual(string1).test(string1));
        System.out.println(Predicate.isEqual(string1).test(string2));
        System.out.println("negate(相反):");
        System.out.println(isPhoneNumberByPredicateStep1.negate().test(string1));
        System.out.println(isPhoneNumberByPredicateStep1.negate().test(string2));
        System.out.println("POJO(原生类):");
        System.out.println(isPhoneNumber(string1));
        System.out.println(isPhoneNumber(string2));
    }

    static Predicate<String> isPhoneNumberByPredicate =
            string -> string.startsWith("180") && string.length() == 11;
    static Predicate<String> isPhoneNumberByPredicateStep1 =
            string -> string.startsWith("180");
    static Predicate<String> isPhoneNumberByPredicateStep2 =
            string -> string.length() == 11;
    static Boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber.startsWith("180") && phoneNumber.length() == 11;
    }
}
