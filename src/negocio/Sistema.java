package negocio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import excepciones.SesionNoJugadaException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import modelo.Evento;
import persistencia.BaseDeDatos;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import modelo.Alumno;
import modelo.Evento_03_04_108;
import modelo.I_Info_Items;
import modelo.InfoItems;
import modelo.RecomendacionSesionC1;
import modelo.Recursos_Sesion;
import modelo2.Escenario;
import modelo2.Sesion;

/**
 * servicios del sistema
 */
public class Sistema
{

    private BaseDeDatos bd ;
    RecomendacionSesionC1 recomendacionSesionC1;
    public static Sistema instance;

    private Sistema()
    {
        recomendacionSesionC1 = RecomendacionSesionC1.getInstance();
        bd = new BaseDeDatos();

    }
    
    public static Sistema getInstance()
    {
        if(instance == null)
        {
            instance = new Sistema();
        }
        return instance;
    }

    /// Eventos
    public Iterator<Evento> getListaEventosByIdSesion(int id_sesion)
    {
        return bd.getListaEventosByIdSesion(id_sesion);
    }

    /**
     * Recomienda según la ultima fecha de sesion jugada, no se fija en la fecha
     * electa en ventana determina un numero de escenario recomendado y lo
     * almacena en la ultima sesión como escenario_recomendado Luego crea una
     * nueva sesion con este mismo escenario como escenario_asignado
     *
     * @param id_alumno
     */
    public void recomendar(int id_alumno) throws SesionNoJugadaException, SQLException
    {
        Sesion sesion_ultima = bd.getSesionUlimaById_alumno(id_alumno); //ok
        if (sesion_ultima.isJugado() == false)
        {
            throw new SesionNoJugadaException(id_alumno);
        }
        ArrayList<Evento_03_04_108> lista_Eventos_108 = bd.getEventosBySesionBytipoEvento_03_04_08(sesion_ultima.getId_sesion(), 108);
        ArrayList<Evento_03_04_108> lista_Eventos_04 = bd.getEventosBySesionBytipoEvento_03_04_08(sesion_ultima.getId_sesion(), 4);
        
        int id_escenario_asignado = sesion_ultima.getEscenario_asignado();
        Escenario escenario_asignado = bd.getEscenarioById(id_escenario_asignado); //ok
        InfoItems recursos_asignados = escenario_asignado.getRecursos_infoItems(); //ok
        Recursos_Sesion recursos_sesion = new Recursos_Sesion(lista_Eventos_108, lista_Eventos_04, recursos_asignados);
        recomendacionSesionC1 = RecomendacionSesionC1.getInstance();
        //int escenario_recomendado = recomendacionSesionC1.getEscenario_recomendado(lista_Eventos_108, lista_Eventos_04);
        int escenario_recomendado = recomendacionSesionC1.getEscenario_recomendado(recursos_sesion);
        //String calificacion_difusa = recomendacionSesionC1.getEvaluacionSesionString(lista_Eventos_108, lista_Eventos_04);
        String calificacion_difusa = recomendacionSesionC1.getEvaluacionSesionString(recursos_sesion);
        sesion_ultima.setEscenario_recomendado(escenario_recomendado);
        sesion_ultima.setCalificacion_difusa(calificacion_difusa);
        Sesion sesion_nueva = new Sesion(new Date(), id_alumno, escenario_recomendado, "sin Calificar", false);
        bd.actualizar_sesion(sesion_ultima);
        bd.sesion_SaveNuevaSesion(sesion_nueva);
    }

    /*
     * public I_Info_Items getInfoItems_recomendacion() { return
     * recursos_recomendados; }
     */
    public void setBd(BaseDeDatos bd)
    {
        this.bd = bd;
    }

    public BaseDeDatos getBd()
    {
        return bd;
    }

    public Iterator<Alumno> getAlumnos_from_Tabla() throws SQLException
    {
        return bd.getAlumnos_from_Tabla();
    }

    public void altaDeAlumno(int id_alumno, String nombre, String apellido) throws SQLException
    {
        bd.altaDeAlumno(id_alumno, nombre, apellido);
        Sesion sesion_nueva = new Sesion(new Date(), id_alumno, 1, "sin Calificar", false);
        bd.sesion_SaveNuevaSesion(sesion_nueva);
    }

    public Escenario getEscenario_by_tipo(String tipo_escenario)
    {
        Escenario escenario = null;
        escenario = bd.getEscenario_by_tipo(tipo_escenario);
        return escenario;
    }

    public Escenario getEscenario_inicial()
    {
        return getEscenario_by_tipo("inicial");

    }

    public Escenario getEscenario_desaprueba()
    {
        return getEscenario_by_tipo("desaprueba");
    }

    public Escenario getEscenario_repasa()
    {
        return getEscenario_by_tipo("repasa");
    }

    public Escenario getEscenario_promueve()
    {
        return getEscenario_by_tipo("promueve");
    }

    public void actualizarEscenario(Escenario escenario)
    {
        bd.actualizarEscenario(escenario);

    }

    public void limpiar_persistencia()
    {
        bd.limpiar_eventos();
        bd.limpiar_sesiones();
        bd.limpiar_alumnos();
    }

    public void reiniciar()
    {
        Escenario escenario_inicial = bd.getEscenarioById(1);
        Escenario escenario_desaprueba = bd.getEscenarioById(1);
        Escenario escenario_repasa = bd.getEscenarioById(1);
        Escenario escenario_promueve = bd.getEscenarioById(1);

        ///inicial
        escenario_inicial.setTipo_escenario("inicial");
        escenario_inicial.setId_escenario(1);
        escenario_inicial.setCalificacion("Calificacion: no aplica");
        escenario_inicial.setDescripcion("Descripción: escenario con recursos iniciales");
        escenario_inicial.setRegla("Regla: no aplica");
        this.actualizarEscenario(escenario_inicial);

        ///desaprueba
        escenario_desaprueba.setTipo_escenario("desaprueba");
        escenario_desaprueba.setId_escenario(2);
        escenario_desaprueba.setCalificacion("Calificacion: Ha sobrevivido una cantidad de días igual a minoría; o ha sobrevivido una cantidad de días igual a mitad con una evaluación promedio igual a mediocre o reprobado; o ha sobrevivido una cantidad de días igual a mayoría  y ha obtenido una evaluación promedio igual a reprobado.\n");
        escenario_desaprueba.setDescripcion("Descripción: Se repiten las mismas condiciones iniciales del Criterio 1");
        escenario_desaprueba.setRegla("Regla: El jugador debe repetir el desafío.");
        this.actualizarEscenario(escenario_desaprueba);

        ///repasa
        escenario_repasa.setTipo_escenario("repasa");
        escenario_repasa.setId_escenario(3);
        escenario_repasa.setCalificacion("Calificacion: Ha sobrevivido una cantidad de días igual a mitad y ha obtenido una evaluación promedio igual a aprobado; o ha sobrevivido una cantidad de días igual a mayoría y ha obtenido una evaluación promedio igual a mediocre.\n");
        escenario_repasa.setDescripcion("Descripción: Habrá generadores de todo tipo");
        escenario_repasa.setRegla("Regla: El jugador volverá a repetir la experiencia relacionada con este criterio sin que represente un desafío complejo para el juego.");

        InfoItems recursos_repasa = escenario_repasa.getRecursos_infoItems();
        int[] carbonDay =
        {
            500, 500, 500, 500, 500, 500, 500, 500, 500, 500
        };
        int[] naftaDay =
        {
            500, 500, 500, 500, 500, 500, 500, 500, 500, 500
        };
        recursos_repasa.setCarbonDay(carbonDay);
        recursos_repasa.setNaftaDay(naftaDay);
        escenario_repasa.setRecursos(recursos_repasa);
        this.actualizarEscenario(escenario_repasa);

        ///promueve
        //this.agregarEscenarioNuevo();
        escenario_promueve.setTipo_escenario("promueve");
        escenario_promueve.setId_escenario(4);
        escenario_promueve.setCalificacion("Calificacion: Ha obtenido una evaluación promedio igual a sobresaliente una cantidad de días igual a  mitad o mayoría; o  ha obtenido una evaluación promedio igual a aprobado una cantidad de días igual a mayoría.\n"
                + " \n");
        escenario_promueve.setDescripcion("Descripción: Todos los generadores tienen capacidad suficiente para generar la energía necesaria.");
        escenario_promueve.setRegla("Regla: El jugador no necesita volver a resolver los desafíos correspondientes al Criterio 1. O sea, no debe ocuparse de la elección de los generadores de energía.");

        InfoItems recursos_promueve = escenario_promueve.getRecursos_infoItems();
        int[] cant_gen_carbon =
        {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        };
        int[] cant_gen_nafta =
        {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        };
        int[] cant_gen_eolico =
        {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1
        };
        recursos_promueve.setItem6Day(cant_gen_carbon);
        recursos_promueve.setItem7Day(cant_gen_nafta);
        recursos_promueve.setItem8Day(cant_gen_eolico);
        recursos_promueve.setItem6ConsumoGen(0);
        recursos_promueve.setItem6Costo(0);
        recursos_promueve.setItem6Productividad(1000);
        recursos_promueve.setItem7ConsumoGen(0);
        recursos_promueve.setItem7Costo(0);
        recursos_promueve.setItem7Productividad(1000);
        recursos_promueve.setItem8ConsumoGen(0);
        recursos_promueve.setItem8Costo(0);
        recursos_promueve.setItem8Productividad(1000);
        escenario_promueve.setRecursos(recursos_promueve);
        this.actualizarEscenario(escenario_promueve);

    }

    public void agregarEscenarioNuevo()
    {
        Escenario escenario_inicial = bd.getEscenarioById(1);
        bd.agregarEscenarioNuevo(escenario_inicial);
    }

    ///// SESIONES
    public void salvarNuevaSesion(Sesion nuevaSesion)
    {
        bd.sesion_SaveNuevaSesion(nuevaSesion);
    }

    public Iterator getSesionesById_alumno(int id_alumno)
    {
        return bd.getSesionesById_alumno(id_alumno);
    }

    /////MANTENIMIENTO ESCENARIOS
    public void mantenimiento_Escenarios_salvarEnArchivoJSon(String path) throws SQLException
    {
        Iterator<Escenario> iter_escenario = bd.getEscenarios();
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            String json = objectMapper.writeValueAsString(iter_escenario);

            // Guardar el JSON en un archivo
            String rutaArchivo = "escenarios.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
            writer.write(json);
            writer.close();

            System.out.println("JSON guardado exitosamente en " + rutaArchivo);
        }
        catch (IOException e)
        {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    public Iterator<Escenario> mantenimiento_Escenarios_leerDesdeArchivoJson(String path)
    {
        Iterator<Escenario> iterator = null;
        try
        {
            // Ruta del archivo JSON
            String rutaArchivo = "escenarios.json";

            // Crear un ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el archivo JSON y convertirlo a una lista
            List<Escenario> lista = objectMapper.readValue(new File(rutaArchivo), new TypeReference<List<Escenario>>()
            {
            });

            // Convertir la lista a un objeto Iterator
            iterator = lista.iterator();

            // Mostrar los elementos del Iterator
            /*
             * while (iterator.hasNext()) { Escenario escenario =
             * iterator.next(); System.out.println(escenario); }
             */
        }
        catch (IOException e)
        {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return iterator;
    }

    public void mantenimiento_Escenarios_salvar_en_BD(Iterator<Escenario> escenarios)
    {
        bd.salvarEscenarios(escenarios);
    }

    ///////////////// MANTENIMIENTO EVENTOS
    public void mantenimiento_Eventos_salvarEnArchivoJSon(String path) throws SQLException
    {
        Iterator<Evento> iter_eventos = bd.getEventos();
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            String json = objectMapper.writeValueAsString(iter_eventos);

            // Guardar el JSON en un archivo
            String rutaArchivo = "eventos.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
            writer.write(json);
            writer.close();

            System.out.println("JSON guardado exitosamente en " + rutaArchivo);
        }
        catch (IOException e)
        {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    public Iterator<Evento> mantenimiento_Eventos_leerDesdeArchivoJson(String path)
    {
        Iterator<Evento> iterator = null;
        try
        {
            // Ruta del archivo JSON
            String rutaArchivo = "eventos.json";

            // Crear un ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el archivo JSON y convertirlo a una lista
            List<Evento> lista = objectMapper.readValue(new File(rutaArchivo), new TypeReference<List<Evento>>()
            {
            });

            // Convertir la lista a un objeto Iterator
            iterator = lista.iterator();

            // Mostrar los elementos del Iterator
            /*
             * while (iterator.hasNext()) { Escenario escenario =
             * iterator.next(); System.out.println(escenario); }
             */
        }
        catch (IOException e)
        {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return iterator;
    }

    public void mantenimiento_Eventos_salvar_en_BD(Iterator<Escenario> escenarios)
    {
        bd.salvarEscenarios(escenarios);
    }

    //////////////MANTENIMIENTO SESIONES
    /// VER EL TEMA DE LOS ID AUTOINCREMENTABLES en los eventos
    public void mantenimiento_Sesiones_salvarEnArchivoJSon(String path) throws SQLException
    {
        Iterator<Sesion> iter_sesiones = bd.getSesiones();
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            String json = objectMapper.writeValueAsString(iter_sesiones);

            // Guardar el JSON en un archivo
            String rutaArchivo = "eventos.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
            writer.write(json);
            writer.close();

            System.out.println("JSON guardado exitosamente en " + rutaArchivo);
        }
        catch (IOException e)
        {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    public Iterator<Sesion> mantenimiento_Sesiones_leerDesdeArchivoJson(String path)
    {
        Iterator<Sesion> iterator = null;
        try
        {
            // Ruta del archivo JSON
            String rutaArchivo = "sesiones.json";

            // Crear un ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el archivo JSON y convertirlo a una lista
            List<Sesion> lista = objectMapper.readValue(new File(rutaArchivo), new TypeReference<List<Sesion>>()
            {
            });

            // Convertir la lista a un objeto Iterator
            iterator = lista.iterator();

            // Mostrar los elementos del Iterator
            /*
             * while (iterator.hasNext()) { Escenario escenario =
             * iterator.next(); System.out.println(escenario); }
             */
        }
        catch (IOException e)
        {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return iterator;
    }

    public void mantenimiento_Sesiones_salvar_en_BD(Iterator<Sesion> sesiones)
    {
        bd.salvarSesionesRecuperadas(sesiones);
    }

    public void mantenimiento_Alumnos_salvarEnArchivoJSon(String path) throws SQLException
    {
        Iterator<Alumno> iter_alumnos = bd.getAlumnos_from_Tabla();
        ObjectMapper objectMapper = new ObjectMapper();
        try
        {
            String json = objectMapper.writeValueAsString(iter_alumnos);

            // Guardar el JSON en un archivo
            String rutaArchivo = "alumnos.json";
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
            writer.write(json);
            writer.close();

            System.out.println("JSON guardado exitosamente en " + rutaArchivo);
        }
        catch (IOException e)
        {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    public Iterator<Alumno> mantenimiento_Alumnos_leerDesdeArchivoJson(String path)
    {
        Iterator<Alumno> iterator = null;
        try
        {
            // Ruta del archivo JSON
            String rutaArchivo = "alumnos.json";

            // Crear un ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el archivo JSON y convertirlo a una lista
            List<Alumno> lista = objectMapper.readValue(new File(rutaArchivo), new TypeReference<List<Alumno>>()
            {
            });

            iterator = lista.iterator();

        }
        catch (IOException e)
        {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return iterator;
    }

    public void mantenimiento_Alumnos_salvar_en_BD(Iterator<Alumno> alumnos) throws SQLException
    {
        bd.salvarAlumnosRecuperados(alumnos);
    }

}
