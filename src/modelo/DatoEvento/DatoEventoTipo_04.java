package modelo.DatoEvento;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

public class DatoEventoTipo_04 implements I_DatoEvento {

    /**
     * {"Zombies": 8, "energySaved": 100, "lanternSaved": -0.1, "inventory":
     * [6,6,6,5,0,1,1,4]}
     */
    public int zombies;
    public int energysaved;
    public double lanternsaved;
    private int[] inventory = new int[8];

    public static DatoEventoTipo_04 crear(String json) {
        DatoEventoTipo_04 datoEventoTipo = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            datoEventoTipo = objectMapper.readValue(json, DatoEventoTipo_04.class);
            System.out.println(datoEventoTipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datoEventoTipo;
    }

    public int getZombies() {
        return zombies;
    }

    public void setZombies(int zombies) {
        this.zombies = zombies;
    }

    public int getEnergysaved() {
        return energysaved;
    }

    public void setEnergysaved(int energysaved) {
        this.energysaved = energysaved;
    }

    public double getLanternsaved() {
        return lanternsaved;
    }

    public void setLanternsaved(double lanternsaved) {
        this.lanternsaved = lanternsaved;
    }

    public int[] getInventory() {
        return inventory;
    }

    public void setInventory(int[] inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "DatoEventoTipo_04{"
                + "zombies=" + zombies
                + ", energysaved=" + energysaved
                + ", lanternsaved=" + lanternsaved
                + ", inventory=" + Arrays.toString(inventory)
                + '}';
    }
}
