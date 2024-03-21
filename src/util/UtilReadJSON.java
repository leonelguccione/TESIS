package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Iterator;

import main.Prueba;

public class UtilReadJSON
{
    public static String leerArchivo(String nombre)
    {
        String respuesta = null;
        BufferedReader is = null;
        try
        {
            is = new BufferedReader(new InputStreamReader(new FileInputStream(nombre)));
            respuesta = cargar(is);
            is.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return respuesta;
    }

    public static String cargar(BufferedReader isl) throws IOException
    {

        StringBuilder sb = new StringBuilder();
        String renglon;
        sb.setLength(0);
        renglon = isl.readLine();

        while (renglon != null)
        {
            sb.append(renglon);
            sb.append('\n');
            renglon = isl.readLine();
        }

        return sb.toString();

    }

    public static Iterator<String> getAtributos()
    {
        ArrayList<String> atributos = new ArrayList<String>();
       // String cadena = leerArchivo("InfoJSONItems.java");
        String cadena = leerArchivo("/media/leonel/DATOS/UNLP/000_TESIS_MAESTRIA/FRANCO-Juego-Version-GUILLE/2023_json/src/main/java/main/items_f.json");
        System.out.println(cadena);
        String[] lineas = cadena.split("\n");
        for (int i = 0; i < lineas.length; i++)
        {
            String[] palabras = lineas[i].split(" ");
            if (palabras.length >= 3 && palabras[0].contains("private"))
            {
                String atributo = palabras[2].substring(0, palabras[2].length() - 1);
                atributos.add(atributo);
                System.out.println(atributo);
            }

        }
        return atributos.iterator();
    }

}
