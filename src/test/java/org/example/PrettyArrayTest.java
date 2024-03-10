package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrettyArrayTest {
    int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7}; // pretty
    int[] arr2 = new int[]{1, 2, 2, 2, 2, 2}; // pretty
    int[] arr3 = new int[]{0, 2, 3, 4, 5, 6, 7}; // not pretty
    int[] arr4 = new int[]{4, 4, 4, 4, 4}; // not pretty
    @Test
    public void put_Ok_1() {
        boolean resultPretty1 = PrettyArray.isArrayPretty(arr1);
        assertEquals(true, resultPretty1 , "Wrong result - ");
    } @Test
    public void put_Ok_2() {
        boolean resultPretty1 = PrettyArray.isArrayPretty(arr2);
        assertTrue(resultPretty1, "Wrong result - ");
    }
    @Test
    void put_Not_Pretty_1() {
        boolean resultPretty1 = PrettyArray.isArrayPretty(arr3);
        assertFalse(resultPretty1, "Wrong result - ");
    }@Test
    void put_Not_Pretty_2() {
        boolean resultPretty1 = PrettyArray.isArrayPretty(arr4);
        assertFalse(resultPretty1, "Wrong result - ");
    }
}