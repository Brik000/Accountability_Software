package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;
import mundo.Data;
import mundo.EstadoDeResultados;
import mundo.Gasto;
import mundo.Ingreso;

public class PanelData extends JPanel{
	
	String titulo;
	public PanelData(ArrayList datos, String titulo) 
	{
		this.setLayout(new GridLayout(datos.size()+1,1));
		this.titulo = titulo;
		add(new JLabel(titulo));
	}
	public void actualizarPanel(ArrayList datos) {
		this.removeAll();
		this.setLayout(new GridLayout(datos.size()+1,1));
		add(new JLabel(titulo));
		for (int i = 0; i < datos.size(); i++) {
			JPanel aux= new JPanel(new BorderLayout());
			JLabel nombre =  new JLabel((((Data) datos.get(i)).getNombre())+"  por un valor de: ");
			JLabel valor = new JLabel((("$"+decimalFormatNum(((Data) datos.get(i)).getValor()))));
			aux.add(nombre, BorderLayout.CENTER);
			aux.add(valor, BorderLayout.EAST);
			add(aux);
			}
			this.repaint();
			this.revalidate();
	}
	
	public String decimalFormatNum(double a) {
		DecimalFormat df=new DecimalFormat("0.00");
		return df.format(a);
	}

		
}

