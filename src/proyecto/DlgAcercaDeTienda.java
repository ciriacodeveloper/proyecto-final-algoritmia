package proyecto;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DlgAcercaDeTienda extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JButton btnCerrar;
	private JLabel lblAutor;
	private JLabel lblAño;
	private JLabel lblLimaPeru;
	private JLabel lblWwwciriacodevelopercom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DlgAcercaDeTienda dialog = new DlgAcercaDeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAcercaDeTienda() {
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 233);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTienda.setBounds(181, 11, 72, 17);
		contentPanel.add(lblTienda);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(172, 155, 89, 28);
		contentPanel.add(btnCerrar);

		// poner tilde D\u00E9bora	
		lblAutor = new JLabel("Hecho por Joseph Michael Ciriaco Bermudez");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAutor.setBounds(95, 53, 243, 15);
		contentPanel.add(lblAutor);

		lblAño = new JLabel("2024");
		lblAño.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAño.setBounds(203, 76, 28, 15);
		contentPanel.add(lblAño);

		lblLimaPeru = new JLabel("Lima, Per\u00FA");
		lblLimaPeru.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLimaPeru.setBounds(188, 101, 57, 15);
		contentPanel.add(lblLimaPeru);
		
		lblWwwciriacodevelopercom = new JLabel("www.ciriacodeveloper.com");
		lblWwwciriacodevelopercom.setBounds(143, 128, 147, 16);
		contentPanel.add(lblWwwciriacodevelopercom);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}