package modelo.DatoEvento;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DatoEventoTipo_02 implements I_DatoEvento {

    private int[] houringame = new int[3];
    private int timeplayed;
    private String causeofdeath;

    public static DatoEventoTipo_02 crear(String json) {
        DatoEventoTipo_02 datoEventoTipo = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            datoEventoTipo = objectMapper.readValue(json, DatoEventoTipo_02.class);
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

    public int getTimeplayed() {
        return timeplayed;
    }

    public void setTimeplayed(int timeplayed) {
        this.timeplayed = timeplayed;
    }

    public String getCauseofdeath() {
        return causeofdeath;
    }

    public void setCauseofdeath(String causeofdeath) {
        this.causeofdeath = causeofdeath;
    }

}
