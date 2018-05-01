package mundo;

public class Saldo extends Movimiento{

	public Saldo(int unidades, double precio_unidad, double precio_total) {
		super(unidades, precio_unidad, precio_total);
	}
	public Saldo() {
		super(0, 0, 0);
	}
}
