package modelo;

public class Recursos_ahorrados_un_dia
{
    /** 
     * 
"dayNumber": <NUMBER_ FORMER_DAY>, 
"zombies": <AMMOUNT_OF_ZOMBIES_GENERATED>, 
"energySaved": <ENERGY_SAVED_DURING_DAY>, 
"inventory": <INVENTORY_OBJECT>, 
"lanternSaved "= <ENERGY_IN_LANTERN>,
"FuelsStatus": <FUELS_STATUS>,
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
    private Double energySaved;
    private Double lanternSaved;
    private Double cant_carbon_medidos;  //la cantidad real de carbon
    private Double cant_nafta_medidos;   //la cantidad real de nafta
    Banco_Generadores bg_en_slots; //puede ser cero, depende del diseño que quede


    public Recursos_ahorrados_un_dia(Double energySaved, Double lanternSaved, Double cant_carbon_medidos, Double cant_nafta_medidos,
                        Banco_Generadores bg_en_slots)
    {
        this.energySaved = energySaved;
        this.lanternSaved = lanternSaved;
        this.cant_carbon_medidos = cant_carbon_medidos;
        this.cant_nafta_medidos = cant_nafta_medidos;
        this.bg_en_slots = bg_en_slots;
    }


    public void setEnergySaved(Double energySaved)
    {
        this.energySaved = energySaved;
    }

    public Double getEnergySaved()
    {
        return energySaved;
    }

    public void setLanternSaved(Double lanternSaved)
    {
        this.lanternSaved = lanternSaved;
    }

    public Double getLanternSaved()
    {
        return lanternSaved;
    }

    public void setCant_carbon_medidos(Double cant_carbon_medidos)
    {
        this.cant_carbon_medidos = cant_carbon_medidos;
    }

    public Double getCant_carbon_medidos()
    {
        return cant_carbon_medidos;
    }

    public void setCant_nafta_medidos(Double cant_nafta_medidos)
    {
        this.cant_nafta_medidos = cant_nafta_medidos;
    }

    public Double getCant_nafta_medidos()
    {
        return cant_nafta_medidos;
    }

    public void setBg_en_slots(Banco_Generadores bg_en_slots)
    {
        this.bg_en_slots = bg_en_slots;
    }

    public Banco_Generadores getBg_en_slots()
    {
        return bg_en_slots;
    }
}
