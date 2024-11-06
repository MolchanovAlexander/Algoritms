package org.example.comparator;

public class MainIter {
    public static void main(String[] args) {
        MyListFor<String> myList = new MyListFor<>();
        myList.add("one");
        myList.add("two");
        myList.add("three");

        MyList<String> myList2 = new MyList<>();
        myList2.add("one1");
        myList2.add("two2");
        myList2.add("three3");

        // Using myForEach to print each element
        myList.myForEach(System.out::println);
        myList2.myForEach(System.out::println);
    }
}
