package interfaz;

import java.awt.GridLayout;

import javax.swing.*;

public class PanelActivos extends JPanel {
	FramePrincipal inter;
	
	public PanelActivos(FramePrincipal inter) {
		this.inter=inter;
		this.setLayout(new GridLayout(inter.darActivos().size(),1));
	}
	public void actualizarPanel() {
		this.removeAll();
		this.setLayout(new GridLayout(inter.darActivos().size(),1));
		for (int i = 0; i < inter.darActivos().size(); i++) {
			JLabel aux=new JLabel(inter.darActivos().get(i).getNombre()+"  por un valor de: $"+inter.darActivos().get(i).getValor());
			add(aux);
			}
			this.repaint();
			this.revalidate();
		}

		
	}

