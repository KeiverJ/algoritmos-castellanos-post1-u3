package com.u3.lab1;

/**
 * Implementación de MergeSort — Divide y Vencerás.
 *
 * <p>
 * Complejidad temporal: Θ(n log n) en todos los casos.
 * Complejidad espacial: O(n) espacio auxiliar por el arreglo temporal
 * en cada llamada a merge.
 *
 * <p>
 * Recurrencia: T(n) = 2T(n/2) + O(n) → Θ(n log n) por Teorema Maestro
 * con a=2, b=2, f(n)=O(n), caso 2: f(n) = Θ(n^log_b(a)) = Θ(n).
 */
public class MergeSort {

    /**
     * Ordena el arreglo in-place usando MergeSort.
     *
     * @param arr arreglo de enteros (no nulo)
     * @post arr queda ordenado en forma no decreciente
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Divide recursivamente el subarreglo [lo, hi] y lo ordena.
     *
     * @param arr arreglo sobre el que se opera
     * @param lo  índice inferior del subarreglo (inclusivo)
     * @param hi  índice superior del subarreglo (inclusivo)
     * @pre 0 <= lo <= hi < arr.length
     * @post arr[lo..hi] queda ordenado en forma no decreciente
     */
    private static void mergeSort(int[] arr, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid); // T(n/2)
        mergeSort(arr, mid + 1, hi); // T(n/2)
        merge(arr, lo, mid, hi); // O(n)
    }

    /**
     * Combina dos subarreglos ordenados arr[lo..mid] y arr[mid+1..hi]
     * en un único subarreglo ordenado.
     *
     * @param arr arreglo que contiene ambos subarreglos
     * @param lo  inicio del primer subarreglo
     * @param mid fin del primer subarreglo
     * @param hi  fin del segundo subarreglo
     */
    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi)
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= hi)
            temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, lo, temp.length);
    }
}