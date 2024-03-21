package modelo;

import modelo.DatoEvento.DatoEventoTipo_InicioDia;
import modelo.DatoEvento.I_DatoEvento;
import modelo.DatoEvento.I_DatoEventoTipo_InicioDia;

public class Evento_Inicio_Dia extends Evento implements I_DatoEventoTipo_InicioDia
{
    //private DatoEventoTipo_100 datoEventoTipo_100;
    
    public Evento_Inicio_Dia()
    {
        super();
    }

    @Override
    public I_DatoEvento getDatoEvento()
    {
        return (DatoEventoTipo_InicioDia)super.datoEvento;
    }

    
    @Override
    public void setDatoEvento(I_DatoEvento datoEvento)
    {
        super.datoEvento = datoEvento;
    }

    @Override
    public Double getCarbon()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCarbon();
    }

    @Override
    public Double getNafta()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getNafta();
    }

    @Override
    public int getCant_Gen_Eolico()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCant_Gen_Eolico();
    }

    @Override
    public int getCant_Gen_Nafta()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCant_Gen_Nafta();
    }

    @Override
    public int getCant_Gen_Carbon()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCant_Gen_Carbon();
    }

    @Override
    public int getCant_Baterias()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCant_Baterias();
    }

    @Override
    public int getCant_Luz_led()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCant_Luz_led();
    }

    @Override
    public int getCant_Luz_bajoConsumo()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCant_Luz_bajoConsumo();
    }

    @Override
    public int getCant_Luz_alogena()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCant_Luz_alogena();
    }

    @Override
    public int getCant_Luz_incandescente()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getCant_Luz_incandescente();
    }

    @Override
    public SlotsInfo getSlots_Info()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getSlots_Info();
    }

    @Override
    public Inventario getIventario()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getIventario();
    }

    @Override
    public int getDaynumber()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getDaynumber();
    }

    @Override
    public int getZombies()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getZombies();
    }

    @Override
    public Double getEnergySaved()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getEnergySaved();
    }

    @Override
    public int[] getInventory()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getInventory();
    }

    @Override
    public Double getLanternSaved()
    {
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getLanternSaved();
    }

    @Override
    public Double[] getFuelsStatus()
    {
        // TODO Implement this method
        return  ((DatoEventoTipo_InicioDia)super.datoEvento).getFuelsStatus();
    }

    @Override
    public UnSlotInfo[] getSlotsInfo()
    {
        // TODO Implement this method
        return ((DatoEventoTipo_InicioDia)super.datoEvento).getSlotsInfo();
    }
}
