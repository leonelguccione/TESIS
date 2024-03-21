package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import util.Combinaciones_de_Generadores;

public class Grupo_BG_Posibles_Ordenados implements I_Grupo_BG_Posibles_Ordenados
{
    private ArrayList<Banco_Generadores> gBGP;
    private int cantidad_combinaciones;
    private int cantidad_combinaciones_negativas;
    private int cantidad_combinaciones_positivas;


    public Grupo_BG_Posibles_Ordenados(List<Generador> lista_generadores, Double cant_nafta, Double cant_carbon)
    {
        gBGP = new ArrayList<Banco_Generadores>();
        List<List<Generador>> lista_lista_generadores_ordenados =
            Combinaciones_de_Generadores.generarTodasLasCombinaciones_todos_los_tamanos(lista_generadores, 3);
        //lista_lista_generadores_ordenados = Combinaciones_de_Generadores.generarTodasLasCombinaciones_todos_los_tamanos(lista_stock_generadores_dia, cantidad_slots);
        int cant_combinaciones = lista_lista_generadores_ordenados.size();
        int i = 0;
        List<Generador> generadores_de_un_banco;
        for (i = 0; i < cant_combinaciones; i++)
        {
            generadores_de_un_banco = lista_lista_generadores_ordenados.get(i);
            //public Banco_Generadores(List<Generador> lista_generadores, double cant_nafta, double cant_carbon)
            Banco_Generadores unBanco = new Banco_Generadores(generadores_de_un_banco, cant_nafta, cant_carbon);
            if (!existeBanco(unBanco))
            {
                gBGP.add(unBanco);
                if (unBanco.getProductividadMaxima() > 0)
                {
                    cantidad_combinaciones_positivas++;
                }
            }
        }
        this.cantidad_combinaciones = gBGP.size();
        cantidad_combinaciones_negativas = cantidad_combinaciones - cantidad_combinaciones_positivas;
        ordenarPorProductividad();
    }


    @Override
    public int getCant_Bancos_Productividad_Positiva()
    {
        return cantidad_combinaciones_positivas;
    }

    @Override
    public int getCant_Bancos_Productividad_Negativa()
    {
        return cantidad_combinaciones_negativas;
    }

    @Override
    public int getCant_Bancos_Productividad_Cero()
    {
        return 0;
    }

    @Override
    public void addBG(Banco_Generadores bg)
    {
        this.gBGP.add(bg);
    }


    private boolean existeBanco(Banco_Generadores newBanco)
    {
        boolean rta = false;
        Iterator<Banco_Generadores> iter_Banco = (Iterator<Banco_Generadores>) gBGP.iterator();
        while (iter_Banco.hasNext() && rta == false)
        {
            Banco_Generadores unBanco = (Banco_Generadores) iter_Banco.next();
            if (unBanco.equals(newBanco))
            {
                rta = true;
            }
        }
        return rta;
    }

    private void ordenarPorProductividad()
    {
        //TODO: ver si es de mayor a menor o al reves
        Collections.sort(gBGP, new Comparator<Banco_Generadores>()
        {
            @Override
            public int compare(Banco_Generadores i1, Banco_Generadores i2)
            {
                return Double.compare(i2.getProductividadMaxima(), i1.getProductividadMaxima());
            }
        });
    }

    @Override
    public Banco_Generadores getBanco_Productividad_Maxima()
    {
        return gBGP.get(0);
    }

    @Override
    public Banco_Generadores getBanco_Productividad_Minima()
    {
        int ultimo = gBGP.size() - 1;
        return gBGP.get(ultimo);
    }

    @Override
    public Banco_Generadores getBanco_Productividad_Cero()
    {
        return null;
    }

    @Override
    public int getOrdenBanco(Id_Banco_Generadores id_banco)
    {
        return 0;
    }

    @Override
    public int getCant_Bancos()
    {
        return 0;
    }
}
