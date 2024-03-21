package modelo;

import java.util.ArrayList;

import util.FIS_RecomendacionSesionC1;

//TODO: se puede cambiar (ArrayList<Evento_03_04_108> lista_eventos_108, ArrayList<Evento_03_04_108> lista_eventos_04) por Recursos_Sesion

public class RecomendacionSesionC1
{
    
    FIS_RecomendacionSesionC1 fis_RecomendacionSesionC1;
    EvaluacionSesionC1 evaluacionSesionC1;
    String[] st_escenario_recomendado = {"Sin Recomendar", "Desaprueba C1", "Repasa C1", "Promueve C1"};
    private static RecomendacionSesionC1 instance;
    
    //TODO: acá puede estar el problema 8/3/24
    private RecomendacionSesionC1()
    {        
        evaluacionSesionC1 = EvaluacionSesionC1.getInstance();  
        fis_RecomendacionSesionC1 = FIS_RecomendacionSesionC1.getInstance();        
    }
    
    public static RecomendacionSesionC1 getInstance()
    {
        if(instance == null)
        {
            instance = new RecomendacionSesionC1();
        }
        return instance;
    }
    
    /*
    public String getSt_escenario_recomendado(ArrayList<Evento_03_04_108> lista_eventos_108, ArrayList<Evento_03_04_108> lista_eventos_04)
    {
        return st_escenario_recomendado[getEscenario_recomendado(lista_eventos_108, lista_eventos_04)];
    }
    * */
    
    public String getSt_escenario_recomendado(Recursos_Sesion recursos_sesion)
    {
        return st_escenario_recomendado[getEscenario_recomendado(recursos_sesion)];
    }
    
    /*
    public int getEscenario_recomendado(ArrayList<Evento_03_04_108> lista_eventos_108, ArrayList<Evento_03_04_108> lista_eventos_04)
    {
        Recursos_Sesion recursos_sesion = new Recursos_Sesion(lista_eventos_108, lista_eventos_04);       
        double recEDC1 = fis_RecomendacionSesionC1.getEDC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
        double recERC1 = fis_RecomendacionSesionC1.getERC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
        double recEPC1 = fis_RecomendacionSesionC1.getEPC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
        int id_escenario_recomendado = getMax(recEDC1, recERC1, recEPC1);
        return id_escenario_recomendado;
    }
    * */
    
    public int getEscenario_recomendado(Recursos_Sesion recursos_sesion)
    {
        double recEDC1 = fis_RecomendacionSesionC1.getEDC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
        double recERC1 = fis_RecomendacionSesionC1.getERC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
        double recEPC1 = fis_RecomendacionSesionC1.getEPC1(evaluacionSesionC1.getEvaluacionSesion(recursos_sesion));
        int id_escenario_recomendado = getMax(recEDC1, recERC1, recEPC1);
        return id_escenario_recomendado;
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
    
    /*
    public String getEvaluacionSesionString(ArrayList<Evento_03_04_108> lista_eventos_108, ArrayList<Evento_03_04_108> lista_eventos_04)
    {
        Recursos_Sesion recursos_sesion = new Recursos_Sesion(lista_eventos_108, lista_eventos_04);    
        return evaluacionSesionC1.getEvaluacionSesionString(recursos_sesion);
    }
    * */
    
    public String getEvaluacionSesionString(Recursos_Sesion recursos_sesion)
    {
        return evaluacionSesionC1.getEvaluacionSesionString(recursos_sesion);
    }
    
    
}
