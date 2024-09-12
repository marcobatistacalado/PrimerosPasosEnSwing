package graficos;

import javax.swing.*;
import java.awt.*;

/*
 * JPanel: clase encargada de construir láminas donde poder dibujar y escribir.
 * -Debemos crear una clase que herede de JPanel.
 *      -paintComponent(Graphics g) --> es de JComponent, una clase superior a JPanel
 */
public class EscribiendoEnMarco {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        MarcoConTexto mimarco = new MarcoConTexto();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que define el marco principal de la aplicación
class MarcoConTexto extends JFrame {
    public MarcoConTexto() {
        setVisible(true); // Hacer visible el marco
        setSize(600, 450); // Establecer el tamaño del marco
        setLocation(400, 200); // Posicionar el marco en la pantalla
        setTitle("Primer Texto"); // Establecer el título del marco
        
        Lamina miLamina = new Lamina(); // Crear una instancia de la lámina personalizada
        add(miLamina); // Agregar la lámina al marco
    }
}

// Clase que define la lámina personalizada para dibujar y escribir texto
class Lamina extends JPanel {
    // Sobrescribimos el método paintComponent para personalizar la pintura en el panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Llamamos al método paintComponent de la superclase para mantener la funcionalidad original
        g.drawString("Estamos aprendiendo swing", 100, 100); // Dibujar el texto en las coordenadas (100, 100)
    }
}
