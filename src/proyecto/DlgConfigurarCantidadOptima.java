package proyecto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConfigurarCantidadOptima extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3503969300500380032L;
	private JTextField txtCantOptm;
	private JButton btnCancelar;
	private JButton btnGuardar;

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
			DlgConfigurarCantidadOptima dialog = new DlgConfigurarCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarCantidadOptima() {
		setTitle("Configurar cantidad óptima");
		setBounds(100, 100, 485, 130);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cantidad óptima de cantidades vendidas");
			lblNewLabel.setBounds(28, 28, 228, 30);
			getContentPane().add(lblNewLabel);
		}
		{
			txtCantOptm = new JTextField();
			txtCantOptm.setBounds(266, 28, 70, 30);
			getContentPane().add(txtCantOptm);
			txtCantOptm.setColumns(10);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(354, 11, 81, 30);
			getContentPane().add(btnGuardar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(354, 51, 81, 30);
			getContentPane().add(btnCancelar);
		}
		userAutentication();
		mostrarData();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			saveChanges(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	private void userAutentication() {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
			txtCantOptm.setEditable(false);
	    }
	}
	private void saveChanges(ActionEvent e) {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
			JOptionPane.showMessageDialog(this, "Solo el administrador puede realizar cambios.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estas seguro que deseas realizar cambios?", "Confirmar cambios", JOptionPane.YES_NO_OPTION);
		    if (confirmacion == JOptionPane.YES_OPTION) {
		    	actionPerformedBtnGuardar(e);	
		        dispose();
		    }
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}

	private void mostrarData() {
		txtCantOptm.setText(FrmVentanaPrincipal.cantidadOptima + "");
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		FrmVentanaPrincipal.cantidadOptima = Integer.parseInt(txtCantOptm.getText());

	    JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
	}
}





