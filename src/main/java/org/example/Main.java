package org.example;

public class Main {
    public static void main(String[] args) {
//        System.out.println(LevenshteinDistance.distance("abcdef", "azcde"));
//        int[] customers = new int[]{2, 2, 3, 3, 4, 4}; // if checkout - 2 - res - 9
//        System.out.println(SupermarketQueue.calculateTotalTime(customers, 6));
        Stack2<String> newStack = new Stack2();
        System.out.println(newStack.isEmpty());
        newStack.push("guf0");
        newStack.push("guf1");
        newStack.push("guf2");
        newStack.push("guf3");
        System.out.println(newStack.pop());
        System.out.println(newStack.peek());
        System.out.println(newStack.isEmpty());
        System.out.println(newStack.size());

    }
}