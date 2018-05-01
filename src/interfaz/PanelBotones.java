package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mundo.EstadoDeResultados;

public class PanelBotones extends JPanel implements ActionListener{

	public final static String AGREGAR="Agregar";
	public final static String ELIMINAR="elimiar";
	

	
	JLabel JlabelNombre;
	JLabel JlabelValor;
	
	JLabel espacio1;
	JLabel espacio2;
	JLabel espacio3;
	JLabel espacio4;
	
	JTextField nombre;
	JTextField valor;
	JComboBox<String> tipo;
	JComboBox<String> tipo2;
	JButton btnAgregar;
	JButton btnEliminar;
	FramePrincipal inter;
	
	public PanelBotones(FramePrincipal inter) {
		this.setLayout(new GridLayout(2,6));
		this.inter=inter;
		btnAgregar=new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		
		btnEliminar=new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR);
		
		JlabelNombre = new JLabel("Nombre:");
		JlabelValor = new JLabel("Valor:");
		
		espacio1 = new JLabel();
		espacio2 = new JLabel();
		espacio3= new JLabel();
		espacio4= new JLabel();
		
		
		nombre=new JTextField("");
		valor=new JTextField("");
		String[] tipos={"Pasivo","Activo","Patrimonio","Ingresos","Gastos"};
		String[] tipos2= {"No aplica","Operacional","No Operacional", "Impuesto", "Costo de Venta", "Reserva"};
		
		tipo=new JComboBox<String>(tipos);
		tipo2 = new JComboBox<String>(tipos2);
		
		add(JlabelNombre);
		add(JlabelValor);
		add(espacio1);
		add(espacio2);
		add(espacio3);
		add(espacio4);
		add(nombre);
		add(valor);
		add(tipo);
		add(tipo2);
		add(btnAgregar);
		add(btnEliminar);	
	}
	
	public void reestablecerValoresIniciales() {
		this.removeAll();
		this.setLayout(new GridLayout(2,6));
		btnAgregar=new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		
		btnEliminar=new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR);
		
		
		JlabelNombre = new JLabel("Nombre:");
		JlabelValor = new JLabel("Valor:");
		
		espacio1 = new JLabel();
		espacio2 = new JLabel();
		espacio3= new JLabel();
		espacio4= new JLabel();
		
		
		nombre=new JTextField("");
		valor=new JTextField("");
		
		String[] tipos={"Pasivo","Activo","Patrimonio","Ingresos","Gastos"};
		String[] tipos2= {"No aplica","Operacional","No Operacional", "Impuesto", "Costo de Venta", "Reserva"};
		
		tipo=new JComboBox<String>(tipos);
		tipo2 = new JComboBox<String>(tipos2);
		

		add(JlabelNombre);
		add(JlabelValor);
		add(espacio1);
		add(espacio2);
		add(espacio3);
		add(espacio4);
		add(nombre);
		add(valor);
		add(tipo);
		add(tipo2);
		add(btnAgregar);
		add(btnEliminar);	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(AGREGAR)) {
			int tipillo=tipo.getSelectedIndex();
			int tipillo2 = tipo2.getSelectedIndex();
			
			if(tipillo==0) {
				try {
				inter.agregarPasivo(nombre.getText(), Double.parseDouble(valor.getText()));
				reestablecerValoresIniciales();
				inter.getPanelBG().actualizarPasivos();
				inter.getPanelBG().actualizarTotales();
				JOptionPane.showMessageDialog(this, "El Pasivo ha sido agregado con exito");

				}catch(Exception e1) {
					JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
				}
				
			}else if(tipillo==1) {
				try {
				inter.agregarActivo(nombre.getText(), Double.parseDouble(valor.getText()));
				reestablecerValoresIniciales();
				inter.getPanelBG().actualizarActivos();
				inter.getPanelBG().actualizarTotales();
				JOptionPane.showMessageDialog(this, "El Activo ha sido agregado con exito");
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
			}
			}else if (tipillo==2){
				try {
				inter.agregarPatrimonio(nombre.getText(), Double.parseDouble(valor.getText()));
				reestablecerValoresIniciales();
				inter.getPanelBG().actualizarPatrimonio();
				inter.getPanelBG().actualizarTotales();
				JOptionPane.showMessageDialog(this, "El elemento de Patrimonio ha sido agregado con exito");
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
			}
				
			}else if (tipillo == 3) { // ingresos
				
				try {
				
					if(tipillo2 == 1) {
						
						inter.agregarIngreso(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.OPERACIONAL);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarIngresosOp();
						inter.ER.actualizarUtilidades();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Ingreso Operativo ha sido agregado con exito");
					}
					if(tipillo2 == 2) {
						
						inter.agregarIngreso(nombre.getText(),Double.parseDouble(valor.getText()),EstadoDeResultados.NO_OPERACIONAL );
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarIngresosNoOp();
						inter.ER.actualizarUtilidades();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Ingreso No Operativo ha sido agregado con exito");

						
					}
					if(tipillo2 == 2  || tipillo2==3 || tipillo2==4) {
						throw new Exception("No puede haber Ingresos de tipos impuestos, reservas o costo de venta");
					}
					
					
				} catch (Exception e2) {
					if(e2.getMessage().equals("No puede haber Ingresos de tipos impuestos, reservas o costo de venta"))
					{
						JOptionPane.showMessageDialog(this, e2.getMessage());
					}
					System.out.println(e2.getMessage());
					JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
				
				}
				
				
				
			}else if (tipillo == 4) { // gastos
				
				try {
					if(tipillo2 == 1)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.OPERACIONAL);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarGastosOp();
						inter.ER.actualizarUtilidades();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Gasto Operativo ha sido agregado con exito");

					}
					if(tipillo2 == 2)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.NO_OPERACIONAL);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarGastosNoOp();
						inter.ER.actualizarUtilidades();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Gasto No Operativo ha sido agregado con exito");

					}
					if(tipillo2 == 3)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.IMPUESTO);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarImpuestos();
						inter.ER.actualizarUtilidades();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Impuesto ha sido agregado con exito");
					}
					if(tipillo2 == 4)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.COSTO_VENTA);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarCostoVenta();
						inter.ER.actualizarUtilidades();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Costo de Venta ha sido agregado con exito");
					}
					if(tipillo2 == 5)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.RESERVA);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarReservas();
						inter.ER.actualizarUtilidades();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Reserva ha sido agregada con exito");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
				}
				
				
			}
			
			
			
			
			
		}else if(e.getActionCommand().equals(ELIMINAR)) {
			int tipillo=tipo.getSelectedIndex();
			
			if(tipillo==0) {
				try {
					inter.eliminarPasivo(nombre.getText());
					inter.getPanelBG().actualizarPasivos();
					reestablecerValoresIniciales();
					inter.getPanelBG().actualizarTotales();
					JOptionPane.showMessageDialog(this, "El Pasivo ha sido eliminado con exito");
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
				
			}else if(tipillo==1) {
				try {
					inter.eliminarActivo(nombre.getText());
					reestablecerValoresIniciales();
					inter.getPanelBG().actualizarActivos();
					inter.getPanelBG().actualizarTotales();
					JOptionPane.showMessageDialog(this, "El Activo ha sido eliminado con exito");

				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
				
			}else if (tipillo==2){
				try {
					inter.eliminarPatrimonio(nombre.getText());
					reestablecerValoresIniciales();
					inter.getPanelBG().actualizarPatrimonio();
					inter.getPanelBG().actualizarTotales();
					JOptionPane.showMessageDialog(this, "El elemento de Patrimonio ha sido eliminado con exito");
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
				
			}		
			
			
		}
		
	}

}
