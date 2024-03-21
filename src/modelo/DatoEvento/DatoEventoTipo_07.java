package modelo.DatoEvento;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DatoEventoTipo_07 implements I_DatoEvento {

    /*
     *
    Evento : SetGenerator <07>. Cada vez que se instala un generador en un slot.
    Json a Guardar
    {
        "houringame": <DAY_AND_HOUR_IN_GAME>,
        "Generator": <SELECTED_GENERATOR>,
        “SlotId”: <SELECTED_SLOT>,
        "FuelsStatus": <FUELS_STATUS>, //cantidad de combustible acumulado (inicial + lo del día, por ej.)
        "inventory": <INVENTORY_OBJECT> // es la columna 1 de la matriz. Representa los recursos.
                                        // tiene 8 elementos
    }
     * */
    private int[] houringame = new int[3];
    private int generator;
    private int slotid;
    private int[] fuelsstatus = new int[2];
    private int[] inventory = new int[8];

    public int[] getHouringame() {
        return houringame;
    }

    public void setHouringame(int[] houringame) {
        this.houringame = houringame;
    }

    public int getGenerator() {
        return generator;
    }

    public void setGenerator(int generator) {
        this.generator = generator;
    }

    public int getSlotid() {
        return slotid;
    }

    public void setSlotid(int slotid) {
        this.slotid = slotid;
    }

    public int[] getFuelsstatus() {
        return fuelsstatus;
    }

    public void setFuelsstatus(int[] fuelsstatus) {
        this.fuelsstatus = fuelsstatus;
    }

    public int[] getInventory() {
        return inventory;
    }

    public void setInventory(int[] inventory) {
        this.inventory = inventory;
    }

    public static DatoEventoTipo_07 crear(String json) {
        DatoEventoTipo_07 datoEventoTipo = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            datoEventoTipo = objectMapper.readValue(json, DatoEventoTipo_07.class);
            System.out.println(datoEventoTipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datoEventoTipo;
    }

    @Override
    public String toString() {
        return "DatoEventoTipo_07{"
                + "houringame=" + Arrays.toString(houringame)
                + ", generator=" + generator
                + ", slotid=" + slotid
                + ", fuelsstatus=" + Arrays.toString(fuelsstatus)
                + ", inventory=" + Arrays.toString(inventory)
                + '}';
    }
}
