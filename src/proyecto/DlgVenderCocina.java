package proyecto;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgVenderCocina extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4861176047472171626L;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnVender;
	private JButton btnCerrar;
	private JComboBox<String> cboModelo;
	
	public static double porcentaje1 = 0.5;
	public static double porcentaje2 = 0.2;
	public static double porcentaje3 = 0.1;
	public static double porcentaje4 = 0.099;
	
	public static String obsequio1 = "Una cachetada";
	public static String obsequio2 = "Un abrazo";
	public static String obsequio3 = "Un beso";
	
	private int contadorVentas = 0;
    private double importeTotalAcumulado = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVenderCocina dialog = new DlgVenderCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVenderCocina() {
		setTitle("Vender Cocina");
		setBounds(100, 100, 450, 370);
		getContentPane().setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(22, 22, 64, 30);
			getContentPane().add(lblModelo);
		}
		{
			JLabel lblPrecio = new JLabel("Precio (s/)");
			lblPrecio.setBounds(22, 58, 64, 30);
			getContentPane().add(lblPrecio);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(22, 94, 64, 30);
			getContentPane().add(lblCantidad);
		}
		{
			cboModelo = new JComboBox<String>();
			cboModelo.addActionListener(this);
			cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {
					FrmVentanaPrincipal.modelo0, FrmVentanaPrincipal.modelo1, FrmVentanaPrincipal.modelo2, FrmVentanaPrincipal.modelo3, FrmVentanaPrincipal.modelo4}));
			cboModelo.setBounds(96, 22, 150, 30);
			getContentPane().add(cboModelo);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(96, 58, 150, 30);
			getContentPane().add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(96, 94, 150, 30);
			getContentPane().add(txtCantidad);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 133, 390, 175);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(323, 22, 89, 25);
		getContentPane().add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(323, 59, 89, 25);
		getContentPane().add(btnCerrar);
		mostrarData(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	int modelo;
	
	protected void actionPerformedBtnVender(ActionEvent e) {
	    int cant;
	    double iComp, iDscto, iPag;
	    String obsq;

	    modelo = getModelo();
	    cant = getCantidad();

	    iComp = calcularImporteCompra(modelo, cant);
	    iDscto = calcularImporteDescuento(cant, iComp);
	    iPag = calcularImportePagar(iComp, iDscto);
	    obsq = calcularObsequio(cant);

	    txtS.setText("");
	    txtS.append("BOLETA DE VENTA:" + "\n\n");
	    txtS.append("Modelo: 		" + cboModelo.getSelectedItem() + "\n");
	    txtS.append("Precio: S/ 		" + obtenerPrecio(modelo) + "\n");
	    txtS.append("Cantidad: 		" + cant + "\n");
	    txtS.append("Importe de compra: 	" + String.format("%.2f", iComp) + "\n");
	    txtS.append("Importe de descuento: 	" + String.format("%.2f", iDscto) + "\n");
	    txtS.append("Importe de pagar: 	" + String.format("%.2f", iPag) + "\n");
	    txtS.append("Obsequio: 		" + obsq + "\n");
	    
	    importeTotalAcumulado += iPag;
	    contadorVentas++;
	    if (contadorVentas == 5) {
            mostrarVentanaMensaje();
            contadorVentas = 0; // Reiniciar el contador
            importeTotalAcumulado = 0; // Reiniciar el importe total acumulado
        }
	}


	private int getModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	private double calcularImporteCompra(int modelo, int cant) {
		switch (modelo) {
		case 0: return cant * FrmVentanaPrincipal.precio0;
		case 1: return cant * FrmVentanaPrincipal.precio1;
		case 2: return cant * FrmVentanaPrincipal.precio2;
		case 3: return cant * FrmVentanaPrincipal.precio3;
		default: return cant * FrmVentanaPrincipal.precio4;
		}
	}
	
	private double calcularImporteDescuento(int cant, double iComp) {
		if (cant < 2) return iComp * porcentaje1;
		else if(cant < 6) return iComp * porcentaje2;
		else if(cant < 11) return iComp * porcentaje3;
		else return iComp * porcentaje4;
	}
	
	private double calcularImportePagar(double iComp, double iDscto) {
		return iComp - iDscto;
	}
	
	String calcularObsequio( int cant ) {
		if ( cant == 1 ) return obsequio1;
		else if ( cant <= 5 ) return obsequio2;
		else return obsequio3;
	}
	
	private void actionPerformedCboModelo(ActionEvent e) {
		modelo = getModelo();
		mostrarData(modelo);
	}
	
	private void mostrarData(int modelo) {
		switch (modelo) {
		case 0:
			txtPrecio.setText(FrmVentanaPrincipal.precio0 + "");			
			break;
		case 1:
			txtPrecio.setText(FrmVentanaPrincipal.precio1 + "");			
			break;
		case 2:
			txtPrecio.setText(FrmVentanaPrincipal.precio2 + "");			
			break;
		case 3:
			txtPrecio.setText(FrmVentanaPrincipal.precio3 + "");			
			break;

		default:
			txtPrecio.setText(FrmVentanaPrincipal.precio4 + "");
			break;
		}
	}
	
	private double obtenerPrecio(int modelo) {
        switch (modelo) {
            case 0:
                return FrmVentanaPrincipal.precio0;
            case 1:
                return FrmVentanaPrincipal.precio1;
            case 2:
                return FrmVentanaPrincipal.precio2;
            case 3:
                return FrmVentanaPrincipal.precio3;
            default:
                return FrmVentanaPrincipal.precio4;
        }
    }
	
	private void mostrarVentanaMensaje() {
        double porcentajeCuotaDiaria = (importeTotalAcumulado / FrmVentanaPrincipal.cuotaDiaria) * 100;
        String mensaje = "Venta Nro.: " + contadorVentas + "\n";
        mensaje += "Importe total general acumulado: " + String.format("%.2f", importeTotalAcumulado) + "\n";
        mensaje += "Porcentaje de la cuota diaria: " + String.format("%.2f", porcentajeCuotaDiaria) + "%";

        JOptionPane.showMessageDialog(this, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
    }
}







