package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import mundo.Activo;
import mundo.BalanceGeneral;
import mundo.Pasivo;
import mundo.Patrimonio;

public class FramePrincipal extends JFrame{
	
	BalanceGeneral mundo;
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
	
	
	
	
	public FramePrincipal() {
		uno=new JScrollPane();
		dos=new JScrollPane();
		tres=new JScrollPane();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		aux=new JPanel();
		aux.setLayout(new GridLayout(2,2));
		this.setLayout(new BorderLayout());
		
		mundo=new BalanceGeneral();
		
		activos=new PanelActivos(this);
        Border bordeActivos = new TitledBorder("Activos");
        activos.setBorder(bordeActivos);
        
		pasivos=new PanelPasivos(this);
		Border bordePasivos = new TitledBorder("Pasivos");
		pasivos.setBorder(bordePasivos);
		
		patrimonio=new PanelPatrimonio(this);
		Border bordePatrimonio = new TitledBorder("Patrimonio");
		patrimonio.setBorder(bordePatrimonio);
		
		
		totales=new PanelTotales(this);
		Border bordeTotales = new TitledBorder("Totales");
		totales.setBorder(bordeTotales);
		
		
		botones=new PanelBotones(this);
		uno=new JScrollPane(activos);
		dos=new JScrollPane(pasivos);
		tres=new JScrollPane(patrimonio);
		aux.add(uno);
		aux.add(dos);
		aux.add(totales);
		aux.add(tres);
		
		this.add(aux,BorderLayout.CENTER);
		this.add(botones,BorderLayout.SOUTH);
		
		pack();
		this.setResizable(false);
	}
	
	public double totalActivos() {
		return mundo.getTotal1();
	}
	public double totalPasivosPatrimonio() {
		return mundo.getTotal2();
	}
	
	public void eliminarActivo(String a) throws Exception {
		mundo.eliminarActivo(a);
	}
	public void eliminarPasivo(String a) throws Exception {
		mundo.eliminarPasivo(a);
	}
	public void eliminarPatrimonio(String a) throws Exception {
		mundo.eliminarPatrimonio(a);
	}
	public void agregarActivo(String a, double b) {
		mundo.anadirActivo(a, b);
		
	}
	public void agregarPasivo(String a, double b) {
		mundo.anadirPasivo(a, b);
	}
	public void agregarPatrimonio(String a, double b) {
	mundo.anadirPatrimonio(a, b);
	}
	public ArrayList<Pasivo> darPasivos(){
		return mundo.getPasivos();
	}
	public ArrayList<Activo> darActivos(){
		return mundo.getActivos();
	}
	public ArrayList<Patrimonio> darPatrimonio(){
		return mundo.getPatrimonio();
	}
	public void actualizarActivos() {
		activos.actualizarPanel();
		pack();
	}
	public void actualizarPasivos() {
		pasivos.actualizarPanel();
		pack();
	}
	public void actualizarPatrimonio() {
		patrimonio.actualizarPanel();
		pack();
	}
	public void actualizarTotales() {
		totales.actualizarPanel();
		pack();
	}
	
	public static void main(String[] args) {
		FramePrincipal frame=new FramePrincipal();
		frame.setVisible(true);
		
	}

}
