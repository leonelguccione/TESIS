package modelo.DatoEvento;

import modelo.Inventario;
import modelo.UnSlotInfo;
import modelo.SlotsInfo;

public interface I_DatoEventoTipo_InicioDia
{
    Double getCarbon();

    Double getNafta();

    int getCant_Gen_Eolico();

    int getCant_Gen_Nafta();

    int getCant_Gen_Carbon();

    int getCant_Baterias();

    int getCant_Luz_led();

    int getCant_Luz_bajoConsumo();

    int getCant_Luz_alogena();

    int getCant_Luz_incandescente();

    SlotsInfo getSlots_Info();

    Inventario getIventario();

    int getDaynumber();

    int getZombies();

    Double getEnergySaved();

    int[] getInventory();

    Double getLanternSaved();

    Double[] getFuelsStatus();

    UnSlotInfo[] getSlotsInfo();
}
