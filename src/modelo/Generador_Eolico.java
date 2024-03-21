package modelo;

public class Generador_Eolico extends Generador implements Cloneable
{
    public Generador_Eolico(double consumo, double costo, int idCombustible, double productividad, String texto)
    {
        super(3, "Generador Eolico", consumo, costo, idCombustible, "Eolico", productividad, texto);
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        // TODO Implement this method
        return super.clone();
    }
}
