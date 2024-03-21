package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import util.UtilReadJSON;

public class Ventana extends JFrame
{

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private PanelItems panelItems;
	private JPanel panel_1;
	private JButton btnAceptar;

	public Ventana(ActionListener listener, Iterator<String> it)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, BorderLayout.CENTER);

		this.panelItems = new PanelItems(it);
		this.scrollPane.setViewportView(this.panelItems);

		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1, BorderLayout.SOUTH);

		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.setActionCommand("ACEPTAR");
		this.btnAceptar.addActionListener(listener);
		this.panel_1.add(this.btnAceptar);
		this.setVisible(true);
	}

	public void setDato(String atributo, Object valor)
	{
		this.panelItems.setDato(atributo, valor);

	}

	public String getDato(String atributo)
	{
		return this.panelItems.getDato(atributo);
	}
}
