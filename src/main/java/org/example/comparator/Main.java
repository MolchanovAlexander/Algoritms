package org.example.comparator;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Create a PriorityQueue with the ReversePersonAgeComparator
        PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) ->Integer.compare(p2.getAge(), p1.getAge()));
        //PriorityQueue<Person> pq = new PriorityQueue<>(new PersonAgeComparator());

        pq.add(new Person("Alice", 30));
        pq.add(new Person("Bob", 25));
        pq.add(new Person("Charlie", 35));

        // The head of the queue is the person with the highest age
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
