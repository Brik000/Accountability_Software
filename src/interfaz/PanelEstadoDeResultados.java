package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import mundo.BalanceGeneral;
import mundo.EstadoDeResultados;

public class PanelEstadoDeResultados extends JPanel{

	FramePrincipal frame;
	PanelData gastosOp;
	PanelData gastosNoOp;
	PanelData ingresosOp;
	PanelData ingresosNoOp;
	PanelData impuestos;
	PanelData reservas;
	PanelData costoVenta;
	
	PanelBotones2 botones;
	
	PanelTotales totales;
	
	JLabel labUtilidadBruta;
	JLabel txtUtilidadBruta;
	JLabel labUtilidadOperacional;
	JLabel txtUtilidadOperacional;
	JLabel labUtilidadAntImp;
	JLabel txtUtilidadAntImp;
	JLabel labUtilidadLiquida;
	JLabel txtUtilidadLiquida;
	JLabel labUtilidadNeta;
	JLabel txtUtilidadNeta;
	
	JScrollPane uno;
	JScrollPane dos;
	JScrollPane tres;
	
	public PanelEstadoDeResultados(FramePrincipal v)
	{
		inicializarPanelEstadoDeResultados(v);
	}
	public void inicializarPanelEstadoDeResultados(FramePrincipal v)
	{
		this.removeAll();
		setLayout(new BorderLayout());
		uno = new JScrollPane();
		dos = new JScrollPane();
		tres = new JScrollPane();
		
		frame = v;
		
		ingresosOp = new PanelData(frame.darIngresosOperacionales(), "Ingresos Operacionales");
//        Border bordeIngresosOp = new TitledBorder("Ingresos Operacionales");
//        ingresosOp.setBorder(bordeIngresosOp);
        
		ingresosNoOp = new PanelData(frame.darIngresosNoOperacionales(), "Ingresos No Operacionales");
//		Border bordeIngresosNoOp = new TitledBorder("Ingresos no Operacionales");
//		ingresosNoOp.setBorder(bordeIngresosNoOp);
		 
		gastosOp = new PanelData(frame.darGastosOperacionales(), "Gastos Operacionales");
//		Border bordeGastosOp = new TitledBorder("Gastos Operacionales");
//		gastosOp.setBorder(bordeGastosOp);
		
		gastosNoOp = new PanelData(frame.darGastosNoOperacionales(), "Gastos No Operacionales");
//		Border bordeGastosNoOp = new TitledBorder("Gastos no Operacionales");
//		gastosNoOp.setBorder(bordeGastosNoOp);
		
		impuestos = new PanelData(frame.darImpuestos(), "Impuestos");
//		Border bordeImpuestos = new TitledBorder("Impuestos");
//		impuestos.setBorder(bordeImpuestos);
		
		reservas = new PanelData(frame.darReervas(), "Reservas");
//		Border bordeReservas = new TitledBorder("Reservas");
//		reservas.setBorder(bordeReservas);
		
		costoVenta = new PanelData(frame.darCostoVenta(), "Costos de Venta");
//        Border bordeCostoVenta = new TitledBorder("Costos de Venta");
//        ingresosOp.setBorder(bordeCostoVenta);
        
		
		JPanel auxUtilidadBruta = new JPanel(new BorderLayout());
		txtUtilidadBruta = new JLabel(frame.getER().getUtilidadBruta()+"");	
		labUtilidadBruta = new JLabel("Utilidad Bruta");
		auxUtilidadBruta.add(labUtilidadBruta, BorderLayout.CENTER);
		auxUtilidadBruta.add(txtUtilidadBruta, BorderLayout.EAST);
		
		JPanel auxUtilidadOperacional = new JPanel(new BorderLayout());
		txtUtilidadOperacional = new JLabel(frame.getER().getUtilidadOperacional()+"");	
		labUtilidadOperacional = new JLabel("Utilidad Operacional");
		auxUtilidadOperacional.add(labUtilidadOperacional, BorderLayout.CENTER);
		auxUtilidadOperacional.add(txtUtilidadOperacional, BorderLayout.EAST);
		
		JPanel auxUtilidadAntImp = new JPanel(new BorderLayout());
		txtUtilidadAntImp = new JLabel(frame.getER().getUtilidadAntImp()+"");	
		labUtilidadAntImp = new JLabel("Utilidad Bruta");
		auxUtilidadAntImp.add(labUtilidadAntImp, BorderLayout.CENTER);
		auxUtilidadAntImp.add(txtUtilidadAntImp, BorderLayout.EAST);
		
		JPanel auxUtilidadLiquida = new JPanel(new BorderLayout());
		txtUtilidadLiquida = new JLabel(frame.getER().getUtilidadLiquida()+"");	
		labUtilidadLiquida = new JLabel("Utilidad Liquida");
		auxUtilidadLiquida.add(labUtilidadLiquida, BorderLayout.CENTER);
		auxUtilidadLiquida.add(txtUtilidadLiquida, BorderLayout.EAST);
		
		JPanel auxUtilidadNeta = new JPanel(new BorderLayout());
		txtUtilidadNeta = new JLabel(frame.getER().getUtilidadNeta()+"");	
		labUtilidadNeta = new JLabel("Utilidad Neta");
		auxUtilidadNeta.add(labUtilidadNeta, BorderLayout.CENTER);
		auxUtilidadNeta.add(txtUtilidadNeta, BorderLayout.EAST);
		
		JPanel auxPrincipal = new JPanel(new GridLayout(0, 1, 0,10));
		auxPrincipal.add(ingresosOp);
		auxPrincipal.add(costoVenta);
		auxPrincipal.add(auxUtilidadBruta);
		auxPrincipal.add(gastosOp);
		auxPrincipal.add(auxUtilidadOperacional);
		auxPrincipal.add(ingresosNoOp);
		auxPrincipal.add(gastosNoOp);
		auxPrincipal.add(auxUtilidadAntImp);
		auxPrincipal.add(impuestos);
		auxPrincipal.add(auxUtilidadLiquida);
		auxPrincipal.add(reservas);
		auxPrincipal.add(auxUtilidadNeta);
		
		botones = new PanelBotones2(frame);
		 
		actualizarIngresosOp();
		actualizarIngresosNoOp();
		actualizarGastosOp();
		actualizarGastosNoOp();
		actualizarImpuestos();
		actualizarReservas();
		actualizarCostoVenta();
		actualizarTotales();
		this.add(auxPrincipal,BorderLayout.CENTER);
		this.add(botones,BorderLayout.SOUTH);
	
	}
	public void actualizarIngresosOp()
	{
		ingresosOp.actualizarPanel(frame.getER().darIngresosOperacionales());
	}
	public void actualizarIngresosNoOp()
	{
		ingresosNoOp.actualizarPanel(frame.getER().darIngresosNoOperacionales());
	}
	public void actualizarGastosOp()
	{
		gastosOp.actualizarPanel(frame.getER().darGastosOperacionales());
	}
	public void actualizarGastosNoOp()
	{
		gastosNoOp.actualizarPanel(frame.getER().darGastosNoOperacionales());
	}
	public void actualizarImpuestos()
	{
		impuestos.actualizarPanel(frame.getER().darImpuestos());
	}
	public void actualizarReservas()
	{
		reservas.actualizarPanel(frame.getER().darReservas());
	}
	public void actualizarCostoVenta()
	{
		costoVenta.actualizarPanel(frame.getER().darCostoVenta());
	}
	public void actualizarTotales()
	{
		txtUtilidadBruta.setText("$" + frame.getER().getUtilidadBruta());
		txtUtilidadOperacional.setText("$" + frame.getER().getUtilidadOperacional());
		txtUtilidadAntImp.setText("$" + frame.getER().getUtilidadAntImp());
		txtUtilidadLiquida.setText("$" + frame.getER().getUtilidadLiquida());
		txtUtilidadNeta.setText("$" + frame.getER().getUtilidadNeta());
	}
}
