package modelo.DatoEvento;

import eventos_3_4.Slot;

import modelo.I_Inventario;
import modelo.SlotsInfo;
import modelo.UnSlotInfo;

public interface I_DatoEventoTipo_03_04_108 extends I_DatoEvento, I_Inventario
{
    int getDayNumber();

    void setDayNumber(int dayNumber);

    double getEnergySaved();

    void setEnergySaved(double energy);

    double getLanternSaved();

    void setLanternSaved(double lantern);

    double getEnergyMax();

    void setEnergyMax(double energyMax);

    double getEnergyGenerated();

    void setEnergyGenerated(double energyGenerated);

    double getEnergyConsumed();

    void setEnergyConsumed(double energyConsumed);

    int getZombies();

    void setZombies(int zombies);

    int[] getInventory();

    void setInventory(int[] inventory);

    double[] getFuelsStatus();

    void setFuelsStatus(double[] fuelsStatus);

    UnSlotInfo[] getSlotsInfo();

    void setSlotsInfo(UnSlotInfo[] slotsInfo);
    
    double getCarbon();
    
    double getNafta();
    
    int getGenNaftaSlots();
    
    int getGenCarbonSlots();
    
    int getGenEolicoSlots();
    

    @Override
    String toString();
}
