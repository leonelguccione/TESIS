package eventos_3_4;

public class Slot
{
	private boolean has_generator;
	private boolean is_on;
	private int tipo_combustible;
	public boolean isHas_generator()
	{
		return has_generator;
	}
	public void setHas_generator(boolean has_generator)
	{
		this.has_generator = has_generator;
	}
	public boolean isIs_on()
	{
		return is_on;
	}
	public void setIs_on(boolean is_on)
	{
		this.is_on = is_on;
	}
	public int getTipo_combustible()
	{
		return tipo_combustible;
	}
	public void setTipo_combustible(int tipo_combustible)
	{
		this.tipo_combustible = tipo_combustible;
	}
	@Override
	public String toString()
	{
		return "Slot [has_generator=" + has_generator + ", is_on=" + is_on + ", tipo_combustible=" + tipo_combustible
				+ "]";
	}
	
	
}


