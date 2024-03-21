package modelo;

import java.util.ArrayList;

public interface I_Recursos_Dia
{
    /**geneardores de infoItems + generadores de slots del día anterior
     * @return
     */
    //public ArrayList<Generador> getListaGeneradores_disponibles();
    public Double getCant_Carbon_inicio();
    public Double getCant_Nafta_inicio();
    public Double getEnergiaEnBateria_inicio();
    public Banco_Generadores getBG_Electo();
    public I_Grupo_BG_Posibles_Ordenados getGrupo_BG_Posibles();
}
