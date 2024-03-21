package modelo;

public class Inventario implements I_Inventario
{
    /*
     * var item1Day = [1,2,3,2,2,2,2,2,2,2] #luz incandescente
    var item2Day = [1,2,3,2,2,2,2,2,2,2] #luz alógena
    var item3Day = [1,2,3,2,2,2,2,2,2,2] #luz bajo consumo
    var item4Day = [1,2,3,2,2,2,2,2,2,2] #luz led
    var item5Day = [0,0,0,0,1,0,0,1,0,0] #batería
    var item6Day = [1,0,1,0,0,1,0,0,0,0] #generador carbón
    var item7Day = [1,1,0,0,0,1,0,0,0,0] #generador nafta
    var item8Day = [3,0,1,0,0,0,0,0,0,0] #generador eolico
     */
    private int[] inventory;

    public Inventario(int[] inventory)
    {
        this.inventory = inventory;
    }

    public int getCant_Gen_Eolico()
    {
        return inventory[7];
    }

    public int getCant_Gen_Nafta()
    {
        return inventory[6];
    }

    public int getCant_Gen_Carbon()
    {
        return inventory[5];
    }


    public int getCant_Baterias()
    {
        return inventory[4];
    }

    public int getCant_Luz_led()
    {
        return this.inventory[3];
    }

    public int getCant_Luz_bajoConsumo()
    {
        return inventory[2];
    }

    public int getCant_Luz_alogena()
    {
        return inventory[1];
    }

    public int getCant_Luz_incandescente()
    {
        return inventory[0];
    }
}
