package modelo;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * una opcion de elección de generadores
 */
public class Banco_Generadores implements I_Banco_Generadores
{

    private List<Generador> lista_generadores;
    private int cant_gen_carbon;
    private int cant_gen_nafta;
    private int cant_gen_eolico;
    private double cant_nafta;
    private double cant_carbon;
    private double productividadMaxima;
    private int cant_gen;
    Id_Banco_Generadores id_banco_generadores;

    public Banco_Generadores(int cant_gen_carbon, int cant_gen_nafta, int cant_gen_eolico)
    {
        this.cant_gen_carbon = cant_gen_carbon;
        this.cant_gen_nafta = cant_gen_nafta;
        this.cant_gen_eolico = cant_gen_eolico;
        id_banco_generadores = new Id_Banco_Generadores(cant_gen_carbon, cant_gen_nafta, cant_gen_eolico);
        this.cant_gen = cant_gen_nafta + cant_gen_carbon + cant_gen_eolico;
        //productividadMaxima = calcularProductividadMaxima();
    }

    public Banco_Generadores(List<Generador> lista_generadores, double cant_carbon, double cant_nafta)
    {
        assert lista_generadores != null : "La lista de generadores no puede ser nula.";
        assert cant_nafta >= 0 : "La cantidad de nafta debe ser un valor no negativo.";
        assert cant_carbon >= 0 : "La cantidad de carbón debe ser un valor no negativo.";

        this.lista_generadores = lista_generadores;
        cant_gen_nafta = contarGeneradores("Nafta");
        cant_gen_carbon = contarGeneradores("Carbon");
        cant_gen_eolico = contarGeneradores("Eolico");
        this.cant_nafta = cant_nafta;
        this.cant_carbon = cant_carbon;
        this.cant_gen = cant_gen_nafta + cant_gen_carbon + cant_gen_eolico;
        productividadMaxima = calcularProductividadMaxima();
        id_banco_generadores = new Id_Banco_Generadores(cant_gen_carbon, cant_gen_nafta, cant_gen_eolico);
    }

    public Id_Banco_Generadores getId_banco_generadores()
    {
        return id_banco_generadores;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id_banco_generadores);
    }

    public void add(Generador unGenerador)
    {
        lista_generadores.add(unGenerador);
    }

    /**
     *
     * @return cantidad de generadores de un determinado tipo
     */
    private int contarGeneradores(String nombre_generador)
    {
        //int cantidad = (int)lista_generadores.stream().filter(p->p.getNombre_generador()==nombre_generador).count();

        int cantidad = 0;
        Iterator iter_lista_generadores = lista_generadores.iterator();
        while (iter_lista_generadores.hasNext())
        {
            Generador unGenerador = (Generador) iter_lista_generadores.next();
            if (unGenerador.getNombre_generador().equals(nombre_generador))
            {
                cantidad++;
            }
        }
        return cantidad;
    }


    //TODO: calcular productividad del generador
    public double calcularProductividadMaxima()
    {
        double nafta_x_generador = cant_nafta / cant_gen_nafta;
        double carbon_x_generador = cant_carbon / cant_gen_carbon;
        Iterator iter_generadores = lista_generadores.iterator();
        double productividad = 0;
        Generador unGenerador;
        double combustible = 0;
        while (iter_generadores.hasNext())
        {
            unGenerador = (Generador) iter_generadores.next();
            if (unGenerador.getNombre_combustible().equals("Nafta"))
            {
                combustible = nafta_x_generador;
            }
            else if (unGenerador.getNombre_combustible().equals("Carbon"))
            {
                combustible = carbon_x_generador;
            }
            productividad = productividad + unGenerador.getProduccionMaxima(combustible);
        }
        return productividad;
    }

    public List<Generador> getLista_generadores()
    {
        return lista_generadores;
    }

    public double getProductividadMaxima()
    {
        return productividadMaxima;
    }

    public void setLista_generadores(List<Generador> lista_generadores)
    {
        this.lista_generadores = lista_generadores;
    }

    public void setCant_gen_nafta(int cant_gen_nafta)
    {
        this.cant_gen_nafta = cant_gen_nafta;
    }

    public int getCant_gen_nafta()
    {
        return cant_gen_nafta;
    }

    public void setCant_gen_carbon(int cant_gen_carbon)
    {
        this.cant_gen_carbon = cant_gen_carbon;
    }

    public int getCant_gen_carbon()
    {
        return cant_gen_carbon;
    }

    public void setCant_gen_eolico(int cant_gen_eolico)
    {
        this.cant_gen_eolico = cant_gen_eolico;
    }

    public int getCant_gen_eolico()
    {
        return cant_gen_eolico;
    }

    public void setCant_nafta(double cant_nafta)
    {
        this.cant_nafta = cant_nafta;
    }

    public double getCant_nafta()
    {
        return cant_nafta;
    }

    public void setCant_carbon(double cant_carbon)
    {
        this.cant_carbon = cant_carbon;
    }

    public double getCant_carbon()
    {
        return cant_carbon;
    }

    public void setProductividadMaxima(double productividadMaxima)
    {
        this.productividadMaxima = productividadMaxima;
    }

    public void setCant_gen(int cant_gen)
    {
        this.cant_gen = cant_gen;
    }

    public int getCant_gen()
    {
        return cant_gen;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Banco_Generadores))
        {
            return false;
        }
        Banco_Generadores that = (Banco_Generadores) o;
        return id_banco_generadores.equals(that.id_banco_generadores);
    }

    @Override
    public String toString()
    {
        return "Banco: " + getId_banco_generadores() + ", productividadMaxima=" + productividadMaxima + ", cant_gen=" +
               cant_gen + "\n";
    }

}
