package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import javafx.scene.layout.Border;

@SuppressWarnings("serial")
public class PanelInventarios extends JPanel implements ActionListener{
	public static final String COMPRA="COMPRA";
	public static final String VENTA="VENTA";
	public static final String INICIAL="INICIAL";
	public JTable tabla;

	private JButton compra;
	private JButton venta;
	private JButton inicial;
	
	private FramePrincipal principal;
	
	public PanelInventarios(FramePrincipal p,String[][] tabla) {
		principal= p;
		setPreferredSize(new Dimension(300,400));
		TitledBorder borde= new TitledBorder("Inventario Kardex");
	    setBorder(borde);
	    setLayout(new BorderLayout());
	    String[] cabeza= {"Movimiento","Unidad","$/Unidad","$Total","Unidad","$/Unidad","$Total","Unidad","$/Unidad","$Total"};
	    this.tabla= new JTable(tabla, cabeza);
	    
	    JPanel aux= new JPanel();
	    aux.setLayout(new GridLayout(1, 3));
	    compra= new JButton("Agregar Compra");
	    compra.addActionListener(this);
	    compra.setActionCommand(COMPRA);
	    venta= new JButton("Agregar venta");
	    venta.addActionListener(this);
	    venta.setActionCommand(VENTA);
	    inicial= new JButton("Agregar inventario inicial");
	    inicial.addActionListener(this);
	    inicial.setActionCommand(INICIAL);
	    aux.add(compra);
	    aux.add(venta);
	    aux.add(inicial);
	    
	    
	    add(this.tabla, BorderLayout.CENTER);
	    add(aux,BorderLayout.SOUTH);
	}
	public void actualizarPanel(String[][] tabla) {
		removeAll();
	    JPanel aux= new JPanel();
	    String[] cabeza= {"Movimiento","Unidad","$/Unidad","$Total","Unidad","$/Unidad","$Total","Unidad","$/Unidad","$Total"};
	    this.tabla= new JTable(tabla, cabeza);
	    aux.setLayout(new GridLayout(1, 3));
//	    compra= new JButton("Agregar Compra");
//	    compra.addActionListener(this);
//	    compra.setActionCommand(COMPRA);
//	    venta= new JButton("Agregar venta");
//	    venta.addActionListener(this);
//	    venta.setActionCommand(VENTA);
//	    inicial= new JButton("Agregar inventario inicial");
//	    inicial.addActionListener(this);
//	    inicial.setActionCommand(INICIAL);
	    
	    aux.add(compra);
	    aux.add(venta);
	    aux.add(inicial);
	    
	    add(this.tabla, BorderLayout.CENTER);
	    add(aux, BorderLayout.SOUTH);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion=e.getActionCommand();
		
		JPanel aux= new JPanel();
		aux.setLayout(new GridLayout(2, 2));
		JLabel lUnidades= new JLabel("Unidades");
		JLabel lprecios= new JLabel("$/Unidad");
		JTextField unidades= new JTextField();
		JTextField precio= new JTextField();
		aux.add(lUnidades);
		aux.add(lprecios);
		aux.add(unidades);
		aux.add(precio);
		
		int opcion=JOptionPane.showConfirmDialog(this, aux, "Confirmar movimiento",0);
		if(!(opcion== JOptionPane.NO_OPTION)) {
			try {
				if(accion.equals(COMPRA)) {
					principal.agregarCompra(Integer.parseInt(unidades.getText()),Double.parseDouble(precio.getText()));
				}
				else if(accion.equals(INICIAL)) {
					principal.agregarInventarioInicial(Integer.parseInt(unidades.getText()),Double.parseDouble(precio.getText()));
				}
				else {
					principal.agregarVenta(Integer.parseInt(unidades.getText()));
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Ingresar un valor valido");
			}
		}
	}
}
