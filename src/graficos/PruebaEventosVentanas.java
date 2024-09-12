package graficos;

import javax.swing.*; // Importa todas las clases necesarias de javax.swing para trabajar con Swing
import java.awt.*; // Importa todas las clases necesarias de java.awt para manejar gráficos y eventos
import java.awt.event.*; // Importa todas las clases necesarias de java.awt.event para manejar eventos

/*
 * EVENTOS DE VENTANA
 * Implementación de WindowListener, que obliga a declarar 7 métodos:
 * - windowActivated(WindowEvent e)
 * - windowClosed(WindowEvent e)
 * - windowClosing(WindowEvent e)
 * - windowDeactivated(WindowEvent e)
 * - windowDeiconified(WindowEvent e)
 * - windowIconified(WindowEvent e)
 * - windowOpened(WindowEvent e)
 */
public class PruebaEventosVentanas {

    public static void main(String[] args) {
        // Crea una instancia de MarcoVentana y la hace visible
        MarcoVentana mimarco = new MarcoVentana();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crea una segunda instancia de MarcoVentana
        MarcoVentana mimarco2 = new MarcoVentana();
        mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Configura títulos y ubicaciones de las ventanas
        mimarco.setTitle("Ventana 1");
        mimarco2.setTitle("Ventana 2");
        mimarco.setBounds(300, 300, 500, 350);
        mimarco2.setBounds(900, 300, 500, 350);
        
        // Si se cierra una ventana, se cierra solo esa ventana gracias a DISPOSE_ON_CLOSE
    }
}

class MarcoVentana extends JFrame {
    public MarcoVentana() {
        setVisible(true);
        
        // Crea un oyente de ventana y lo añade al marco
        M_Ventana oyente_ventana = new M_Ventana();
        addWindowListener(oyente_ventana);
    }
}

class M_Ventana implements WindowListener {
    public void windowActivated(WindowEvent e) {
        // Llamado cuando la ventana se activa
        System.out.println("Ventana activada");
    }
    
    public void windowClosed(WindowEvent e) {
        // Llamado cuando la ventana ha sido cerrada
        System.out.println("La ventana ha sido cerrada");
    }
    
    public void windowClosing(WindowEvent e) {
        // Llamado cuando la ventana se está cerrando
        System.out.println("Cerrando ventana");
    }
    
    public void windowDeactivated(WindowEvent e) {
        // Llamado cuando la ventana se desactiva
        System.out.println("Ventana desactivada");
    }
    
    public void windowDeiconified(WindowEvent e) {
        // Llamado cuando la ventana es restaurada de un estado minimizado
        System.out.println("Ventana restaurada");
    }
    
    public void windowIconified(WindowEvent e) {
        // Llamado cuando la ventana es minimizada
        System.out.println("Ventana minimizada");
    }
    
    public void windowOpened(WindowEvent e) {
        // Llamado cuando la ventana es abierta
        System.out.println("Ventana abierta");
    }
}
