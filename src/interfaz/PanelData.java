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

	ArrayList datos;
	
	public PanelData(ArrayList datos) 
	{
		this.datos = datos;
		this.setLayout(new GridLayout(datos.size(),1));
	}
	public void actualizarPanel() 
	{
		this.removeAll();
		this.setLayout(new GridLayout(datos.size(),1));
		if(datos.get(0) instanceof Ingreso)
		{
			for (int i = 0; i < datos.size(); i++) 
			{
				JLabel aux=new JLabel(((Ingreso) datos.get(i)).getNombre()+"  por un valor de: $"+((Ingreso)datos.get(i)).getValor());
				add(aux);
			}
		}
		else
		{
			for (int i = 0; i < datos.size(); i++) 
			{
				JLabel aux=new JLabel(((Gasto) datos.get(i)).getNombre()+"  por un valor de: $"+ ((Gasto) datos.get(i)).getValor());
				add(aux);
			}
		this.repaint();
		this.revalidate();
	}

		
}
}
