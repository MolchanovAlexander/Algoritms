package org.example;

class AddTwoNumbers {
    public static Node top;

    public static Node addTwoNumbers(Node list1, Node list2) {
        top = null;
        int res = process(list1) + process(list2);
        char[] nextValue = String.valueOf(res).toCharArray();
        for (char ch : nextValue) {
            push(ch - '0');
        }
        return top;
    }
    public static int process(Node node) {
        StringBuilder sum1 = new StringBuilder();
        while (node != null) {
            sum1.append(node.data);
            node = node.next;
        }
       return Integer.parseInt(sum1.reverse().toString());
    }

    public static void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
}
