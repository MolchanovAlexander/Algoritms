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
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        //List<Integer> bst = new ArrayList<>();
//        bst.insert(10);
//
//        bst.traverse();
        System.out.println( " start");
        for (int i = 0; i < 10_000_000;i++) {
            bst.insert(ThreadLocalRandom.current().nextInt(10_000_000));
            //bst.add(ThreadLocalRandom.current().nextInt(10_000_000));
        }
        var time = System.nanoTime();
        System.out.println(time / 1000 + " mkrsec");
        for (int i = 0; i < 10;i++) {
            bst.delete(ThreadLocalRandom.current().nextInt(10_000_000));
            System.out.println( " " + (System.nanoTime() - time) / 1000 + " mkrsec");
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