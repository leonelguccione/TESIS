package eventos_3_4;

import java.util.Arrays;

public class EventInfo
{
	private int dayNumber;
	private double energy;
	private double lantern;
	private double energyMax;
	private double energyGenerated;
	private double energyConsumed;
	private int zombies;
	private int[] inventory;
	private double[] fuelsStatus;
	private Slot[] slotsInfo;
        
	public int getDayNumber()
	{
		return dayNumber;
	}
	public void setDayNumber(int dayNumber)
	{
		this.dayNumber = dayNumber;
	}
	public double getEnergy()
	{
		return energy;
	}
	public void setEnergy(double energy)
	{
		this.energy = energy;
	}
	public double getLantern()
	{
		return lantern;
	}
	public void setLantern(double lantern)
	{
		this.lantern = lantern;
	}
	public double getEnergyMax()
	{
		return energyMax;
	}
	public void setEnergyMax(double energyMax)
	{
		this.energyMax = energyMax;
	}
	public double getEnergyGenerated()
	{
		return energyGenerated;
	}
	public void setEnergyGenerated(double energyGenerated)
	{
		this.energyGenerated = energyGenerated;
	}
	public double getEnergyConsumed()
	{
		return energyConsumed;
	}
	public void setEnergyConsumed(double energyConsumed)
	{
		this.energyConsumed = energyConsumed;
	}
	public int getZombies()
	{
		return zombies;
	}
	public void setZombies(int zombies)
	{
		this.zombies = zombies;
	}
	public int[] getInventory()
	{
		return inventory;
	}
	public void setInventory(int[] inventory)
	{
		this.inventory = inventory;
	}
	public double[] getFuelsStatus()
	{
		return fuelsStatus;
	}
	public void setFuelsStatus(double[] fuelsStatus)
	{
		this.fuelsStatus = fuelsStatus;
	}
	public Slot[] getSlotsInfo()
	{
		return slotsInfo;
	}
	public void setSlotsInfo(Slot[] slotsInfo)
	{
		this.slotsInfo = slotsInfo;
	}
	@Override
	public String toString()
	{
		return "EventInfo [dayNumber=" + dayNumber + ", energy=" + energy + ", lantern=" + lantern + ", energyMax="
				+ energyMax + ", energyGenerated=" + energyGenerated + ", energyConsumed=" + energyConsumed
				+ ", zombies=" + zombies + ", inventory=" + Arrays.toString(inventory) + ", fuelsStatus="
				+ Arrays.toString(fuelsStatus) + ", slotsInfo=" + Arrays.toString(slotsInfo) + "]";
	}
	
	
}
