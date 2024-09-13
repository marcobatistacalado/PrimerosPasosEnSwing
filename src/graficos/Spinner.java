package graficos;

import javax.swing.*;
import java.awt.*;

/*
 * –SPINNER
 * JSpinner ©
 *     JSpinner()
 *     JSpinner(SpinnerModel modelo)
 */

public class Spinner {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        FrameSpinner mimarco = new FrameSpinner();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

// Clase que define el marco principal de la aplicación
class FrameSpinner extends JFrame {
    public FrameSpinner() {
        // Configurar las dimensiones y la posición del marco
        setBounds(500, 300, 500, 350);
        // Crear y añadir la lámina principal al marco
        LaminaSpinner milamina = new LaminaSpinner();
        add(milamina);
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que define la lámina principal donde se colocarán los componentes
class LaminaSpinner extends JPanel {
    public LaminaSpinner() {
        // Crear un array de Strings para los meses
        String[] lista = {"Enero", "Febrero", "Marzo", "Abril"};
        
        // Crear un JSpinner con el modelo de lista
        JSpinner control = new JSpinner(new SpinnerListModel(lista));
        
        // Los JSpinner se adaptan por defecto al tamaño del primer valor del modelo
        // Configurar el tamaño preferido del spinner
        Dimension d = new Dimension(200, 20);
        control.setPreferredSize(d);
        
        // Crear un JSpinner con un modelo numérico
        // Comienza en 5, valor mínimo 0, valor máximo 10, incremento de 1
        JSpinner control2 = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1));
        
        // Añadir los spinners a la lámina
        add(control);
        add(control2);
    }
}
