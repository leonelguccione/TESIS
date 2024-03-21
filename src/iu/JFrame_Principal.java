package iu;

//import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import negocio.Sistema;

/**
 *
 * @author leonel
 */
public class JFrame_Principal extends javax.swing.JFrame
{

    JPanel_Alumnos_Alta jPanel_Alumnos;
    JPanel_Recomendaciones jP_recomendaciones;
    JPanel_Escenarios_C1 jP_escenarios;
    JScrollPane scrollPane;
    Sistema sistema;

    /**
     * Creates new form JFrame_Configuracion_iu
     *
     * @param sistema
     */
    public JFrame_Principal()
    {
        initComponents();
        jP_escenarios = new JPanel_Escenarios_C1();
        scrollPane = new JScrollPane(jP_escenarios);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //getContentPane().add(scrollPane);

        // Mostramos la ventana
        setVisible(true);

        jP_recomendaciones = new JPanel_Recomendaciones();
        jPanel_Alumnos = new JPanel_Alumnos_Alta();
        jTabbedPane1.add("Alta de alumnos", jPanel_Alumnos);
        //jTabbedPane1.add("Recomendacion", jPanel_EIC1);
        //jTabbedPane1.add("Escenarios", jP_escenarios);
        jTabbedPane1.add("Escenarios", scrollPane);
        jTabbedPane1.add("Recomendaciones", jP_recomendaciones);
        this.setExtendedState(MAXIMIZED_BOTH);
        //setSistema(sistema);

    }

    public void setSistema(Sistema sistema)
    {
        this.sistema = sistema;
        jP_escenarios.setSistema(sistema);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[])
    {

        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager
                            .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util
            .logging.Logger
                    .getLogger(JFrame_Principal.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger
                    .getLogger(JFrame_Principal.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger
                    .getLogger(JFrame_Principal.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger
                    .getLogger(JFrame_Principal.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue
                .invokeLater(new Runnable()
                {
                    public void run()
                    {
                        new JFrame_Principal().setVisible(true);
                    }
                });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
