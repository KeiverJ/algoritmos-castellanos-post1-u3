package com.u3.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para las tres variantes de Fibonacci con JUnit 5.
 * Verifica que las tres implementaciones producen resultados idénticos.
 */
class FibonacciTest {

    @Test
    void testCasosBase() {
        assertEquals(0L, Fibonacci.fibRecursivo(0));
        assertEquals(0L, Fibonacci.fibMemo(0));
        assertEquals(0L, Fibonacci.fibTabla(0));

        assertEquals(1L, Fibonacci.fibRecursivo(1));
        assertEquals(1L, Fibonacci.fibMemo(1));
        assertEquals(1L, Fibonacci.fibTabla(1));
    }

    @Test
    void testN2() {
        assertEquals(1L, Fibonacci.fibRecursivo(2));
        assertEquals(1L, Fibonacci.fibMemo(2));
        assertEquals(1L, Fibonacci.fibTabla(2));
    }

    @Test
    void testN5() {
        assertEquals(5L, Fibonacci.fibRecursivo(5));
        assertEquals(5L, Fibonacci.fibMemo(5));
        assertEquals(5L, Fibonacci.fibTabla(5));
    }

    @Test
    void testN10() {
        assertEquals(55L, Fibonacci.fibRecursivo(10));
        assertEquals(55L, Fibonacci.fibMemo(10));
        assertEquals(55L, Fibonacci.fibTabla(10));
    }

    @Test
    void testN20() {
        assertEquals(6765L, Fibonacci.fibRecursivo(20));
        assertEquals(6765L, Fibonacci.fibMemo(20));
        assertEquals(6765L, Fibonacci.fibTabla(20));
    }

    @Test
    void testN30() {
        assertEquals(832040L, Fibonacci.fibRecursivo(30));
        assertEquals(832040L, Fibonacci.fibMemo(30));
        assertEquals(832040L, Fibonacci.fibTabla(30));
    }

    @Test
    void testTabla92SinDesbordamiento() {
        assertEquals(7540113804746346429L, Fibonacci.fibTabla(92));
    }
}