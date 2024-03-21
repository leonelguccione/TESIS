package excepciones;

public class SesionNoJugadaException extends Exception
{
    int id_alumno;
    public SesionNoJugadaException(int id_alumno)
    {
        super();
    }
    
    public int getId_alumno()
    {
        return id_alumno;
    }
    
}
