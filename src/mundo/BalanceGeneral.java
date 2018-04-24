package mundo;

import java.util.ArrayList;

public class BalanceGeneral {
	
	private ArrayList<Activo> activos;
	private ArrayList<Pasivo> pasivos;
	private ArrayList<Patrimonio> patrimonio;
	//contiene el total de los activos
	private double total1;
	//contiene el total de los pasivos+patrimonio
	private double total2;
	public BalanceGeneral() {
		super();
		this.activos = new ArrayList<Activo>();
		this.pasivos = new ArrayList<Pasivo>();
		this.patrimonio = new ArrayList<Patrimonio>();
		this.total1 = 0.0;
		this.total2 = 0.0;
	}
	public void anadirPatrimonio(String a,double b) {
		Patrimonio nuevo=new Patrimonio(a, b);
		patrimonio.add(nuevo);
		total2=total2+nuevo.getValor();
		
	}
	public void anadirActivo(String a,double b) {
		Activo nuevo=new Activo(a,b);
		activos.add(nuevo);
		total1=total1+nuevo.getValor();
		
	}
	public void anadirPasivo(String a,double b) {
		Pasivo nuevo=new Pasivo(a,b);
		pasivos.add(nuevo);
		total2=total2+nuevo.getValor();
		
	}
	
	public void eliminarActivo(String a) throws Exception {
		boolean control=false;
		for (int i = 0; i < activos.size()&&!control; i++) {
			if(a.equals(activos.get(i).getNombre())) {
				total1=total1-activos.get(i).getValor();
				control=true;
				activos.remove(i);
				
			}
		}
		if(control==false) {
			throw new Exception("El elemento no parece estar registrado");
		}
	}
	public void eliminarPasivo(String p) throws Exception{
		boolean control=false;
		for (int i = 0; i < pasivos.size(); i++) {
			if(p.equals(pasivos.get(i).getNombre())) {
				control=true;
				total2=total2-pasivos.get(i).getValor();
				pasivos.remove(i);
			}
			
		}
		if(control==false) {
			throw new Exception("El elemento no parece estar registrado");
		}
		
	}
	public void eliminarPatrimonio(String p)throws Exception{
		boolean control=false;
		for (int i = 0; i < patrimonio.size(); i++) {
			if(p.equals(patrimonio.get(i).getNombre())) {
				total2=total2-patrimonio.get(i).getValor();
				control=true;
				patrimonio.remove(i);
			}
		}
		if(control==false) {
			throw new Exception("El elemento no parece estar registrado");
		}
	
}
	
	public ArrayList<Activo> getActivos() {
		return activos;
		
	}
	public void setActivos(ArrayList<Activo> activos) {
		this.activos = activos;
	}
	public ArrayList<Pasivo> getPasivos() {
		return pasivos;
	}
	public void setPasivos(ArrayList<Pasivo> pasivos) {
		this.pasivos = pasivos;
	}
	public ArrayList<Patrimonio> getPatrimonio() {
		return patrimonio;
	}
	public void setPatrimonio(ArrayList<Patrimonio> patrimonio) {
		this.patrimonio = patrimonio;
	}
	public double getTotal1() {
		return total1;
	}
	public void setTotal1(double total1) {
		this.total1 = total1;
	}
	public double getTotal2() {
		return total2;
	}
	public void setTotal2(double total2) {
		this.total2 = total2;
	}
}