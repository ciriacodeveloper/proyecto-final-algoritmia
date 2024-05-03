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
		public static double porcentaje1 = 7.5;
		public static double porcentaje2 = 10.0;
		public static double porcentaje3 = 12.5;
		public static double porcentaje4 = 15.0;
		// Obsequios
		public static String obsequio1 = "Cafetera";
		public static String obsequio2 = "Licuadora";
		public static String obsequio3 = "Extractor";
		// Cantidad óptima de unidades vendidas
		public static int cantidadOptima = 10;
		// Cuota diaria
		public static double cuotaDiaria = 75000;
		// Precio promedio
		public static double precioPromedio = getPrecioPromedio();
		// Precio menor
		public static double precioMenor = getPrecioMenor();
		// Precio mayor
		public static double precioMayor = getPrecioMayor();
		// Ancho promedio
		public static double anchoPromedio = getAnchoPromedio();
		// Ancho menor
		public static double anchoMenor = getAnchoMenor();
		// Ancho mayor
		public static double anchoMayor = getAnchoMayor();
		private JMenuItem mntmCerrarSesion;
		

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
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesión");
		mntmCerrarSesion.addActionListener(this);
		mnArchivo.add(mntmCerrarSesion);
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
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfigurarCantidadptima.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarCantidadptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
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
		if (e.getSource() == mntmCerrarSesion) {
			actionPerformedMntmCerrarSesion(e);
		}
		if (e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if (e.getSource() == mntmConfigurarCantidadptima) {
			actionPerformedMntmConfigurarCantidadptima(e);
		}
		if (e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
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
	protected void actionPerformedMntmCerrarSesion(ActionEvent e) {
		dispose();
		abrirVentanaLogin();
	}
	private void abrirVentanaLogin() {
		Login con = new Login();
		con.setVisible(true);
		con.setLocationRelativeTo(null);
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		//CERRAR APLICACION
		System.exit(0);
	}
	protected void actionPerformedMntmConsultarCocina(ActionEvent e) {
		abrirVentanaConsultarCocina();
	}

	private void abrirVentanaConsultarCocina() {
		DlgConsultarCocina con = new DlgConsultarCocina();
		con.setVisible(true);
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
	
	public static double getPrecioPromedio() {
        return (precio0 + precio1 + precio2 + precio3 + precio4) / 5;
    }
	
	public static double getPrecioMenor() {
        double menor = precio0;
        if (precio1 < menor) menor = precio1;
        if (precio2 < menor) menor = precio2;
        if (precio3 < menor) menor = precio3;
        if (precio4 < menor) menor = precio4;
        return menor;
    }
	
	public static double getPrecioMayor() {
        double mayor = precio0;
        if (precio1 > mayor) mayor = precio1;
        if (precio2 > mayor) mayor = precio2;
        if (precio3 > mayor) mayor = precio3;
        if (precio4 > mayor) mayor = precio4;
        return mayor;
    }
	
	public static double getAnchoPromedio() {
        return (ancho0 + ancho1 + ancho2 + ancho3 + ancho4) / 5;
    }
	
	public static double getAnchoMenor() {
		double menor = ancho0;
        if (ancho1 < menor) menor = ancho1;
        if (ancho2 < menor) menor = ancho2;
        if (ancho3 < menor) menor = ancho3;
        if (ancho4 < menor) menor = ancho4;
        return menor;
	}
	public static double getAnchoMayor() {
		double mayor = ancho0;
        if (ancho1 > mayor) mayor = ancho1;
        if (ancho2 > mayor) mayor = ancho2;
        if (ancho3 > mayor) mayor = ancho3;
        if (ancho4 > mayor) mayor = ancho4;
        return mayor;
	}
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		abrirVentanaConfigurarDescuentos();
	}
	private void abrirVentanaConfigurarDescuentos() {
		DlgConfigurarDescuentos con = new DlgConfigurarDescuentos();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		abrirVentanaConfigurarObsequios();
	}
	private void abrirVentanaConfigurarObsequios() {
		DlgConfigurarObsequios con = new DlgConfigurarObsequios();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarCantidadptima(ActionEvent e) {
		abrirVentanaConfigurarCantidadptima();
	}
	private void abrirVentanaConfigurarCantidadptima() {
		DlgConfigurarCantidadOptima con = new DlgConfigurarCantidadOptima();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		abrirVentanaConfigurarCuotaDiaria();
	}
	private void abrirVentanaConfigurarCuotaDiaria() {
		DlgConfigurarCuotaDiaria con = new DlgConfigurarCuotaDiaria();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
	}
	
}












