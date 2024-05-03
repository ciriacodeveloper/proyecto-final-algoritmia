package proyecto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConfigurarDescuentos extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8047898870940757869L;
	private JLabel lblCinco;
	private JLabel lblDiez;
	private JLabel lblQuince;
	private JLabel lblMasQuince;
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblCinco_1;
	private JLabel lblDiez_1;
	private JLabel lblQuince_1;
	private JLabel lblMasQuince_1;

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
			DlgConfigurarDescuentos dialog = new DlgConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarDescuentos() {
		setTitle("Configurar porcentajes de descuentos");
		setBounds(100, 100, 418, 241);
		getContentPane().setLayout(null);
		
		lblCinco = new JLabel("1 a 5 unidades");
		lblCinco.setBounds(21, 26, 100, 30);
		getContentPane().add(lblCinco);
		
		lblDiez = new JLabel("6 a 10 unidades");
		lblDiez.setBounds(21, 68, 100, 30);
		getContentPane().add(lblDiez);
		
		lblQuince = new JLabel("11 a 15 unidades");
		lblQuince.setBounds(21, 110, 100, 30);
		getContentPane().add(lblQuince);
		
		lblMasQuince = new JLabel("Más de 15 unidades");
		lblMasQuince.setBounds(21, 152, 118, 30);
		getContentPane().add(lblMasQuince);
		
		txtPorcentaje1 = new JTextField();
		txtPorcentaje1.setBounds(151, 26, 86, 30);
		getContentPane().add(txtPorcentaje1);
		txtPorcentaje1.setColumns(10);
		
		txtPorcentaje2 = new JTextField();
		txtPorcentaje2.setColumns(10);
		txtPorcentaje2.setBounds(151, 68, 86, 30);
		getContentPane().add(txtPorcentaje2);
		
		txtPorcentaje3 = new JTextField();
		txtPorcentaje3.setColumns(10);
		txtPorcentaje3.setBounds(151, 110, 86, 30);
		getContentPane().add(txtPorcentaje3);
		
		txtPorcentaje4 = new JTextField();
		txtPorcentaje4.setColumns(10);
		txtPorcentaje4.setBounds(151, 152, 86, 30);
		getContentPane().add(txtPorcentaje4);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(294, 26, 89, 30);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(294, 61, 89, 30);
		getContentPane().add(btnCancelar);
		
		lblCinco_1 = new JLabel("%");
		lblCinco_1.setBounds(247, 26, 20, 30);
		getContentPane().add(lblCinco_1);
		
		lblDiez_1 = new JLabel("%");
		lblDiez_1.setBounds(245, 68, 22, 30);
		getContentPane().add(lblDiez_1);
		
		lblQuince_1 = new JLabel("%");
		lblQuince_1.setBounds(247, 110, 20, 30);
		getContentPane().add(lblQuince_1);
		
		lblMasQuince_1 = new JLabel("%");
		lblMasQuince_1.setBounds(247, 152, 20, 30);
		getContentPane().add(lblMasQuince_1);
		userAutentication();
		mostrarData();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		} else if (e.getSource() == btnGuardar) {
			saveChanges(e);
        }
	}
	private void userAutentication() {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
			txtPorcentaje1.setEditable(false);
			txtPorcentaje2.setEditable(false);
			txtPorcentaje3.setEditable(false);
			txtPorcentaje4.setEditable(false);
	    }
	}
	private void saveChanges(ActionEvent e) {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
			JOptionPane.showMessageDialog(this, "Solo el administrador puede realizar cambios.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estas seguro que deseas realizar cambios?", "Confirmar cambios", JOptionPane.YES_NO_OPTION);
		    if (confirmacion == JOptionPane.YES_OPTION) {
		    	guardarCambios();	
		        dispose();
		    }
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	private void mostrarData() {
		txtPorcentaje1.setText(FrmVentanaPrincipal.porcentaje1 + "");
		txtPorcentaje2.setText(FrmVentanaPrincipal.porcentaje2 + "");
		txtPorcentaje3.setText(FrmVentanaPrincipal.porcentaje3 + "");
		txtPorcentaje4.setText(FrmVentanaPrincipal.porcentaje4 + "");
	}
	private void guardarCambios() {		
		FrmVentanaPrincipal.porcentaje1 = Double.parseDouble(txtPorcentaje1.getText());
		FrmVentanaPrincipal.porcentaje2 = Double.parseDouble(txtPorcentaje2.getText());
		FrmVentanaPrincipal.porcentaje3 = Double.parseDouble(txtPorcentaje3.getText());
		FrmVentanaPrincipal.porcentaje4 = Double.parseDouble(txtPorcentaje4.getText());

	    JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
	}
	
}








