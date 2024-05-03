package proyecto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConfigurarObsequios extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9220278221546395910L;
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
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
			DlgConfigurarObsequios dialog = new DlgConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(null);
		{
			JLabel lblUno = new JLabel("1 unidad");
			lblUno.setBounds(26, 26, 100, 30);
			getContentPane().add(lblUno);
		}
		{
			JLabel lblCinco = new JLabel("2 a 5 unidades");
			lblCinco.setBounds(26, 67, 100, 30);
			getContentPane().add(lblCinco);
		}
		{
			JLabel lblSeis = new JLabel("6 a más unidades");
			lblSeis.setBounds(26, 108, 100, 30);
			getContentPane().add(lblSeis);
		}
		{
			txtObsequio1 = new JTextField();
			txtObsequio1.setBounds(136, 26, 160, 30);
			getContentPane().add(txtObsequio1);
			txtObsequio1.setColumns(10);
		}
		{
			txtObsequio2 = new JTextField();
			txtObsequio2.setColumns(10);
			txtObsequio2.setBounds(136, 67, 160, 30);
			getContentPane().add(txtObsequio2);
		}
		{
			txtObsequio3 = new JTextField();
			txtObsequio3.setColumns(10);
			txtObsequio3.setBounds(136, 108, 160, 30);
			getContentPane().add(txtObsequio3);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(this);
			btnGuardar.setBounds(323, 26, 89, 30);
			getContentPane().add(btnGuardar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(323, 67, 89, 30);
			getContentPane().add(btnCancelar);
		}
		userAutentication();
		mostrarData();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			saveChanges(e);
		} else if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	private void userAutentication() {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
			txtObsequio1.setEditable(false);
			txtObsequio2.setEditable(false);
			txtObsequio3.setEditable(false);
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
		txtObsequio1.setText(FrmVentanaPrincipal.obsequio1 + "");
		txtObsequio2.setText(FrmVentanaPrincipal.obsequio2 + "");
		txtObsequio3.setText(FrmVentanaPrincipal.obsequio3 + "");
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		FrmVentanaPrincipal.obsequio1 = txtObsequio1.getText();
		FrmVentanaPrincipal.obsequio2 = txtObsequio2.getText();
		FrmVentanaPrincipal.obsequio3 = txtObsequio3.getText();

	    JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
	}
}





