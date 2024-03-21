package iu;

import excepciones.SesionNoJugadaException;
import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import modelo.Alumno;
import modelo2.Sesion;
import negocio.Sistema;

/**
 *
 * @author leonel
 */
public class JPanel_Recomendaciones extends javax.swing.JPanel
{

    DefaultListModel modeloLista_alumnos;//new DefaultListModel();
    DefaultListModel modeloLista_sesiones;
    Sistema sistema;
    jPanel_Sesion jPanel_Sesion_C1;
    jPanel_Sesion jPanel_Sesion_C2;
    jPanel_Sesion jPanel_Sesion_C3;

    /**
     * Creates new form JPanel_Recomendacion
     */
    public JPanel_Recomendaciones()
    {
        initComponents();
        this.sistema = Sistema.getInstance();
        modeloLista_alumnos = new DefaultListModel();
        jL_alumnos.setModel(modeloLista_alumnos);
        modeloLista_sesiones = new DefaultListModel();
        jL_sesiones.setModel(modeloLista_sesiones);

        jPanel_Sesion_C1 = new jPanel_Sesion();
        jPanel_Sesion_C2 = new jPanel_Sesion();
        jPanel_Sesion_C3 = new jPanel_Sesion();

        jPanel_recomendaciones.setLayout(new BorderLayout());
        jPanel_recomendaciones.add(jPanel_Sesion_C1, BorderLayout.CENTER);
        //jPanel_recomendaciones2.setLayout(new GridLayout(1, 1));
        //jPanel_recomendaciones2.add(jPanel_Sesion_C2);
        //jPanel_recomendaciones3.setLayout(new GridLayout(1, 1));
        //jPanel_recomendaciones3.add(jPanel_Sesion_C3);

        //panel_Recomendacion.add(vista_Items_Recomendados_C1);
        // jL_alumnos.setModel(modeloLista_alumnos);
        //jL_sesiones.setModel(modeloLista_sesiones);
        initDatos();
    }

    public void initDatos()
    {
        try
        {
            modeloLista_alumnos.clear();
            Iterator<Alumno> alumnos = sistema.getAlumnos_from_Tabla();
            while (alumnos.hasNext())
            {
                modeloLista_alumnos.addElement(alumnos.next());
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void setJL_sesiones(int id_alumno)
    {
        modeloLista_sesiones.clear();
        //Iterator<InfoItems_alumno_sesion> iter_alumnos_sesion = sistema.getInfoItems_alumno_from_tabla(id_alumno);
        Iterator iter_sesiones = sistema.getSesionesById_alumno(id_alumno);
        while (iter_sesiones.hasNext())
        {
            modeloLista_sesiones.addElement((Sesion) iter_sesiones.next());
        }
    }

    public void realizarNuevaRecomendacion() throws SesionNoJugadaException, SQLException
    {
        System.out.println("recomendando");
        int index = jL_alumnos.getSelectedIndex();
        Alumno unAlumno = (Alumno) modeloLista_alumnos.getElementAt(index);
        System.out.println("recomendando");
        sistema.recomendar(unAlumno.getId_alumno());
        //setJL_sesiones(unAlumno.getId_alumno());
        modeloLista_sesiones.clear();
        jPanel_Sesion_C1.clearData();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jT_nombre = new javax.swing.JTextField();
        jT_apellido = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jL_sesiones = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jB_nuevaRecomendacion = new javax.swing.JButton();
        jT_id1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jL_alumnos = new javax.swing.JList<>();
        jPanel_recomendaciones = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(32000, 32000));
        setName("jp_principal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(750, 750));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Nombre");

        jLabel2.setText("Alumno elegido");

        jLabel4.setText("Apellido");

        jLabel5.setText("id");

        jL_sesiones.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jL_sesiones.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jL_sesionesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jL_sesiones);

        jLabel6.setText("Sesiones");

        jB_nuevaRecomendacion.setText("nueva recomendacion");
        jB_nuevaRecomendacion.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jB_nuevaRecomendacionMouseClicked(evt);
            }
        });

        jT_id1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jT_id1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jT_nombre))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jT_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jT_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addComponent(jLabel6)
                    .addComponent(jB_nuevaRecomendacion))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jT_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jT_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jT_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_nuevaRecomendacion)
                .addGap(6, 6, 6))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Alumnos:");

        jL_alumnos.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jL_alumnos.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jL_alumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jL_alumnos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 218, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(6, 6, 6))
        );

        jPanel_recomendaciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel_recomendacionesLayout = new javax.swing.GroupLayout(jPanel_recomendaciones);
        jPanel_recomendaciones.setLayout(jPanel_recomendacionesLayout);
        jPanel_recomendacionesLayout.setHorizontalGroup(
            jPanel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        jPanel_recomendacionesLayout.setVerticalGroup(
            jPanel_recomendacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_recomendaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_recomendaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jL_alumnosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jL_alumnosMouseClicked
    {//GEN-HEADEREND:event_jL_alumnosMouseClicked
        int index = jL_alumnos.getSelectedIndex();
        Alumno unAlumno = (Alumno) modeloLista_alumnos.getElementAt(index);
        jT_apellido.setText(unAlumno.getApellido());
        jT_nombre.setText(unAlumno.getNombre());
        jT_id1.setText(unAlumno.getId_alumno() + "");
        setJL_sesiones(unAlumno.getId_alumno());
        //vista_Items_Recomendados_C1.clearData();
    }//GEN-LAST:event_jL_alumnosMouseClicked

    private void jL_sesionesMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jL_sesionesMouseClicked
    {//GEN-HEADEREND:event_jL_sesionesMouseClicked
        int index = jL_sesiones.getSelectedIndex();
        Sesion sesion = (Sesion) modeloLista_sesiones.getElementAt(index);
        System.out.println("sesion: " + sesion.toString() + " " + sesion.getFecha().toString());
        //this.jPanel_Sesion_C1.setData(criterio, fecha, calificacion, tipo_escenario_asignado, tipo_escenario_rec);
        this.jPanel_Sesion_C1.setData("Criterio 1", sesion.getFecha().toString(), sesion.getCalificacion_difusa() + "",
                sesion.getEscenarioAsignado() + "", sesion.getEscenarioRecomendado() + "");
        //this.jPanel_Sesion_C1.setData("Criterio 1","","","","");

        //vista_Items_Recomendados_C1.setData(iias);
    }//GEN-LAST:event_jL_sesionesMouseClicked

    private void jB_nuevaRecomendacionMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jB_nuevaRecomendacionMouseClicked
    {//GEN-HEADEREND:event_jB_nuevaRecomendacionMouseClicked
        try
        {
            realizarNuevaRecomendacion();
        }
        catch (SesionNoJugadaException e)
        {
            JOptionPane.showMessageDialog(this, "no se pudo realizar la recomendacion", "problemas", JOptionPane.INFORMATION_MESSAGE);

            Logger.getLogger(JPanel_Recomendaciones.class.getName()).log(Level.SEVERE, null, e);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(JPanel_Recomendaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jB_nuevaRecomendacionMouseClicked

    private void jT_id1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jT_id1ActionPerformed
    {//GEN-HEADEREND:event_jT_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_id1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_nuevaRecomendacion;
    private javax.swing.JList<String> jL_alumnos;
    private javax.swing.JList<String> jL_sesiones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_recomendaciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jT_apellido;
    private javax.swing.JTextField jT_id1;
    private javax.swing.JTextField jT_nombre;
    // End of variables declaration//GEN-END:variables

}