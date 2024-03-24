package org.example.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainApp {

    /*
     * Video Reference: https://youtu.be/zIX3zQP0khM
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> collection = new BinarySearchTree<>();
       // RecursiveBinarySearchTree<Integer> collection = new RecursiveBinarySearchTree<>();
        //List<Integer> collection = new ArrayList<>();
//        bst.insert(10);
//
//        bst.traverse();
        System.out.println( " start");
        var limit = 10_000_000;
        for (int i = 0; i < limit; i++) {
            var let = ThreadLocalRandom.current().nextInt(limit);
            //collection.add(let);  // uncomment for list test
            collection.insert(let); // uncomment for BST test
        }
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            var let = ThreadLocalRandom.current().nextInt(limit);
            System.out.println("CONTAINS "
                    + let + " <-> "
                    + collection.contains(let) + "  __ "
                    + (System.nanoTime() - start) / 1000 + " mkrSec");
        }
//        System.out.println("Max is: " + bst.getMax());
//        System.out.println("Min is: " + bst.getMin());
//
//        System.out.println("Deleting 60 from Tree");
//        bst.delete(60);
//        System.out.println("New Max is: " + bst.getMax());
//        bst.traverse();

    }

}