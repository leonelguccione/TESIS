package main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.I_Info_Items;
import modelo.InfoItems;

public class InfoItemsGUI extends JFrame
{

    private I_Info_Items infoItems;

    private JTextField item6ConsumoGenField;
    private JTextField item6CostoField;
    private JTextField item6CombustibleField;
    private JTextField item6ProductividadField;

    private JTextField playerSpeedField;
    private JTextField playerRecuperacionField;

    public InfoItemsGUI(I_Info_Items infoItems)
    {
        this.infoItems = infoItems;

        setTitle("Editar InfoItems");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Pestaña para editar los campos item6ConsumoGen, item6Costo, item6Combustible e item6Productividad
        JPanel item6Panel = createItem6Panel();
        tabbedPane.addTab("Generador a Carbon", item6Panel);

        // Pestaña para editar los campos playerSpeed y playerRecuperacion
        JPanel playerPanel = createPlayerPanel();
        tabbedPane.addTab("Jugador", playerPanel);

        // Agrega el componente de pestañas a la ventana principal
        add(tabbedPane);

        setVisible(true);
        
        this.item6CombustibleField.setText(infoItems.getCostoText());
    }

    private JPanel createItem6Panel()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel consumoGenLabel = new JLabel("Consumo Generador a Carbon:");
        item6ConsumoGenField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(consumoGenLabel, gbc);
        gbc.gridx = 1;
        panel.add(item6ConsumoGenField, gbc);

        JLabel costoLabel = new JLabel("Costo Generador a Carbon:");
        item6CostoField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(costoLabel, gbc);
        gbc.gridx = 1;
        panel.add(item6CostoField, gbc);

        JLabel combustibleLabel = new JLabel("Combustible Generador a Carbon:");
        item6CombustibleField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(combustibleLabel, gbc);
        gbc.gridx = 1;
        panel.add(item6CombustibleField, gbc);

        JLabel productividadLabel = new JLabel("Productividad Generador a Carbon:");
        item6ProductividadField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(productividadLabel, gbc);
        gbc.gridx = 1;
        panel.add(item6ProductividadField, gbc);

        JButton guardarButton = new JButton("Guardar Cambios");
        guardarButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                saveItem6Changes();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(guardarButton, gbc);

        return panel;
    }

    private JPanel createPlayerPanel()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel speedLabel = new JLabel("Velocidad del Jugador:");
        playerSpeedField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(speedLabel, gbc);
        gbc.gridx = 1;
        panel.add(playerSpeedField, gbc);

        JLabel recuperacionLabel = new JLabel("Recuperación del Jugador:");
        playerRecuperacionField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(recuperacionLabel, gbc);
        gbc.gridx = 1;
        panel.add(playerRecuperacionField, gbc);

        JButton guardarButton = new JButton("Guardar Cambios");
        guardarButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                savePlayerChanges();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(guardarButton, gbc);

        return panel;
    }

    private void saveItem6Changes()
    {
        // Obtener los valores de los campos y actualizar los atributos correspondientes
        try
        {
            int consumoGen = Integer.parseInt(item6ConsumoGenField.getText());
            int costo = Integer.parseInt(item6CostoField.getText());
            int combustible = Integer.parseInt(item6CombustibleField.getText());
            double productividad = Double.parseDouble(item6ProductividadField.getText());

            // Actualizar los atributos en infoItems
            infoItems.setItem6ConsumoGen(consumoGen);
            infoItems.setItem6Costo(costo);
            infoItems.setItem6Combustible(combustible);
            infoItems.setItem6Productividad(productividad);

            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Cambios en Generador a Carbon guardados con éxito.");
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.");
        }
    }

    private void savePlayerChanges()
    {
        // Obtener los valores de los campos y actualizar los atributos correspondientes
        try
        {
            double speed = Double.parseDouble(playerSpeedField.getText());
            double recuperacion = Double.parseDouble(playerRecuperacionField.getText());

            // Actualizar los atributos en infoItems
            infoItems.setPlayerSpeed(speed);
            infoItems.setPlayerRecuperacion(recuperacion);

            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Cambios en Jugador guardados con éxito.");
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.");
        }
    }

    public static void main(String[] args)
    {
        I_Info_Items infoItems = new InfoItems(); // Crea una instancia de InfoItems con valores iniciales
        // Establece valores iniciales para los atributos según sea necesario

        InfoItemsGUI gui = new InfoItemsGUI(infoItems);
    }
}


