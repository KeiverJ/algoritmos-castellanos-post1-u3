package com.u3.lab1;

import java.util.Arrays;

/**
 * Tres implementaciones de Fibonacci para comparación empírica.
 *
 * <p>
 * Permite contrastar el impacto de la estrategia de diseño
 * (recursión ingenua vs Programación Dinámica) en el rendimiento real.
 */
public class Fibonacci {

    /**
     * Calcula el n-ésimo número de Fibonacci de forma recursiva ingenua.
     *
     * <p>
     * Complejidad temporal: O(2^n) — árbol de recursión con subproblemas
     * repetidos sin memoización.
     * Complejidad espacial: O(n) — profundidad máxima de la pila de llamadas.
     *
     * @param n índice del número de Fibonacci (n >= 0)
     * @return el n-ésimo número de Fibonacci
     * @throws StackOverflowError para n > ~10000
     */
    public static long fibRecursivo(int n) {
        if (n <= 1)
            return n;
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    /**
     * Calcula el n-ésimo número de Fibonacci con memoización top-down.
     *
     * <p>
     * Complejidad temporal: O(n) — cada subproblema se resuelve una sola vez.
     * Complejidad espacial: O(n) — arreglo memo de tamaño n+2 más pila de
     * recursión.
     *
     * @param n índice del número de Fibonacci (n >= 0)
     * @return el n-ésimo número de Fibonacci
     */
    public static long fibMemo(int n) {
        long[] memo = new long[n + 2];
        Arrays.fill(memo, -1L);
        return fibMemoHelper(n, memo);
    }

    /**
     * Auxiliar recursivo de fibMemo que usa el arreglo de memoización.
     *
     * @param n    índice actual
     * @param memo arreglo de resultados previamente calculados
     * @return el n-ésimo número de Fibonacci
     */
    private static long fibMemoHelper(int n, long[] memo) {
        if (n <= 1)
            return n;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
        return memo[n];
    }

    /**
     * Calcula el n-ésimo número de Fibonacci con tabulación bottom-up.
     *
     * <p>
     * Complejidad temporal: O(n) — un único recorrido iterativo.
     * Complejidad espacial: O(1) — solo dos variables de estado prev1 y prev2.
     *
     * @param n índice del número de Fibonacci (n >= 0, n <= 92 sin desbordamiento)
     * @return el n-ésimo número de Fibonacci
     */
    public static long fibTabla(int n) {
        if (n <= 1)
            return n;
        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}