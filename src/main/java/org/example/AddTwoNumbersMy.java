package org.example;

import java.util.LinkedList;

class AddTwoNumbersMy {
    public static Node top = null;
    public static Node first;
    public static Node second;

    public static Node addTwoNumbers(Node list1, Node list2) {
        top = null;
        first = list1;
        second = list2;
        LinkedList<Integer> fres = new LinkedList<>();
        while (first != null) {
            fres.add(first.data);
            first = first.next;
        }
        LinkedList<Integer> sres = new LinkedList<>();
        while (second != null) {
            sres.add(second.data);
            second = second.next;
        }
        StringBuilder sum1 = new StringBuilder();
        StringBuilder sum2 = new StringBuilder();
        for (int i : fres) {
            sum1.append(i);
        }
        for (int i : sres) {
            sum2.append(i);
        }
        int res = Integer.parseInt(sum1.reverse().toString())
                + Integer.parseInt(sum2.reverse().toString());
        char[] nextValue = String.valueOf(res).toCharArray();
        for (char ch : nextValue) {
            push(ch - '0');
        }
        return top;
    }

    public static void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;

    }
}
