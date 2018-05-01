package mundo;

public class Inventario {
	private Ponderado ponderado;
	private String[][] tablaPonderada;
	public Inventario() {
		Saldo saldo_inicial= new Saldo();
		this.ponderado = new Ponderado(saldo_inicial);
		generarTablaPonderada();
	}
	public Ponderado getPonderado() {
		return ponderado;
	}
	public void setPonderado(Ponderado ponderado) {
		this.ponderado = ponderado;
	}
	public String[][] getTabla() {
		return tablaPonderada;
	}

	public void setTabla(String[][] tabla) {
		this.tablaPonderada = tabla;
	}
	public void generarTablaPonderada() {
		setTabla(ponderado.generarTablaPonderada());
	}
	public void setSaldoInicial(int unidades, double precioUnidad){
		double precioTotal=unidades*precioUnidad;
		Saldo nuevo= new Saldo(unidades, precioUnidad, precioTotal);
		ponderado.setSaldo_inicial(nuevo);
		generarTablaPonderada();
	}
	public void agregarCompraPonderado(int unidades, double precioUnidad) {
		double precioTotal=unidades*precioUnidad;
		Entrada nuevo= new Entrada(unidades, precioUnidad, precioTotal);
		ponderado.agregarCompra(nuevo);
		generarTablaPonderada();
	}
    public void agregarVentaPonderado(int unidades) {
    	ponderado.agregarVenta(unidades);
		generarTablaPonderada();
	}
}
