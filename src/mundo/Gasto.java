package mundo;

public class Gasto extends Data{

	private String tipo;
	
	public Gasto(String nombre, double valor, String tipo) 
	{
		super(nombre, valor);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
