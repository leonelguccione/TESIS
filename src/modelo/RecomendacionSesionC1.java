package modelo;

import java.util.ArrayList;

import util.FIS_RecomendacionSesionC1;

//TODO: terminar de acomodar el uso de RecomendacionSesionC1_DTO. Esto implicaría cambiar la base de datos 
public class RecomendacionSesionC1
{
    
    FIS_RecomendacionSesionC1 fis_RecomendacionSesionC1;
    EvaluacionSesionC1 evaluacionSesionC1;
    String[] st_escenario_recomendado = {"Sin Recomendar", "Desaprueba C1", "Repasa C1", "Promueve C1"};
    private static RecomendacionSesionC1 instance;
    
    RecomendacionSesionC1_DTO rs_dto = new RecomendacionSesionC1_DTO();
    
    //TODO: acá puede estar el problema 8/3/24
    private RecomendacionSesionC1()
    {        
        evaluacionSesionC1 = EvaluacionSesionC1.getInstance();  
        fis_RecomendacionSesionC1 = FIS_RecomendacionSesionC1.getInstance();        
    }
    
    public RecomendacionSesionC1_DTO getRecomendacionSesionC1_DTO(Recursos_Sesion recursos_sesion)
    {
        RecomendacionSesionC1_DTO rec = new RecomendacionSesionC1_DTO();
        rec.setEscenario_asignado(recursos_sesion.getEscenarioAsignado());
        rec.setCalificacionDifusa(getEvaluacionSesionString(recursos_sesion));
        rec.setCalificacionPromedioSesion(getEvaluacionSesion(recursos_sesion));
        rec.setRecEDC1(getEDC1(recursos_sesion));
        rec.setRecEPC1(getEPC1(recursos_sesion));
        rec.setRecERC1(getERC1(recursos_sesion));
        //rec.setEscenario_recomendado(escenario_recomendado);
        
        return rs_dto;
        
    }
    
    public static RecomendacionSesionC1 getInstance()
    {
        if(instance == null)
        {
            instance = new RecomendacionSesionC1();
        }
        return instance;
    }
    
    public String getSt_escenario_recomendado(Recursos_Sesion recursos_sesion)
    {
        return st_escenario_recomendado[getEscenario_recomendado(recursos_sesion)];
    }
    
    public int getEscenario_recomendado(Recursos_Sesion recursos_sesion)
    {
        double recEDC1 = getEDC1(recursos_sesion);
        double recERC1 = getERC1(recursos_sesion);
        double recEPC1 = getEPC1(recursos_sesion);
        int id_escenario_recomendado = getMax(recEDC1, recERC1, recEPC1);
        return id_escenario_recomendado;
    }
    
    public double getEDC1(Recursos_Sesion recursos_sesion)
    {
        return fis_RecomendacionSesionC1.getEDC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
    }
    
    public double getERC1(Recursos_Sesion recursos_sesion)
    {
        return fis_RecomendacionSesionC1.getERC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
    }
    
    public double getEPC1(Recursos_Sesion recursos_sesion)
    {
        return fis_RecomendacionSesionC1.getEPC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
    }
        
    public int getMax(double rec_EDC1, double rec_ERC1, double rec_EPC1)
    {
        int num_escenario = 0;//inicial
        if ( (rec_EDC1>rec_ERC1) && (rec_EDC1>rec_EPC1))//desaprueba
        {
            num_escenario = 1;//repite Einicial
        }
        else if ((rec_ERC1>rec_EDC1) && (rec_ERC1>rec_EPC1))//repasa
        {
            num_escenario = 2;//repasa
        }
        else if ((rec_EPC1>rec_EDC1) && (rec_EPC1>rec_ERC1))//promueve
        {
            num_escenario = 3;//promueve
        }
        return num_escenario;
    }
 
    public double getEvaluacionSesion(Recursos_Sesion recursos_sesion)
    {
        return evaluacionSesionC1.getEvaluacionSesion(recursos_sesion);
    }
    
    public String getEvaluacionSesionString(Recursos_Sesion recursos_sesion)
    {
        return evaluacionSesionC1.getEvaluacionSesionString(recursos_sesion);
    }
    
    
}
