package org.example.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        System.out.println("Before sorting:");
        for (Person person : people) {
            System.out.println(person);
        }
        Collections.sort(people, Comparator.reverseOrder());

        System.out.println("\nAfter sorting:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
