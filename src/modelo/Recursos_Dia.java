package modelo;

import java.util.ArrayList;

import java.util.List;
import modelo.DatoEvento.DatoEventoTipo_03_04_108;

import modelo.DatoEvento.DatoEventoTipo_InicioDia;
import modelo.DatoEvento.I_DatoEventoTipo_03_04_108;
import modelo.DatoEvento.I_DatoEventoTipo_InicioDia;

public class Recursos_Dia implements I_Recursos_Dia
{

    int dia;
    I_Grupo_BG_Posibles_Ordenados grupo_BG_Posibles;
    I_Banco_Generadores bGE;
    int cant_Baterias;

    /**
     * carga remanente. Lo que quedó de ayer
     */
    private double cargaRemanente;
    private int cantGenCarbon;
    private int cantGenNafta;
    private int cantGenEolico;
    private double cant_nafta;
    private double cant_carbon;

    //I_Info_Items infoItems;
    Evento_03_04_108 evento_108;
    Evento_03_04_108 evento_04;

    Bateria bateria;
    Generador_Carbon gc;
    Generador_Nafta gn;
    Generador_Eolico ge;

    //TODO: elimino el uso de info_items. Se podría eliminar toda la clase
    public Recursos_Dia(ArrayList<Evento_03_04_108> lista_eventos_108, ArrayList<Evento_03_04_108> lista_eventos_04, InfoItems infoItems, int dia)
    {
        //gc = new Generador_Carbon(consumo, costo, idCombustible, productividad, texto);
        
        gc = new Generador_Carbon(infoItems.getItem6ConsumoGen(), infoItems.getItem6Costo(),
                infoItems.getItem6Combustible(), infoItems.getItem6Productividad(),
                infoItems.getItem6Texto());
        gn = new Generador_Nafta(infoItems.getItem7ConsumoGen(), infoItems.getItem7Costo(),
                infoItems.getItem7Combustible(), infoItems.getItem7Productividad(),
                infoItems.getItem7Texto());
        ge = new Generador_Eolico(infoItems.getItem8ConsumoGen(), infoItems.getItem8Costo(),
                infoItems.getItem8Combustible(), infoItems.getItem8Productividad(),
                infoItems.getItem8Texto());

        this.evento_108 = (Evento_03_04_108) lista_eventos_108.get(dia - 1);
        this.evento_04 = (Evento_03_04_108) lista_eventos_04.get(dia - 1);

        DatoEventoTipo_03_04_108 datoEvento_03_04_108 = (DatoEventoTipo_03_04_108) evento_108.getDatoEvento();

        this.cantGenCarbon = datoEvento_03_04_108.getCant_Gen_Carbon();
        this.cantGenNafta = datoEvento_03_04_108.getCant_Gen_Carbon();
        this.cantGenEolico = datoEvento_03_04_108.getCant_Gen_Eolico();
        this.cant_nafta = datoEvento_03_04_108.getNafta();
        this.cant_carbon = datoEvento_03_04_108.getCarbon();
        this.cargaRemanente = datoEvento_03_04_108.getEnergySaved();
        try
        {
            grupo_BG_Posibles = new Grupo_BG_Posibles_Ordenados(crearLista_generadores_todos(), cant_nafta, cant_carbon);
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println("no se puede clonar generador");
        }
        //bGE = new Banco_Generadores(, cant_nafta, cant_carbon);
        bGE = new Banco_Generadores(evento_04.getCant_Gen_Carbon(), evento_04.getCant_Gen_Nafta(), evento_04.getCant_Gen_Eolico());
        bateria = new Bateria(datoEvento_03_04_108.getEnergyMax());
    }

    /*
     * public Recursos_Dia(I_Grupo_BG_Posibles_Ordenados grupo_BG_Posibles,
     * I_Banco_Generadores bg_electo, I_Info_Items info_items, int dia, Double
     * cant_nafta, Double cant_carbon) { super(); this.dia = dia;
     * this.grupo_BG_Posibles = grupo_BG_Posibles; this.bGE = bg_electo;
     * this.cantGenCarbon = info_items.getCant_Gen_Carbon_dia(dia);
     * this.cantGenNafta = info_items.getCant_Gen_Nafta_dia(dia);
     * this.cantGenEolico = info_items.getCant_Gen_Eolico_dia(dia);
     * this.cant_nafta = cant_nafta; this.cant_carbon = cant_carbon; }
     */
    private List<Generador> crearLista_generadores_electos(int cgCarbon_electo, int cgNafta_electo,
            int cgEolicos_electo) throws CloneNotSupportedException
    {

        ArrayList<Generador> lista_generador = new ArrayList<Generador>();
        int i = 0;
        for (i = 0; i < cgCarbon_electo; i++)
        {
            lista_generador.add((Generador) gc.clone());
        }

        int j = 0;
        for (j = 0; j < cgNafta_electo; j++)
        {
            lista_generador.add((Generador) gn.clone());
        }

        int k = 0;
        for (k = 0; k < cgEolicos_electo; k++)
        {
            lista_generador.add((Generador) ge.clone());
        }

        return lista_generador;
    }

    private List<Generador> crearLista_generadores_todos() //primer dia comienza en 1
            throws CloneNotSupportedException
    {
        ArrayList<Generador> lista_generador = new ArrayList<Generador>();
        int i = 0;
        for (i = 0; i < cantGenCarbon; i++)
        {
            lista_generador.add((Generador) gc.clone());
        }

        int j = 0;
        for (j = 0; j < cantGenNafta; j++)
        {
            lista_generador.add((Generador) gn.clone());
        }

        int k = 0;
        for (k = 0; k < cantGenEolico; k++)
        {
            lista_generador.add((Generador) ge.clone());
        }

        return lista_generador;
    }

    /**
     * //TODO:arreglar carga remanente
     *
     * @return
     */
    public Double getCargaNecesaria()
    {
        //return cant_Baterias * bateria.getCapacidad() - cargaRemanente;
        return cant_Baterias * bateria.getCapacidad();
    }

    @Override
    public Double getCant_Carbon_inicio()
    {

        return cant_carbon;
    }

    @Override
    public Double getCant_Nafta_inicio()
    {

        return cant_nafta;
    }

    @Override
    public Double getEnergiaEnBateria_inicio()
    {

        return null;
    }

    @Override
    public Banco_Generadores getBG_Electo()
    {

        return (Banco_Generadores) bGE;
    }

    @Override
    public I_Grupo_BG_Posibles_Ordenados getGrupo_BG_Posibles()
    {

        return grupo_BG_Posibles;
    }
}
