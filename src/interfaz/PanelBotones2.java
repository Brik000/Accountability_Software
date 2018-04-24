package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mundo.EstadoDeResultados;

public class PanelBotones2 extends JPanel implements ActionListener{

	public final static String AGREGAR="Agregar";
	public final static String ELIMINAR="elimiar";
	
	JTextField nombre;
	JTextField valor;
	JComboBox<String> tipo;
	JComboBox<String> tipo2;
	JButton btnAgregar;
	JButton btnEliminar;
	FramePrincipal inter;
	
	public PanelBotones2(FramePrincipal inter) {
		this.setLayout(new GridLayout(1,6));
		this.inter=inter;
		btnAgregar=new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		
		btnEliminar=new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR);
		
		nombre=new JTextField("nombre");
		valor=new JTextField("valor");
		String[] tipos={"Ingreso","Gasto",};
		tipo=new JComboBox<String>(tipos);
		String[] tipos2={"Operacional","No Operacional", "Impuesto", "Costo de Venta", "Reserva"};
		tipo2=new JComboBox<String>(tipos2);
		add(nombre);
		add(valor);
		add(tipo);
		add(tipo2);
		add(btnAgregar);
		add(btnEliminar);	
	}
	
	public void reestablecerValoresIniciales() {
		this.removeAll();
		this.setLayout(new GridLayout(1,6));
		btnAgregar=new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		
		btnEliminar=new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR);
		
		nombre=new JTextField("nombre");
		valor=new JTextField("valor");
		String[] tipos={"Ingreso","Gasto",};
		tipo=new JComboBox<String>(tipos);
		String[] tipos2={"Operacional","No Operacional", "Impuesto", "Costo de Venta", "Reserva"};
		tipo2=new JComboBox<String>(tipos2);
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
			if(tipillo==0) 
			{
				try
				{
					if(tipillo2 == 0)
					{
						inter.agregarIngreso(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.OPERACIONAL);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarIngresosOp();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Ingreso Operativo ha sido agregado con exito");

					}
					if(tipillo2 == 1)
					{
						inter.agregarIngreso(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.NO_OPERACIONAL);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarIngresosNoOp();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Ingreso No Operativo ha sido agregado con exito");

					}
					if(tipillo2 == 2 || tipillo2 == 3 || tipillo == 4)
					{
						throw new Exception("No puede haber Ingresos de tipos impuestos, reservas o costo de venta");
					}
				}
				catch(Exception e1) {
					if(e1.getMessage().equals("No puede haber Ingresos de tipos impuestos, reservas o costo de venta"))
					{
						JOptionPane.showMessageDialog(this, e1.getMessage());
					}
					System.out.println(e1.getMessage());
					JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
				}
				
			}
			else if(tipillo==1) 
			{
				try
				{
					if(tipillo2 == 0)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.OPERACIONAL);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarGastosOp();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Gasto Operativo ha sido agregado con exito");

					}
					if(tipillo2 == 1)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.NO_OPERACIONAL);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarGastosNoOp();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Gasto No Operativo ha sido agregado con exito");

					}
					if(tipillo2 == 2)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.IMPUESTO);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarImpuestos();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Impuesto ha sido agregado con exito");
					}
					if(tipillo2 == 3)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.COSTO_VENTA);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarCostoVenta();
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Costo de Venta ha sido agregado con exito");
					}
					if(tipillo2 == 4)
					{
						inter.agregarGasto(nombre.getText(), Double.parseDouble(valor.getText()), EstadoDeResultados.RESERVA);
						reestablecerValoresIniciales();
						inter.getPanelER().actualizarReservas();;
						inter.getPanelER().actualizarTotales();
						JOptionPane.showMessageDialog(this, "Reserva ha sido agregada con exito");
					}
				}
				catch(Exception e1) 
				{
					JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
				}
			}
		}
		else if(e.getActionCommand().equals(ELIMINAR)) {
			int tipillo=tipo.getSelectedIndex();
			int tipillo2=tipo2.getSelectedIndex();
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
