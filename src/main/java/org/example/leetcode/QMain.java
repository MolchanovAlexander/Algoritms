package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QMain {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();
        queue.add(1);
        queue.add(1);
        queue.add(2);
        queue2.add(1);
        queue2.add(2);
        queue2.add(78);
        queue.offerFirst(null);
        //System.out.println(queue.remove());
        int size = queue.size();

        for (int i = 0; i < size ; i++) {

            System.out.println(queue.remove());
            System.out.println(queue);
        }
        //System.out.println(queue);
    }
}
