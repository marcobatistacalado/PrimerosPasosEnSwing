package graficos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

public class SlideEjemplo2 {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        Frame_Sliders2 mimarco = new Frame_Sliders2();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que define el marco principal de la aplicación
class Frame_Sliders2 extends JFrame {
    public Frame_Sliders2() {
        // Configurar las dimensiones y la posición del marco
        setBounds(550, 400, 550, 350);
        // Crear y añadir la lámina principal al marco
        Lamina_Sliders2 milamina = new Lamina_Sliders2();
        add(milamina);
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que define la lámina principal donde se colocarán los componentes
class Lamina_Sliders2 extends JPanel {
    // Definir los componentes que se utilizarán
    private JLabel rotulo;
    private JSlider control;

    public Lamina_Sliders2() {
        // Configurar el diseño de la lámina principal
        setLayout(new BorderLayout());
        
        // Crear y añadir un rótulo en el centro de la lámina
        rotulo = new JLabel("En un lugar de la Mancha cuyo nombre...");
        add(rotulo, BorderLayout.CENTER);
        
        // Crear un JSlider con rango de 8 a 50 y valor inicial de 12
        control = new JSlider(8, 50, 12);
        
        // Configurar el espaciado mayor (20) para las marcas del slider
        control.setMajorTickSpacing(20);
        // Configurar el espaciado menor (5) para las marcas del slider
        control.setMinorTickSpacing(5);
        // Hacer que se impriman las líneas de división en el slider
        control.setPaintTicks(true);
        // Hacer que se impriman las etiquetas en el slider
        control.setPaintLabels(true);
        // Establecer la fuente del slider
        control.setFont(new Font("Serif", Font.ITALIC, 10));
        // Añadir un ChangeListener al slider para manejar eventos de cambio de estado
        control.addChangeListener(new EventoSlider());
        
        // Crear un panel para contener el slider y añadirlo a la lámina
        JPanel laminaSlider = new JPanel();
        laminaSlider.add(control);
        add(laminaSlider, BorderLayout.NORTH);
    }

    // Clase interna para manejar eventos de cambio de estado del slider
    private class EventoSlider implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            // Actualizar la fuente del rótulo según el valor actual del slider
            rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
        }
    }
}
