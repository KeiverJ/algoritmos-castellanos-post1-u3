package com.u3.lab1;

/**
 * Clase principal para demostración rápida de los algoritmos.
 * Para benchmarks formales usar BenchmarkFibonacci con JMH.
 */
public class Main {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("=== MergeSort ===");
        int[] arr = { 5, 2, 8, 1, 9, 3 };
        MergeSort.sort(arr);
        System.out.print("Ordenado: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        System.out.println("\n=== Fibonacci ===");
        int[] valores = { 10, 20, 30, 35 };
        for (int n : valores) {
            System.out.printf("fib(%d) recursivo=%d | memo=%d | tabla=%d%n",
                    n,
                    Fibonacci.fibRecursivo(n),
                    Fibonacci.fibMemo(n),
                    Fibonacci.fibTabla(n));
        }
    }
}