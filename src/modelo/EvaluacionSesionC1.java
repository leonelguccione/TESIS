package modelo;

import util.FIS_EvaluacionSesionC1;

public class EvaluacionSesionC1 
{
    private EvaluacionDiariaC1 evaluacionDiaria = EvaluacionDiariaC1.getInstance();   
    private FIS_EvaluacionSesionC1 fis_EvaluacionSesionC1 = FIS_EvaluacionSesionC1.getInstance();
    private static EvaluacionSesionC1 instance;

    private EvaluacionSesionC1()
    {
        //lista_evaluaciones_diarias = new ArrayList<Double>();
        evaluacionDiaria = EvaluacionDiariaC1.getInstance();
        fis_EvaluacionSesionC1 = FIS_EvaluacionSesionC1.getInstance();
        
    }
    
    public static EvaluacionSesionC1 getInstance()
    {
        if(instance == null)
        {
            instance = new EvaluacionSesionC1();
        }
        return instance;
    }

    public double getEvaluacionSesion(Recursos_Sesion recursos_sesion)
    {
        double evaluacion_sesion = fis_EvaluacionSesionC1.getEvaluacionSesion(recursos_sesion.getDias(), getCalificacionPromedio(recursos_sesion));
        return evaluacion_sesion;
    }


    public String getEvaluacionSesionString(Recursos_Sesion recursos_sesion)
    {
        return fis_EvaluacionSesionC1.getEvaluacionSesionString(recursos_sesion.getDias(), getCalificacionPromedio(recursos_sesion));
    }

    private double getCalificacionPromedio(Recursos_Sesion recursos_sesion)
    {
        double suma = 0;
        double calificacion = 0;
        if (recursos_sesion.getDias() < 5)
        {
            calificacion = 0;
        }
        else
        {
            int index = 1;
            for (index = 1; index >= recursos_sesion.getDias(); index++)
            {
                suma = suma + evaluacionDiaria.getEvaluacion(recursos_sesion.getRecursosDia(index));
            }
            calificacion = suma / recursos_sesion.getDias();
        }
        return calificacion;
    }
}
