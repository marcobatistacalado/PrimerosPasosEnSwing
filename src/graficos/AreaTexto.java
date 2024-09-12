package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * ÁREAS DE TEXTO
 * JTextArea ©
 *  - getText() (m): Obtener el texto del área.
 *  - setLineWrap(boolean) (m): Establecer si debe haber saltos de línea automáticos.
 *  - getLineWrap() (m): Obtener el estado de los saltos de línea automáticos.
 */
public class AreaTexto {

    public static void main(String[] args) {
        // Crear una instancia de MarcoArea y configurarla para que se cierre al salir
        MarcoArea mimarco = new MarcoArea();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

// Clase que representa el marco principal de la aplicación
class MarcoArea extends JFrame {
    public MarcoArea() {
        // Establecer el tamaño y la posición del marco
        setBounds(500, 300, 500, 350);
        
        // Crear una instancia de LaminaArea y añadirla al marco
        LaminaArea milamina = new LaminaArea();
        add(milamina);
        
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que representa el panel principal de la aplicación
class LaminaArea extends JPanel {
    private JTextArea miarea;  // Área de texto

    public LaminaArea() {
        // Crear un área de texto con 8 filas y 20 columnas
        miarea = new JTextArea(8, 20);
        
        // Establecer que el área de texto tenga saltos de línea automáticos
        miarea.setLineWrap(true);
        
        // Crear un panel de desplazamiento para el área de texto
        JScrollPane laminaBarras = new JScrollPane(miarea);
        
        // Añadir el panel de desplazamiento al panel principal
        add(laminaBarras);
        
        // Crear un botón y añadirle un ActionListener
        JButton miboton = new JButton("Dale");
        miboton.addActionListener(new GestionArea());
        add(miboton);
    }

    // Clase interna para manejar los eventos del botón
    private class GestionArea implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener y mostrar el texto del área de texto en la consola
            System.out.println(miarea.getText());
        }
    }
}


