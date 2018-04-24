package interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTotales extends JPanel{
	FramePrincipal inter;
	//el vaino de los totales 
	public PanelTotales(FramePrincipal inter) {
	this.inter=inter;
	 setLayout(new GridLayout(2,2));
	
	 JLabel labTotalActivos=new JLabel("Total Activos");
	 JTextField  txtTotalActivos=new JTextField("$"+inter.totalActivos());
	 txtTotalActivos.setEditable(false);
	 JLabel labTotalPasivosMasActivos=new JLabel("Total Pasivos mas patrimonio");
	 JTextField txtTotalPasivosMasActivos=new JTextField("$"+inter.totalPasivosPatrimonio());
	 txtTotalPasivosMasActivos.setEditable(false);
	 add(labTotalActivos);
	 add(labTotalPasivosMasActivos);
	 add(txtTotalActivos);
	 add(txtTotalPasivosMasActivos);
	 
	}
	public void actualizarPanel() {
		this.removeAll();
		 setLayout(new GridLayout(2,2));
			
		 JLabel labTotalActivos=new JLabel("Total Activos");
		 JTextField  txtTotalActivos=new JTextField("$"+inter.totalActivos());
		 txtTotalActivos.setEditable(false);
		 JLabel labTotalPasivosMasActivos=new JLabel("Total Pasivos ams patrimonio");
		 JTextField txtTotalPasivosMasActivos=new JTextField("$"+inter.totalPasivosPatrimonio());
		 txtTotalPasivosMasActivos.setEditable(false);
		 add(labTotalActivos);
		 add(labTotalPasivosMasActivos);
		 add(txtTotalActivos);
		 add(txtTotalPasivosMasActivos);
	}
}
