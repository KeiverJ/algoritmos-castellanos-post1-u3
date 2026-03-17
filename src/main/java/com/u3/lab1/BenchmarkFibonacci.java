package com.u3.lab1;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

/**
 * Benchmark JMH para comparar las tres variantes de Fibonacci.
 *
 * <p>
 * Mide el tiempo promedio de ejecución para n = {10, 20, 30, 35}.
 * Se excluye fibRecursivo para n > 35 porque su complejidad O(2^n)
 * haría que cada iteración tardara varios segundos, excediendo el
 * presupuesto de tiempo del benchmark.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class BenchmarkFibonacci {

    /**
     * Valores de n evaluados en el benchmark.
     * Se limita a n <= 35 para fibRecursivo por su crecimiento O(2^n).
     */
    @Param({ "10", "20", "30", "35" })
    public int n;

    /**
     * Benchmark de Fibonacci recursivo ingenuo — O(2^n).
     *
     * @return el n-ésimo número de Fibonacci
     */
    @Benchmark
    public long recursivo() {
        return Fibonacci.fibRecursivo(n);
    }

    /**
     * Benchmark de Fibonacci con memoización top-down — O(n).
     *
     * @return el n-ésimo número de Fibonacci
     */
    @Benchmark
    public long memoizacion() {
        return Fibonacci.fibMemo(n);
    }

    /**
     * Benchmark de Fibonacci con tabulación bottom-up — O(n), O(1) espacio.
     *
     * @return el n-ésimo número de Fibonacci
     */
    @Benchmark
    public long tabulacion() {
        return Fibonacci.fibTabla(n);
    }
}