package modelo;

import eventos_3_4.Slot;

public class UnSlotInfo
{
    /*
    {
       "has_generator": <HAS_GENERATOR>, 
       "is_on": <IS_ON>, 
       "tipo_combustible": <FUELS_TYPE> 
    },
*/
    public boolean has_generator;
    public boolean is_on;

    /**1: Carbon
     * 2: Nafta
     * 3: Eolico
     */
    public int tipo_combustible;// 1, 2 o 3


    public UnSlotInfo(boolean has_generator, boolean is_on, int tipo_combustible)
    {
        this.has_generator = has_generator;
        this.is_on = is_on;
        this.tipo_combustible = tipo_combustible;
    }
    
    

    public UnSlotInfo()
    {
        super();
    }


    public void setHas_generator(boolean has_generator)
    {
        this.has_generator = has_generator;
    }

    public boolean isHas_generator()
    {
        return has_generator;
    }

    public void setIs_on(boolean is_on)
    {
        this.is_on = is_on;
    }

    public boolean isIs_on()
    {
        return is_on;
    }

    public void setTipo_combustible(int tipo_combustible)
    {
        this.tipo_combustible = tipo_combustible;
    }

    public int getTipo_combustible()
    {
        return tipo_combustible;
    }
}
