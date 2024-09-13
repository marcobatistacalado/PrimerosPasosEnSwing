package graficos;

import java.awt.*; // Importa todas las clases de java.awt
import javax.swing.JFrame; // Importa JFrame para crear la ventana
import javax.swing.JPanel; // Importa JPanel para crear paneles
import javax.imageio.*; // Importa las clases de javax.imageio para leer imágenes
import java.io.*; // Importa las clases de java.io para trabajar con archivos

/*
 * Paquete: Java.awt
 * Image --> getWidth() // Método para obtener el ancho de la imagen
 * |--> getHeight() // Método para obtener la altura de la imagen
 * 
 * Paquete: javax.imageio.* y java.io.*
 * ImageIO --> read() // Método para leer la imagen de una carpeta o de un enlace
 * 
 * Paquete: Java.awt
 * Graphics --> drawImage() // Método para dibujar la imagen en el panel
 * |--> copyArea() // Método para copiar un área específica de la imagen
 */
public class PruebaImagenes {

    public static void main(String[] args) {
        // Crea una instancia de MarcoImagen y la hace visible
        MarcoImagen mimarco = new MarcoImagen();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoImagen extends JFrame {
    public MarcoImagen() {
        setTitle("Prueba con Imagenes"); // Establece el título de la ventana
        setBounds(750, 300, 300, 200); // Establece la posición y el tamaño de la ventana

        LaminaConImagen miLamina = new LaminaConImagen(); // Crea una instancia de LaminaConImagen
        add(miLamina); // Añade la lámina a la ventana
    }
}

class LaminaConImagen extends JPanel {
    
    // Constructor para cargar la imagen en memoria
    public LaminaConImagen() {
        File miimagen = new File("src/graficos/abeja.jpg"); // Ruta de la imagen
        try {
            imagen = ImageIO.read(miimagen); // Lee la imagen desde el archivo
        } catch (IOException e) {
            System.out.println("La imagen no se encuentra"); // Mensaje de error si la imagen no se encuentra
        }
    }

    // Método para dibujar en el panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método de la superclase para limpiar el panel

        int anchuraImagen = imagen.getWidth(this); // Obtiene el ancho de la imagen
        int alturaImagen = imagen.getHeight(this); // Obtiene la altura de la imagen
        g.drawImage(imagen, 0, 0, null); // Dibuja la imagen en la posición (0,0)
        
        // Bucle para copiar la imagen en una cuadrícula
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 200; j++) {
                if (i + j > 0) { // Condición para saltarse la primera iteración y evitar copiar la imagen en su propia posición
                    g.copyArea(0, 0, anchuraImagen, alturaImagen, i * anchuraImagen, j * alturaImagen); // Copia el área de la imagen
                }
            }
        }
    }

    private Image imagen; // Variable para almacenar la imagen

}
