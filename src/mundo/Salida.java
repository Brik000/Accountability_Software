package mundo;

public class Salida extends Movimiento{
	
	private Saldo saldo_Actual;
	private Saldo saldo_Anterior;
	public Salida(int unidades, double precio_unidad, double precio_total) {
		super(unidades, precio_unidad, precio_total);
	}
	public Saldo getSaldo_Actual() {
		return saldo_Actual;
	}

	public void setSaldo_Actual(Saldo saldo_Actual) {
		this.saldo_Actual = saldo_Actual;
	}

	public Saldo getSaldo_Anterior() {
		return saldo_Anterior;
	}

	public void setSaldo_Anterior(Saldo saldo_Anterior) {
		this.saldo_Anterior = saldo_Anterior;
	}

	public void calcularSaldoActual(Saldo anterior) {
		int unidades= anterior.getUnidades()- getUnidades();
		double precio_total=  anterior.getPrecio_total()- getPrecio_total();
		double precio_unidad= precio_total/ unidades;
		Saldo nuevo= new Saldo(unidades, precio_unidad, precio_total);
		setSaldo_Anterior(anterior);
		setSaldo_Actual(nuevo);
	}

}
