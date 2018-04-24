package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import mundo.Activo;
import mundo.BalanceGeneral;
import mundo.EstadoDeResultados;
import mundo.Gasto;
import mundo.Ingreso;
import mundo.Pasivo;
import mundo.Patrimonio;

public class FramePrincipal extends JFrame{
	
//	BalanceGeneral mundo;
//	PanelActivos activos;
//	PanelPasivos pasivos;
//	PanelPatrimonio patrimonio;
//	PanelBotones botones;
//	
//	PanelTotales totales;
//	
//	JLabel labTotalActivos;
//	JTextField txtTotalActivos;
//	JLabel labTotalPasivosMasActivos;
//	JTextField txtTotalPasivosMasActivos;
//	JPanel aux;
//	
//	JScrollPane uno;
//	JScrollPane dos;
//	JScrollPane tres;
	
	EstadoDeResultados ER;
	BalanceGeneral BG;
	
	PanelBalanceGeneral panelBG;
	PanelEstadoDeResultados panelER;
	
	
	
	public FramePrincipal() {
//		uno=new JScrollPane();
//		dos=new JScrollPane();
//		tres=new JScrollPane();
//		
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		aux=new JPanel();
//		aux.setLayout(new GridLayout(2,2));
//		this.setLayout(new BorderLayout());
//		
//		mundo=new BalanceGeneral();
//		
//		activos=new PanelActivos(this);
//        Border bordeActivos = new TitledBorder("Activos");
//        activos.setBorder(bordeActivos);
//        
//		pasivos=new PanelPasivos(this);
//		Border bordePasivos = new TitledBorder("Pasivos");
//		pasivos.setBorder(bordePasivos);
//		
//		patrimonio=new PanelPatrimonio(this);
//		Border bordePatrimonio = new TitledBorder("Patrimonio");
//		patrimonio.setBorder(bordePatrimonio);
//		
//		
//		totales=new PanelTotales(this);
//		Border bordeTotales = new TitledBorder("Totales");
//		totales.setBorder(bordeTotales);
//		
//		
//		botones=new PanelBotones(this);
//		uno=new JScrollPane(activos);
//		dos=new JScrollPane(pasivos);
//		tres=new JScrollPane(patrimonio);
//		aux.add(uno);
//		aux.add(dos);
//		aux.add(totales);
//		aux.add(tres);
		
		JTabbedPane aux = new JTabbedPane();
		ER = new EstadoDeResultados();
		panelER = new PanelEstadoDeResultados(this);
		
		BG = new BalanceGeneral();
		panelBG = new PanelBalanceGeneral(this);
		aux.addTab("Balance General", panelBG);
		aux.addTab("Estado de Resultados", panelER);
		add(aux);
		//this.add(botones,BorderLayout.SOUTH);
		
		pack();
		this.setResizable(false);
	}
	
	public double totalActivos() {
		return BG.getTotal1();
	}
	public double totalPasivosPatrimonio() {
		return BG.getTotal2();
	}
	
	public void eliminarActivo(String a) throws Exception {
		BG.eliminarActivo(a);
	}
	public void eliminarPasivo(String a) throws Exception {
		BG.eliminarPasivo(a);
	}
	public void eliminarPatrimonio(String a) throws Exception {
		BG.eliminarPatrimonio(a);
	}
	public void agregarActivo(String a, double b) {
		BG.anadirActivo(a, b);
		
	}
	public void agregarPasivo(String a, double b) {
		BG.anadirPasivo(a, b);
	}
	public void agregarPatrimonio(String a, double b) {
		BG.anadirPatrimonio(a, b);
	}
	public ArrayList<Pasivo> darPasivos(){
		return BG.getPasivos();
	}
	public ArrayList<Activo> darActivos(){
		return BG.getActivos();
	}
	public ArrayList<Patrimonio> darPatrimonio(){
		return BG.getPatrimonio();
	}
//	public void actualizarActivos() {
//		activos.actualizarPanel();
//		pack();
//	}
//	public void actualizarPasivos() {
//		pasivos.actualizarPanel();
//		pack();
//	}
//	public void actualizarPatrimonio() {
//		patrimonio.actualizarPanel();
//		pack();
//	}
//	public void actualizarTotales() {
//		totales.actualizarPanel();
//		pack();
//	}
	
	public ArrayList<Ingreso> darIngresosOperacionales()
	{
		return ER.darIngresosOperacionales();
	}
	public ArrayList<Ingreso> darIngresosNoOperacionales()
	{
		return ER.darIngresosNoOperacionales();
	}
	public ArrayList<Gasto> darGastosOperacionales()
	{
		return ER.darGastosOperacionales();
	}
	public ArrayList<Gasto> darGastosNoOperacionales()
	{
		return ER.darGastosNoOperacionales();
	}
	public ArrayList<Gasto> darImpuestos()
	{
		return ER.darImpuestos();
	}
	public ArrayList<Gasto> darReervas()
	{
		return ER.darReservas();
	}
	public ArrayList<Gasto> darCostoVenta()
	{
		return ER.darCostoVenta();
	}
	public EstadoDeResultados getER() {
		return ER;
	}

	public void setER(EstadoDeResultados eR) {
		ER = eR;
	}
	
	public PanelBalanceGeneral getPanelBG() {
		return panelBG;
	}

	public PanelEstadoDeResultados getPanelER() {
		return panelER;
	}

	public void setPanelBG(PanelBalanceGeneral panelBG) {
		this.panelBG = panelBG;
	}

	public void setPanelER(PanelEstadoDeResultados panelER) {
		this.panelER = panelER;
	}

	public BalanceGeneral getBG() {
		return BG;
	}

	public void setBG(BalanceGeneral bG) {
		BG = bG;
	}
	public void agregarIngreso(String nombre, double valor, String tipo)
	{
		ER.agregarIngreso(nombre, valor, tipo);
	}
	public void agregarGasto(String nombre, double valor, String tipo)
	{
		ER.agregarGasto(nombre, valor, tipo);
	}
	public static void main(String[] args) {
		FramePrincipal frame=new FramePrincipal();
		frame.setVisible(true);
		
	}
	
}
