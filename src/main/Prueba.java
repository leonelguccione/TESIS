package main;


import iu.I_Configuracion_iu;
import iu.JF_ppal;
import iu.JFrame_Principal;

import iu.JPanel_Escenario_C1;
import iu.JPanel_Recomendaciones;

import java.io.IOException;

import java.sql.SQLException;

import java.util.Iterator;

import modelo.I_Info_Items;

import modelo2.Escenario;

import negocio.Sistema;

import util.UtilReadJSON;

import vista.Ventana;

public class Prueba
{
    public static void main2(String[] args)
    {
        //Controlador controlador = new Controlador();
        Iterator<String> it = UtilReadJSON.getAtributos();
        //Ventana ventana = new Ventana(controlador, it);

    }

    public static void main(String[] args)
    {
        Sistema sistema = Sistema.getInstance();      
        JFrame_Principal jFrame_Principal = new JFrame_Principal();
        jFrame_Principal.setSistema(sistema);
        jFrame_Principal.setVisible(true);  

    }
    
     public static void main3(String[] args)
    {
         //Sistema sistema = new Sistema();
         //JPanel_Recomendaciones jPanel_Recomendaciones = new JPanel_Recomendaciones(sistema);
         JF_ppal.main(args);
                 
     }
}
