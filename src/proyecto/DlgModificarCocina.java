package proyecto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
		mostrarData(0);
	}
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            dispose();
        } else if (e.getSource() == btnGrabar) {
            guardarCambios();
            dispose();
        } else if (e.getSource() == cboModelo) {
            int modelo = cboModelo.getSelectedIndex();
            mostrarData(modelo);
        }
    }
	
	private void mostrarData(int modelo) {
		switch (modelo) {
		case 0:
			txtPrecio.setText(FrmVentanaPrincipal.precio0 + "");
			txtAlto.setText(FrmVentanaPrincipal.alto0 + "");
			txtAncho.setText(FrmVentanaPrincipal.ancho0 + "");
			txtFondo.setText(FrmVentanaPrincipal.fondo0 + "");
			txtQuemadores.setText(FrmVentanaPrincipal.quemadores0 + "");
			break;
		case 1:
			txtPrecio.setText(FrmVentanaPrincipal.precio1 + "");
			txtAlto.setText(FrmVentanaPrincipal.alto1 + "");
			txtAncho.setText(FrmVentanaPrincipal.ancho1 + "");
			txtFondo.setText(FrmVentanaPrincipal.fondo1 + "");
			txtQuemadores.setText(FrmVentanaPrincipal.quemadores1 + "");
			break;
		case 2:
			txtPrecio.setText(FrmVentanaPrincipal.precio2 + "");
			txtAlto.setText(FrmVentanaPrincipal.alto2 + "");
			txtAncho.setText(FrmVentanaPrincipal.ancho2 + "");
			txtFondo.setText(FrmVentanaPrincipal.fondo2 + "");
			txtQuemadores.setText(FrmVentanaPrincipal.quemadores2 + "");
			break;
		case 3:
			txtPrecio.setText(FrmVentanaPrincipal.precio3 + "");
			txtAlto.setText(FrmVentanaPrincipal.alto3 + "");
			txtAncho.setText(FrmVentanaPrincipal.ancho3 + "");
			txtFondo.setText(FrmVentanaPrincipal.fondo3 + "");
			txtQuemadores.setText(FrmVentanaPrincipal.quemadores3 + "");
			break;
		default:
			txtPrecio.setText(FrmVentanaPrincipal.precio4 + "");
			txtAlto.setText(FrmVentanaPrincipal.alto4 + "");
			txtAncho.setText(FrmVentanaPrincipal.ancho4 + "");
			txtFondo.setText(FrmVentanaPrincipal.fondo4 + "");
			txtQuemadores.setText(FrmVentanaPrincipal.quemadores4 + "");

		}
	}

	// Método para guardar los cambios realizados en la cocina
	private void guardarCambios() {
	    // Obtener el modelo seleccionado
	    int modelo = cboModelo.getSelectedIndex();
	    // Obtener los nuevos valores ingresados en los campos de texto
	    double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
	    double nuevoAncho = Double.parseDouble(txtAncho.getText());
	    double nuevoAlto = Double.parseDouble(txtAlto.getText());
	    double nuevoFondo = Double.parseDouble(txtFondo.getText());
	    double nuevoQuemadores = Double.parseDouble(txtQuemadores.getText());

	    // Actualizar los datos en la ventana principal
	    switch (modelo) {
	        case 0:
	            FrmVentanaPrincipal.precio0 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho0 = nuevoAncho;
	            FrmVentanaPrincipal.alto0 = nuevoAlto;
	            FrmVentanaPrincipal.fondo0 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores0 = (int) nuevoQuemadores;
	            break;
	        case 1:
	            FrmVentanaPrincipal.precio1 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho1 = nuevoAncho;
	            FrmVentanaPrincipal.alto1 = nuevoAlto;
	            FrmVentanaPrincipal.fondo1 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores1 = (int) nuevoQuemadores;
	            break;
	        case 2:
	            FrmVentanaPrincipal.precio2 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho2 = nuevoAncho;
	            FrmVentanaPrincipal.alto2 = nuevoAlto;
	            FrmVentanaPrincipal.fondo2 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores2 = (int) nuevoQuemadores;
	            break;
	        case 3:
	            FrmVentanaPrincipal.precio3 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho3 = nuevoAncho;
	            FrmVentanaPrincipal.alto3 = nuevoAlto;
	            FrmVentanaPrincipal.fondo3 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores3 = (int) nuevoQuemadores;
	            break;
	        default:
	            FrmVentanaPrincipal.precio4 = nuevoPrecio;
	            FrmVentanaPrincipal.ancho4 = nuevoAncho;
	            FrmVentanaPrincipal.alto4 = nuevoAlto;
	            FrmVentanaPrincipal.fondo4 = nuevoFondo;
	            FrmVentanaPrincipal.quemadores4 = (int) nuevoQuemadores;
	    }
	}

}







