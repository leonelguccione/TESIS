package modelo;

public class Poste
{
    private boolean has_lamp;
    private boolean is_on;
    private int luz_id;
    private int luz_damage;
    private int consumo;
    
    
    public Poste()
    {
        super();
    }

    public Poste(boolean has_lamp, boolean is_on, int luz_id, int luz_damage, int consumo)
    {
        this.has_lamp = has_lamp;
        this.is_on = is_on;
        this.luz_id = luz_id;
        this.luz_damage = luz_damage;
        this.consumo = consumo;
    }

    public void setHas_lamp(boolean has_lamp)
    {
        this.has_lamp = has_lamp;
    }

    public boolean isHas_lamp()
    {
        return has_lamp;
    }

    public void setIs_on(boolean is_on)
    {
        this.is_on = is_on;
    }

    public boolean isIs_on()
    {
        return is_on;
    }

    public void setLuz_id(int luz_id)
    {
        this.luz_id = luz_id;
    }

    public int getLuz_id()
    {
        return luz_id;
    }

    public void setLuz_damage(int luz_damage)
    {
        this.luz_damage = luz_damage;
    }

    public int getLuz_damage()
    {
        return luz_damage;
    }

    public void setConsumo(int consumo)
    {
        this.consumo = consumo;
    }

    public int getConsumo()
    {
        return consumo;
    }
}
