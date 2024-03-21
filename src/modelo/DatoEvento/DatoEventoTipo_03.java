package modelo.DatoEvento;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

public class DatoEventoTipo_03 implements I_DatoEvento {

    /**
     * {"energyUsed": 4.896, "dayNumber": 3, "energyGenerated": 0,
     * "zombieskilled": 8, "energyperzombie": 0.612, "inventory":
     * [6,6,6,5,0,1,1,4]}
     */
    private double energyused;
    private int daynumber;
    private int energygenerated;
    private int zombieskilled;
    private double energyperzombie;
    private int[] inventory = new int[8];

    public static DatoEventoTipo_03 crear(String json) {
        DatoEventoTipo_03 datoEventoTipo = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            datoEventoTipo = objectMapper.readValue(json, DatoEventoTipo_03.class);
            System.out.println(datoEventoTipo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datoEventoTipo;
    }

    public double getEnergyused() {
        return energyused;
    }

    public void setEnergyused(double energyused) {
        this.energyused = energyused;
    }

    public int getDaynumber() {
        return daynumber;
    }

    public void setDaynumber(int daynumber) {
        this.daynumber = daynumber;
    }

    public int getEnergygenerated() {
        return energygenerated;
    }

    public void setEnergygenerated(int energygenerated) {
        this.energygenerated = energygenerated;
    }

    public int getZombieskilled() {
        return zombieskilled;
    }

    public void setZombieskilled(int zombieskilled) {
        this.zombieskilled = zombieskilled;
    }

    public double getEnergyperzombie() {
        return energyperzombie;
    }

    public void setEnergyperzombie(double energyperzombie) {
        this.energyperzombie = energyperzombie;
    }

    public int[] getInventory() {
        return inventory;
    }

    public void setInventory(int[] inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "DatoEventoTipo_03{"
                + "energyused=" + energyused
                + ", daynumber=" + daynumber
                + ", energygenerated=" + energygenerated
                + ", zombieskilled=" + zombieskilled
                + ", energyperzombie=" + energyperzombie
                + ", inventory=" + Arrays.toString(inventory)
                + '}';
    }
}
