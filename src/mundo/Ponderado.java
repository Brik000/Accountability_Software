package mundo;

import java.util.ArrayList;

public class Ponderado {
	public static final int ULT_COMPRA=0;
	public static final int ULT_VENTA=1;
	
	private Saldo saldo_Inicial;
	private ArrayList<Entrada> compras;
	private ArrayList<Salida> ventas;
	private ArrayList<Movimiento> movimientos;
	private int ultimo_Movimiento;
	private double costo_venta;

	public Ponderado(Saldo saldo_inicial) {
		super();
		this.saldo_Inicial = saldo_inicial;
		compras = new ArrayList<Entrada>();
		ventas = new ArrayList<Salida>();
		movimientos= new ArrayList<Movimiento>();
	}
	public Saldo getSaldo_inicial() {
		return saldo_Inicial;
	}
	public void setSaldo_inicial(Saldo saldo_inicial) {
		this.saldo_Inicial = saldo_inicial;
	}
	public ArrayList<Entrada> getCompras() {
		return compras;
	}
	public void setCompras(ArrayList<Entrada> compras) {
		this.compras = compras;
	}
	public ArrayList<Salida> getSalidas() {
		return ventas;
	}
	public void setSalidas(ArrayList<Salida> ventas) {
		this.ventas = ventas;
	}
	public int getUltimo_Movimiento() {
		return ultimo_Movimiento;
	}
	public void setUltimo_Movimiento(int ultimo_Movimiento) {
		this.ultimo_Movimiento = ultimo_Movimiento;
	}
	public double getCosto_venta() {
		return costo_venta;
	}
	public void setCosto_venta(double costo_venta) {
		this.costo_venta = costo_venta;
	}
	public void agregarCompra(Entrada agregar) {
		compras.add(agregar);
		int agregado= compras.size()-1;
		if( agregado== 0) {
			if( ventas.size()>0) {
				compras.get(agregado).setSaldo_Anterior(ventas.get(ventas.size()-1).getSaldo_Actual());
			}
			else {
				compras.get(agregado).setSaldo_Anterior(saldo_Inicial);
			}
		}
		else {
			if( getUltimo_Movimiento()== 0) {
				compras.get(agregado).setSaldo_Anterior(compras.get(agregado-1).getSaldo_Actual());
			}
			else compras.get(agregado).setSaldo_Anterior(ventas.get(ventas.size()-1).getSaldo_Actual());
		}
		compras.get(agregado).generarSaldoActual();
		movimientos.add(compras.get(agregado));
		setUltimo_Movimiento(0);
	}
	public void agregarVenta(int unidades) {
		Saldo anterior= new Saldo();
		if(movimientos.size()>0) {
		if(movimientos.get(movimientos.size()-1) instanceof Entrada) {
			anterior= ((Entrada)movimientos.get(movimientos.size()-1)).getSaldo_Actual();
		  }
		else if (movimientos.get(movimientos.size()-1) instanceof Salida)anterior= ((Salida)movimientos.get(movimientos.size()-1)).getSaldo_Actual();
		}
		else anterior= saldo_Inicial;
		double precio_unidad= anterior.getPrecio_unidad();
		double precio_total= unidades* precio_unidad;
		Salida nueva= new Salida(unidades, precio_unidad, precio_total);
		ventas.add(nueva);
		int agregado= ventas.size()-1;
		ventas.get(agregado).calcularSaldoActual(anterior);
		movimientos.add(ventas.get(agregado));
		setUltimo_Movimiento(1);
	}
	public void generarCostoVenta() {
		double costo_venta=0;
		for (int i = 0; i < ventas.size(); i++) {
			costo_venta+= ventas.get(i).getPrecio_total();
		}
		setCosto_venta(costo_venta);
	}
	public String[][] generarTablaPonderada(){
		int filas=compras.size()+ventas.size()+1;
		if( saldo_Inicial.getUnidades()>=0) filas++;
		int columnas= 10;
		String[][] tabla= new String[filas][columnas];
		String[] cabeza= {"Movimiento","Unidad","$/Unidad","$Total","Unidad","$/Unidad","$Total","Unidad","$/Unidad","$Total"};
		for (int i = 0; i < tabla[0].length; i++) {
			tabla[0][i]=cabeza[i];
		}
		if( filas>1) {
		tabla[1][0]="Saldo inicial";
		tabla[1][1]="";
		tabla[1][2]="";
		tabla[1][3]="";
		tabla[1][4]="";
		tabla[1][5]="";
		tabla[1][6]="";
		tabla[1][7]=saldo_Inicial.getUnidades()+"";
		tabla[1][8]=saldo_Inicial.getPrecio_unidad()+"";
		tabla[1][9]=saldo_Inicial.getPrecio_total()+"";
		for (int i = 0; i < movimientos.size(); i++) {
			if( movimientos.get(i) instanceof Entrada) {
				tabla[i+2][0]="Compra ";
				tabla[i+2][1]=movimientos.get(i).getUnidades()+"";
				tabla[i+2][2]=movimientos.get(i).getPrecio_unidad()+"";
				tabla[i+2][3]=movimientos.get(i).getPrecio_total()+"";
				tabla[i+2][4]="";
				tabla[i+2][5]="";
				tabla[i+2][6]="";
				tabla[i+2][7]=((Entrada)movimientos.get(i)).getSaldo_Actual().getUnidades()+"";
				tabla[i+2][8]=((Entrada)movimientos.get(i)).getSaldo_Actual().getPrecio_unidad()+"";
				tabla[i+2][9]=((Entrada)movimientos.get(i)).getSaldo_Actual().getPrecio_total()+"";
			}
			else {
				tabla[i+2][0]="Venta #"+ i+1;
				tabla[i+2][1]="";
				tabla[i+2][2]="";
				tabla[i+2][3]="";
				tabla[i+2][4]=movimientos.get(i).getUnidades()+"";
				tabla[i+2][5]=movimientos.get(i).getPrecio_unidad()+"";
				tabla[i+2][6]=movimientos.get(i).getPrecio_total()+"";
				tabla[i+2][7]=((Salida)movimientos.get(i)).getSaldo_Actual().getUnidades()+"";
				tabla[i+2][8]=((Salida)movimientos.get(i)).getSaldo_Actual().getPrecio_unidad()+"";
				tabla[i+2][9]=((Salida)movimientos.get(i)).getSaldo_Actual().getPrecio_total()+"";
			}
		}
		}
		return tabla;
	}
	
}
