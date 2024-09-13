package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

// POSICIONAR VENTANA EN EL CENTRO DE CUALQUIER PANTALLA
/* CLASE TOOLKIT ©
 *  --Almacén de multitud de métodos que se comunican con el sistema huésped de ventanas
 * getDefaultToolkit()
 * getScreenSize()
 */

public class CreandoMarcoCentrado {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        MarcoCentrado mimarco = new MarcoCentrado();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true); // Hacer visible el marco
    }
}

// Clase que define el marco principal de la aplicación
class MarcoCentrado extends JFrame {
    public MarcoCentrado() {
        // Obtener una instancia del toolkit para interactuar con el sistema de ventanas
        Toolkit mipantalla = Toolkit.getDefaultToolkit();
        
        // Obtener las dimensiones de la pantalla
        Dimension tamanoPantalla = mipantalla.getScreenSize();
        
        // Obtener la altura y el ancho de la pantalla
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        
        // Establecer el tamaño del marco a la mitad del tamaño de la pantalla
        setSize(anchoPantalla / 2, alturaPantalla / 2); 
        
        // Posicionar el marco en el centro de la pantalla
        setLocation(anchoPantalla / 4, alturaPantalla / 4); 
        
        // Establecer el título del marco
        setTitle("Marco Centrado");
        
        // Cambiar el ícono de la ventana
        Image miIcono = mipantalla.getImage("icono.jpg"); // Imagen ubicada en la carpeta del proyecto
        setIconImage(miIcono);
    }
}
