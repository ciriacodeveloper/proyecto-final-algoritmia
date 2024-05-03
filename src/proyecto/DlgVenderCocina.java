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
	
	
	private int contadorVentasTotal = 0;
    private double importeTotalAcumulado = 0;
    
    // esta variable es para acumular las veces que se realizo una venta de un modelo de cocina
    public static int cantidadDeVentas0 = 0;
    public static int cantidadDeVentas1 = 0;
    public static int cantidadDeVentas2 = 0;
    public static int cantidadDeVentas3 = 0;
    public static int cantidadDeVentas4 = 0;
	
	//Cantidad de unidades vendidas por cada modelo de cocina, muestra el total
    public static int cantidadDeUnidadesVendidas0 = 0;
    public static int cantidadDeUnidadesVendidas1 = 0;
    public static int cantidadDeUnidadesVendidas2 = 0;
    public static int cantidadDeUnidadesVendidas3 = 0;
    public static int cantidadDeUnidadesVendidas4 = 0;
    
    //Importe total vendido, esta variable acumula el importe a pagar cada vez que se realiza una venta por cada modelo de cocina
    public static double importeTotalVendido0 = 0;
    public static double importeTotalVendido1 = 0;
    public static double importeTotalVendido2 = 0;
    public static double importeTotalVendido3 = 0;
    public static double importeTotalVendido4 = 0;
    
    //Aporte a la cuota diaria, esta variable saca el porcentaje de las variables importe total vendido dividido entre la cuotaDiaria multiplicado por 100
    public static double porcentajeAporteCuotaDiaria0 = 0;
    public static double porcentajeAporteCuotaDiaria1 = 0;
    public static double porcentajeAporteCuotaDiaria2 = 0;
    public static double porcentajeAporteCuotaDiaria3 = 0;
    public static double porcentajeAporteCuotaDiaria4 = 0;

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
		userAutentication();
		mostrarData(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnVender) {
			saveChanges(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	private void userAutentication() {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
	        txtCantidad.setEditable(false);
	    }
	}
	private void saveChanges(ActionEvent e) {
		if (!Login.usuarioAutenticado.getRol().equals("administrador")) {
			JOptionPane.showMessageDialog(this, "Solo el administrador puede realizar ventas.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estas seguro que deseas realizar la venta?", "Confirmar venta", JOptionPane.YES_NO_OPTION);
		    if (confirmacion == JOptionPane.YES_OPTION) {
		    	actionPerformedBtnVender(e);	
		        dispose();
		    }
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	
	protected void actionPerformedBtnVender(ActionEvent e) {
	    int cant, modelo;
	    double iComp, iDscto, iPag;
	    String obsq;

	    modelo = getModelo();
	    try {
			cant = getCantidad();
			
			if (cant <= 0){
				mesajeError("Ingresar valores mayores a 0.");
				return;
			}
		} catch (NumberFormatException n) {
			mesajeError("Ingresar valores númericos sin decimal.");
			return;
		}

	    iComp = calcularImporteCompra(modelo, cant);
	    iDscto = calcularImporteDescuento(cant, iComp);
	    iPag = calcularImportePagar(iComp, iDscto);
	    obsq = calcularObsequio(cant);

	    imprimir(cant, iComp, iDscto, iPag, obsq, modelo);
	    
	    avanceVentas( iPag );
	    cantidadDeVentas( modelo );
	    cantidadDeUnidadesVendidas( modelo, cant );
	    importeTotalVendido( modelo, iPag );
	    porcentajeAporteCuotaDiaria( modelo );

	    JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
	}

	private void mesajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error!!!", 0);
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
		if (cant <= 5) return iComp * (FrmVentanaPrincipal.porcentaje1 / 100);
		else if(cant <= 10) return iComp * (FrmVentanaPrincipal.porcentaje2 / 100);
		else if(cant <= 15) return iComp * (FrmVentanaPrincipal.porcentaje3 / 100);
		else return iComp * (FrmVentanaPrincipal.porcentaje4 / 100 );
	}
	
	private double calcularImportePagar(double iComp, double iDscto) {
		return iComp - iDscto;
	}
	
	String calcularObsequio( int cant ) {
		if ( cant == 1 ) return FrmVentanaPrincipal.obsequio1;
		else if ( cant <= 5 ) return FrmVentanaPrincipal.obsequio2;
		else return FrmVentanaPrincipal.obsequio3;
	}
	
	private void actionPerformedCboModelo(ActionEvent e) {
		int modelo;
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

	private void imprimir(int cant, double iComp, double iDscto, double iPag, String obsq, int modelo) {
		txtS.setText("");
	    txtS.append("BOLETA DE VENTA:" + "\n\n");
	    txtS.append("Modelo: 		" + cboModelo.getSelectedItem() + "\n");
	    txtS.append("Precio: S/ 		" + obtenerPrecio(modelo) + "\n");
	    txtS.append("Cantidad: 		" + cant + "\n");
	    txtS.append("Importe de compra: 	" + String.format("%.2f", iComp) + "\n");
	    txtS.append("Importe de descuento: 	" + String.format("%.2f", iDscto) + "\n");
	    txtS.append("Importe de pagar: 	" + String.format("%.2f", iPag) + "\n");
	    txtS.append("Obsequio: 		" + obsq + "\n");
	}

	private void avanceVentas(double iPag) {
		importeTotalAcumulado += iPag;
	    contadorVentasTotal++;
	    if (contadorVentasTotal == 5) {
            mostrarVentanaMensaje();
            contadorVentasTotal = 0; // Reiniciar el contador
            importeTotalAcumulado = 0; // Reiniciar el importe total acumulado
        }
	}
	
	private void mostrarVentanaMensaje() {
        double porcentajeCuotaDiaria = (importeTotalAcumulado / FrmVentanaPrincipal.cuotaDiaria) * 100;
        String mensaje = "Venta Nro.: " + contadorVentasTotal + "\n";
        mensaje += "Importe total general acumulado: " + String.format("%.2f", importeTotalAcumulado) + "\n";
        mensaje += "Porcentaje de la cuota diaria: " + String.format("%.2f", porcentajeCuotaDiaria) + "%";

        JOptionPane.showMessageDialog(this, mensaje, "Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
    }
	
	private void cantidadDeVentas(int modelo) {
		
		switch (modelo) {
		case 0:
			cantidadDeVentas0++;
			break;
		case 1:
			cantidadDeVentas1++;
			break;
		case 2:
			cantidadDeVentas2++;
			break;
		case 3:
			cantidadDeVentas3++;
			break;
		default:
			cantidadDeVentas4++;
			break;
		}
	}
	
	private void cantidadDeUnidadesVendidas(int modelo, int cant) {
		
		switch (modelo) {
		case 0:
			cantidadDeUnidadesVendidas0 += cant;
			break;
		case 1:
			cantidadDeUnidadesVendidas1 += cant;
			break;
		case 2:
			cantidadDeUnidadesVendidas2 += cant;
			break;
		case 3:
			cantidadDeUnidadesVendidas3 += cant;
			break;

		default:
		case 4:
			cantidadDeUnidadesVendidas4 += cant;
			break;
		}
	}

	private void importeTotalVendido( int modelo, double iPag ) {
		switch (modelo) {
		case 0:
			importeTotalVendido0 += iPag;
			break;
		case 1:
			importeTotalVendido1 += iPag;
			break;
		case 2:
			importeTotalVendido2 += iPag;
			break;
		case 3:
			importeTotalVendido3 += iPag;
			break;
		default:
			importeTotalVendido4 += iPag;
			break;
		}
	}
	
	private void porcentajeAporteCuotaDiaria(int modelo) {
		switch (modelo) {
		case 0:
			porcentajeAporteCuotaDiaria0 = (importeTotalVendido0 / FrmVentanaPrincipal.cuotaDiaria) * 100;
			break;
		case 1:
			porcentajeAporteCuotaDiaria1 = (importeTotalVendido1 / FrmVentanaPrincipal.cuotaDiaria) * 100;
			break;
		case 2:
			porcentajeAporteCuotaDiaria2 = (importeTotalVendido2 / FrmVentanaPrincipal.cuotaDiaria) * 100;
			break;
		case 3:
			porcentajeAporteCuotaDiaria3 = (importeTotalVendido3 / FrmVentanaPrincipal.cuotaDiaria) * 100;
			break;
		default:
			porcentajeAporteCuotaDiaria4 = (importeTotalVendido4 / FrmVentanaPrincipal.cuotaDiaria) * 100;
			break;
		}
	}
}







