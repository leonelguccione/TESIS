package main;

import java.sql.SQLException;

import java.util.Iterator;

import modelo2.Escenario;

import negocio.Sistema;

public class INICIAR
{
    
    
    public INICIAR()
    {
        super();
    }
    
    public static void main(String args[])
    {
        Sistema sistema = Sistema.getInstance();
        //sistema.reiniciar();
       // sistema.agregarEscenarioNuevo();
        try
        {
            sistema.mantenimiento_Escenarios_salvarEnArchivoJSon("escenarios.txt");
            sistema.mantenimiento_Alumnos_salvarEnArchivoJSon("alumnos.txt");
            sistema.mantenimiento_Eventos_salvarEnArchivoJSon("eventos.txt");
            sistema.mantenimiento_Sesiones_salvarEnArchivoJSon("sesiones.txt");
            //Iterator<Escenario> escenarios = sistema.mantenimiento_Escenarios_leerDesdeArchivoJson("escenarios.txt");
            //sistema.mantenimiento_Escenarios_salvar_en_BD(escenarios);
            
        }
        catch (SQLException e)
        {
            System.out.println("no se pudo grabar");
        }
    }
}
