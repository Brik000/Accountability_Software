package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import mundo.EstadoDeResultados;

public class PanelBalanceGeneral extends JPanel{

	FramePrincipal frame;
	PanelActivos activos;
	PanelPasivos pasivos;
	PanelPatrimonio patrimonio;
	PanelBotones botones;
	
	PanelTotales totales;
	
	JLabel labTotalActivos;
	JTextField txtTotalActivos;
	JLabel labTotalPasivosMasActivos;
	JTextField txtTotalPasivosMasActivos;
	JPanel aux;
	
	JScrollPane uno;
	JScrollPane dos;
	JScrollPane tres;
	
	public PanelBalanceGeneral(FramePrincipal v) {
		frame = v;
		uno=new JScrollPane();
		dos=new JScrollPane();
		tres=new JScrollPane();
		
		aux=new JPanel();
		aux.setLayout(new GridLayout(2,2));
		this.setLayout(new BorderLayout());
		
		activos = new PanelActivos(frame);
        Border bordeActivos = new TitledBorder("Activos");
        activos.setBorder(bordeActivos);
        
		pasivos=new PanelPasivos(frame);
		Border bordePasivos = new TitledBorder("Pasivos");
		pasivos.setBorder(bordePasivos);
		
		patrimonio=new PanelPatrimonio(frame);
		Border bordePatrimonio = new TitledBorder("Patrimonio");
		patrimonio.setBorder(bordePatrimonio);
		
		
		totales=new PanelTotales(frame);
		Border bordeTotales = new TitledBorder("Totales");
		totales.setBorder(bordeTotales);
		
		
		botones=new PanelBotones(frame);
		uno=new JScrollPane(activos);
		dos=new JScrollPane(pasivos);
		tres=new JScrollPane(patrimonio);
		aux.add(uno);
		aux.add(dos);
		aux.add(totales);
		aux.add(tres);
		
		this.add(aux,BorderLayout.CENTER);
		this.add(botones,BorderLayout.SOUTH);
	
	}
	public void actualizarActivos() {
		activos.actualizarPanel();
	}
	public void actualizarPasivos() {
		pasivos.actualizarPanel();
	}
	public void actualizarPatrimonio() {
		patrimonio.actualizarPanel();
	}
	public void actualizarTotales() {
		totales.actualizarPanel();
	}
	
}
