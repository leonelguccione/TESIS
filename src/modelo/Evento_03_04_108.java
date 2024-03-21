package modelo;


import modelo.DatoEvento.I_DatoEventoTipo_03_04_108;

public class Evento_03_04_108 extends Evento implements I_DatoEventoTipo_03_04_108
{
    public Evento_03_04_108()
    {
        super();
    }
    
    @Override
    public int getDayNumber()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getDayNumber();
    }

    @Override
    public void setDayNumber(int dayNumber)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setDayNumber(dayNumber);
    }

    @Override
    public double getEnergySaved()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getEnergySaved();
        
    }

    @Override
    public void setEnergySaved(double energy)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setEnergySaved(energy);
    }

    @Override
    public double getLanternSaved()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getLanternSaved();
    }

    @Override
    public void setLanternSaved(double lantern)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setLanternSaved(lantern);
    }

    @Override
    public double getEnergyMax()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getEnergyMax();
    }

    @Override
    public void setEnergyMax(double energyMax)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        double d = datoEvento_03y04.getEnergyMax();
    }

    @Override
    public double getEnergyGenerated()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getEnergyGenerated();
    }

    @Override
    public void setEnergyGenerated(double energyGenerated)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setEnergyGenerated(energyGenerated);
    }

    @Override
    public double getEnergyConsumed()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getEnergyConsumed();
    }

    @Override
    public void setEnergyConsumed(double energyConsumed)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setEnergyConsumed(energyConsumed);
    }

    @Override
    public int getZombies()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getZombies();
    }

    @Override
    public void setZombies(int zombies)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setZombies(zombies);
    }

    @Override
    public int[] getInventory()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getInventory();
    }

    @Override
    public void setInventory(int[] inventory)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setInventory(inventory);
    }

    @Override
    public double[] getFuelsStatus()//carbon , nafta
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getFuelsStatus();
    }

    @Override
    public void setFuelsStatus(double[] fuelsStatus)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setFuelsStatus(fuelsStatus);
    }



    @Override
    public int getCant_Gen_Eolico()
    {
  
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getCant_Gen_Eolico();
    }

    @Override
    public int getCant_Gen_Nafta()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getCant_Gen_Nafta();
    }

    @Override
    public int getCant_Gen_Carbon()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getCant_Gen_Carbon();
    }

    @Override
    public int getCant_Baterias()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getCant_Baterias();
    }

    @Override
    public int getCant_Luz_led()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getCant_Luz_led();
    }

    @Override
    public int getCant_Luz_bajoConsumo()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getCant_Luz_bajoConsumo();
    }

    @Override
    public int getCant_Luz_alogena()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getCant_Luz_alogena();
    }

    @Override
    public int getCant_Luz_incandescente()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getCant_Luz_incandescente();
    }
    
    public I_DatoEventoTipo_03_04_108 getDatoEvento()
    {
        return  (I_DatoEventoTipo_03_04_108)datoEvento;
    }

    @Override
    public double getCarbon()
    {
        return getFuelsStatus()[0];
    }

    @Override
    public double getNafta()
    {
        return getFuelsStatus()[1];
    }

    public int getGenNaftaSlots()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getGenNaftaSlots();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getGenCarbonSlots()
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getGenCarbonSlots();
    }

    public int getGenEolicoSlots()
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getGenEolicoSlots();
    }

    public UnSlotInfo[] getSlotsInfo()
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        return datoEvento_03y04.getSlotsInfo();
    }

    public void setSlotsInfo(UnSlotInfo[] si)
    {
        I_DatoEventoTipo_03_04_108 datoEvento_03y04 = (I_DatoEventoTipo_03_04_108)datoEvento;
        datoEvento_03y04.setSlotsInfo(si);
    }
}
