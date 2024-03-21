package modelo;

public class SlotsInfo
{
    private UnSlotInfo[] slotsInfo;
    
    public SlotsInfo(UnSlotInfo[] slotInfo)
    {
        super();
        slotsInfo = slotInfo;
    }   
    
    public int getCant_Gen_Carbon()
    {
        int cant = 0;
        int index = 0;
        int cant_slots = slotsInfo.length;
        while((index < cant_slots) && (slotsInfo[index].getTipo_combustible()==0))
        {
           cant++;
        }
        
        return cant;
    }
    
    public int getCant_Gen_Nafta()
    {
        int cant = 0;
        int index = 0;
        int cant_slots = slotsInfo.length;
        while((index < cant_slots) && (slotsInfo[index].getTipo_combustible()==1))
        {
           cant++;
        }
        
        return cant;
    }
    
    
    public int getCant_Gen_Eolico()
    {
        int cant = 0;
        int index = 0;
        int cant_slots = slotsInfo.length;
        while((index < cant_slots) && (slotsInfo[index].getTipo_combustible()==2))
        {
           cant++;
        }
        
        return cant;
    }

    public UnSlotInfo[] getLista_slotInfo()
    {
        return slotsInfo;
    }

    public void setLista_slotInfo(UnSlotInfo[] lista_slotInfo)
    {
        this.slotsInfo = lista_slotInfo;
    }
    
}
