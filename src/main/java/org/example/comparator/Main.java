package org.example.comparator;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Create a PriorityQueue with the ReversePersonAgeComparator
        PriorityQueue<Person> pq = new PriorityQueue<>(new ReversePersonAgeComparator());

        pq.add(new Person("Alice", 30));
        pq.add(new Person("Bob", 25));
        pq.add(new Person("Charlie", 35));

        // The head of the queue is the person with the highest age
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
