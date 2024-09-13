package graficos;

import javax.swing.*;
import java.awt.*;

/*
 * –SPINNER
 * JSpinner ©
 *     JSpinner()
 *     JSpinner(SpinnerModel modelo)
 */

public class Spinner2 {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        FrameSpinner2 mimarco = new FrameSpinner2();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

// Clase que define el marco principal de la aplicación
class FrameSpinner2 extends JFrame {
    public FrameSpinner2() {
        // Configurar las dimensiones y la posición del marco
        setBounds(500, 300, 500, 350);
        // Crear y añadir la lámina principal al marco
        LaminaSpinner2 milamina = new LaminaSpinner2();
        add(milamina);
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que define la lámina principal donde se colocarán los componentes
class LaminaSpinner2 extends JPanel {
    public LaminaSpinner2() {
        // Crear un JSpinner con un modelo numérico personalizado
        JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1) { //CLASE ANONIMA
            // Sobrescribir el método getNextValue para devolver el valor anterior
            public Object getNextValue() {
                return super.getPreviousValue();
            }

            // Sobrescribir el método getPreviousValue para devolver el valor siguiente
            public Object getPreviousValue() {
                return super.getNextValue();
            }
        });
        
        // Configurar el tamaño preferido del spinner
        Dimension d = new Dimension(200, 20);
        control.setPreferredSize(d);
        
        // Añadir el spinner a la lámina
        add(control);
    }
    
    // Código comentado para usar una clase anonima interna personalizada
    /*
    private class MiModeloJSpinner extends SpinnerNumberModel {
        public MiModeloJSpinner() {
            super(5, 0, 10, 1);
        }

        public Object getNextValue() {
            return super.getPreviousValue();
        }

        public Object getPreviousValue() {
            return super.getNextValue();
        }
    }
    */
}

