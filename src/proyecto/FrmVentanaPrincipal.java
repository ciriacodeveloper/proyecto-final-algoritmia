package proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmVentanaPrincipal extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = -6187284385684655814L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarCocina;
	private JMenuItem mntmModificarCocina;
	private JMenuItem mntmListarCocinas;
	private JMenu mnVentas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenu mnConfiguracin;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
	
	// Datos mínimos de la primera cocina
		public static String modelo0 = "Mabe EMP6120PG0";
		public static double precio0 = 949.0;
		public static double fondo0 = 58.6;
		public static double ancho0 = 60.0;
		public static double alto0 = 91.0;
		public static int quemadores0 = 4;
		// Datos mínimos de la segunda cocina
		public static String modelo1 = "Indurama Parma";
		public static double precio1 = 1089.0;
		public static double ancho1 = 80.0;
		public static double alto1 = 94.0;
		public static double fondo1 = 67.5;
		public static int quemadores1 = 6;
		// Datos mínimos de la tercera cocina
		public static String modelo2 = "Sole COSOL027";
		public static double precio2 = 850.0;
		public static double ancho2 = 60.0;
		public static double alto2 = 90.0;
		public static double fondo2 = 50.0;
		public static int quemadores2 = 4;
		// Datos mínimos de la cuarta cocina
		public static String modelo3 = "Coldex CX602";
		public static double precio3 = 629.0;
		public static double ancho3 = 61.6;
		public static double alto3 = 95.0;
		public static double fondo3 = 51.5;
		public static int quemadores3 = 5;
		// Datos mínimos de la quinta cocina
		public static String modelo4 = "Reco Dakota";
		public static double precio4 = 849.0;
		public static double ancho4 = 75.4;
		public static double alto4 = 94.5;
		public static double fondo4 = 66.0;
		public static int quemadores4 = 5;
		// Porcentajes de descuento
		public static double porcentaje1 = 0.075;
		public static double porcentaje2 = 0.1;
		public static double porcentaje3 = 0.125;
		public static double porcentaje4 = 0.15;
		// Obsequios
		public static String obsequio1 = "Cafetera";
		public static String obsequio2 = "Licuadora";
		public static String obsequio3 = "Extractor";
		// Cantidad óptima de unidades vendidas
		public static int cantidadOptima = 10;
		// Cuota diaria
		public static double cuotaDiaria = 75000;
		
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVentanaPrincipal frame = new FrmVentanaPrincipal();
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
	public FrmVentanaPrincipal() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 487);
        setLocationRelativeTo(null);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarCocina = new JMenuItem("Consultar cocina");
		mntmConsultarCocina.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCocina);
		
		mntmModificarCocina = new JMenuItem("Modificar cocina");
		mntmModificarCocina.addActionListener(this);
		mnMantenimiento.add(mntmModificarCocina);
		
		mntmListarCocinas = new JMenuItem("Listar cocinas");
		mntmListarCocinas.addActionListener(this);
		mnMantenimiento.add(mntmListarCocinas);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracin);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mnConfiguracin.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mnConfiguracin.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mnConfiguracin.add(mntmConfigurarCantidadptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mnConfiguracin.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmListarCocinas) {
			actionPerformedMntmListarCocinas(e);
		}
		if (e.getSource() == mntmModificarCocina) {
			actionPerformedMntmModificarCocina(e);
		}
		if (e.getSource() == mntmConsultarCocina) {
			actionPerformedMntmConsultarCocina(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		//CERRAR APLICACION
		System.exit(0);
	}
	protected void actionPerformedMntmConsultarCocina(ActionEvent e) {
		abrirVentanaConsultarCocina();
	}

	private void abrirVentanaConsultarCocina() {
		// Instanciar un objeto de la clase DlgConsultarCocina
		DlgConsultarCocina con = new DlgConsultarCocina();
		//ventana sea visible
		con.setVisible(true);
		//ubicacion de la ventana en el medio
		con.setLocationRelativeTo(this);
		
		
	}
	protected void actionPerformedMntmModificarCocina(ActionEvent e) {
		abrirVentanaModificarCocina();
	}

	private void abrirVentanaModificarCocina() {
		DlgModificarCocina con = new DlgModificarCocina();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
		
	}
	protected void actionPerformedMntmListarCocinas(ActionEvent e) {
		abrirVentanaListarCocina();
	}

	private void abrirVentanaListarCocina() {
		DlgListarCocina con = new DlgListarCocina();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
		
		
	}
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		abrirVentanaAcercaDeTienda();
	}

	private void abrirVentanaAcercaDeTienda() {
		DlgAcercaDeTienda con = new DlgAcercaDeTienda();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
		
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
		abrirVentanaVenderCocina();
	}

	private void abrirVentanaVenderCocina() {
		DlgVenderCocina con = new DlgVenderCocina();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
		
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		abrirVentanaGenerarReporte();
	}

	private void abrirVentanaGenerarReporte() {
		DlgGenerarReportes con = new DlgGenerarReportes();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
		
	}
}












