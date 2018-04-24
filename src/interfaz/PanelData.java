package interfaz;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mundo.Data;
import mundo.EstadoDeResultados;
import mundo.Gasto;
import mundo.Ingreso;

public class PanelData extends JPanel{
	
	public PanelData(ArrayList datos) 
	{
		this.setLayout(new GridLayout(datos.size(),1));
	}
	public void actualizarPanel(ArrayList datos) 
	{
		this.removeAll();
		this.setLayout(new GridLayout(datos.size(),1));
			for (int i = 0; i < datos.size(); i++) 
			{
				JLabel aux=new JLabel((((Data)datos.get(i)).getNombre()+"  por un valor de: $"+((Data)datos.get(i)).getValor()));
				add(aux);
			}
		this.repaint();
		this.revalidate();
	}

		
}

