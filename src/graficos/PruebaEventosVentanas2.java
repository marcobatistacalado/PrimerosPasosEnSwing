package graficos;

import javax.swing.*; // Importa todas las clases de javax.swing para trabajar con Swing
import java.awt.*; // Importa todas las clases de java.awt
import java.awt.event.*; // Importa todas las clases de java.awt.event para manejar eventos

/*
 * EVENTOS: ADAPTER CLASSES
 * Solución a la implementación de múltiples métodos. Limpieza y optimización de código.
 * - KeyAdapter
 * - WindowAdapter
 *   - WindowFocusListener(i)
 *   - WindowStateListener(i)
 *   - WindowListener(i)
 * - MouseAdapter
 */
public class PruebaEventosVentanas2 {

    public static void main(String[] args) {
        // Crea dos instancias de MarcoVentana2
        MarcoVentana2 mimarco = new MarcoVentana2();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana

        MarcoVentana2 mimarco2 = new MarcoVentana2();
        mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana actual

        // Establece el título y las dimensiones de las ventanas
        mimarco.setTitle("Ventana 1");
        mimarco2.setTitle("Ventana 2");
        mimarco.setBounds(300, 300, 500, 350); // Posición y tamaño de la primera ventana
        mimarco2.setBounds(900, 300, 500, 350); // Posición y tamaño de la segunda ventana

        // Si se cierra una ventana, solo se cierra esa ventana
        // EXIT_ON_CLOSE cierra toda la aplicación, mientras que DISPOSE_ON_CLOSE cierra solo la ventana actual
    }
}

class MarcoVentana2 extends JFrame {
    public MarcoVentana2() {
        setVisible(true); // Hace visible la ventana

        // Crea una instancia de M_Ventana2 y la añade como listener de eventos de ventana
        M_Ventana2 oyente_ventana = new M_Ventana2();
        addWindowListener(oyente_ventana); // Añade el listener de eventos de ventana
    }
}

// Clase que hereda de WindowAdapter para manejar eventos de ventana
class M_Ventana2 extends WindowAdapter {
    // Sobrescribe el método windowIconified para manejar el evento de minimización de la ventana
    public void windowIconified(WindowEvent e) {
        System.out.println("Ventana minimizada"); // Mensaje que se muestra al minimizar la ventana
    }
}
