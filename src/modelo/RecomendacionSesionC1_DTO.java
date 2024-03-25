/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import modelo2.Escenario;

/**
 *
 * @author leonel
 */
public class RecomendacionSesionC1_DTO
{
    Escenario escenario_asignado;
    double calificacionPromedioSesion;
    String calificacionDifusa;
    Escenario escenario_recomendado;
    double recEDC1;
    double recERC1;
    double recEPC1;

    public RecomendacionSesionC1_DTO()
    {
    }
    
    

    public RecomendacionSesionC1_DTO(Escenario escenario_asignado, double calificacionPromedioSesion, String calificacionDifusa, Escenario escenario_recomendado, double recEDC1, double recERC1, double recEPC1)
    {
        this.escenario_asignado = escenario_asignado;
        this.calificacionPromedioSesion = calificacionPromedioSesion;
        this.calificacionDifusa = calificacionDifusa;
        this.escenario_recomendado = escenario_recomendado;
        this.recEDC1 = recEDC1;
        this.recERC1 = recERC1;
        this.recEPC1 = recEPC1;
    }
    
    

    public Escenario getEscenario_asignado()
    {
        return escenario_asignado;
    }

    public void setEscenario_asignado(Escenario escenario_asignado)
    {
        this.escenario_asignado = escenario_asignado;
    }

    public double getCalificacionPromedioSesion()
    {
        return calificacionPromedioSesion;
    }

    public void setCalificacionPromedioSesion(double calificacionPromedioSesion)
    {
        this.calificacionPromedioSesion = calificacionPromedioSesion;
    }

    public String getCalificacionDifusa()
    {
        return calificacionDifusa;
    }

    public void setCalificacionDifusa(String calificacionDifusa)
    {
        this.calificacionDifusa = calificacionDifusa;
    }

    public Escenario getEscenario_recomendado()
    {
        return escenario_recomendado;
    }

    public void setEscenario_recomendado(Escenario escenario_recomendado)
    {
        this.escenario_recomendado = escenario_recomendado;
    }

    public double getRecEDC1()
    {
        return recEDC1;
    }

    public void setRecEDC1(double recEDC1)
    {
        this.recEDC1 = recEDC1;
    }

    public double getRecERC1()
    {
        return recERC1;
    }

    public void setRecERC1(double recERC1)
    {
        this.recERC1 = recERC1;
    }

    public double getRecEPC1()
    {
        return recEPC1;
    }

    public void setRecEPC1(double recEPC1)
    {
        this.recEPC1 = recEPC1;
    }
    
    
    
    
    
    
}
