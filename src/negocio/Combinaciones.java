package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * En este ejemplo, la lista de números está representada por el arreglo
 * numeros. El valor de n representa la cantidad de números que se desean en
 * cada combinación.
 *
 * El método generarCombinaciones recibe estos parámetros y devuelve una lista
 * de listas de enteros (List<List<Integer>>) que representa todas las
 * combinaciones posibles.
 *
 * La implementación de la recursión se encuentra en el método privado
 * generarCombinaciones. En cada llamada recursiva, se agregan los números de la
 * lista numeros a la combinación actual (combinacionActual) y se continúa la
 * recursión para el siguiente índice. Cuando se ha alcanzado la cantidad
 * deseada de números en la
 */
public class Combinaciones {

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int n = 3;

        List<List<Integer>> combinaciones = generarCombinaciones(numeros, n);

        for (List<Integer> combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }

    public static List<List<Integer>> generarCombinaciones(int[] numeros, int n) {
        List<List<Integer>> combinaciones = new ArrayList<>();
        List<Integer> combinacionActual = new ArrayList<>();

        //generarCombinaciones(numeros, n, 0, combinacionActual, combinaciones);
        generarTodasCombinaciones(numeros, 0, combinacionActual, combinaciones);

        return combinaciones;
    }

    /**
     * Generar las combinaciones de m tomados de a n.
     *
     * @param numeros
     * @param n
     * @param indice
     * @param combinacionActual
     * @param combinaciones
     */
    private static void generarCombinaciones(int[] numeros, int n, int indice, List<Integer> combinacionActual, List<List<Integer>> combinaciones) {
        if (combinacionActual.size() == n) {
            combinaciones.add(new ArrayList<>(combinacionActual));
            return;
        }

        for (int i = indice; i < numeros.length; i++) {
            combinacionActual.add(numeros[i]);
            generarCombinaciones(numeros, n, i + 1, combinacionActual, combinaciones);
            combinacionActual.remove(combinacionActual.size() - 1);
        }
    }

    private static void generarTodasCombinaciones(int[] numeros, int indice, List<Integer> combinacionActual, List<List<Integer>> combinaciones) {
        int m = numeros.length; //cantidad de recursos
        int n = 0;
        for (n = 1; n <= m; n++) {
            generarCombinaciones(numeros, n, indice, combinacionActual, combinaciones);
        }
    }
}
