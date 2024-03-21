package util;

import modelo.Generador;

import org.apache.commons.math3.util.CombinatoricsUtils;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinaciones_de_Generadores
{
    //private int capacidadGeneracion;
    // otros campos y métodos

    private static List<List<Generador>> generarCombinaciones_de_un_tamano(List<Generador> lista_generadores,
                                                                           int tamano_combinacion)
    {
        List<List<Generador>> combinaciones = new ArrayList<>();
        int cantidad_de_generadores = lista_generadores.size();
        tamano_combinacion = Math.min(tamano_combinacion, cantidad_de_generadores);

        long numCombinaciones = CombinatoricsUtils.binomialCoefficient(cantidad_de_generadores, tamano_combinacion);

        for (Iterator<int[]> it = CombinatoricsUtils.combinationsIterator(cantidad_de_generadores, tamano_combinacion);
             it.hasNext();)
        {
            int[] indices = it.next();
            List<Generador> combinacion = new ArrayList<>();
            for (int i : indices)
            {
                combinacion.add(lista_generadores.get(i));
            }
            combinaciones.add(combinacion);
        }

        return combinaciones;
    }

    public static List<List<Generador>> generarTodasLasCombinaciones_todos_los_tamanos(List<Generador> lista_generadores,
                                                                                       int n)
    {
        List<List<Generador>> todasCombinaciones = new ArrayList<>();

        for (int i = 1; i <= n; i++)
        {
            List<List<Generador>> combinacionesTamanoI = generarCombinaciones_de_un_tamano(lista_generadores, i);
            todasCombinaciones.addAll(combinacionesTamanoI);
        }

        return todasCombinaciones;
    }
}
