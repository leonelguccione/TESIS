package modelo;

import modelo.DatoEvento.I_DatoEvento;

import java.sql.Timestamp;

public class Evento
{
    private int id_evento;
    private Timestamp hora;
    private int tipo_evento;
    private String titulo;    
    private String datos;
    protected I_DatoEvento datoEvento;
    private int id_sesion;

    public Evento()
    {
        super();
        
    }

    public I_DatoEvento getDatoEvento()
    {
        return datoEvento;
    }
    
    public  void setDatoEvento(I_DatoEvento datoEvento)
    {
        this.datoEvento = datoEvento;
    }

    public void setDatos(String datos)
    {
        this.datos = datos;
    }

    public String getDatos()
    {
        return datos;
    }

    public void setHora(Timestamp hora)
    {
        this.hora = hora;
    }

    public Timestamp getHora()
    {
        return hora;
    }

    

    public void setId_sesion(int id_sesion)
    {
        this.id_sesion = id_sesion;
    }

    public int getId_sesion()
    {
        return id_sesion;
    }

    public void setTipo_evento(int tipo_evento)
    {
        this.tipo_evento = tipo_evento;
    }

    public int getTipo_evento()
    {
        return tipo_evento;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    @Override
    public String toString()
    {

        return "Evento:" + tipo_evento + ", titulo='" + titulo + '\'' + "    {" + "datos='" + datos + '\'' + ", hora=" +
               hora + ", id_alumno="  + ", id_sesion=" + id_sesion + ", tipo_evento=" + tipo_evento +
               ", titulo='" + titulo + '\'' + ", datoEvento=" + datoEvento + '}';
    }
}
