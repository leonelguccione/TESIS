package modelo.DatoEvento;

public class DatoEventoFactory
{

    public static I_DatoEvento crear(int tipoEvento, String json)
    {
        I_DatoEvento datoEvento = null;
        if (tipoEvento == 7)
        {
            datoEvento = DatoEventoTipo_07.crear(json);
        }
        else if (tipoEvento == 2)
        {
            datoEvento = DatoEventoTipo_02.crear(json);
        }
        else if (tipoEvento == 9)
        {
            datoEvento = DatoEventoTipo_09.crear(json);
        }
        else if (tipoEvento == 3)
        {
            datoEvento = DatoEventoTipo_03_04_108.crear(json);
        }
        else if (tipoEvento == 4)
        {
            datoEvento = DatoEventoTipo_03_04_108.crear(json);
        }
        else if (tipoEvento == 1)
        {
            datoEvento = DatoEventoTipo_01.crear(json);
        }
        else if (tipoEvento == 100)
        {
            //datoEvento = DatoEventoTipo_InicioDia.crear(json);
            datoEvento = DatoEventoTipo_allStatus_100.crear(json);
        }
        else if (tipoEvento == 108)
        {
            datoEvento = DatoEventoTipo_03_04_108.crear(json);
        }
        return datoEvento;
    }
}
