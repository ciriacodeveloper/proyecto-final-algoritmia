package proyecto;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgListarCocina extends JDialog implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    private JScrollPane scrollPane;
    private JTextArea txtS;
    private JButton btnCerrar;
    private JButton btnListar;
    private JPanel panel;

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
                    DlgListarCocina dialog = new DlgListarCocina();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the dialog.
     */
    public DlgListarCocina() {
        setTitle("Listar Cocinas");
        setBounds(100, 100, 466, 321);
        getContentPane().setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 430, 226);
        getContentPane().add(scrollPane);

        txtS = new JTextArea();
        txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
        scrollPane.setViewportView(txtS);

        panel = new JPanel();
        panel.setBounds(123, 238, 202, 38);
        getContentPane().add(panel);
        panel.setLayout(null);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(107, 0, 89, 33);
        panel.add(btnCerrar);

        btnListar = new JButton("Listar");
        btnListar.addActionListener(this);
        btnListar.setBounds(6, 0, 89, 33);
        panel.add(btnListar);
        btnCerrar.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnListar) {
            actionPerformedBtnListar(e);
        }
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
    }

    protected void actionPerformedBtnCerrar(ActionEvent e) {
        dispose();
    }

    protected void actionPerformedBtnListar(ActionEvent e) {
        // Al pulsar el botón Listar, se mostrará un reporte con los datos de las cocinas
        // Se recorre la información de las cocinas disponibles y se muestra en el área de texto
        txtS.setText(""); // Limpiamos el área de texto antes de mostrar las cocinas
        txtS.append("LISTADO DE COCINAS:" + "\n\n");
        for (int i = 0; i < 5; i++) { // Suponiendo que hay 5 cocinas disponibles
        	txtS.append("Cocina número	: " + (i + 1) + "\n");
            txtS.append("Modelo		: " + obtenerModelo(i) + "\n");
            txtS.append("Precio		: S/ " + obtenerPrecio(i) + "\n");
            txtS.append("Ancho		: " + obtenerAncho(i) + " cm\n");
            txtS.append("Alto		: " + obtenerAlto(i) + " cm\n");
            txtS.append("Fondo		: " + obtenerFondo(i) + " cm\n");
            txtS.append("Quemadores	: " + obtenerQuemadores(i) + "\n");
            txtS.append("\n");
        }
    }


    // Métodos de ejemplo para obtener información de las cocinas
    private String obtenerModelo(int indice) {
        // Devuelve el modelo de la cocina según el índice proporcionado
        switch (indice) {
            case 0:
                return "Mabe EMP6120PG0";
            case 1:
                return "Indurama Parma";
            case 2:
                return "Sole COSOL027";
            case 3:
                return "Coldex CX602";
            case 4:
                return "Reco Dakota";
            default:
                return "";
        }
    }

    private double obtenerPrecio(int indice) {
        // Devuelve el precio de la cocina según el índice proporcionado
        switch (indice) {
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

 // Métodos de ejemplo para obtener información de las cocinas
    private double obtenerAncho(int indice) {
        // Devuelve el ancho de la cocina según el índice proporcionado
        switch (indice) {
            case 0:
                return FrmVentanaPrincipal.ancho0;
            case 1:
                return FrmVentanaPrincipal.ancho1;
            case 2:
                return FrmVentanaPrincipal.ancho2;
            case 3:
                return FrmVentanaPrincipal.ancho3;
            default:
                return FrmVentanaPrincipal.ancho4;
            
        }
    }

    private double obtenerAlto(int indice) {
        // Devuelve el alto de la cocina según el índice proporcionado
        switch (indice) {
            case 0:
                return FrmVentanaPrincipal.alto0;
            case 1:
                return FrmVentanaPrincipal.alto1;
            case 2:
                return FrmVentanaPrincipal.alto2;
            case 3:
                return FrmVentanaPrincipal.alto3;
            default:
                return FrmVentanaPrincipal.alto4;
            
        }
    }

    private double obtenerFondo(int indice) {
        // Devuelve el fondo de la cocina según el índice proporcionado
        switch (indice) {
            case 0:
                return FrmVentanaPrincipal.fondo0;
            case 1:
                return FrmVentanaPrincipal.fondo1;
            case 2:
                return FrmVentanaPrincipal.fondo2;
            case 3:
                return FrmVentanaPrincipal.fondo3;
            default:
                return FrmVentanaPrincipal.fondo4;
            
        }
    }

    private int obtenerQuemadores(int indice) {
        // Devuelve la cantidad de quemadores de la cocina según el índice proporcionado
        switch (indice) {
            case 0:
                return FrmVentanaPrincipal.quemadores0;
            case 1:
                return FrmVentanaPrincipal.quemadores1;
            case 2:
                return FrmVentanaPrincipal.quemadores2;
            case 3:
                return FrmVentanaPrincipal.quemadores3;
            default:
                return FrmVentanaPrincipal.quemadores4;
            
        }
    }
}