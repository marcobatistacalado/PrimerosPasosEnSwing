package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/*Graphics se ha ido quedando obsoleto
 * -Biblioteca Graphics2D que hereda de Graphics: 
 *      -Rectangle2D
 *      -Ellipse2D
 *      -Line2D
 *      TODAS ESTAS IMPLEMENTAN UNA INTERFAZ LLAMADA: Shape
 *  
 *      Método:
 *      -draw(Shape s)
 */
public class PruebaDibujo {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        MarcoConDibujos mimarco = new MarcoConDibujos();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

// Clase que define el marco principal de la aplicación
class MarcoConDibujos extends JFrame {
    public MarcoConDibujos() {
        setTitle("Prueba de Dibujo"); // Establecer el título del marco
        setSize(400, 400); // Establecer el tamaño del marco
        
        LaminaConFiguras miLamina = new LaminaConFiguras(); // Crear una instancia de la lámina personalizada
        add(miLamina); // Agregar la lámina al marco
    }
}

// Clase que define la lámina personalizada para dibujar figuras geométricas
class LaminaConFiguras extends JPanel {
    // Sobrescribimos el método paintComponent para personalizar la pintura en el panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Llamamos al método paintComponent de la superclase para mantener la funcionalidad original
        
        // Convertimos el objeto Graphics a Graphics2D para usar métodos avanzados de dibujo
        Graphics2D g2 = (Graphics2D) g;
        
        // Crear y dibujar un rectángulo
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.draw(rectangulo);
        
        // Crear y dibujar una elipse que encaja en el rectángulo
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo); // Utilizamos el rectángulo como marco de referencia para la elipse
        g2.draw(elipse);
        
        // Dibujar una línea desde el punto (100, 100) hasta (300, 250)
        g2.draw(new Line2D.Double(100, 100, 300, 250));
        
        // Dibujar un círculo centrado en el rectángulo
        double CentroenX = rectangulo.getCenterX(); // Obtener la coordenada X del centro del rectángulo
        double CentroenY = rectangulo.getCenterY(); // Obtener la coordenada Y del centro del rectángulo
        
        double radio = 150; // Definir el radio del círculo
        Ellipse2D circulo = new Ellipse2D.Double();
        // Utilizar setFrame para establecer el marco del círculo con las coordenadas del centro y el radio
        circulo.setFrame(CentroenX - radio / 2, CentroenY - radio / 2, radio, radio);
        g2.draw(circulo);
    }
}

