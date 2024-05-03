package proyecto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConfigurarCuotaDiaria extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -943336651203142460L;
	private JLabel lblCuotaDiaria;
	private JTextField txtCuotaDiaria;
	private JButton btnGuardar;
	private JButton btnCancelar;

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
			DlgConfigurarCuotaDiaria dialog = new DlgConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 465, 154);
		getContentPane().setLayout(null);
		
		lblCuotaDiaria = new JLabel("Cuota diaria esperada (S/.)");
		lblCuotaDiaria.setBounds(26, 46, 180, 16);
		getContentPane().add(lblCuotaDiaria);
		
		txtCuotaDiaria = new JTextField();
		txtCuotaDiaria.setBounds(197, 40, 122, 30);
		getContentPane().add(txtCuotaDiaria);
		txtCuotaDiaria.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(331, 22, 90, 28);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(331, 55, 90, 28);
		getContentPane().add(btnCancelar);
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
			txtCuotaDiaria.setEditable(false);
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
		txtCuotaDiaria.setText(FrmVentanaPrincipal.cuotaDiaria + "");
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		FrmVentanaPrincipal.cuotaDiaria = Integer.parseInt(txtCuotaDiaria.getText());
	}
}





