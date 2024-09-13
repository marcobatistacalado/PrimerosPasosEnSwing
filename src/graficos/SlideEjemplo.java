package graficos;

import javax.swing.*;
import java.awt.*;

/*
 * –SLIDER
 * JSlider ©
 *     setPaintTicks(boolean) (m) → imprimir líneas de división
 *     setMajorTickSpacing(int) (m) → imprimir números
 *     setMinorTickSpacing(int) (m) → decir cuánto espaciado
 *     setPaintLabels(boolean) (m)
 *     addChangeListener(ChangeListener (m)
 */

public class SlideEjemplo {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        Frame_Sliders mimarco = new Frame_Sliders();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que define el marco principal de la aplicación
class Frame_Sliders extends JFrame {
    public Frame_Sliders() {
        // Configurar las dimensiones y la posición del marco
        setBounds(550, 400, 550, 350);
        // Crear y añadir la lámina principal al marco
        Lamina_Sliders milamina = new Lamina_Sliders();
        add(milamina);
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que define la lámina principal donde se colocarán los componentes
class Lamina_Sliders extends JPanel {
    public Lamina_Sliders() {
        // Crear un JSlider con rango de 0 a 100 y valor inicial 50
        JSlider control = new JSlider(0, 100, 50);
        
        // Descomentar las siguientes líneas para configurar el slider en vertical
        // JSlider control = new JSlider(SwingConstants.VERTICAL, 20, 100, 25); // ponerlo en vertical
        // control.setOrientation(SwingConstants.VERTICAL); // con esto también
        
        // Establecer el espaciado mayor (50) para las marcas del slider
        control.setMajorTickSpacing(50);
        // Establecer el espaciado menor (25) para las marcas del slider
        control.setMinorTickSpacing(25);
        // Hacer que se impriman las líneas de división en el slider
        control.setPaintTicks(true);
        
        // Establecer la fuente del slider
        control.setFont(new Font("Serif", Font.ITALIC, 12));
        // Hacer que se impriman las etiquetas en el slider
        control.setPaintLabels(true); // rótulos
        
        // No permitir valores intermedios, ajustar el slider a las marcas
        control.setSnapToTicks(true);
        // Añadir el slider a la lámina
        add(control);
    }
}

