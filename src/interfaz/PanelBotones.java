package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBotones extends JPanel implements ActionListener{

	public final static String AGREGAR="Agregar";
	public final static String ELIMINAR="elimiar";
	
	JTextField nombre;
	JTextField valor;
	JComboBox<String> tipo;
	JButton btnAgregar;
	JButton btnEliminar;
	FramePrincipal inter;
	
	public PanelBotones(FramePrincipal inter) {
		this.setLayout(new GridLayout(1,5));
		this.inter=inter;
		btnAgregar=new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		
		btnEliminar=new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR);
		
		nombre=new JTextField("nombre");
		valor=new JTextField("valor");
		String[] tipos={"Pasivo","Activo","Patrimonio"};
		tipo=new JComboBox<String>(tipos);
		
		add(nombre);
		add(valor);
		add(tipo);
		add(btnAgregar);
		add(btnEliminar);	
	}
	
	public void reestablecerValoresIniciales() {
		this.removeAll();
		this.setLayout(new GridLayout(1,5));
		btnAgregar=new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR);
		
		btnEliminar=new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR);
		
		nombre=new JTextField("nombre");
		valor=new JTextField("valor");
		String[] tipos={"Pasivo","Activo","Patrimonio"};
		tipo=new JComboBox<String>(tipos);
		
		add(nombre);
		add(valor);
		add(tipo);
		add(btnAgregar);
		add(btnEliminar);	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(AGREGAR)) {
			int tipillo=tipo.getSelectedIndex();
			if(tipillo==0) {
				try {
				inter.agregarPasivo(nombre.getText(), Double.parseDouble(valor.getText()));
				JOptionPane.showMessageDialog(this, "El Pasivo ha sido agregado con exito");
				reestablecerValoresIniciales();
				inter.actualizarPasivos();
				inter.actualizarTotales();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
				}
				
			}else if(tipillo==1) {
				try {
				inter.agregarActivo(nombre.getText(), Double.parseDouble(valor.getText()));
				JOptionPane.showMessageDialog(this, "El Activo ha sido agregado con exito");
				reestablecerValoresIniciales();
				inter.actualizarActivos();
				inter.actualizarTotales();
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
			}
			}else if (tipillo==2){
				try {
				inter.agregarPatrimonio(nombre.getText(), Double.parseDouble(valor.getText()));
				JOptionPane.showMessageDialog(this, "El elemento de Patrimonio ha sido agregado con exito");
				reestablecerValoresIniciales();
				inter.actualizarPatrimonio();
				inter.actualizarTotales();
			}catch(Exception e1) {
				JOptionPane.showMessageDialog(this, "en el campo valor solo se aceptan numeros con punto como su decimal"+"\n"+"volver a intentar");
			}
				
			}			
			
		}else if(e.getActionCommand().equals(ELIMINAR)) {
			int tipillo=tipo.getSelectedIndex();
			
			if(tipillo==0) {
				try {
					inter.eliminarPasivo(nombre.getText());
					JOptionPane.showMessageDialog(this, "El Pasivo ha sido eliminado con exito");
					inter.actualizarPasivos();
					reestablecerValoresIniciales();
					inter.actualizarTotales();
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
				
			}else if(tipillo==1) {
				try {
					inter.eliminarActivo(nombre.getText());
					JOptionPane.showMessageDialog(this, "El Activo ha sido eliminado con exito");
					reestablecerValoresIniciales();
					inter.actualizarActivos();
					inter.actualizarTotales();
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
				
			}else if (tipillo==2){
				try {
					inter.eliminarPatrimonio(nombre.getText());
					JOptionPane.showMessageDialog(this, "El elemento de Patrimonio ha sido eliminado con exito");
					reestablecerValoresIniciales();
					inter.actualizarPatrimonio();
					inter.actualizarTotales();
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
				
				
			}		
			
			
		}
		
	}

}
