
package iu;


import javax.swing.table.TableModel;
import modelo.I_Info_Items;
import modelo.InfoItems;
import modelo2.Escenario;
import negocio.Sistema;

/**
 *
 * @author leonel
 */
public class JPanel_Escenario_C1 extends javax.swing.JPanel
{
    //no esta bien resuelto el MVC
    int id_escenario;
    String tipo_escenario;
    Sistema sistema;
    jPanel_Combustible jP_Gen_nafta = new jPanel_Combustible();
    jPanel_Combustible jP_Gen_carbon = new jPanel_Combustible();
    jPanel_Combustible jP_Gen_eolico = new jPanel_Combustible();


    /** Creates new form Configuracion_iu */
    TableModel tm_generadores =
        new javax.swing.table.DefaultTableModel(new Object[][] { { "Carbon", null, null, null, null, null, null, null, null, null, null }, { "Nafta", null, null, null, null, null, null, null, null, null, null }, { "Eolico", null, null, null, null, null, null, null, null, null, null } },
                                                new String[] { "Generador", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });

    TableModel tm_combustibles =
        new javax.swing.table.DefaultTableModel(new Object[][] { { "Carbon", null, null, null, null, null, null, null, null, null, null }, { "Nafta", null, null, null, null, null, null, null, null, null, null } },
                                                new String[] { "Combustible", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });
    final int nafta_fila = 1;
    final int carbon_fila = 0;
    final int eolico_fila = 2;

    TableModel tm_zombis =
        new javax.swing.table.DefaultTableModel(new Object[][] { { "Zombis", null, null, null, null, null, null, null, null, null, null }},
                                                new String[] { "Cant", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" });


    public JPanel_Escenario_C1(String tipo_escenario)
    {
        initComponents();
        this.tipo_escenario = tipo_escenario;
        this.jt_Generadores.setModel(tm_generadores);
        this.jt_Combustibles.setModel(tm_combustibles);
        this.jt_Zombis.setModel(tm_zombis);
        this.jb_save.setActionCommand("SAVE");
        sistema = Sistema.getInstance();
        this.jtp_gen_nafta.add("Gen. Nafta", jP_Gen_nafta);
        this.jtp_gen_carbon.add("Gen Carbon", jP_Gen_carbon);
        this.jtp_gen_eolico.add("Gen Eolico", jP_Gen_eolico);

    }

    public void setTitulo(String titulo)
    {
        this.jLabel_titulo.setText(titulo);
    }


    public void puedeSalvar(boolean valor)
    {
        jb_save.setVisible(valor);
        jb_save.setEnabled(valor);
    }

    public void clearData()
    {
        initNafta.setText("");
        initCarbon.setText("");
        jP_Gen_nafta.setDatos(0, 0, 0);
        jP_Gen_carbon.setDatos(0, 0, 0);
        jP_Gen_eolico.setDatos(0, 0, 0);
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            this.tm_generadores.setValueAt("", carbon_fila, index);
            this.tm_generadores.setValueAt("", nafta_fila, index);
            this.tm_generadores.setValueAt("", eolico_fila, index);
            this.tm_combustibles.setValueAt("", carbon_fila, index);
            this.tm_combustibles.setValueAt("", nafta_fila, index);
            this.tm_zombis.setValueAt("", 0, index);
        }


    }

    public void mostrarEscenario(String tipo_escenario)
    {
        Escenario escenario = sistema.getEscenario_by_tipo(tipo_escenario);
        I_Info_Items recursos = escenario.getRecursos_infoItems();
        this.jEditor_Calificacion.setText(escenario.getCalificacion());
        this.jEditor_Descripcion.setText(escenario.getDescripcion());
        this.jEditor_Regla.setText(escenario.getRegla());
        setId_Escenario(escenario.getId_escenario());
        setTipo_Escenario(escenario.getTipo_escenario());
        setData(recursos);
    }

    public void salvarEscenario()
    {
        Escenario escenario;
        escenario = sistema.getEscenario_by_tipo(tipo_escenario);

        InfoItems recursos_infoItems = escenario.getRecursos_infoItems();
        
        
        escenario.setCalificacion(jEditor_Calificacion.getText());
        escenario.setDescripcion(jEditor_Descripcion.getText());
        escenario.setRegla(jEditor_Regla.getText());
        escenario.setTipo_escenario(this.tipo_escenario);


        if (escenario == null)
        {
            System.out.println("es null");
        }
        recursos_infoItems.setInitNafta(this.getInitNafta());
        recursos_infoItems.setInitCarbon(this.getInitCarbon());
        recursos_infoItems.setItem6ConsumoGen(this.getItem6ConsumoGen());
        recursos_infoItems.setItem6Costo(this.getItem6Costo());
        recursos_infoItems.setItem6Productividad(this.getItem6Productividad());
        recursos_infoItems.setItem7ConsumoGen(this.getItem7ConsumoGen());
        recursos_infoItems.setItem7Costo(this.getItem7Costo());
        recursos_infoItems.setItem7Productividad(this.getItem7Productividad());
        recursos_infoItems.setItem8ConsumoGen(this.getItem8ConsumoGen());
        recursos_infoItems.setItem8Costo(this.getItem8Costo());
        recursos_infoItems.setItem8Productividad(this.getItem8Productividad());

        recursos_infoItems.setItem6Day(this.getItem6Day());
        recursos_infoItems.setItem7Day(this.getItem7Day());
        recursos_infoItems.setItem8Day(this.getItem8Day());
        recursos_infoItems.setCarbonDay(this.getCarbonDay());
        recursos_infoItems.setNaftaDay(this.getNaftaDay());
        recursos_infoItems.setZombieDay(this.getZombisDay());

        escenario.setRecursos(recursos_infoItems);
        sistema.actualizarEscenario(escenario);


        //sistema.saveInfoItems_inicial(infoItems);


    }

    public void setId_Escenario(int id)
    {
        this.id_escenario = id;
    }

    public void setTipo_Escenario(String tipo_escenario)
    {
        this.tipo_escenario = tipo_escenario;
    }



    public void setData(I_Info_Items infoItems)
    {
        this.setInitNafta(infoItems.getInitNafta());
        this.setInitCarbon(infoItems.getInitCarbon());

        this.jP_Gen_nafta.setDatos(infoItems.getItem6ConsumoGen(), infoItems.getItem6Costo(),
                                   infoItems.getItem6Productividad());
        this.jP_Gen_carbon.setDatos(infoItems.getItem7ConsumoGen(), infoItems.getItem7Costo(),
                                    infoItems.getItem7Productividad());
        this.jP_Gen_eolico.setDatos(infoItems.getItem8ConsumoGen(), infoItems.getItem8Costo(),
                                    infoItems.getItem8Productividad());

        //cantidad de generadores diarios
        this.setItem6Day(infoItems.getItem6Day());
        this.setItem7Day(infoItems.getItem7Day());
        this.setItem8Day(infoItems.getItem8Day());

        //cantidad de combustible diario
        this.setCarbonDay(infoItems.getCarbonDay());
        this.setNaftaDay(infoItems.getNaftaDay());
        
        //zombis
        this.setZombisDay(infoItems.getZombieDay());
        
     


    }


    public void setCalificacion(String text)
    {
        this.jEditor_Calificacion.setText(text);
    }

    public void setDescripcion(String t)
    {
        this.jEditor_Descripcion.setText(t);
    }

    public void setRegla(String t)
    {
        this.jEditor_Regla.setText(t);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        initNafta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        initCarbon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jb_save = new javax.swing.JButton();
        jtp_gen_nafta = new javax.swing.JTabbedPane();
        jtp_gen_carbon = new javax.swing.JTabbedPane();
        jtp_gen_eolico = new javax.swing.JTabbedPane();
        jLabel_titulo = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditor_Descripcion = new javax.swing.JEditorPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jEditor_Calificacion = new javax.swing.JEditorPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jEditor_Regla = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_Combustibles = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jt_Generadores = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jt_Zombis = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        initNafta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initNaftaActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Cant. inicial de Nafta:");

        initCarbon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initCarbonActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cant. inicial de Carbon:");

        jb_save.setText("Save");
        jb_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_saveMouseClicked(evt);
            }
        });
        jb_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_saveActionPerformed(evt);
            }
        });

        jtp_gen_nafta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtp_gen_carbon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtp_gen_eolico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_titulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_titulo.setText("Escenario");

        jScrollPane6.setViewportView(jEditor_Descripcion);

        jScrollPane4.setViewportView(jEditor_Calificacion);

        jScrollPane5.setViewportView(jEditor_Regla);

        jt_Combustibles.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jt_Combustibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nafta", null, null, null, null, null, null, null, null, null, null},
                {"Carbon", null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Combustible", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ));
        jScrollPane2.setViewportView(jt_Combustibles);
        jt_Combustibles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jt_Combustibles.getColumnModel().getColumnCount() > 0) {
            jt_Combustibles.getColumnModel().getColumn(0).setHeaderValue("Combustible");
            jt_Combustibles.getColumnModel().getColumn(1).setHeaderValue("1");
            jt_Combustibles.getColumnModel().getColumn(2).setHeaderValue("2");
            jt_Combustibles.getColumnModel().getColumn(3).setHeaderValue("3");
            jt_Combustibles.getColumnModel().getColumn(4).setHeaderValue("4");
            jt_Combustibles.getColumnModel().getColumn(5).setHeaderValue("5");
            jt_Combustibles.getColumnModel().getColumn(6).setHeaderValue("6");
            jt_Combustibles.getColumnModel().getColumn(7).setHeaderValue("7");
            jt_Combustibles.getColumnModel().getColumn(8).setHeaderValue("8");
            jt_Combustibles.getColumnModel().getColumn(9).setHeaderValue("9");
            jt_Combustibles.getColumnModel().getColumn(10).setHeaderValue("10");
        }

        jt_Generadores.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jt_Generadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ));
        jt_Generadores.setColumnSelectionAllowed(true);
        jScrollPane8.setViewportView(jt_Generadores);
        jt_Generadores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jt_Generadores.getColumnModel().getColumnCount() > 0) {
            jt_Generadores.getColumnModel().getColumn(0).setHeaderValue("1");
            jt_Generadores.getColumnModel().getColumn(1).setHeaderValue("2");
            jt_Generadores.getColumnModel().getColumn(2).setHeaderValue("3");
            jt_Generadores.getColumnModel().getColumn(3).setHeaderValue("4");
            jt_Generadores.getColumnModel().getColumn(4).setHeaderValue("5");
            jt_Generadores.getColumnModel().getColumn(5).setHeaderValue("6");
            jt_Generadores.getColumnModel().getColumn(6).setHeaderValue("7");
            jt_Generadores.getColumnModel().getColumn(7).setHeaderValue("8");
            jt_Generadores.getColumnModel().getColumn(8).setHeaderValue("9");
            jt_Generadores.getColumnModel().getColumn(9).setHeaderValue("10");
        }

        jt_Zombis.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jt_Zombis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nafta", null, null, null, null, null, null, null, null, null, null},
                {"Carbon", null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Combustible", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ));
        jScrollPane9.setViewportView(jt_Zombis);
        jt_Zombis.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jt_Zombis.getColumnModel().getColumnCount() > 0) {
            jt_Zombis.getColumnModel().getColumn(0).setHeaderValue("Combustible");
            jt_Zombis.getColumnModel().getColumn(1).setHeaderValue("1");
            jt_Zombis.getColumnModel().getColumn(2).setHeaderValue("2");
            jt_Zombis.getColumnModel().getColumn(3).setHeaderValue("3");
            jt_Zombis.getColumnModel().getColumn(4).setHeaderValue("4");
            jt_Zombis.getColumnModel().getColumn(5).setHeaderValue("5");
            jt_Zombis.getColumnModel().getColumn(6).setHeaderValue("6");
            jt_Zombis.getColumnModel().getColumn(7).setHeaderValue("7");
            jt_Zombis.getColumnModel().getColumn(8).setHeaderValue("8");
            jt_Zombis.getColumnModel().getColumn(9).setHeaderValue("9");
            jt_Zombis.getColumnModel().getColumn(10).setHeaderValue("10");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtp_gen_nafta, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtp_gen_carbon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtp_gen_eolico, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(initCarbon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(initNafta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_save, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(initNafta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_save))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(initCarbon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtp_gen_carbon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtp_gen_nafta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtp_gen_eolico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initNaftaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_initNaftaActionPerformed
    {//GEN-HEADEREND:event_initNaftaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initNaftaActionPerformed

    private void initCarbonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_initCarbonActionPerformed
    {//GEN-HEADEREND:event_initCarbonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initCarbonActionPerformed

    private void jb_saveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jb_saveActionPerformed
    {//GEN-HEADEREND:event_jb_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_saveActionPerformed

    private void jb_saveMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jb_saveMouseClicked
    {//GEN-HEADEREND:event_jb_saveMouseClicked
        System.out.println("salvar");
        this.salvarEscenario();
    }//GEN-LAST:event_jb_saveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField initCarbon;
    private javax.swing.JTextField initNafta;
    private javax.swing.JEditorPane jEditor_Calificacion;
    private javax.swing.JEditorPane jEditor_Descripcion;
    private javax.swing.JEditorPane jEditor_Regla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_save;
    private javax.swing.JTable jt_Combustibles;
    private javax.swing.JTable jt_Generadores;
    private javax.swing.JTable jt_Zombis;
    private javax.swing.JTabbedPane jtp_gen_carbon;
    private javax.swing.JTabbedPane jtp_gen_eolico;
    private javax.swing.JTabbedPane jtp_gen_nafta;
    // End of variables declaration//GEN-END:variables


    public int getCant_Gen_Carbon_dia(int dia)
    {
        //Integer dato = (Integer) this.tm_generadores.getValueAt(carbon_fila, dia);
        int dato = Integer.parseInt((String) this.tm_generadores.getValueAt(carbon_fila, dia));
        return dato;
    }


    public int getCant_Gen_Nafta_dia(int dia)
    {
        //Integer dato = (Integer) this.tm_generadores.getValueAt(nafta_fila, dia);
        int dato = Integer.parseInt((String) this.tm_generadores.getValueAt(nafta_fila, dia));
        return dato;
    }


    public int getCant_Gen_Eolico_dia(int dia)
    {
        //Integer dato = (Integer) this.tm_generadores.getValueAt(eolico_fila, dia);
        int dato = Integer.parseInt((String) this.tm_generadores.getValueAt(eolico_fila, dia));
        return dato;
    }


    public int getInitNafta()
    {
        return new Integer((String) this.initNafta.getText());
    }


    public void setInitNafta(int initNafta)
    {
        this.initNafta.setText("" + initNafta);
    }


    public int getInitCarbon()
    {
        return new Integer((String) this.initCarbon.getText());
    }


    public void setInitCarbon(int initCarbon)
    {
        this.initCarbon.setText("" + initCarbon);
    }


    public int getItem6ConsumoGen()
    {
        return new Integer(this.jP_Gen_nafta.getConsumo());
    }


    public int getItem6Costo()
    {
        return new Integer(this.jP_Gen_nafta.getCosto());
    }


    public double getItem6Productividad()
    {
        return new Double(this.jP_Gen_nafta.getProductividad());
    }


    public int getItem7ConsumoGen()
    {
        return new Integer(this.jP_Gen_carbon.getConsumo());
    }


    public int getItem7Costo()
    {
        return new Integer(this.jP_Gen_nafta.getCosto());
    }


    public double getItem7Productividad()
    {
        return new Double(this.jP_Gen_nafta.getProductividad());
    }


    public int getItem8ConsumoGen()
    {
        return new Integer(this.jP_Gen_eolico.getConsumo());
    }


    public int getItem8Costo()
    {
        return new Integer(this.jP_Gen_eolico.getCosto());
    }


    public double getItem8Productividad()
    {
        return new Double(this.jP_Gen_eolico.getProductividad());
    }


    public void setCant_Gen_Carbon_dia(int pos, int cant)
    {
        String c = new Integer(cant).toString();
        this.tm_generadores.setValueAt(c, carbon_fila, pos);
    }


    public void setCant_Gen_Nafta_dia(int dia, int cant)
    {
        String c = new Integer(cant).toString();
        this.tm_generadores.setValueAt(c, nafta_fila, dia);
    }


    public void setCant_Gen_Eolico_dia(int dia, int cant)
    {
        String c = new Integer(cant).toString();
        this.tm_generadores.setValueAt(c, eolico_fila, dia);
    }


    public int[] getItem6Day()
    {
        //cantidad de generadores de carbón incorporados en cada día.

        int[] fila = new int[10];
        int dia = 1;
        for (dia = 1; dia <= 10; dia++)
        {
            fila[dia - 1] = getCant_Gen_Carbon_dia(dia);
        }
        return fila;
    }


    public void setItem6Day(int[] item6Day)
    {
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            setCant_Gen_Carbon_dia(index, item6Day[index - 1]);
        }
    }


    public int[] getItem7Day()
    {
        int[] fila = new int[10];
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            fila[index - 1] = getCant_Gen_Nafta_dia(index);
        }
        return fila;

    }


    public void setItem7Day(int[] item7Day)
    {
        int[] fila = new int[10];
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            setCant_Gen_Nafta_dia(index, item7Day[index - 1]);
        }
    }


    public int[] getItem8Day()
    {
        int[] fila = new int[10];
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            fila[index - 1] = getCant_Gen_Eolico_dia(index);
        }
        return fila;
    }


    public void setItem8Day(int[] item8Day)
    {
        int[] fila = new int[10];
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            setCant_Gen_Eolico_dia(index, item8Day[index - 1]);
        }
    }


    public int[] getCarbonDay()
    {
        int[] fila = new int[10];
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            String valor_str = (String) this.tm_combustibles.getValueAt(carbon_fila, index);
            System.out.println("\n carbon fila: " + carbon_fila + " index:  " + index + ": " + valor_str);
            fila[index - 1] = new Integer(valor_str);
        }
        return fila;
    }


    public void setCarbonDay(int[] carbonDay)
    {
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            this.tm_combustibles.setValueAt("" + carbonDay[index - 1], carbon_fila, index);
        }
    }

    public int[] getZombisDay()
    {
        int[] fila = new int[10];
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            String valor_str = (String) this.tm_zombis.getValueAt(0, index);
            fila[index - 1] = new Integer(valor_str);
        }
        return fila;
    }
    
    public void setZombisDay(int[] zombisDay)
    {
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            this.tm_zombis.setValueAt("" + zombisDay[index - 1], carbon_fila, index);
        }
        
    }

    public int[] getNaftaDay()
    {
        int[] fila = new int[10];
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            String valor_str = (String) this.tm_zombis.getValueAt(0, index);
            fila[index - 1] = new Integer(valor_str);
        }
        return fila;
    }

    public void setNaftaDay(int[] naftaDay)
    {
        int index = 1;
        for (index = 1; index <= 10; index++)
        {
            this.tm_combustibles.setValueAt("" + naftaDay[index - 1], nafta_fila, index);
        }
    }


}
