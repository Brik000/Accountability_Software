package mundo;

public class Movimiento {
	private int unidades;
	private double precio_unidad;
	private double precio_total;
	public Movimiento(int unidades, double precio_unidad, double precio_total) {
		this.unidades = unidades;
		this.precio_unidad = precio_unidad;
		this.precio_total = precio_total;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecio_unidad() {
		return precio_unidad;
	}
	public void setPrecio_unidad(double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}
	public double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
}
