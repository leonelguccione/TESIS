package modelo;

import java.util.ArrayList;
import modelo2.Escenario;

/**Contiene los recursos de la sesión
 * Tanto los recursos de InfoItems
 * como los recursos conservados cada día
 */
public class Recursos_Sesion 
{
    private ArrayList<Recursos_Dia> lista_recursos_dia;
    private Escenario escenarioAsignado;

    public Recursos_Sesion(ArrayList<Evento_03_04_108> lista_eventos_108, ArrayList<Evento_03_04_108> lista_eventos_04, Escenario escenario_asignado)
    {       
        escenarioAsignado = escenario_asignado;
        InfoItems infoItems = escenario_asignado.getRecursos_infoItems();
        lista_recursos_dia = new ArrayList<Recursos_Dia>();
        int dia = 1;
        int cant_dias = lista_eventos_108.size();
        for (dia = 1; dia <= cant_dias; dia++)
        {
            Recursos_Dia recurso_dia;
            //recurso_dia = new Recursos_Dia(recursos_asignados, lista_eventos, dia);
            recurso_dia = new Recursos_Dia(lista_eventos_108, lista_eventos_04, infoItems, dia);
            lista_recursos_dia.add(recurso_dia);
        }
    }
    
    public Escenario getEscenarioAsignado()
    {
        return escenarioAsignado;
    }

    public Recursos_Dia getRecursosDia(int dia)
    {
        assert (dia>=1 && dia <=10) : "incorrecto el dia";
        return lista_recursos_dia.get(dia - 1);
    }

    public int getDias()
    {
        return lista_recursos_dia.size();
    }
}
