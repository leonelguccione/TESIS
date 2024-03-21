package modelo.DatoEvento;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import modelo.Poste;
import modelo.UnSlotInfo;

public class DatoEventoTipo_allStatus_100 implements I_DatoEvento 
{
    private int[] houringame = new int[3];
    private int[] fuelsstatus = new int[2];
    private int[] energystatus = new int[3];
    private int laternbattery;
    private UnSlotInfo[] slots = new UnSlotInfo[3];
    private int[] inventory = new int[8];
    private Poste[] postes = new Poste[12];

    public static DatoEventoTipo_allStatus_100 crear(String json)
    {

        DatoEventoTipo_allStatus_100 datoEventoTipo = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try
        {
            datoEventoTipo = objectMapper.readValue(json.toLowerCase(), DatoEventoTipo_allStatus_100.class);
            System.out.println(datoEventoTipo);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return datoEventoTipo;
    }


    public void setHouringame(int[] houringame)
    {
        this.houringame = houringame;
    }

    public int[] getHouringame()
    {
        return houringame;
    }

    public void setFuelsstatus(int[] fuelsstatus)
    {
        this.fuelsstatus = fuelsstatus;
    }

    public int[] getFuelsstatus()
    {
        return fuelsstatus;
    }

    public void setEnergystatus(int[] energystatus)
    {
        this.energystatus = energystatus;
    }

    public int[] getEnergystatus()
    {
        return energystatus;
    }

    public void setLaternbattery(int laternbattery)
    {
        this.laternbattery = laternbattery;
    }

    public int getLaternbattery()
    {
        return laternbattery;
    }

    public void setSlots(UnSlotInfo[] slots)
    {
        this.slots = slots;
    }

    public UnSlotInfo[] getSlots()
    {
        return slots;
    }

    public void setInventory(int[] inventory)
    {
        this.inventory = inventory;
    }

    public int[] getInventory()
    {
        return inventory;
    }

    public void setPostes(Poste[] postes)
    {
        this.postes = postes;
    }

    public Poste[] getPostes()
    {
        return postes;
    }
}
