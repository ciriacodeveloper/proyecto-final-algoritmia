package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6091078350818984134L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JTextField txtUser;
	private JLabel lblContrasea;
    private JPasswordField passwordField;
	private JButton btnSignIn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblImagen;
	
	private GestorUsuarios gestorUsuarios;
	public static Usuario usuarioAutenticado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		gestorUsuarios = new GestorUsuarios();
		setTitle("Tienda 1.0");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(41, 187, 73, 30);
		contentPane.add(lblUsuario);
		
		txtUser = new JTextField();
		txtUser.setBounds(40, 219, 204, 30);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(41, 260, 73, 30);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(41, 292, 204, 30);
		contentPane.add(passwordField);
		
		btnSignIn = new JButton("Iniciar Sesión");
		btnSignIn.addActionListener(this);
		btnSignIn.setBounds(41, 344, 203, 30);
		contentPane.add(btnSignIn);
		
		lblNewLabel = new JLabel("¡Bienvenido!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(79, 127, 127, 31);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Inicia sesión con tus credenciales.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 162, 204, 14);
		contentPane.add(lblNewLabel_1);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(79, 21, 127, 95);
		try {
            // Carga la imagen desde una URL
            @SuppressWarnings("deprecation")
			URL url = new URL("https://campusvirtualperu.com/wp-content/uploads/2023/11/logo_cibertec_fondo_blanco_low.jpg");
            Image imagen = ImageIO.read(url);
            // Escala la imagen al tamaño del JLabel
            imagen = imagen.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
            lblImagen.setIcon(new ImageIcon(imagen));
        } catch (IOException e) {
            e.printStackTrace();
        }
        contentPane.add(lblImagen);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSignIn) {
			actionPerformedBtnSignIn(e);
		}
	}
	protected void actionPerformedBtnSignIn(ActionEvent e) {
	    String nombreUsuario = txtUser.getText();
	    String contraseña = new String(passwordField.getPassword());

	    // Verifica las credenciales
	    Usuario usuario = gestorUsuarios.verificarCredenciales(nombreUsuario, contraseña);
	    if (usuario != null) {
	    	usuarioAutenticado = usuario;
	        JOptionPane.showMessageDialog(null, "¡Bienvenido, " + usuario.getNombre() + "! Tienes un rol de " + usuario.getRol() + ".");
	        dispose();
	        FrmVentanaPrincipal ventanaPrincipal = new FrmVentanaPrincipal();
	        ventanaPrincipal.setVisible(true);
	        ventanaPrincipal.setLocationRelativeTo(this);
	    } else {
	        JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.");
	    }
	}
	
	public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

}
