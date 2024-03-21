package modelo;

import java.util.Objects;

public class Id_Banco_Generadores
{

    private int id;
    int cant_gen_carbon;
    int cant_gen_nafta;
    int cant_gen_eolico;

    public Id_Banco_Generadores(int cant_gen_carbon, int cant_gen_nafta, int cant_gen_eolico)
    {
        this.cant_gen_carbon = cant_gen_carbon;
        this.cant_gen_nafta = cant_gen_nafta;
        this.cant_gen_eolico = cant_gen_eolico;
        id = cant_gen_eolico + 10 * cant_gen_nafta + 100 * cant_gen_carbon;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            {
                return true;
            }
        if (!(o instanceof Id_Banco_Generadores))
            {
                return false;
            }
        Id_Banco_Generadores that = (Id_Banco_Generadores) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getId());
    }

    @Override
    public String toString()
    {
        return "{" + "CNE=" + cant_gen_carbon + "" + cant_gen_nafta + "" + cant_gen_eolico + '}';
    }
}
