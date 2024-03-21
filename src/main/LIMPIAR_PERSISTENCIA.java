package main;

import negocio.Sistema;

public class LIMPIAR_PERSISTENCIA
{
    public LIMPIAR_PERSISTENCIA()
    {
        super();
    }

    public static void main(String[] args)
    {
        Sistema sistema = Sistema.getInstance();
        sistema.limpiar_persistencia();
    }
}
