package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;

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
		 JTextField  txtTotalActivos=new JTextField("$"+decimalFormatNum(inter.totalActivos()));
		 txtTotalActivos.setEditable(false);
		 JLabel labTotalPasivosMasActivos=new JLabel("Total Pasivos ams patrimonio");
		 JTextField txtTotalPasivosMasActivos=new JTextField("$"+decimalFormatNum(inter.totalPasivosPatrimonio()));
		 txtTotalPasivosMasActivos.setEditable(false);
		 add(labTotalActivos);
		 add(labTotalPasivosMasActivos);
		 add(txtTotalActivos);
		 add(txtTotalPasivosMasActivos);
		 
		
		 
	}
	public String decimalFormatNum(double a) {
		DecimalFormat df=new DecimalFormat("0.00");
		return df.format(a);
	}
}
