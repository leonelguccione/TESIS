package modelo.DatoEvento;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

public class DatoEventoTipo_09 implements I_DatoEvento {

    /**
     * {"houringame": [1,7,20], "Battery": 10, "BatteryStatus": 110,
     * "inventory": [1,1,1,1,1,1,1,1]}
     */
    private int[] houringame = new int[3];
    private int battery;
    private int batterystatus;
    private int[] inventory = new int[8];

    public static DatoEventoTipo_09 crear(String json) {
        DatoEventoTipo_09 datoEventoTipo = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            datoEventoTipo = objectMapper.readValue(json, DatoEventoTipo_09.class);
            System.out.println(datoEventoTipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datoEventoTipo;
    }

    public int[] getHouringame() {
        return houringame;
    }

    public void setHouringame(int[] houringame) {
        this.houringame = houringame;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getBatterystatus() {
        return batterystatus;
    }

    public void setBatterystatus(int batterystatus) {
        this.batterystatus = batterystatus;
    }

    public int[] getInventory() {
        return inventory;
    }

    public void setInventory(int[] inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "DatoEventoTipo_09{"
                + "houringame=" + Arrays.toString(houringame)
                + ", battery=" + battery
                + ", batterystatus=" + batterystatus
                + ", inventory=" + Arrays.toString(inventory)
                + '}';
    }
}
