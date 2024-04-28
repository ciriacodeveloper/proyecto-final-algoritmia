package proyecto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgGenerarReportes extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5901513184110405877L;
	private JLabel lblTipo;
	private JComboBox<String> cboReporte;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

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
			DlgGenerarReportes dialog = new DlgGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgGenerarReportes() {
		setTitle("Generar reportes");
		setBounds(100, 100, 550, 350);
		getContentPane().setLayout(null);
		
		lblTipo = new JLabel("Tipo de reporte");
		lblTipo.setBounds(10, 11, 94, 38);
		getContentPane().add(lblTipo);
		
		cboReporte = new JComboBox<String>();
		cboReporte.setModel(new DefaultComboBoxModel<String>(new String[] {"Ventas por modelo", "Ventas en relación a la venta óptima", "Precios en relación al precio promedio", "Promedios, menores y mayores"}));
		cboReporte.setBounds(114, 11, 300, 38);
		getContentPane().add(cboReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(435, 11, 89, 38);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 514, 240);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		reporteVentasPorModelo();
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cboReporte) {
            // Verificar si se selecciona el primer ítem del JComboBox
            if (cboReporte.getSelectedIndex() == 0)
                // Llamar al método para generar el reporte
            	reporteVentasPorModelo();
            else if ( cboReporte.getSelectedIndex() == 1 ) 
            	reporteVentasRelacionVentaOptima();
            
        } else if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);}
        }
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	// Método para generar el reporte Ventas por modelo
    private void reporteVentasPorModelo() {
        textArea.setText("");

        textArea.append("VENTAS POR MODELO\n\n");

        // Mostrar información para cada modelo de cocina
        mostrarInfoModelo0(FrmVentanaPrincipal.modelo0, DlgVenderCocina.cantidadDeVentas0, DlgVenderCocina.cantidadDeUnidadesVendidas0, DlgVenderCocina.importeTotalVendido0, DlgVenderCocina.porcentajeAporteCuotaDiaria0);
        mostrarInfoModelo0(FrmVentanaPrincipal.modelo1, DlgVenderCocina.cantidadDeVentas1, DlgVenderCocina.cantidadDeUnidadesVendidas1, DlgVenderCocina.importeTotalVendido1, DlgVenderCocina.porcentajeAporteCuotaDiaria1);
        mostrarInfoModelo0(FrmVentanaPrincipal.modelo2, DlgVenderCocina.cantidadDeVentas2, DlgVenderCocina.cantidadDeUnidadesVendidas2, DlgVenderCocina.importeTotalVendido2, DlgVenderCocina.porcentajeAporteCuotaDiaria2);
        mostrarInfoModelo0(FrmVentanaPrincipal.modelo3, DlgVenderCocina.cantidadDeVentas3, DlgVenderCocina.cantidadDeUnidadesVendidas3, DlgVenderCocina.importeTotalVendido3, DlgVenderCocina.porcentajeAporteCuotaDiaria3);
        mostrarInfoModelo0(FrmVentanaPrincipal.modelo4, DlgVenderCocina.cantidadDeVentas4, DlgVenderCocina.cantidadDeUnidadesVendidas4, DlgVenderCocina.importeTotalVendido4, DlgVenderCocina.porcentajeAporteCuotaDiaria4);
    }
    
    // Método para mostrar la información de un modelo de cocina
    private void mostrarInfoModelo0(String nombreCocina, int cantVentas, int cantUnidadesVendidas, double iTotalVendido, double porcAporteCuotaDiaria) {
        textArea.append("Modelo 		: " + nombreCocina + "\n");
        textArea.append("Cantidad de ventas 	: " + cantVentas + "\n");
        textArea.append("Cantidad de unidades vendidas : " + cantUnidadesVendidas + "\n");
        textArea.append("Importe total vendido 	: S/. " + String.format("%.2f", iTotalVendido) + "\n");
        textArea.append("Aporte a la cuota diaria 	: " + String.format("%.2f", porcAporteCuotaDiaria) + "%\n\n");
    }
    
    
    
    
    
    
    
    // Método para generar el reporte: Ventas en relación a la venta óptima
    private void reporteVentasRelacionVentaOptima() {
        textArea.setText("");

        textArea.append("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA\n\n");

        // Mostrar información para cada modelo de cocina
        mostrarInfoModelo1(FrmVentanaPrincipal.modelo0, DlgVenderCocina.cantidadDeUnidadesVendidas0);
        mostrarInfoModelo1(FrmVentanaPrincipal.modelo1, DlgVenderCocina.cantidadDeUnidadesVendidas1);
        mostrarInfoModelo1(FrmVentanaPrincipal.modelo2, DlgVenderCocina.cantidadDeUnidadesVendidas2);
        mostrarInfoModelo1(FrmVentanaPrincipal.modelo3, DlgVenderCocina.cantidadDeUnidadesVendidas3);
        mostrarInfoModelo1(FrmVentanaPrincipal.modelo4, DlgVenderCocina.cantidadDeUnidadesVendidas4);
    }
    
    // Método para mostrar la información de un modelo de cocina
    private void mostrarInfoModelo1(String nombreCocina, int cantUnidadesVendidas) {
        textArea.append("Modelo 		: " + nombreCocina + "\n");
        textArea.append("Cantidad de unidades vendidas : " + cantUnidadesVendidas + relacionVentaOptima(cantUnidadesVendidas) + "\n\n");
    }
    
    private String relacionVentaOptima(int cantUndVend) {
        int diferencia = cantUndVend - FrmVentanaPrincipal.cantidadOptima;
        if (cantUndVend > FrmVentanaPrincipal.cantidadOptima)
            return "(" + diferencia + " más que la cantidad óptima)";
        else if (cantUndVend < FrmVentanaPrincipal.cantidadOptima)
            return "(" + diferencia + " menos que la cantidad óptima)";
        else
            return "(igual a la cantidad óptima)";
    }
    
    
    
    
}





