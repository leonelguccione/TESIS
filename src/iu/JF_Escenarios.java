/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package iu;

import javax.swing.JScrollPane;

/**
 *
 * @author leonel
 */
public class JF_Escenarios extends javax.swing.JInternalFrame
{
    JPanel_Escenarios_C1 jPanel_Escenarios_C1;

    /**
     * Creates new form JF_Escenarios
     */
    public JF_Escenarios()
    {
        initComponents();
        jPanel_Escenarios_C1 = new JPanel_Escenarios_C1();
        jPanel_Escenarios_C1.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(jPanel_Escenarios_C1);
        
        // Configurar el JScrollPane para que muestre barras de desplazamiento según sea necesario
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        // Agregar el JScrollPane al marco
       // add(scrollPane);
        
        
        getContentPane().add(scrollPane);
        setVisible(true);
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

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setVisible(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
