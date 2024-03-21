package persistencia;


import com.google.gson.Gson;


import java.sql.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import modelo.Alumno;

import modelo.DatoEvento.DatoEventoFactory;

import modelo.DatoEvento.I_DatoEventoTipo_03_04_108;

import modelo.Evento;
import modelo.Evento_03_04_108;
import modelo.InfoItems_alumno_sesion;

import modelo2.Escenario;
import modelo2.Sesion;


public class BaseDeDatos
{

    Connection conexion;
    Statement sentencia;
    PreparedStatement ps;
    ResultSet resultado;

    public BaseDeDatos()
    {
        super();
    }

    public void cargarDriver()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar()
    {
        try
        {
            // Se establece la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "leonel", "leonel127");
            System.out.println("mydb conectado");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar()
    {
        try
        {
            conexion.close();
            System.out.println("Desconectando de BD");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /////////////////// hacer un backup de los datos en JSON sobre un archivo.

    public String escenario_to_json(Escenario escenario)
    {
        Gson gson = new Gson();
        String json = gson.toJson(escenario);
        return json;
    }


    //////////////EVENTOS

    public void limpiar_eventos()
    {
        conectar();
        try
        {
            sentencia = conexion.createStatement();
            String sql = "DELETE FROM eventos";
            int filasAfectadas = sentencia.executeUpdate(sql);
        }
        catch (SQLException e)
        {
        }
        finally
        {
            desconectar();
        }

    }

    public Iterator<Evento> getEventos()
    {
        String query = "SELECT * FROM eventos";
        Iterator iter_eventos = null;
        iter_eventos = getEventosFromQuery(query).iterator();
        return iter_eventos;
    }

    public ArrayList<Evento> getEventosFromQuery(String sql)
    {
        ArrayList<Evento> listaDeEventos = null;
        try
        {
            conectar();
            listaDeEventos = new ArrayList<Evento>();
            Evento evento = null;
            sentencia = conexion.createStatement();
            ResultSet rows = sentencia.executeQuery(sql);
            while (rows.next())
            {
                evento = new Evento();
                evento.setTipo_evento(rows.getInt("tipo_evento")); //getInt("tipo_evento"));

                evento.setId_sesion(rows.getInt("id_sesion")); //id_sesion
                evento.setHora(rows.getTimestamp("hora"));
                evento.setTipo_evento(rows.getInt("tipo_evento")); //tipo_evento
                evento.setTitulo(rows.getString("titulo"));
                evento.setDatos(rows.getString("datos"));
                String json = evento.getDatos();
                evento.setDatoEvento(DatoEventoFactory.crear(evento.getTipo_evento(), json));
            }
            // return listaDeEventos;
        }
        catch (SQLSyntaxErrorException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            desconectar();
            return listaDeEventos;
        }
    }

    /**Genera la lista de eventos de una determinada sesion
     * @param id_sesion
     * @return
     */
    public Iterator<Evento> getListaEventosByIdSesion(int id_sesion)
    {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        conectar();
        String consulta = "SELECT * FROM eventos WHERE id_sesion = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta))
        {
            statement.setInt(1, id_sesion);

            try (ResultSet resultSet = statement.executeQuery())
            {
                while (resultSet.next())
                {
                    Evento evento = new Evento();
                    evento.setDatos(resultSet.getString("datos"));
                    evento.setHora(resultSet.getTimestamp("hora"));

                    evento.setId_sesion(resultSet.getInt("id_sesion"));
                    evento.setTipo_evento(resultSet.getInt("tipo_evento"));
                    evento.setTitulo(resultSet.getString("titulo"));
                    // Puedes necesitar mapear datoEvento aquí si es relevante
                    eventos.add(evento);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("no se pueden recuperar los eventos de la tabla");
            System.out.println(e.toString());
        }
        finally
        {
            desconectar();
            return eventos.iterator();
        }
    }

    /**Elegir los eventos del id_alumno correspondientes a la última sesión
     * @param tipo_evento
     * @return
     */
    public ArrayList<Evento> getEventosBySesionBytipoEvento(int id_sesion, int tipo_evento)
    {
        String consultaSQL = "SELECT * FROM eventos WHERE tipo_evento = ? AND id_sesion = ?";
        ArrayList<Evento> listaDeEventos = new ArrayList<Evento>();
        try
        {
            conectar();
            PreparedStatement statement = conexion.prepareStatement(consultaSQL);
            statement.setInt(1, tipo_evento);
            statement.setInt(2, id_sesion);

            Evento evento = null;
            ResultSet rows = statement.executeQuery();
            while (rows.next())
            {
                evento = new Evento();
                evento.setTipo_evento(rows.getInt("tipo_evento")); //getInt("tipo_evento"));

                evento.setId_sesion(rows.getInt("id_sesion")); //id_sesion
                evento.setHora(rows.getTimestamp("hora"));
                evento.setTipo_evento(rows.getInt("tipo_evento")); //tipo_evento
                evento.setTitulo(rows.getString("titulo"));
                evento.setDatos(rows.getString("datos"));
                String json = evento.getDatos();
                evento.setDatoEvento(DatoEventoFactory.crear(evento.getTipo_evento(), json));
                listaDeEventos.add(evento);
            }
            // return listaDeEventos;
        }
        catch (SQLSyntaxErrorException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            desconectar();
            return listaDeEventos;
        }
    }
    
    public ArrayList<Evento_03_04_108> getEventosBySesionBytipoEvento_03_04_08(int id_sesion, int tipo_evento)
    {
        String consultaSQL = "SELECT * FROM eventos WHERE tipo_evento = ? AND id_sesion = ?";
        ArrayList<Evento_03_04_108> listaDeEventos = new ArrayList<Evento_03_04_108>();
        try
        {
            conectar();
            PreparedStatement statement = conexion.prepareStatement(consultaSQL);
            statement.setInt(1, tipo_evento);
            statement.setInt(2, id_sesion);      
            Evento_03_04_108 evento_03_04_108 = null;
            ResultSet rows = statement.executeQuery();
            int i = 0;
            while (rows.next() && i<10)
            {
                evento_03_04_108 = new Evento_03_04_108();
                evento_03_04_108.setTipo_evento(rows.getInt("tipo_evento")); //getInt("tipo_evento"));

                evento_03_04_108.setId_sesion(rows.getInt("id_sesion")); //id_sesion
                evento_03_04_108.setHora(rows.getTimestamp("hora"));
                evento_03_04_108.setTipo_evento(rows.getInt("tipo_evento")); //tipo_evento
                evento_03_04_108.setTitulo(rows.getString("titulo"));
                evento_03_04_108.setDatos(rows.getString("datos"));
                String json = evento_03_04_108.getDatos();
                evento_03_04_108.setDatoEvento(DatoEventoFactory.crear(evento_03_04_108.getTipo_evento(), json));
                listaDeEventos.add(evento_03_04_108);
                i++;
            }
            // return listaDeEventos;
        }
        catch (SQLSyntaxErrorException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            desconectar();
            return listaDeEventos;
        }
    }


    /**Elegir los eventos del id_alumno correspondientes a la última sesión
     * @param id_sesion
     * @param id_alumno
     * @param tipo_evento
     * @return
     */
    public ArrayList<Evento> getEventos_By_idSesion_By_idAlumno_By_tipoEvento(int id_sesion, int id_alumno,
                                                                              int tipo_evento) throws SQLException
    {
        String sql =
            "SELECT * FROM eventos WHERE id_sesion = " + id_sesion + " AND id_alumno= " + id_alumno +
            " AND tipo_evento = " + tipo_evento;
        String consultaSQL =
            "SELECT * FROM eventos WHERE id_alumno = ? AND tipo_evento = ? AND id_sesion = (SELECT MAX(id_sesion) FROM eventos WHERE id_alumno = ?)";
        PreparedStatement statement = conexion.prepareStatement(consultaSQL);
        statement.setInt(1, id_alumno);
        statement.setInt(2, tipo_evento);
        statement.setInt(3, id_alumno);

        ArrayList<Evento> listaDeEventos = null;
        listaDeEventos = getEventosFromQuery(sql);
        return listaDeEventos;
    }

    public ArrayList<Evento> getEventos_Inicio_Dia(int id_sesion, int id_alumno) throws SQLException
    {
        ArrayList<Evento> lista_eventos = getEventos_By_idSesion_By_idAlumno_By_tipoEvento(id_sesion, id_alumno, 3);
        return lista_eventos;
    }

    public ArrayList<Evento> getEventos_03(int id_sesion, int id_alumno) throws SQLException
    {
        ArrayList<Evento> lista_eventos = getEventos_By_idSesion_By_idAlumno_By_tipoEvento(id_sesion, id_alumno, 3);
        return lista_eventos;
    }
    
    

    public void mostrarEventos_03() throws SQLException
    {
        ArrayList<Evento> lista_eventos = getEventos_03(15510, 1);
        Iterator iterEventos = lista_eventos.iterator();
        while (iterEventos.hasNext())
        {
            Evento_03_04_108 evento0304 = (Evento_03_04_108) iterEventos.next();
            I_DatoEventoTipo_03_04_108 dato = (I_DatoEventoTipo_03_04_108) evento0304.getDatoEvento();
            System.out.println("evento: " + dato.toString());
        }
    }

    /**Evento de tipo allStatus
     * @param id_sesion
     * @param tipo_evento
     * @return
     */
    public Evento getEventoBeginPlay(int id_sesion, int tipo_evento)
    {
        ArrayList<Evento> eventos = getEventosBySesionBytipoEvento(id_sesion, tipo_evento);
        return eventos.get(0);
    }
    
    //// ALUMNOS

    public void limpiar_alumnos()
    {
        conectar();
        try
        {
            sentencia = conexion.createStatement();
            String sql = "DELETE FROM alumnos";
            int filasAfectadas = sentencia.executeUpdate(sql);
        }
        catch (SQLException e)
        {
        }
        finally
        {
            desconectar();
        }
    }

    public Iterator<Alumno> getAlumnos_from_Tabla() throws SQLException
    {
        String sql = "SELECT * FROM alumnos";
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        Alumno unAlumno;
        conectar();
        sentencia = conexion.createStatement();
        ResultSet rows = sentencia.executeQuery(sql);
        while (rows.next())
        {
            unAlumno = new Alumno();
            unAlumno.setId_alumno(rows.getInt("id_alumno"));
            unAlumno.setNombre(rows.getString("nombre"));
            unAlumno.setApellido(rows.getString("apellido"));

            alumnos.add(unAlumno);
        }

        desconectar();
        return alumnos.iterator();
    }


    public InfoItems_alumno_sesion getInfoItems_from_tabla_ultima_fecha(int id_alumno) throws SQLException
    {
        InfoItems_alumno_sesion infoItems_alumno_sesion = new InfoItems_alumno_sesion();
        String sql =
            "SELECT * FROM infoitems WHERE id_alumno= " + id_alumno +
            " AND fecha = (SELECT MAX(fecha) FROM eventos WHERE id_alumno = " + id_alumno + ")";

        try
        {
            conectar();
            sentencia = conexion.createStatement();
            ResultSet rows = sentencia.executeQuery(sql);
            if (rows.next())
            {
                infoItems_alumno_sesion.setId_sesion(rows.getInt("id_sesion"));
                infoItems_alumno_sesion.setId_alumno(rows.getInt("id_alumno"));
                infoItems_alumno_sesion.setJson(rows.getString("json"));
            }
            else
            {
                infoItems_alumno_sesion = null;
            }
        }
        finally
        {
            desconectar();
            return infoItems_alumno_sesion;
        }

    }

    public void salvarAlumnosRecuperados(Iterator<Alumno> iter_alumnos) throws SQLException
    {
        conectar();
        while (iter_alumnos.hasNext())
        {
            Alumno alumno = iter_alumnos.next();
            String consulta = "INSERT INTO alumnos (id_alumno, nombre, apellido) VALUES (?, ?, ?)";
            // Preparar la declaración SQL con parámetros
            PreparedStatement statement = conexion.prepareStatement(consulta);
            // Establecer los valores de los parámetros
            statement.setInt(1, alumno.getId_alumno());
            statement.setString(2, alumno.getNombre());
            statement.setString(3, alumno.getApellido());

            // Ejecutar la inserción
            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0)
            {
                System.out.println("Inserción exitosa. Se han insertado " + filasAfectadas + " filas.");
            }
            else
            {
                System.out.println("La inserción no tuvo éxito. No se han insertado filas.");
            }
        }
        desconectar();
    }

    public void altaDeAlumno(int id_alumno, String nombre, String apellido) throws SQLException
    {
        String consulta = "INSERT INTO alumnos (id_alumno, nombre, apellido) VALUES (?, ?, ?)";
        this.conectar();
        // Preparar la declaración SQL con parámetros
        PreparedStatement statement = conexion.prepareStatement(consulta);
        // Establecer los valores de los parámetros
        statement.setInt(1, id_alumno);
        statement.setString(2, nombre);
        statement.setString(3, apellido);

        // Ejecutar la inserción
        int filasAfectadas = statement.executeUpdate();

        if (filasAfectadas > 0)
        {
            System.out.println("Inserción exitosa. Se han insertado " + filasAfectadas + " filas.");
        }
        else
        {
            System.out.println("La inserción no tuvo éxito. No se han insertado filas.");
        }
        desconectar();
    }

    ///////////   ESCENARIOS


    public Iterator<Escenario> getEscenarios() throws SQLException
    {
        Escenario escenario;
        ArrayList<Escenario> escenarios = new ArrayList<Escenario>();
        String sql = "SELECT * FROM escenarios";
        conectar();
        sentencia = conexion.createStatement();
        ResultSet rows = sentencia.executeQuery(sql);
        while (rows.next())
        {
            escenario = new Escenario();
            escenario.setId_escenario(rows.getInt("id_escenario"));
            escenario.setCalificacion(rows.getString("calificacion"));
            escenario.setRecursos(rows.getString("recursos"));
            escenario.setDescripcion(rows.getString("descripcion"));
            escenario.setRegla(rows.getString("regla"));
            escenario.setTipo_escenario(rows.getString("tipo_escenario"));
            // escenario.setRecursos_infoItems();
            escenarios.add(escenario);
        }

        desconectar();
        return escenarios.iterator();
    }

    public Escenario getEscenarioById(int id)
    {
        conectar();
        Escenario escenario = null;

        try (PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM escenarios WHERE id_escenario = ?"))
        {
            pstmt.setInt(1, id);

            try (ResultSet rows = pstmt.executeQuery())
            {
                if (rows.next())
                {
                    escenario = new Escenario();
                    escenario.setId_escenario(rows.getInt("id_escenario"));
                    escenario.setCalificacion(rows.getString("calificacion"));
                    escenario.setRecursos(rows.getString("recursos"));
                    escenario.setDescripcion(rows.getString("descripcion"));
                    escenario.setRegla(rows.getString("regla"));
                    escenario.setTipo_escenario(rows.getString("tipo_escenario"));
                    //escenario.setRecursos_infoItems();
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error al intentar obtener el escenario por id_escenario: " + e.getMessage());
        }
        finally
        {
            desconectar();
        }

        return escenario;
    }


    public Escenario getEscenario_by_tipo(String tipo_escenario)
    {
        Escenario escenario = null;
        String sql = "SELECT * FROM escenarios WHERE tipo_escenario = ?";
        conectar();

        try (PreparedStatement pstmt = conexion.prepareStatement(sql))
        {
            pstmt.setString(1, tipo_escenario);

            try (ResultSet rows = pstmt.executeQuery())
            {
                if (rows.next())
                {
                    escenario = new Escenario();
                    escenario.setId_escenario(rows.getInt("id_escenario"));
                    escenario.setCalificacion(rows.getString("calificacion"));
                    escenario.setRecursos(rows.getString("recursos"));
                    escenario.setDescripcion(rows.getString("descripcion"));
                    escenario.setRegla(rows.getString("regla"));
                    escenario.setTipo_escenario(rows.getString("tipo_escenario"));
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.out.println("No se puede seleccionar por tipo de escenario " + tipo_escenario);
        }
        finally
        {
            desconectar();
            return escenario;
        }
    }


    public void actualizarEscenario(Escenario escenario)
    {
        conectar();
        try
        {
            System.out.println("actualizando escenario " + escenario.getTipo_escenario() + "  " +
                               escenario.getId_escenario());
            String sql =
                "UPDATE escenarios SET calificacion = ?, recursos = ?, descripcion = ?, regla = ?, tipo_escenario = ? WHERE id_escenario = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            // Establecer los nuevos valores para la fila
            pstmt.setString(1, escenario.getCalificacion());
            pstmt.setString(2, escenario.getRecursos_json());
            pstmt.setString(3, escenario.getDescripcion());
            pstmt.setString(4, escenario.getRegla());
            pstmt.setString(5, escenario.getTipo_escenario());
            pstmt.setInt(6, escenario.getId_escenario());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0)
            {
                System.out.println("Se actualizó la fila correctamente.");
            }
            else
            {
                System.out.println("No se pudo actualizar la fila. Verifica el ID de escenario.");
            }
        }
        catch (SQLException e)
        {
            System.out.println("no se pudo salvar escenario:" + escenario.getTipo_escenario());
            System.out.println(e.toString());
        }
        finally
        {
            desconectar();
        }
    }

    public void salvarEscenarios(Iterator<Escenario> iter_escenarios)
    {
        Escenario escenario;
        while (iter_escenarios.hasNext())
        {
            escenario = iter_escenarios.next();
            agregarEscenarioNuevo(escenario);
        }
    }

    public void agregarEscenarioNuevo(Escenario nuevoEscenario)
    {
        // Suponiendo que tienes un objeto Escenario con los valores que deseas insertar

        nuevoEscenario.setTipo_escenario("promueve");
        nuevoEscenario.setId_escenario(4);

        String sql =
            "INSERT INTO escenarios (calificacion, recursos, descripcion, regla, tipo_escenario) VALUES (?, ?, ?, ?, ?)";
        conectar();

        try (PreparedStatement pstmt = conexion.prepareStatement(sql))
        {
            pstmt.setString(1, nuevoEscenario.getCalificacion());
            pstmt.setString(2, nuevoEscenario.getRecursos_json());
            pstmt.setString(3, nuevoEscenario.getDescripcion());
            pstmt.setString(4, nuevoEscenario.getRegla());
            pstmt.setString(5, nuevoEscenario.getTipo_escenario());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0)
            {
                System.out.println("Se insertó la nueva fila correctamente.");
            }
            else
            {
                System.out.println("No se pudo insertar la nueva fila.");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
            System.out.println("Error al insertar la nueva fila.");
        }
        finally
        {
            desconectar();
        }

    }

    ////////// Sesion

    public void limpiar_sesiones()
    {
        conectar();
        try
        {
            sentencia = conexion.createStatement();
            String sql = "DELETE FROM sesiones";
            int filasAfectadas = sentencia.executeUpdate(sql);
        }
        catch (SQLException e)
        {
        }
        finally
        {
            desconectar();
        }
    }

    public void sesion_SaveNuevaSesion(Sesion nuevaSesion)
    {
        conectar();
        PreparedStatement pstmt;
        //String sql = "INSERT INTO sesiones (fecha, id_alumno, escenario_asignado, escenario_recomendado, calificacion_difusa, jugado) VALUES (?, ?, ?, ?, ?, ?)";
        String sql =
            "INSERT INTO sesiones (id_alumno, escenario_asignado, escenario_recomendado, calificacion_difusa, jugado) VALUES (?, ?, ?, ?, ?)";

        try 
        {
            pstmt = conexion.prepareStatement(sql);
            //pstmt.setDate(1, new java.sql.Date(nuevaSesion.getFecha().getTime()));
            pstmt.setInt(1, nuevaSesion.getId_alumno());
            pstmt.setInt(2, nuevaSesion.getEscenario_asignado());
            pstmt.setInt(3, nuevaSesion.getEscenario_recomendado());
            pstmt.setString(4, nuevaSesion.getCalificacion_difusa());
            pstmt.setBoolean(5, nuevaSesion.isJugado());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0)
            {
                System.out.println("Se insertó la nueva fila en la tabla sesiones correctamente.");
            }
            else
            {
                System.out.println("No se pudo insertar la nueva fila en la tabla sesiones.");
            }
        }

        catch (SQLException e)
        {
            e.printStackTrace();

        }
        finally
        {
            desconectar();
        }
    }

    public Iterator<Sesion> getSesiones()
    {
        conectar();
        List<Sesion> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM sesiones";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql))
        {
            try (ResultSet rs = pstmt.executeQuery())
            {
                while (rs.next())
                {
                    Sesion sesion = new Sesion();
                    sesion.setId_sesion(rs.getInt("id_sesion"));
                    sesion.setFecha(new Date(rs.getDate("fecha").getTime()));
                    sesion.setId_alumno(rs.getInt("id_alumno"));
                    sesion.setEscenario_asignado(rs.getInt("escenario_asignado"));
                    sesion.setEscenario_recomendado(rs.getInt("escenario_recomendado"));
                    sesion.setCalificacion_difusa(rs.getString("calificacion_difusa"));
                    sesion.setJugado(rs.getBoolean("jugado"));

                    sesiones.add(sesion);
                }
            }
        }
        catch (SQLException e)
        {

        }
        finally
        {
            desconectar();
            return sesiones.iterator();
        }
    }

    public Iterator getSesionesById_alumno(int id_alumno)
    {
        conectar();
        List<Sesion> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM sesiones WHERE id_alumno = ?";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql))
        {
            pstmt.setInt(1, id_alumno);

            try (ResultSet rs = pstmt.executeQuery())
            {
                while (rs.next())
                {
                    Sesion sesion = new Sesion();
                    sesion.setId_sesion(rs.getInt("id_sesion"));
                    sesion.setFecha(new Date(rs.getDate("fecha").getTime()));
                    sesion.setId_alumno(rs.getInt("id_alumno"));
                    sesion.setEscenario_asignado(rs.getInt("escenario_asignado"));
                    sesion.setEscenario_recomendado(rs.getInt("escenario_recomendado"));
                    sesion.setCalificacion_difusa(rs.getString("calificacion_difusa"));
                    sesion.setJugado(rs.getBoolean("jugado"));

                    sesiones.add(sesion);
                }
            }
        }
        catch (SQLException e)
        {

        }
        finally
        {
            desconectar();
            return sesiones.iterator();
        }
    }


    /**selecciona la última sesión jugada por el alumno.
     * @param id_alumno
     * @return
     */
    public Sesion getSesionUlimaById_alumno(int id_alumno) throws SQLException
    {
        conectar();
        Sesion sesion = null;
        String sql =
            "SELECT * FROM mydb.sesiones WHERE id_sesion IN (SELECT MAX(id_sesion) FROM mydb.sesiones WHERE (id_alumno = ?))";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql))
        {
            pstmt.setInt(1, id_alumno);

            try (ResultSet rs = pstmt.executeQuery())
            {
                if (rs.next())
                {
                    sesion = new Sesion();
                    sesion.setId_sesion(rs.getInt("id_sesion"));
                    sesion.setFecha(new Date(rs.getDate("fecha").getTime()));
                    sesion.setId_alumno(rs.getInt("id_alumno"));
                    sesion.setEscenario_asignado(rs.getInt("escenario_asignado"));
                    sesion.setEscenario_recomendado(rs.getInt("escenario_recomendado"));
                    sesion.setCalificacion_difusa(rs.getString("calificacion_difusa"));
                    sesion.setJugado(rs.getBoolean("jugado"));
                }
            }
        }
        finally
        {
            desconectar();
            return sesion;
        }
    }

    public void actualizar_sesion(Sesion sesion)
    {
        conectar();
        try
        {
            System.out.println("actualizando sesion ultima");
            String sql =
                "UPDATE sesiones SET fecha = ?, id_alumno = ?, escenario_asignado = ?, escenario_recomendado = ?, calificacion_difusa = ?, jugado = ? WHERE id_sesion = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            // Establecer los nuevos valores para la fila
            pstmt.setDate(1, new java.sql.Date(sesion.getFecha().getTime())); //fecha
            pstmt.setInt(2, sesion.getId_alumno()); //id_alumno
            pstmt.setInt(3, sesion.getEscenario_asignado()); //escenario_asignado
            pstmt.setInt(4, sesion.getEscenario_recomendado()); //escenario_recomendado
            pstmt.setString(5, sesion.getCalificacion_difusa()); //calificacion_difusa
            pstmt.setBoolean(6, sesion.isJugado()); //jugado
            pstmt.setInt(7, sesion.getId_sesion()); //id_sesion
            
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0)
            {
                System.out.println("Se actualizó la fila correctamente.");
            }
            else
            {
                System.out.println("No se pudo actualizar la fila. Verifica el ID de escenario.");
            }
        }
        catch (SQLException e)
        {
            System.out.println("no se pudo salvar sesion:" + sesion.getId_sesion());
            System.out.println(e.toString());
        }
        finally
        {
            desconectar();
        }
    }

    public void salvarSesionesRecuperadas(Iterator<Sesion> iter_sesiones)
    {
        conectar();
        while (iter_sesiones.hasNext())
        {
            Sesion sesion = iter_sesiones.next();
            salvarUnaSesionRecuperada(sesion);
        }
        desconectar();
    }

    /**Restaura a la base de datos
     * las sesiones backupeadas en json
     * Debe usarse dentro de SalvarSesionesRecuperadas
     * Registra tambien la fecha que tenía y el numero de sesion
     * @param sesionRecuperada
     */
    public void salvarUnaSesionRecuperada(Sesion sesionRecuperada)
    {
        String sql =
            "INSERT INTO sesiones (id_sesion, fecha, id_alumno, escenario_asignado, escenario_recomendado, calificacion_difusa, jugado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql))
        {
            //pstmt.setDate(1, new java.sql.Date(nuevaSesion.getFecha().getTime()));
            pstmt.setInt(1, sesionRecuperada.getId_sesion());
            pstmt.setDate(2, new java.sql.Date(sesionRecuperada.getFecha().getTime()));
            pstmt.setInt(3, sesionRecuperada.getId_alumno());
            pstmt.setInt(4, sesionRecuperada.getEscenario_asignado());
            pstmt.setInt(5, sesionRecuperada.getEscenario_recomendado());
            pstmt.setString(6, sesionRecuperada.getCalificacion_difusa());
            pstmt.setBoolean(7, sesionRecuperada.isJugado());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0)
            {
                System.out.println("Se insertó la nueva fila en la tabla sesiones correctamente.");
            }
            else
            {
                System.out.println("No se pudo insertar la nueva fila en la tabla sesiones.");
            }
        }

        catch (SQLException e)
        {
            e.printStackTrace();

        }
    }


}
