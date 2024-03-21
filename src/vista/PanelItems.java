package vista;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelItems extends JPanel
{
	private HashMap<String, JTextField> camposTexto = new HashMap<String, JTextField>();

	public PanelItems(Iterator<String> it)
	{
		setLayout(new GridLayout(0, 2, 0, 0));
		while (it.hasNext())
		{
			String atributo = it.next();
			JPanel panel1 = new JPanel();
			JLabel label1 = new JLabel(atributo);
			panel1.add(label1);

			JPanel panel2 = new JPanel();
			JTextField textField = new JTextField();
			panel2.add(textField);
			textField.setColumns(10);

			this.add(panel1);
			this.add(panel2);
			this.camposTexto.put(atributo, textField);
		}

	}

	public void setDato(String atributo, Object valor)
	{
		JTextField tf = this.camposTexto.get(atributo);
		if (tf != null)
			tf.setText(valor.toString());
	}

	public String getDato(String atributo)
	{
		String respuesta = null;
		JTextField tf = this.camposTexto.get(atributo);
		if (tf != null)
			respuesta = this.camposTexto.get(atributo).getText();
		return respuesta;
	}
}
