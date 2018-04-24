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
	
	PanelBotones botones;
	
	PanelTotales totales;
	
	JLabel labUtilidadBruta;
	JTextField txtUtilidadBruta;
	JLabel labUtilidadOperacional;
	JTextField txtUtilidadOperacional;
	JLabel labUtilidadAntImp;
	JTextField txtUtilidadAntImp;
	JLabel labUtilidadLiquida;
	JTextField txtUtilidadLiquida;
	JLabel labUtilidadNeta;
	JTextField txtUtilidadNeta;
	
	JScrollPane uno;
	JScrollPane dos;
	JScrollPane tres;
	
	public PanelEstadoDeResultados(FramePrincipal v)
	{
		inicializarPanelEstadoDeResultados(v);
	}
	public void inicializarPanelEstadoDeResultados(FramePrincipal v)
	{
		setLayout(new BorderLayout());
		uno = new JScrollPane();
		dos = new JScrollPane();
		tres = new JScrollPane();
		
		frame = v;
		
		ingresosOp = new PanelData(frame.darIngresosOperacionales());
        Border bordeIngresosOp = new TitledBorder("Ingresos Operacionales");
        ingresosOp.setBorder(bordeIngresosOp);
        
		ingresosNoOp = new PanelData(frame.darIngresosNoOperacionales());
		Border bordeIngresosNoOp = new TitledBorder("Ingresos no Operacionales");
		ingresosNoOp.setBorder(bordeIngresosNoOp);
		 
		gastosOp = new PanelData(frame.darGastosOperacionales());
		Border bordeGastosOp = new TitledBorder("Gastos Operacionales");
		gastosOp.setBorder(bordeGastosOp);
		
		gastosNoOp = new PanelData(frame.darGastosNoOperacionales());
		Border bordeGastosNoOp = new TitledBorder("Gastos no Operacionales");
		gastosNoOp.setBorder(bordeGastosNoOp);
		
		impuestos = new PanelData(frame.darImpuestos());
		Border bordeImpuestos = new TitledBorder("Impuestos");
		impuestos.setBorder(bordeImpuestos);
		
		reservas = new PanelData(frame.darReervas());
		Border bordeReservas = new TitledBorder("Reservas");
		reservas.setBorder(bordeReservas);
		
		costoVenta = new PanelData(frame.darCostoVenta());
        Border bordeCostoVenta = new TitledBorder("Costos de Venta");
        ingresosOp.setBorder(bordeCostoVenta);
        
		
		JPanel auxUtilidadBruta = new JPanel(new GridLayout(1, 2));
		txtUtilidadBruta = new JTextField(frame.getER().getUtilidadBruta()+"");	
		labUtilidadBruta = new JLabel("Utilidad Bruta");
		auxUtilidadBruta.add(labUtilidadBruta);
		auxUtilidadBruta.add(txtUtilidadBruta);
		
		JPanel auxUtilidadOperacional = new JPanel(new GridLayout(1, 2));
		txtUtilidadOperacional = new JTextField(frame.getER().getUtilidadOperacional()+"");	
		labUtilidadOperacional = new JLabel("Utilidad Operacional");
		auxUtilidadOperacional.add(labUtilidadOperacional);
		auxUtilidadOperacional.add(txtUtilidadOperacional);
		
		JPanel auxUtilidadAntImp = new JPanel(new GridLayout(1, 2));
		txtUtilidadAntImp = new JTextField(frame.getER().getUtilidadAntImp()+"");	
		labUtilidadAntImp = new JLabel("Utilidad Bruta");
		auxUtilidadAntImp.add(labUtilidadAntImp);
		auxUtilidadAntImp.add(txtUtilidadAntImp);
		
		JPanel auxUtilidadLiquida = new JPanel(new GridLayout(1, 2));
		txtUtilidadLiquida = new JTextField(frame.getER().getUtilidadLiquida()+"");	
		labUtilidadLiquida = new JLabel("Utilidad Liquida");
		auxUtilidadLiquida.add(labUtilidadLiquida);
		auxUtilidadLiquida.add(txtUtilidadLiquida);
		
		JPanel auxUtilidadNeta = new JPanel(new GridLayout(1, 2));
		txtUtilidadNeta = new JTextField(frame.getER().getUtilidadNeta()+"");	
		labUtilidadNeta = new JLabel("Utilidad Neta");
		auxUtilidadNeta.add(labUtilidadNeta);
		auxUtilidadNeta.add(txtUtilidadNeta);
		
		JPanel auxPrincipal = new JPanel(new GridLayout(0, 1));
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
		
		botones = new PanelBotones(frame);
		 
		this.add(auxPrincipal,BorderLayout.CENTER);
		this.add(botones,BorderLayout.SOUTH);
	}
	public void actualizarIngresosOp()
	{
		ingresosOp.actualizarPanel();
	}
	public void actualizarIngresosNoOp()
	{
		ingresosNoOp.actualizarPanel();
	}
	public void actualizarGastosOp()
	{
		gastosOp.actualizarPanel();
	}
	public void actualizarGastosNoOp()
	{
		gastosNoOp.actualizarPanel();
	}
	public void actualizarImpuestos()
	{
		impuestos.actualizarPanel();
	}
	public void actualizarReservas()
	{
		reservas.actualizarPanel();
	}
	public void actualizarCostoVenta()
	{
		costoVenta.actualizarPanel();
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
