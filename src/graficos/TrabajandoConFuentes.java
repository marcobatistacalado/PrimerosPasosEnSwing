package graficos;

import java.awt.*; // Importar todas las clases del paquete java.awt
import javax.swing.JFrame; // Importar la clase JFrame de javax.swing
import javax.swing.JPanel; // Importar la clase JPanel de javax.swing

/*
 * Uso de fuentes y estilos con Graphics2D:
 * - setFont(Font): establece la fuente a usar para dibujar texto.
 * - Font: clase que representa una fuente.
 *      - Font(tipografia, estilo, tamaño)
 *      - Estilos: Font.BOLD, Font.PLAIN, Font.ITALIC
 * - Cada sistema puede tener diferentes fuentes instaladas.
 */

public class TrabajandoConFuentes {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        MarcoConFuentes mimarco = new MarcoConFuentes();
        mimarco.setVisible(true); // Hacer el marco visible
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establecer la operación de cierre
    }

}

// Clase que define el marco principal de la aplicación
class MarcoConFuentes extends JFrame {
    public MarcoConFuentes() {
        setTitle("Prueba con Fuentes"); // Establecer el título del marco
        setSize(400, 400); // Establecer el tamaño del marco
        
        LaminaConFuentes miLamina = new LaminaConFuentes(); // Crear una instancia de la lámina personalizada
        add(miLamina); // Agregar la lámina al marco
    }
}

// Clase que define la lámina personalizada para dibujar texto con fuentes
class LaminaConFuentes extends JPanel {
    // Sobrescribimos el método paintComponent para personalizar la pintura en el panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Llamamos al método paintComponent de la superclase para mantener la funcionalidad original
        
        // Convertimos el objeto Graphics a Graphics2D para usar métodos avanzados de dibujo
        Graphics2D g2 = (Graphics2D) g;
        
        // Crear una nueva fuente
        Font mifuente = new Font("Arial", Font.BOLD, 26); // Fuente Arial, estilo negrita, tamaño 26
        g2.setFont(mifuente); // Establecer la fuente a usar
        g2.setColor(Color.BLUE); // Establecer el color del texto
        
        // Dibujar el texto en el panel
        g2.drawString("Juan", 100, 100); // Dibuja la cadena "Juan" en la posición (100, 100)
    }
}

