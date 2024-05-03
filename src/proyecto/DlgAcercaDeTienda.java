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
	private JLabel lblEricAlfonsoIllapuma;
	private JLabel lblSebastianAmadorYallico;
	private JLabel lblEdinsonAdrielSalas;
	private JLabel lblEdinsonAdrielSalas_1;

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
		setBounds(100, 100, 450, 298);
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
		btnCerrar.setBounds(172, 210, 89, 28);
		contentPanel.add(btnCerrar);

		// poner tilde D\u00E9bora	
		lblAutor = new JLabel("AUTORES");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAutor.setBounds(188, 53, 57, 15);
		contentPanel.add(lblAutor);

		lblAño = new JLabel("Joseph Michael Ciriaco Bermudez");
		lblAño.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAño.setBounds(128, 76, 177, 15);
		contentPanel.add(lblAño);
		
		lblEricAlfonsoIllapuma = new JLabel("Eric Alfonso Illapuma Collazos");
		lblEricAlfonsoIllapuma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEricAlfonsoIllapuma.setBounds(136, 105, 161, 15);
		contentPanel.add(lblEricAlfonsoIllapuma);
		
		lblSebastianAmadorYallico = new JLabel("Sebastian Amador yallico Siviruero");
		lblSebastianAmadorYallico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSebastianAmadorYallico.setBounds(125, 132, 183, 15);
		contentPanel.add(lblSebastianAmadorYallico);
		
		lblEdinsonAdrielSalas = new JLabel("Edinson Adriel Salas Salgado");
		lblEdinsonAdrielSalas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdinsonAdrielSalas.setBounds(141, 159, 152, 15);
		contentPanel.add(lblEdinsonAdrielSalas);
		
		lblEdinsonAdrielSalas_1 = new JLabel("-------------------------------------------------------------------------------------------------------");
		lblEdinsonAdrielSalas_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdinsonAdrielSalas_1.setBounds(11, 26, 412, 15);
		contentPanel.add(lblEdinsonAdrielSalas_1);
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