package modelo.DatoEvento;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import modelo.Combustibles;
import modelo.Inventario;
import modelo.UnSlotInfo;
import modelo.SlotsInfo;

public class DatoEventoTipo_InicioDia implements I_DatoEvento, I_DatoEventoTipo_InicioDia
{
    /*
"dayNumber": <NUMBER_ FORMER_DAY>,
"zombies": <AMMOUNT_OF_ZOMBIES_GENERATED>,
"energySaved": <ENERGY_SAVED_DURING_DAY>,
"inventory": <INVENTORY_OBJECT>,
"lanternSaved "= <ENERGY_IN_LANTERN>,
"fuelsStatus": <FUELS_STATUS>,
"slotsInfo":
    [
       {
          "has_generator": <HAS_GENERATOR>,
          "is_on": <IS_ON>,
          "tipo_combustible": <FUELS_TYPE>
       },
       {
           "has_generator": <HAS_GENERATOR>,
           "is_on": <IS_ON>,
           "tipo_combustible": <FUELS_TYPE>
        } ,
        {
            "has_generator": <HAS_GENERATOR>,
            "is_on": <IS_ON>,
            "tipo_combustible": <FUELS_TYPE>
        }
     ]
     */


    private int daynumber;
    private int zombies;
    private Double energySaved;
    private int[] inventory = new int[8];
    private Double lanternSaved;
    private Double[] fuelsStatus = new Double[2];
    private UnSlotInfo[] slotsInfo; //debería resolverse con readValue

    private Inventario inventario; //casi no se usa, ver si se elimina
    //private Combustibles combustibles;
    SlotsInfo slots_Info;

    public static DatoEventoTipo_InicioDia crear(String json)
    {
        DatoEventoTipo_InicioDia datoEventoTipo = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try
            {
                datoEventoTipo = objectMapper.readValue(json, DatoEventoTipo_InicioDia.class);
                datoEventoTipo.inventario = new Inventario(datoEventoTipo.inventory);
                datoEventoTipo.slots_Info = new SlotsInfo(datoEventoTipo.slotsInfo);
                System.out.println(datoEventoTipo);
            }
        catch (IOException e)
            {
                e.printStackTrace();
            }
        return datoEventoTipo;
    }

    public Double getCarbon()
    {
        return fuelsStatus[0];
    }

    public Double getNafta()
    {
        return fuelsStatus[1];
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

    public SlotsInfo getSlots_Info()
    {
        return slots_Info;
    }

    public Inventario getIventario()
    {
        return inventario;
    }

    public int getDaynumber()
    {
        return daynumber;
    }

    public int getZombies()
    {
        return zombies;
    }

    public Double getEnergySaved()
    {
        return energySaved;
    }

    public int[] getInventory()
    {
        return inventory;
    }

    public Double getLanternSaved()
    {
        return lanternSaved;
    }

    public Double[] getFuelsStatus()
    {
        return fuelsStatus;
    }

    public UnSlotInfo[] getSlotsInfo()
    {
        return slotsInfo;
    }
}
