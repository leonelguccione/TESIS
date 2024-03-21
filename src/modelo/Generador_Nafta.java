package modelo;

public class Generador_Nafta extends Generador implements Cloneable
{

    public Generador_Nafta(double consumo, double costo, int idCombustible, double productividad, String texto)
    {
        /**
         * Generador(int id_generador, String nombre_generador, double consumo,
         * double costo, int id_combustible, String nombre_combustible, double
         * productividad)
         * 
         *    
     *     private double item8ConsumoGen;
    private int item8Costo;
    private int item8Combustible;
    private double item8Productividad;
    private String item8Texto;
     */
      
        //super(2, "Carbon", 0.034, 20, 2, "Carbon", 0.416);
        //super(1, "Carbon", consumo, costo, 1, "Carbon", productividad);
        super(2, "Generador Nafta", consumo, costo, idCombustible, "Nafta", productividad, texto);
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        // TODO Implement this method
        return super.clone();
    }
}
