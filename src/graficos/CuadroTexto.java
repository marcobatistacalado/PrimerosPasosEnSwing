package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * CUADROS DE TEXTO
 * JTextComponent (A) © 
 *     void setText(String t) (m)
 *     void getText(String t) (m)
 * JTextField © → construir cuadro de texto de una línea
 * JTextArea © → area de texto
 */

public class CuadroTexto {

    public static void main(String[] args) {
        // Crear una instancia de MarcoTexto y configurarlo para que se cierre al salir
        MarcoTexto mimarco = new MarcoTexto();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoTexto extends JFrame {
    public MarcoTexto() {
        // Establecer el tamaño y la posición del marco
        setBounds(600, 300, 600, 350);
        
        // Crear una instancia de LaminaTexto y añadirla al marco
        LaminaTexto milamina = new LaminaTexto();
        add(milamina);
        
        // Hacer visible el marco
        setVisible(true);
    }
}

class LaminaTexto extends JPanel {
    private JTextField campo1; // Campo de texto para introducir el email
    private JLabel resultado; // Etiqueta para mostrar el resultado de la comprobación del email

    public LaminaTexto() {
        // Crear la etiqueta para mostrar el resultado y centrar el texto
        resultado = new JLabel("", JLabel.CENTER);

        // Crear el campo de texto con un tamaño de 28 columnas
        campo1 = new JTextField(28);

        // Establecer el layout del panel principal como BorderLayout
        setLayout(new BorderLayout());

        // Crear un segundo panel con FlowLayout para los componentes de entrada
        JPanel milamina2 = new JPanel();
        milamina2.setLayout(new FlowLayout());

        // Crear una etiqueta para el texto "Email:" y añadirla al panel secundario
        JLabel texto1 = new JLabel("Email: ");
        milamina2.add(texto1);
        
        // Añadir el campo de texto al panel secundario
        milamina2.add(campo1);
        
        // Añadir la etiqueta de resultado al centro del panel principal
        add(resultado, BorderLayout.CENTER);

        // Crear un botón para comprobar el email
        JButton miboton = new JButton("Comprobar");

        // Crear una instancia del manejador de eventos y añadirlo al botón
        DameTexto mievento = new DameTexto();
        miboton.addActionListener(mievento);

        // Añadir el botón al panel secundario
        milamina2.add(miboton);
        
        // Añadir el panel secundario a la parte superior del panel principal
        add(milamina2, BorderLayout.NORTH);
    }

    // Clase interna para manejar los eventos del botón
    private class DameTexto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int correcto = 0; // Contador para el número de '@' en el email
            String email = campo1.getText().trim(); // Obtener el texto del campo de texto y eliminar espacios en blanco

            // Recorrer el email y contar el número de '@'
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    correcto++;
                }
            }

            // Comprobar si el email es válido (debe tener exactamente un '@')
            if (correcto != 1) {
                resultado.setText("Incorrecto");
            } else {
                resultado.setText("Correcto");
            }
        }
    }
}
