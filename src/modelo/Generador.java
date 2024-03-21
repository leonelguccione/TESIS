package modelo;

public class Generador implements Cloneable
{

    private int id_generador;
    private String nombre_generador;
    private double consumo;
    private double costo;
    private int id_combustible;
    private String nombre_combustible;
    private double productividad;
    private double produccion_maxima;
    private String texto;
    

    public Generador(int id_generador, String nombre_generador, double consumo, double costo, int id_combustible,
                     String nombre_combustible, double productividad, String texto)
    {
        this.id_generador = id_generador;
        this.nombre_generador = nombre_generador;
        this.consumo = consumo;
        this.costo = costo;
        this.id_combustible = id_combustible;
        this.nombre_combustible = nombre_combustible;
        this.productividad = productividad;
        this.texto = texto;
    }

    public int getId_generador()
    {
        return id_generador;
    }

    public void setId_generador(int id_generador)
    {
        this.id_generador = id_generador;
    }

    public String getNombre_generador()
    {
        return nombre_generador;
    }

    public void setNombre_generador(String nombre_generador)
    {
        this.nombre_generador = nombre_generador;
    }

    public String getNombre_combustible()
    {
        return nombre_combustible;
    }

    public void setNombre_combustible(String nombre_combustible)
    {
        this.nombre_combustible = nombre_combustible;
    }

    public double getConsumo()
    {
        return consumo;
    }

    public void setConsumo(double consumo)
    {
        this.consumo = consumo;
    }

    public double getCosto()
    {
        return costo;
    }

    public void setCosto(double costo)
    {
        this.costo = costo;
    }

    public int getId_combustible()
    {
        return id_combustible;
    }

    public void setId_combustible(int id_combustible)
    {
        this.id_combustible = id_combustible;
    }

    public double getProductividad()
    {
        return productividad;
    }

    public void setProductividad(double productividad)
    {
        this.productividad = productividad;
    }

    public double getProduccionMaxima(double cant_combustible)
    {
        this.produccion_maxima = (getProductividad() * cant_combustible / getConsumo()) - getCosto();
        return produccion_maxima;
    }

    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    public String getTexto()
    {
        return texto;
    }

    /**
     * private int id_generador; private String nombre_generador; private double
     * consumo; private double costo; private int id_combustible; private String
     * nombre_combustible; private double productividad; private int
     * id_ubicacion;
     *
     * @return
     */
    public String toString2()
    {
        return "Generador{" + "id_generador=" + id_generador + ", nombre_generador='" + nombre_generador + '\'' +
               ", consumo=" + consumo + ", costo=" + costo + ", id_combustible=" + id_combustible +
               ", nombre_combustible='" + nombre_combustible + '\'' + ", productividad=" + productividad +
               ", id_ubicacion=" + ", produccion_maxima=" + produccion_maxima + '}';
    }

    @Override
    public String toString()
    {
        // TODO Implement this method
        return nombre_generador;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        // TODO Implement this method
        return super.clone();
    }
}
