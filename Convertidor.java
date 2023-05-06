import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Convertidor {
    private JPanel panelMain;
    private JComboBox cmbMonedaOriginal;
    private JLabel labelMonedaResultado;
    private JLabel labelMonedaOriginal;
    private JComboBox cmbMonedaResultado;
    private JTextArea txtMonto;
    private JButton btnConvertir;
    private JLabel labelMonto;
    private JLabel labelResultado;


    public String[] Convertir(int moneda_origen, int moneda_destino, double monto) {

        String[][] monedas = {
                {"MXN", "0.05"},
                {"USD", "1.0"},
                {"EUR", "1.12"},
                {"GBP", "1.28"},
                {"JPY", "0.0094"},
                {"KRW", "0.0009"},
        };
        double valor_origen = Double.parseDouble(monedas[moneda_origen][1]);
        double valor_destino = Double.parseDouble(monedas[moneda_destino][1]);
        double montoResultado = Math.round(((monto * valor_origen) / valor_destino) * 100.0) / 100.0;
        return new String[]{monedas[moneda_origen][0], monedas[moneda_destino][0], String.valueOf(montoResultado)};
    }

    public Convertidor() {

        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int moneda_origen = cmbMonedaOriginal.getSelectedIndex();
                int moneda_destino = cmbMonedaResultado.getSelectedIndex();
                double monto = Double.parseDouble(txtMonto.getText());
                String[] resultado = Convertir(moneda_origen, moneda_destino, monto);
                labelResultado.setText("Resultado de " + resultado[0] + " a " + resultado[1] + " es: " + resultado[2]);
            }
        });
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Convertidor");
        frame.setContentPane(new Convertidor().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}





