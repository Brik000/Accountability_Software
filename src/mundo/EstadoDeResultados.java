package mundo;

import java.util.ArrayList;

public class EstadoDeResultados {
	
	public static final String OPERACIONAL = "Operacional";
	public static final String NO_OPERACIONAL = "No Operacional";
	public static final String IMPUESTO = "Impuesto";
	public static final String RESERVA = "Reserva";
	public static final String COSTO_VENTA = "Costo de Venta";
	
	private ArrayList<Gasto> gastos;
	private ArrayList<Ingreso> ingresos;
	
	private double utilidadBruta;
	private double utilidadOperacional;
	private double utilidadAntImp;
	private double utilidadLiquida;
	private double utilidadNeta;
	
	public EstadoDeResultados()
	{
		gastos = new ArrayList<>();
		ingresos = new ArrayList<>();
		utilidadBruta = 0;
		utilidadOperacional = 0;
		utilidadAntImp = 0;
		utilidadLiquida = 0;
		utilidadNeta = 0;
	}
	public void agregarGasto(String nombre, double valor, String tipo)
	{
		gastos.add(new Gasto(nombre, valor, tipo));
	}
	public void agregarIngreso(String nombre, double valor, String tipo)
	{
		ingresos.add(new Ingreso(nombre, valor, tipo));
	}
	public void calcularUtilidadBruta()
	{
		utilidadBruta = 0;
		for (int i = 0; i < ingresos.size(); i++) 
		{
			if(ingresos.get(i).getTipo().equals(OPERACIONAL))
			{
				utilidadBruta += ingresos.get(i).getValor();
			}
		}
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(COSTO_VENTA))
			{
				utilidadBruta -= gastos.get(i).getValor();
			}
		}
	}
	public void calcularUtilidadOperacional()
	{
		utilidadOperacional= 0;
		utilidadOperacional += utilidadBruta;
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(OPERACIONAL))
			{
				utilidadOperacional -= gastos.get(i).getValor();
			}
		}
	}
	public void calcularUtilidadAntesDeImpuesto()
	{
		utilidadAntImp = 0;
		utilidadAntImp += utilidadOperacional;
		for (int i = 0; i < ingresos.size(); i++) 
		{
			if(ingresos.get(i).getTipo().equals(NO_OPERACIONAL))
			{
				utilidadAntImp += ingresos.get(i).getValor();
			}
		}
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(NO_OPERACIONAL))
			{
				utilidadAntImp -= gastos.get(i).getValor();
			}
		}
	}
	public void calcularUtilidadLiquida()
	{
		utilidadLiquida= 0;
		utilidadLiquida += utilidadAntImp;
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(IMPUESTO))
			{
				utilidadLiquida -= gastos.get(i).getValor();
			}
		}
	}
	public void calcularUtilidadNeta()
	{
		utilidadNeta = 0;
		utilidadNeta += utilidadLiquida;
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(RESERVA))
			{
				utilidadNeta -= gastos.get(i).getValor();
			}
		}
	}
	public ArrayList<Ingreso> darIngresosOperacionales()
	{
		ArrayList<Ingreso> ingresosOp = new ArrayList<>();
		for (int i = 0; i < ingresos.size(); i++) 
		{
			if(ingresos.get(i).getTipo().equals(OPERACIONAL))
			{
				ingresosOp.add(ingresos.get(i));
			}
		}
		return ingresosOp;
	}
	public ArrayList<Ingreso> darIngresosNoOperacionales()
	{
		ArrayList<Ingreso> ingresosNoOp = new ArrayList<>();
		for (int i = 0; i < ingresos.size(); i++) 
		{
			if(ingresos.get(i).getTipo().equals(NO_OPERACIONAL))
			{
				ingresosNoOp.add(ingresos.get(i));
			}
		}
		return ingresosNoOp;
	}
	public ArrayList<Gasto> darGastosOperacionales()
	{
		ArrayList<Gasto> gastosOp = new ArrayList<>();
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(OPERACIONAL))
			{
				gastosOp.add(gastos.get(i));
			}
		}
		return gastosOp;
	}
	public ArrayList<Gasto> darGastosNoOperacionales()
	{
		ArrayList<Gasto> gastosNoOp = new ArrayList<>();
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(NO_OPERACIONAL))
			{
				gastosNoOp.add(gastos.get(i));
			}
		}
		return gastosNoOp;
	}
	public ArrayList<Gasto> darImpuestos()
	{
		ArrayList<Gasto> impuestos = new ArrayList<>();
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(IMPUESTO))
			{
				impuestos.add(gastos.get(i));
			}
		}
		return impuestos;
	}
	public ArrayList<Gasto> darCostoVenta()
	{
		ArrayList<Gasto> costoVenta = new ArrayList<>();
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(COSTO_VENTA))
			{
				costoVenta.add(gastos.get(i));
			}
		}
		return costoVenta;
	}
	public ArrayList<Gasto> darReservas()
	{
		ArrayList<Gasto> reservas = new ArrayList<>();
		for (int i = 0; i < gastos.size(); i++) 
		{
			if(gastos.get(i).getTipo().equals(RESERVA))
			{
				reservas.add(gastos.get(i));
			}
		}
		return reservas;
	}
	public double getUtilidadBruta() {
		return utilidadBruta;
	}
	public double getUtilidadOperacional() {
		return utilidadOperacional;
	}
	public double getUtilidadAntImp() {
		return utilidadAntImp;
	}
	public double getUtilidadLiquida() {
		return utilidadLiquida;
	}
	public double getUtilidadNeta() {
		return utilidadNeta;
	}
	public void setUtilidadBruta(double utilidadBruta) {
		this.utilidadBruta = utilidadBruta;
	}
	public void setUtilidadOperacional(double utilidadOperacional) {
		this.utilidadOperacional = utilidadOperacional;
	}
	public void setUtilidadAntImp(double utilidadAntImp) {
		this.utilidadAntImp = utilidadAntImp;
	}
	public void setUtilidadLiquida(double utilidadLiquida) {
		this.utilidadLiquida = utilidadLiquida;
	}
	public void setUtilidadNeta(double utilidadNeta) {
		this.utilidadNeta = utilidadNeta;
	}
	public void actualizarUtilidades()
	{
		calcularUtilidadBruta();
		calcularUtilidadOperacional();
		calcularUtilidadAntesDeImpuesto();
		calcularUtilidadLiquida();
		calcularUtilidadNeta();
	}
}
