package graficos;

import javax.swing.*;
import java.awt.*;

public class MarcoMEmergente {

    public static void main(String[] args) {
        // Crear y configurar el marco principal
        MarcoEmergenteM mimarco = new MarcoEmergenteM();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que crea el marco principal
class MarcoEmergenteM extends JFrame {
    public MarcoEmergenteM() {
        setBounds(100, 100, 300, 250); // Posición y tamaño del marco
        LaminaEmergenteM milamina = new LaminaEmergenteM(); // Crear la lámina
        add(milamina); // Añadir la lámina al marco
        setVisible(true); // Hacer visible el marco
    }
}

// Clase que crea la lámina con el menú emergente
class LaminaEmergenteM extends JPanel {
    public LaminaEmergenteM() {
        // Crear el menú emergente
        JPopupMenu emergente = new JPopupMenu();

        // Crear las opciones del menú emergente
        JMenuItem opcion1 = new JMenuItem("Opción 1");
        JMenuItem opcion2 = new JMenuItem("Opción 2");
        JMenuItem opcion3 = new JMenuItem("Opción 3");

        // Añadir las opciones al menú emergente
        emergente.add(opcion1);
        emergente.add(opcion2);
        emergente.add(opcion3);

        // Asignar el menú emergente al panel
        setComponentPopupMenu(emergente);
    }
}
