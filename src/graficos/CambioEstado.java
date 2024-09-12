package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

/*
 * CONTROLANDO ESTADO VENTANA
 * Implementación de WindowStateListener para manejar cambios de estado de ventana.
 * WindowEvent proporciona métodos para obtener el estado nuevo y antiguo de la ventana.
 * Podemos comparar estos estados con constantes de Frame (Frame.MAXIMIZED_BOTH, Frame.NORMAL, Frame.ICONIFIED).
 */
public class CambioEstado {

    public static void main(String[] args) {
        // Crea una instancia de MarcoEstado y la hace visible
        MarcoEstado mimarco = new MarcoEstado();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoEstado extends JFrame {
    public MarcoEstado() {
        setVisible(true);
        setBounds(300, 300, 500, 350);
        
        // Crea una instancia de CambiaEstado (WindowStateListener) y la añade al marco
        CambiaEstado nuevo_estado = new CambiaEstado();
        addWindowStateListener(nuevo_estado); // Pone al marco a la escucha de cambios de estado
    }
}

class CambiaEstado implements WindowStateListener {

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("La ventana ha cambiado de estado");

        // Obtiene el estado nuevo de la ventana usando getNewState()
        int newState = e.getNewState();

        // Compara el estado nuevo con constantes de Frame
        if (newState == Frame.MAXIMIZED_BOTH) {
            System.out.println("La ventana está a pantalla completa");
        } else if (newState == Frame.NORMAL) {
            System.out.println("La ventana está en estado normal");
        } else if (newState == Frame.ICONIFIED) {
            System.out.println("La ventana está minimizada");
        }
    }
}
