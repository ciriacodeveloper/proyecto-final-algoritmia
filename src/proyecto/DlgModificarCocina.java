package proyecto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class DlgModificarCocina extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5499997447925445157L;
	private JLabel lblModelo;
	private JComboBox<String> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblAnchocm;
	private JTextField txtAncho;
	private JLabel lblAltocm;
	private JTextField txtAlto;
	private JLabel lblFondocm;
	private JTextField txtFondo;
	private JLabel lblQuemadores;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgModificarCocina dialog = new DlgModificarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModificarCocina() {
		setTitle("Modificar Cocina");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(21, 21, 88, 14);
		getContentPane().add(lblModelo);
		
		cboModelo = new JComboBox<String>();
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.addActionListener(this);
		cboModelo.setBounds(121, 11, 160, 35);
		getContentPane().add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(21, 60, 88, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(121, 55, 160, 30);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setBounds(21, 98, 88, 14);
		getContentPane().add(lblAnchocm);
		
		txtAncho = new JTextField();
		txtAncho.setBounds(121, 90, 160, 30);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		lblAltocm = new JLabel("Alto (cm)");
		lblAltocm.setBounds(21, 133, 88, 14);
		getContentPane().add(lblAltocm);
		
		txtAlto = new JTextField();
		txtAlto.setBounds(121, 125, 160, 30);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);
		
		lblFondocm = new JLabel("Fondo (cm)");
		lblFondocm.setBounds(21, 168, 88, 14);
		getContentPane().add(lblFondocm);
		
		txtFondo = new JTextField();
		txtFondo.setBounds(121, 160, 160, 30);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(19, 203, 90, 14);
		getContentPane().add(lblQuemadores);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setBounds(121, 195, 160, 30);
		getContentPane().add(txtQuemadores);
		txtQuemadores.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 11, 89, 35);
		getContentPane().add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(this);
		btnGrabar.setBounds(334, 53, 90, 32);
		getContentPane().add(btnGrabar);
		userAutentication();
		mostrarData(0);
	}

	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            dispose();
        } else if (e.getSource() == btnGrabar) {
        	saveChanges();
        } else if (e.getSource() == cboModelo) {
            int modelo = getModelo();
            mostrarData(modelo);
        }
    }
	private void userAutentication() {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
			txtPrecio.setEditable(false);
		    txtAncho.setEditable(false);
		    txtAlto.setEditable(false);
		    txtFondo.setEditable(false);
		    txtQuemadores.setEditable(false);
		}
	}
	private int getModelo() {
		int modelo = cboModelo.getSelectedIndex();
		return modelo;
	}

	private void saveChanges() {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
			JOptionPane.showMessageDialog(this, "Solo el administrador puede realizar modificaciones.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estas seguro que deseas guardar los cambios?", "Confirmar cambios", JOptionPane.YES_NO_OPTION);
		    if (confirmacion == JOptionPane.YES_OPTION) {
		        guardarCambios();	
		        dispose();
		    }
		}
	}
	
	private void mostrarData(int modelo) {
	    switch (modelo) {
	        case 0:	            
	            mostrarDatosCocina(FrmVentanaPrincipal.precio0, FrmVentanaPrincipal.alto0, FrmVentanaPrincipal.ancho0, FrmVentanaPrincipal.fondo0, FrmVentanaPrincipal.quemadores0);
	            break;
	        case 1:
	            mostrarDatosCocina(FrmVentanaPrincipal.precio1, FrmVentanaPrincipal.alto1, FrmVentanaPrincipal.ancho1, FrmVentanaPrincipal.fondo1, FrmVentanaPrincipal.quemadores1);
	            break;
	        case 2:
	            mostrarDatosCocina(FrmVentanaPrincipal.precio2, FrmVentanaPrincipal.alto2, FrmVentanaPrincipal.ancho2, FrmVentanaPrincipal.fondo2, FrmVentanaPrincipal.quemadores2);
	            break;
	        case 3:
	            mostrarDatosCocina(FrmVentanaPrincipal.precio3, FrmVentanaPrincipal.alto3, FrmVentanaPrincipal.ancho3, FrmVentanaPrincipal.fondo3, FrmVentanaPrincipal.quemadores3);
	            break;
	        default:
	            mostrarDatosCocina(FrmVentanaPrincipal.precio4, FrmVentanaPrincipal.alto4, FrmVentanaPrincipal.ancho4, FrmVentanaPrincipal.fondo4, FrmVentanaPrincipal.quemadores4);
	    }
	}

	private void mostrarDatosCocina(double precio, double alto, double ancho, double fondo, int quemadores) {
	    txtPrecio.setText(Double.toString(precio));
	    txtAlto.setText(Double.toString(alto));
	    txtAncho.setText(Double.toString(ancho));
	    txtFondo.setText(Double.toString(fondo));
	    txtQuemadores.setText(Integer.toString(quemadores));
	}

	private void guardarCambios() {
		
	    double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
	    double nuevoAncho = Double.parseDouble(txtAncho.getText());
	    double nuevoAlto = Double.parseDouble(txtAlto.getText());
	    double nuevoFondo = Double.parseDouble(txtFondo.getText());
	    int nuevoQuemadores = Integer.parseInt(txtQuemadores.getText());

	    int modelo = getModelo();
	    switch (modelo) {
	        case 0:
	            FrmVentanaPrincipal.precio0 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho0 = nuevoAncho;
	            FrmVentanaPrincipal.alto0 = nuevoAlto;
	            FrmVentanaPrincipal.fondo0 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores0 = nuevoQuemadores;
	            break;
	        case 1:
	            FrmVentanaPrincipal.precio1 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho1 = nuevoAncho;
	            FrmVentanaPrincipal.alto1 = nuevoAlto;
	            FrmVentanaPrincipal.fondo1 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores1 = nuevoQuemadores;
	            break;
	        case 2:
	            FrmVentanaPrincipal.precio2 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho2 = nuevoAncho;
	            FrmVentanaPrincipal.alto2 = nuevoAlto;
	            FrmVentanaPrincipal.fondo2 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores2 = nuevoQuemadores;
	            break;
	        case 3:
	            FrmVentanaPrincipal.precio3 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho3 = nuevoAncho;
	            FrmVentanaPrincipal.alto3 = nuevoAlto;
	            FrmVentanaPrincipal.fondo3 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores3 = nuevoQuemadores;
	            break;
	        default:
	            FrmVentanaPrincipal.precio4 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho4 = nuevoAncho;
	            FrmVentanaPrincipal.alto4 = nuevoAlto;
	            FrmVentanaPrincipal.fondo4 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores4 = nuevoQuemadores;
	    }
	    JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
    }

}







