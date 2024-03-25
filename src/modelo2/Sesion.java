package modelo2;

import java.util.Date;

public class Sesion
{
    Escenario EIC1;
    Escenario EDC1;
    Escenario ERC1;
    Escenario EPC1;
    
    private int id_sesion;
    private Date fecha;
    private int id_alumno;
    private int escenario_asignado;
    private int escenario_recomendado;
    private String calificacion_difusa;
    private boolean jugado;
    
    private String[] escenarioAsignado = {"Sin Asignar", "E1-desaprueba", "E2-repasa", "E3-promueve"};
    private String[] escenarioRecomendado = {"Sin Recomendar", "E1-desaprueba", "E2-repasa", "E3-promueve"};
   
    public Sesion()
    {

    }

    public Sesion(Date fecha, int id_alumno, int escenario_asignado, String calificacion_difusa, boolean jugado)
    {
        this.fecha = fecha;
        this.id_alumno = id_alumno;
        this.escenario_asignado = escenario_asignado;
        this.calificacion_difusa = calificacion_difusa;
        this.jugado = jugado;
        this.escenario_recomendado = 0;        
    }

    public Sesion(int id_alumno)
    {
        this(new Date(), id_alumno, 1, "sin calificar", false);
        this.id_alumno = id_alumno;
    }
    
    public void setId_sesion(int id_sesion)
    {
        this.id_sesion = id_sesion;
    }

    public int getId_sesion()
    {
        return id_sesion;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setId_alumno(int id_alumno)
    {
        this.id_alumno = id_alumno;
    }

    public int getId_alumno()
    {
        return id_alumno;
    }

    public void setEscenario_asignado(int escenario_asignado)
    {
        this.escenario_asignado = escenario_asignado;
    }

    public int getEscenario_asignado()
    {
        return escenario_asignado;
    }

    public String getEscenarioAsignado()
    {
        return escenarioAsignado[escenario_asignado];
    }

    public void setEscenario_recomendado(int escenario_recomendado)
    {
        this.escenario_recomendado = escenario_recomendado;
    }

    public int getEscenario_recomendado()
    {
        return escenario_recomendado;
    }
    
    public String getEscenarioRecomendado()
    {
        return escenarioRecomendado[escenario_recomendado];
    }

    public void setCalificacion_difusa(String calificacion_difusa)
    {
        this.calificacion_difusa = calificacion_difusa;
    }

    public String getCalificacion_difusa()
    {
        return calificacion_difusa;
    }

    public void setJugado(boolean jugado)
    {
        this.jugado = jugado;
    }

    public boolean isJugado()
    {
        return jugado;
    }


    @Override
    public String toString()
    {
        String jugada = "No jugada aún";
        if (isJugado())
            jugada = "Ya ha sido jugada";
        return "Nro: "+getId_sesion() + ". "+jugada;
    }
}
