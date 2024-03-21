package modelo;

public class Bateria
{

    /**
     * capacidad medida en Amperes. No tiene costo.
     */
    Double capacidad;

    public Bateria(Double capacidad)
    {
        this.capacidad = capacidad;
    }

    public Double getCapacidad()
    {
        return capacidad;
    }

    public void setCapacidad(Double capacidad)
    {
        this.capacidad = capacidad;
    }
}
