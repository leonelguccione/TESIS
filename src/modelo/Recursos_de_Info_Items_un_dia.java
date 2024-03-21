package modelo;

public class Recursos_de_Info_Items_un_dia
{
    //recursos iniciales según infoItems
    private int cant_halogenas; //halogena
    private int cant_incandescentes; //incandescente
    private int cant_bajoConsumo; //bajo consumo
    private int cant_leds; //led
    private int cant_baterias; //bateria
    private int cant_Gens_Carbon; //Generadores a Carbon 0-9
    private int cant_Gens_Nafta; //Generadores a Nafta
    private int cant_Gens_Eolico; //Generadores Eolico
    //inventory contiene los itmes de 1 a 8
    private Double cant_carbon_info_items;
    private Double cant_nafta_info_items;
    private int cant_zombies;
    Banco_Generadores bg_info_items = null;

    public Recursos_de_Info_Items_un_dia()
    {

    }

    public Recursos_de_Info_Items_un_dia(int item1_halogenas, int item2_incandescentes, int item3_bajoConsumos, int item4_leds,
                    int item5_baterias, int item6_Gens_Carbon, int item7_Gens_Nafta, int item8_Gens_Eolico,
                    Double carbonDay, Double naftaDay, int zombieDay)
    {
        this.cant_halogenas = item1_halogenas;
        this.cant_incandescentes = item2_incandescentes;
        this.cant_bajoConsumo = item3_bajoConsumos;
        this.cant_leds = item4_leds;
        this.cant_baterias = item5_baterias;
        this.cant_Gens_Carbon = item6_Gens_Carbon;
        this.cant_Gens_Nafta = item7_Gens_Nafta;
        this.cant_Gens_Eolico = item8_Gens_Eolico;
        this.cant_carbon_info_items = carbonDay;
        this.cant_nafta_info_items = naftaDay;
        this.cant_zombies = zombieDay;
        this.bg_info_items = new Banco_Generadores(this.cant_Gens_Carbon,this.cant_Gens_Nafta, this.cant_Gens_Eolico);
    }

    public void setCant_halogenas(int cant_halogenas)
    {
        this.cant_halogenas = cant_halogenas;
    }

    public int getCant_halogenas()
    {
        return cant_halogenas;
    }

    public void setCant_incandescentes(int cant_incandescentes)
    {
        this.cant_incandescentes = cant_incandescentes;
    }

    public int getCant_incandescentes()
    {
        return cant_incandescentes;
    }

    public void setCant_bajoConsumo(int cant_bajoConsumo)
    {
        this.cant_bajoConsumo = cant_bajoConsumo;
    }

    public int getCant_bajoConsumo()
    {
        return cant_bajoConsumo;
    }

    public void setCant_leds(int cant_leds)
    {
        this.cant_leds = cant_leds;
    }

    public int getCant_leds()
    {
        return cant_leds;
    }

    public void setCant_baterias(int cant_baterias)
    {
        this.cant_baterias = cant_baterias;
    }

    public int getCant_baterias()
    {
        return cant_baterias;
    }

    public void setCant_Gens_Carbon(int cant_Gens_Carbon)
    {
        this.cant_Gens_Carbon = cant_Gens_Carbon;
    }

    public int getCant_Gens_Carbon()
    {
        return cant_Gens_Carbon;
    }

    public void setCant_Gens_Nafta(int cant_Gens_Nafta)
    {
        this.cant_Gens_Nafta = cant_Gens_Nafta;
    }

    public int getCant_Gens_Nafta()
    {
        return cant_Gens_Nafta;
    }

    public void setCant_Gens_Eolico(int cant_Gens_Eolico)
    {
        this.cant_Gens_Eolico = cant_Gens_Eolico;
    }

    public int getCant_Gens_Eolico()
    {
        return cant_Gens_Eolico;
    }


    public Double getCant_carbon_info_items()
    {
        return cant_carbon_info_items;
    }

    public Double getCant_nafta_info_items()
    {
        return cant_nafta_info_items;
    }

    public Banco_Generadores getBg_info_items()
    {
        return bg_info_items;
    }

    public void setCant_zombies(int cant_zombies)
    {
        this.cant_zombies = cant_zombies;
    }

    public int getCant_zombies()
    {
        return cant_zombies;
    }
}
