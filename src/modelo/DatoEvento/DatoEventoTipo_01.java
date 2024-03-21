package modelo.DatoEvento;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

public class DatoEventoTipo_01 implements I_DatoEvento {

    private int[] inventory = new int[8];

    public static DatoEventoTipo_01 crear(String json) {
        return null;
    }

    public int[] getInventory() {
        return inventory;
    }

    public void setInventory(int[] inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "DatoEventoTipo_01{"
                + "inventory=" + Arrays.toString(inventory)
                + '}';
    }
}
