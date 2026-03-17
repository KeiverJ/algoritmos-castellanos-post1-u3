# Estrategias de Diseño de Algoritmos — Lab 1

**Curso:** Diseño de Algoritmos y Sistemas — Unidad 3  
**Actividad:** Post-Contenido 1  
**Programa:** Ingeniería de Sistemas — Universidad de Santander (UDES)  
**Año:** 2026

---

## Descripción

Se implementa MergeSort como ejemplo canónico de Divide y Vencerás,
y tres variantes de Fibonacci como estudio comparativo de Programación
Dinámica. Se mide empíricamente el comportamiento de complejidad con
JMH y se correlacionan los resultados con el análisis teórico.

---

## Requisitos

- Java 17+
- Maven 3.8+

```bash
java --version
mvn --version
```

---

## Instrucciones de build y ejecución

```bash
# 1. Clonar el repositorio
git clone https://github.com/<usuario>/algoritmos-castellanos-post1-u3.git
cd algoritmos-castellanos-post1-u3

# 2. Compilar y ejecutar tests
mvn clean test

# 3. Empaquetar
mvn clean package -q

# 4. Ejecutar benchmark JMH
java -jar target/benchmarks.jar -rf json -rff benchmark-results.json
```

---

## Estructura del proyecto

```
algoritmos-castellanos-post1-u3/
├── pom.xml
├── README.md
├── results/
│   └── benchmark-results.json
└── src/
    ├── main/java/com/u3/lab1/
    │   ├── MergeSort.java
    │   ├── Fibonacci.java
    │   ├── BenchmarkFibonacci.java
    │   └── Main.java
    └── test/java/com/u3/lab1/
        ├── MergeSortTest.java
        └── FibonacciTest.java
```

---

## MergeSort — Divide y Vencerás

MergeSort divide el arreglo en dos mitades, las ordena recursivamente
y las combina. Su recurrencia es T(n) = 2T(n/2) + O(n), que por el
Teorema Maestro con a=2, b=2, f(n)=O(n) corresponde al caso 2,
resolviendo en Θ(n log n) en todos los casos. Los 5 tests JUnit 5
pasan correctamente verificando arreglo vacío, un elemento, ya
ordenado, orden inverso y con duplicados.

---

## Fibonacci — Comparación de estrategias

### Resultados JMH

Tiempos promedio en microsegundos (μs/op), 5 mediciones por configuración.

| n   | Recursivo (μs) | Memoización (μs) | Tabulación (μs) |
| --- | -------------- | ---------------- | --------------- |
| 10  | 0.164          | 0.031            | 0.003           |
| 20  | 20.741         | 0.067            | 0.004           |
| 30  | 2563.277       | 0.113            | 0.005           |
| 35  | 28539.775      | 0.099            | 0.005           |

### Interpretación de resultados

Los resultados empíricos confirman con precisión las complejidades
teóricas de cada variante. El método recursivo ingenuo crece de forma
exponencial O(2^n): de n=10 a n=20 el tiempo se multiplica por ~126x
(de 0.164 a 20.741 μs), y de n=20 a n=30 por ~123x (de 20.741 a
2563.277 μs), comportamiento consistente con la duplicación esperada
de un árbol de recursión donde cada nodo genera dos llamadas
adicionales sin reutilizar subproblemas ya resueltos.

La variante con memoización top-down O(n) muestra crecimiento lineal
moderado: de 0.031 μs en n=10 a 0.113 μs en n=30, un factor de
~3.6x para un incremento de 3x en n, ligeramente por encima de la
predicción teórica debido al overhead de inicializar y consultar el
arreglo memo en cada llamada. La ligera caída de n=30 a n=35 se
atribuye a efectos de compilación JIT que optimiza el código tras el
calentamiento.

La tabulación bottom-up O(n) con O(1) espacio es consistentemente
la más rápida: mantiene tiempos entre 0.003 y 0.005 μs para todos
los valores de n evaluados. El crecimiento es casi imperceptible
porque el loop iterativo sin overhead de recursión ni allocación de
arreglo auxiliar permite que el JIT optimice el código al máximo.

La razón por la que fibRecursivo no se prueba para n > 40 es que
su tiempo de ejecución crece como O(2^n): para n=40 tomaría
aproximadamente 28539 × 2^5 ≈ 913.000 μs (~0.9 segundos) por
operación, haciendo inviable el benchmark y los tests unitarios.

---

## Conclusión

La elección de estrategia de diseño tiene un impacto drástico en el
rendimiento: para n=35, tabulación (0.005 μs) es aproximadamente
5.7 millones de veces más rápida que recursión ingenua (28539 μs).
Dos algoritmos que resuelven el mismo problema pueden diferir en
órdenes de magnitud dependiendo de si reutilizan o no los
subproblemas ya calculados.
