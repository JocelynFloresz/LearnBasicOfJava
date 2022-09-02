package com.cyy._00_DeclarePrograming;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(Arrays.asList(new Person("1", Gender.FEMALE),
                new Person("2", Gender.MALE),
                new Person("3", Gender.FEMALE),
                new Person("4", Gender.MALE),
                new Person("5", Gender.FEMALE)));
        //Imperative approach
        System.out.println("Imperative approach:");
        List<Person> females = new ArrayList<>();
        for (Person person: personList) {
            if (person.Gender.equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        //Declare approach
        System.out.println("\nDeclare approach:");
        personList.stream()
                .filter(person -> person.Gender.equals(Gender.FEMALE))
                .forEach(System.out::println);
    }

    enum Gender {
        MALE, FEMALE
    }

    @ToString
    @AllArgsConstructor
    static class Person {
        private final String Name;
        private final Gender Gender;
    }

}
