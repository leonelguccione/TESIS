package modelo.DatoEvento;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import modelo.UnSlotInfo;
import modelo.SlotsInfo;

public class DatoEventoTipo_03_04_108 implements I_DatoEventoTipo_03_04_108
{
    private int dayNumber;
    private double energySaved;
    private double lanternSaved;
    private double energyMax;
    private double energyGenerated;
    private double energyConsumed;
    private int zombies;
    private int[] inventory;
    private double[] fuelsStatus;
    private UnSlotInfo[] slotsInfo;

    public DatoEventoTipo_03_04_108()
    {
        super();
    }

    
    
    public void setDayNumber(int dayNumber)
    {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber()
    {
        return dayNumber;
    }

    public void setEnergySaved(double energySaved)
    {
        this.energySaved = energySaved;
    }

    public double getEnergySaved()
    {
        return energySaved;
    }

    public void setLanternSaved(double lanternSaved)
    {
        this.lanternSaved = lanternSaved;
    }

    public double getLanternSaved()
    {
        return lanternSaved;
    }

    public void setEnergyMax(double energyMax)
    {
        this.energyMax = energyMax;
    }

    public double getEnergyMax()
    {
        return energyMax;
    }

    public void setEnergyGenerated(double energyGenerated)
    {
        this.energyGenerated = energyGenerated;
    }

    public double getEnergyGenerated()
    {
        return energyGenerated;
    }

    public void setEnergyConsumed(double energyConsumed)
    {
        this.energyConsumed = energyConsumed;
    }

    public double getEnergyConsumed()
    {
        return energyConsumed;
    }

    public void setZombies(int zombies)
    {
        this.zombies = zombies;
    }

    public int getZombies()
    {
        return zombies;
    }

    public void setInventory(int[] inventory)
    {
        this.inventory = inventory;
    }

    public int[] getInventory()
    {
        return inventory;
    }

    public void setFuelsStatus(double[] fuelsStatus)
    {
        this.fuelsStatus = fuelsStatus;
    }

    public double[] getFuelsStatus()
    {
        return fuelsStatus;
    }

    


    @Override
    public String toString()
    {
        /*
        return "EventInfo [dayNumber=" + dayNumber + ", energy=" + energySaved + ", lantern=" + lanternSaved + ", energyMax=" +
               energyMax + ", energyGenerated=" + energyGenerated + ", energyConsumed=" + energyConsumed +
               ", zombies=" + zombies + ", inventory=" + Arrays.toString(inventory) + ", fuelsStatus=" +
               Arrays.toString(fuelsStatus) + ", slotsInfo_back=" + Arrays.toString(slotsInfo_back) + "]";
               * */
        return "DatoEventoTIpo0304108";
    }


    

    public int getCant_Baterias()
    {
        return inventory[4];
    }

    public int getCant_Luz_led()
    {
        return this.inventory[3];
    }

    public int getCant_Luz_bajoConsumo()
    {
        return inventory[2];
    }

    public int getCant_Luz_alogena()
    {
        return inventory[1];
    }

    public int getCant_Luz_incandescente()
    {
        return inventory[0];
    }

    public static DatoEventoTipo_03_04_108 crear(String json)
    {
        DatoEventoTipo_03_04_108 datoEventoTipo = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try
        {
            datoEventoTipo = objectMapper.readValue(json, DatoEventoTipo_03_04_108.class);
            System.out.println(datoEventoTipo);
        }
        catch (IOException e)
        {
            System.out.println("error al crear objeto desde json");
            e.printStackTrace();
        }
        return datoEventoTipo;
    }

    
    public double getCarbon()
    {
        return getFuelsStatus()[0];
    }

    public double getNafta()
    {
        return getFuelsStatus()[1];
    }
    
    public int getCant_Gen_Eolico()
    {
        return inventory[7];
    }

    public int getCant_Gen_Nafta()
    {
        return inventory[6];
    }

    public int getCant_Gen_Carbon()
    {
        return inventory[5];
    }

    public int getGenNaftaSlots()
    {
        return getCantGenSlotsByTipoCombustible(1);
    }
    
    public int getCantGenSlotsByTipoCombustible(int tc)
    { //carbon, nafta, eolico
        int cant = 0;
        int index = 0;
        int cant_slots = slotsInfo.length;
        while((index < cant_slots) && (slotsInfo[index].getTipo_combustible()==tc))
        {
           cant++;
        }        
        return cant;         
    }

    public int getGenCarbonSlots()
    {
        return getCantGenSlotsByTipoCombustible(0); 
    }

    public int getGenEolicoSlots()
    {
        return getCantGenSlotsByTipoCombustible(2);
    }

    public UnSlotInfo[] getSlotsInfo()
    {
        return slotsInfo;
    }

    public void setSlotsInfo(UnSlotInfo[] slotsInfo)
    {
        this.slotsInfo = slotsInfo;
    }

   

 

    
    
    
}
