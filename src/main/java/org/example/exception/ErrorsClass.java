package org.example.exception;

import java.util.LinkedList;
import java.util.List;

public class ErrorsClass {
    public static void main(String[] args) {
        //stackOver(0);
        outOfMem();
    }
    public static void stackOver(int start) {
        int o = start;
        o++;
        stackOver(o);
    }
    public static void outOfMem() {
        List<int[]> intList = new LinkedList<>();
        for (int i = 0; i < 40_000_000; i++) {
            intList.add(new int[100_000]);
        }
    }
}
