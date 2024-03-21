package modelo;

import java.util.ArrayList;

public interface I_Grupo_BG_Posibles_Ordenados
{
    //private ArrayList<Banco_Generadores> gBGE;
    public void addBG(Banco_Generadores bg);
    public int getCant_Bancos_Productividad_Positiva();
    public int getCant_Bancos_Productividad_Negativa();
    public int getCant_Bancos_Productividad_Cero();
    public Banco_Generadores getBanco_Productividad_Maxima();
    public Banco_Generadores getBanco_Productividad_Minima();
    public Banco_Generadores getBanco_Productividad_Cero();  
    public int getOrdenBanco(Id_Banco_Generadores id_banco);
    public int getCant_Bancos();
    
}
