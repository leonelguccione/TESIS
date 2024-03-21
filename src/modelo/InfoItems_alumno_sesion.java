package modelo;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class InfoItems_alumno_sesion
{
    int id;
    Date fecha;
    int id_alumno;
    int id_sesion;
    String json;
    InfoItems infoItems;
        
    public InfoItems_alumno_sesion()
    {
        super();
    }


    public InfoItems_alumno_sesion(int id, Date fecha, int id_alumno, int id_sesion, String json)
    {
        this.id = id;
        this.fecha = fecha;
        this.id_alumno = id_alumno;
        this.id_sesion = id_sesion;
        this.json = json;
        Gson gson = new Gson();
        this.infoItems = gson.fromJson(json, InfoItems.class);
    }

    public void setInfoItems(InfoItems infoItems)
    {
        this.infoItems = infoItems;
    }

    public InfoItems getInfoItems()
    {
        return infoItems;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setFecha(String fecha) throws ParseException
    {
        SimpleDateFormat formatoSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        this.fecha = formatoSQL.parse(fecha);
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setId_alumno(int id_alumno)
    {
        this.id_alumno = id_alumno;
    }

    public int getId_alumno()
    {
        return id_alumno;
    }

    public void setId_sesion(int id_sesion)
    {
        this.id_sesion = id_sesion;
    }

    public int getId_sesion()
    {
        return id_sesion;
    }

    public void setJson(String json)
    {
        this.json = json;
        Gson gson = new Gson();
        setInfoItems(gson.fromJson(json, InfoItems.class));
    }

    public String getJson()
    {
        return json;
    }


    @Override
    public String toString()
    {
        return "fecha:"+fecha;
    }
}
