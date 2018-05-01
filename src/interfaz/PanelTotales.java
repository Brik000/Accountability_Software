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
	 txtTotalActivos.setFont(new java.awt.Font("Tahoma",0,20));
	 txtTotalActivos.setForeground(Color.RED);
	 
	 JLabel labTotalPasivosMasActivos=new JLabel("Total Pasivos mas patrimonio");
	 JTextField txtTotalPasivosMasActivos=new JTextField("$"+inter.totalPasivosPatrimonio());
	 txtTotalPasivosMasActivos.setEditable(false);
	 txtTotalPasivosMasActivos.setFont(new java.awt.Font("Tahoma",0,20));
	 txtTotalPasivosMasActivos.setForeground(Color.RED);
	 
	
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
		 JLabel labTotalPasivosMasActivos=new JLabel("Total Pasivos mas patrimonio");
		 JTextField txtTotalPasivosMasActivos=new JTextField("$"+decimalFormatNum(inter.totalPasivosPatrimonio()));
		 txtTotalPasivosMasActivos.setEditable(false);
		 txtTotalActivos.setFont(new java.awt.Font("Tahoma",0,20));
		 txtTotalPasivosMasActivos.setFont(new java.awt.Font("Tahoma",0,20));
		 
		 if(inter.totalActivos() == inter.totalPasivosPatrimonio()) {
			 
			 txtTotalActivos.setForeground(Color.GREEN);
			 txtTotalPasivosMasActivos.setForeground(Color.GREEN);
		 }else {
			
			 txtTotalActivos.setForeground(Color.RED);
			 txtTotalPasivosMasActivos.setForeground(Color.RED);
			 
		 }
		 
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
