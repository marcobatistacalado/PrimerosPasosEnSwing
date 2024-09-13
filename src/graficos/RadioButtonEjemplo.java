package graficos;

import javax.swing.*;
import java.awt.*;

/*
 * –RADIO BUTTON
 * JRadioButton ©
 *     crear cada botón
 * ButtonGroup ©
 *     agrupar para que tengan el mismo funcionamiento
 */
public class RadioButtonEjemplo {

    public static void main(String[] args) {
        // Crear y configurar la ventana principal de la aplicación
        Marco_radio_sintaxis mimarco = new Marco_radio_sintaxis();
        // Configurar la aplicación para que se cierre cuando se cierra la ventana
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que representa el marco principal de la aplicación
class Marco_radio_sintaxis extends JFrame {
    public Marco_radio_sintaxis() {
        // Configurar las dimensiones y la posición de la ventana
        setBounds(500, 300, 500, 350);
        
        // Crear y agregar el panel con los componentes a la ventana
        Lamina_radio_sintaxis milamina = new Lamina_radio_sintaxis();
        add(milamina);
        
        // Hacer visible la ventana
        setVisible(true);
    }
}

// Clase que representa el panel con los componentes de la interfaz
class Lamina_radio_sintaxis extends JPanel {
    public Lamina_radio_sintaxis() {
        // Crear dos grupos de botones para agrupar los radio buttons
        ButtonGroup migrupo1 = new ButtonGroup();
        ButtonGroup migrupo2 = new ButtonGroup();
        
        // Crear los radio buttons y establecer su estado de selección inicial
        JRadioButton boton1 = new JRadioButton("Azul", false);
        JRadioButton boton2 = new JRadioButton("Rojo", true);
        JRadioButton boton3 = new JRadioButton("Verde", false);
        JRadioButton boton4 = new JRadioButton("Verde", false);
        JRadioButton boton5 = new JRadioButton("Verde", false);
        
        // Añadir los radio buttons al primer grupo de botones
        migrupo1.add(boton1);
        migrupo1.add(boton2);
        migrupo1.add(boton3);
        
        // Añadir los radio buttons al segundo grupo de botones
        migrupo2.add(boton4);
        migrupo2.add(boton5);
        
        // Añadir los radio buttons al panel
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
    }
}
