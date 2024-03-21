package modelo;

import java.util.ArrayList;

public interface I_RecomendacionSesionC1
{
    
    
    ArrayList<I_EvaluacionDiariaC1> getLista_evaluaciones_diarias();
    public double getEvaluacionSesion();
    public String getEvaluacionSesionString();

}
