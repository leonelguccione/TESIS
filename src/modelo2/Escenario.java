package modelo2;

import com.google.gson.Gson;
import modelo.InfoItems;

public class Escenario
{
    private int id_escenario;
    private String tipo_escenario;
    private String recursos_json;
    private String descripcion = "escenario";
    private String calificacion= "calificacion";
    private String regla="regla";
    private InfoItems recursos_infoItems;

    public Escenario(int id_escenario, String tipo_escenario, String recursos_json, String descripcion, String calificacion, String regla)
    {
        this.id_escenario = id_escenario;
        this.tipo_escenario = tipo_escenario;
        this.recursos_json = recursos_json;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.regla=regla;
        Gson gson = new Gson();
        this.recursos_infoItems = gson.fromJson(recursos_json, InfoItems.class);
    }

    public Escenario()
    {
        super();
    }

    /*     public void setRecursos_infoItems()
    {
        Gson gson = new Gson();
        this.recursos_infoItems = gson.fromJson(recursos_json, InfoItems.class);
    } */
    
    public void setRecursos(String json)
    {
        this.recursos_json = json;
        Gson gson = new Gson();
        this.recursos_infoItems = gson.fromJson(recursos_json, InfoItems.class);
        
    }
    
    public void setRecursos(InfoItems recursos_info_items)
    {
        this.recursos_infoItems = recursos_info_items;
        Gson gson = new Gson();
        recursos_json = gson.toJson(recursos_infoItems, InfoItems.class);
        
    }

    public void setCalificacion(String calificacion)
    {
        this.calificacion = calificacion;
    }

    public String getCalificacion()
    {
        return calificacion;
    }

    public void setRegla(String regla)
    {
        this.regla = regla;
    }

    public String getRegla()
    {
        return regla;
    }

    public void setId_escenario(int id_escenario)
    {
        this.id_escenario = id_escenario;
    }

    public int getId_escenario()
    {
        return id_escenario;
    }

    public void setTipo_escenario(String tipo_escenario)
    {
        this.tipo_escenario = tipo_escenario;
    }

    public String getTipo_escenario()
    {
        return tipo_escenario;
    }

    /*     public void setRecursos_json(String recursos_json)
    {
        this.recursos_json = recursos_json;
    } */
    
    /*   public void setRecursos_infoItems_to_json()
    {
        Gson gson = new Gson();
        recursos_json = gson.toJson(recursos_infoItems, InfoItems.class);
    } */

    public String getRecursos_json()
    {
        return recursos_json;
    }

    /*    public void setRecursos_infoItems(I_Info_Items recursos_infoItems)
    {
        this.recursos_infoItems = recursos_infoItems;
    } */

    public InfoItems getRecursos_infoItems()
    {
        return recursos_infoItems;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;
    }


    @Override
    public String toString()
    {
        return recursos_infoItems.toString();
    }

}
