package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SupermarketQueue {
    public static int calculateTotalTime(int[] customers, int checkout) {
        if (customers.length == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i : customers) {
            queue.add(i);
        }
        int time = 0;
        int filter0 = 0;
        int forLength = Math.min(customers.length, checkout);
        boolean exit = true;
        int[] newArr = new int[forLength];
        while (exit) {
            for (int a = 0; a < newArr.length; a++) {
                if (newArr[a] == 0 && !queue.isEmpty()) {
                    newArr[a] = queue.poll();
                }
                newArr[a]--;
            }
            time++;
            for (int i : newArr) {
                if (i <= 0) {
                    filter0++;
                }
            }
            if (filter0 >= newArr.length && queue.isEmpty()) {
                exit = false;
            }
            filter0 = 0;
        }
        return time;
    }
}
