package graficos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layaout_Grid_Calculadora {

    public static void main(String[] args) {
        MarcoCalculadora mimarco = new MarcoCalculadora();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoCalculadora extends JFrame {
    public MarcoCalculadora() {
        setTitle("Calculadora");
        setBounds(500, 300, 450, 300);
        LaminaCalculadora milamina = new LaminaCalculadora();
        add(milamina);
    }
}

class LaminaCalculadora extends JPanel {
    private JPanel milamina2; // Panel que contiene los botones de la calculadora
    private JButton pantalla; // Botón que actúa como pantalla de la calculadora
    private boolean principio; // Indica si estamos al principio de la entrada de un número
    private double resultado; // Almacena el resultado de las operaciones
    private String ultimaOperacion; // Almacena la última operación realizada

    public LaminaCalculadora() {
        principio = true;
        resultado = 0;
        ultimaOperacion = "=";

        // Configuración del layout del panel principal
        setLayout(new BorderLayout());
        pantalla = new JButton("0");
        pantalla.setEnabled(false); // La pantalla no es clicable
        add(pantalla, BorderLayout.NORTH);

        // Panel para los botones
        milamina2 = new JPanel();
        milamina2.setLayout(new GridLayout(4, 4));

        // Creación de los oyentes para los botones
        ActionListener insertar = new InsertaNumero();
        ActionListener orden = new AccionOrden();

        // Añadir botones numéricos y de operación al panel
        ponerBoton("7", insertar);
        ponerBoton("8", insertar);
        ponerBoton("9", insertar);
        ponerBoton("/", orden);
        ponerBoton("4", insertar);
        ponerBoton("5", insertar);
        ponerBoton("6", insertar);
        ponerBoton("*", orden);
        ponerBoton("1", insertar);
        ponerBoton("2", insertar);
        ponerBoton("3", insertar);
        ponerBoton("-", orden);
        ponerBoton("0", insertar);
        ponerBoton(".", insertar);
        ponerBoton("=", orden);
        ponerBoton("+", orden);

        // Añadir el panel de botones al panel principal
        add(milamina2, BorderLayout.CENTER);
    }

    // Método para crear y añadir un botón al panel
    private void ponerBoton(String rotulo, ActionListener oyente) {
        JButton boton = new JButton(rotulo);
        boton.addActionListener(oyente); // Asignar oyente al botón
        milamina2.add(boton); // Añadir el botón al panel
    }

    // Clase interna para manejar la inserción de números
    private class InsertaNumero implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String entrada = e.getActionCommand(); // Obtener el texto del botón presionado
            if (principio) { // Si estamos al principio de la entrada
                pantalla.setText(""); // Limpiar la pantalla
                principio = false; // Ya no estamos al principio
            }
            pantalla.setText(pantalla.getText() + entrada); // Añadir el texto del botón a la pantalla
        }
    }

    // Clase interna para manejar las operaciones
    private class AccionOrden implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operacion = e.getActionCommand(); // Obtener la operación del botón presionado
            calcular(Double.parseDouble(pantalla.getText())); // Calcular el resultado con el número en la pantalla
            ultimaOperacion = operacion; // Actualizar la última operación
            principio = true; // Resetear para la siguiente entrada de número
        }

        // Método para realizar las operaciones
        private void calcular(double x) {
            switch (ultimaOperacion) {
                case "+":
                    resultado += x;
                    break;
                case "-":
                    resultado -= x;
                    break;
                case "*":
                    resultado *= x;
                    break;
                case "/":
                    resultado /= x;
                    break;
                case "=":
                    resultado = x;
                    break;
            }
            pantalla.setText("" + resultado); // Actualizar la pantalla con el resultado
        }
    }
}

