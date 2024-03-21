package modelo;

public class Combustibles
{
    private Double[] fuelsStatus;

    public Combustibles(Double[] fuelsStatus)
    {
        this.fuelsStatus = fuelsStatus;
    }
    
    public Double getCarbon()
    {
        return fuelsStatus[0];
    }
    
    public Double getNafta()
    {
        return fuelsStatus[1];
    }
}
