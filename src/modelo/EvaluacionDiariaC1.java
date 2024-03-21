package modelo;

import util.FIS_EvaluacionDiariaC1;

public class EvaluacionDiariaC1
{
    FIS_EvaluacionDiariaC1 fis_EvaluacionDiariaC1;
    private static EvaluacionDiariaC1 instance;

    //TODO: Posta Posta acá esta el error
    private EvaluacionDiariaC1()
    {
        this.fis_EvaluacionDiariaC1 = FIS_EvaluacionDiariaC1.getInstance();
    }
    
    public static EvaluacionDiariaC1 getInstance()
    {
        if(instance == null)
        {
            instance = new EvaluacionDiariaC1();
        }
        return instance;
    }
    
    public double getEvaluacion(I_Recursos_Dia recursos_dia)
    {
        return fis_EvaluacionDiariaC1.getEvaluacionDiaria(calcularGD_normalizado(recursos_dia), calcularProductividad_BGE_normalizado(recursos_dia));
    }
    
    private double calcularGD_normalizado(I_Recursos_Dia recursos_dia)
    {
        double gd_normalizado;
        int cant_bg_pos = recursos_dia.getGrupo_BG_Posibles().getCant_Bancos_Productividad_Positiva();
        int cant_bg_neg = recursos_dia.getGrupo_BG_Posibles().getCant_Bancos_Productividad_Negativa();
        int diferencia = cant_bg_pos - cant_bg_neg;
        int total = cant_bg_pos + cant_bg_neg;
        gd_normalizado = new Double(diferencia/total); 
        return gd_normalizado;
    }
    
    private double calcularProductividad_BGE_normalizado(I_Recursos_Dia recursos_dia)
    {
        double productividad_bge_normalizado = 0;
        double productividad_bge = recursos_dia.getBG_Electo().getProductividadMaxima();
        double vp_min = recursos_dia.getGrupo_BG_Posibles().getBanco_Productividad_Minima().getProductividadMaxima();
        double vp_max = recursos_dia.getGrupo_BG_Posibles().getBanco_Productividad_Maxima().getProductividadMaxima();
        if(productividad_bge < 0)
        {
            productividad_bge_normalizado = productividad_bge/vp_min;
            //TODO:revisar setProductividad_bge_normalizado()
        }
        else if(productividad_bge > 0)
        {
            productividad_bge_normalizado = productividad_bge/vp_max;
        }
        return productividad_bge_normalizado;
    }
    
    
}
