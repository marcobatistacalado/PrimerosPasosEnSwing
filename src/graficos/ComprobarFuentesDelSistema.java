package graficos;

import java.awt.GraphicsEnvironment; // Importa GraphicsEnvironment para trabajar con fuentes del sistema
import javax.swing.JOptionPane; // Importa JOptionPane para mostrar cuadros de diálogo

public class ComprobarFuentesDelSistema {

    public static void main(String[] args) {
        // Solicita al usuario que introduzca el nombre de una fuente
        String fuente = JOptionPane.showInputDialog("Introduce fuente");
        
        // Bandera para comprobar si la fuente está instalada
        boolean estaLaFuente = false;

        // Obtiene los nombres de todas las fuentes disponibles en el sistema
        String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        // Recorre los nombres de las fuentes disponibles
        for (String nombre : nombresDeFuentes) {
            // Compara cada nombre de fuente con el nombre introducido por el usuario
            if (nombre.equals(fuente)) {
                // Si encuentra una coincidencia, marca la bandera como verdadera
                estaLaFuente = true;
                break; // Sale del bucle al encontrar la fuente
            }
        }
        
        // Informa al usuario si la fuente está instalada o no
        if (estaLaFuente) {
            System.out.println("Fuente instalada");
        } else {
            System.out.println("No está la fuente instalada");
        }
    }
}
