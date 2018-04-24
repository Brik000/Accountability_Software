package interfaz;

import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPasivos extends JPanel{
	FramePrincipal inter;

	
	public PanelPasivos(FramePrincipal inter) {
		this.inter=inter;
		this.setLayout(new GridLayout(inter.darPasivos().size(),1));
		
		
	}
	public void actualizarPanel() {
		this.removeAll();
		this.setLayout(new GridLayout(inter.darPasivos().size(),1));
		
		for (int i = 0; i < inter.darPasivos().size(); i++) {
			JLabel aux=new JLabel(inter.darPasivos().get(i).getNombre()+"  por un valor de: $"+decimalFormatNum(inter.darPasivos().get(i).getValor()));
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
