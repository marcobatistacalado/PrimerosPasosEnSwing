package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * EVENTOS DE TECLADO
 * Implementación de KeyListener para manejar eventos de teclado.
 * KeyListener define tres métodos: keyPressed, keyReleased y keyTyped.
 * Cada método se llama cuando ocurre el evento respectivo en el teclado.
 * KeyEvent proporciona métodos para obtener información sobre la tecla presionada.
 */

public class EventosTeclado {

    public static void main(String[] args) {
        // Crea una instancia de MarcoConTeclas y la hace visible
        MarcoConTeclas mimarco = new MarcoConTeclas();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoConTeclas extends JFrame {
    public MarcoConTeclas() {
        setVisible(true);
        setBounds(700, 300, 600, 450);
        
        // Crea una instancia de EventoDeTeclado (KeyListener) y la añade al JFrame
        EventoDeTeclado tecla = new EventoDeTeclado();
        addKeyListener(tecla); // Añade el KeyListener al JFrame
    }
}

class EventoDeTeclado implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // Se invoca cuando se presiona y luego se suelta una tecla
        char letra = e.getKeyChar(); // Obtiene el carácter correspondiente a la tecla presionada
        System.out.println("Tecla typed: " + letra);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Se invoca cuando una tecla es presionada
        int codigo = e.getKeyCode(); // Obtiene el código de la tecla presionada
        System.out.println("Tecla pressed: " + codigo);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Se invoca cuando se suelta una tecla
        char letra = e.getKeyChar(); // Obtiene el carácter correspondiente a la tecla liberada
        System.out.println("Tecla released: " + letra);
    }
}
