package org.example.comparator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");

        // Step 2: Obtain an Iterator from the Set
        Iterator<String> iterator = set.iterator();

        // Step 3: Traverse the Set using the Iterator
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        Object a = List.of("1", "2");
        System.out.println(a.getClass().getSimpleName());
//        Comparable<String> sttrCom = new Comparable<String>(String o1, String o2) {
//            @Override
//            public int compareTo(o1) {
//                return 0;
//            }
//        }
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
