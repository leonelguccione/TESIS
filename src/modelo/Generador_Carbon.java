package modelo;

public class Generador_Carbon extends Generador implements Cloneable
{

    public Generador_Carbon(double consumo, double costo, int idCombustible, double productividad, String texto)
    {
        super(3, "Generador Carbon", consumo, costo, idCombustible, "Carbon", productividad, texto);
    }

    @Override
    public String toString()
    {
        String texto = "Generador Carbon" + getProductividad();
        return super.toString();
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
