package modelo;

public class Alumno
{
    private int id_alumno;
    private String apellido;
    private String nombre;
    
    public Alumno()
    {
        super();
    }


    public Alumno(int id_alumno, String apellido, String nombre)
    {
        this.id_alumno = id_alumno;
        this.apellido = apellido;
        this.nombre = nombre;
    }


    public void setId_alumno(int id_alumno)
    {
        this.id_alumno = id_alumno;
    }

    public int getId_alumno()
    {
        return id_alumno;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }


    @Override
    public String toString()
    {      
        return ""+this.id_alumno+": "+nombre+", "+apellido;
    }

}
