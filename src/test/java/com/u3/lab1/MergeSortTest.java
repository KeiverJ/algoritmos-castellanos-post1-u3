package com.u3.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para MergeSort con JUnit 5.
 * Verifica correctitud en casos borde y casos generales.
 */
class MergeSortTest {

    @Test
    void testArregloVacio() {
        int[] arr = {};
        MergeSort.sort(arr);
        assertArrayEquals(new int[] {}, arr);
    }

    @Test
    void testArregloUnElemento() {
        int[] arr = { 42 };
        MergeSort.sort(arr);
        assertArrayEquals(new int[] { 42 }, arr);
    }

    @Test
    void testArregloYaOrdenado() {
        int[] arr = { 1, 2, 3, 4, 5 };
        MergeSort.sort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    void testArregloOrdenInverso() {
        int[] arr = { 5, 4, 3, 2, 1 };
        MergeSort.sort(arr);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arr);
    }

    @Test
    void testArregloConDuplicados() {
        int[] arr = { 3, 1, 4, 1, 5, 9, 2, 6, 5 };
        MergeSort.sort(arr);
        assertArrayEquals(new int[] { 1, 1, 2, 3, 4, 5, 5, 6, 9 }, arr);
    }
}