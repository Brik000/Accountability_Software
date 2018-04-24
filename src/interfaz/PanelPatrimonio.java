package interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPatrimonio extends JPanel {
	FramePrincipal inter;
	public PanelPatrimonio(FramePrincipal inter) {
		this.inter=inter;
		this.setLayout(new GridLayout(inter.darPatrimonio().size(),1));
		
	}
	public void actualizarPanel() {
		this.removeAll();
		this.setLayout(new GridLayout(inter.darPatrimonio().size(),1));
		
		for (int i = 0; i < inter.darPatrimonio().size(); i++) {
			JLabel aux=new JLabel(inter.darPatrimonio().get(i).getNombre()+"  por un valor de: $"+inter.darPatrimonio().get(i).getValor());
			add(aux);
			}
			this.repaint();
			this.revalidate();
		}
	
	
	
}
