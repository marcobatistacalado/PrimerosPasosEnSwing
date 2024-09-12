package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonEjemplo2 {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        Marco_radio mimarco = new Marco_radio();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que define el marco principal de la aplicación
class Marco_radio extends JFrame {
    public Marco_radio() {
        // Configurar las dimensiones y la posición del marco
        setBounds(500, 300, 500, 350);
        // Crear y añadir la lámina principal al marco
        Lamina_radio milamina = new Lamina_radio();
        add(milamina);
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que define la lámina principal donde se colocarán los componentes
class Lamina_radio extends JPanel {
    // Componentes de la lámina
    private JLabel texto;
    private JRadioButton boton1, boton2, boton3, boton4;
    private ButtonGroup migrupo;
    private JPanel lamina_botones;

    public Lamina_radio() {
        // Configurar el diseño de la lámina principal
        setLayout(new BorderLayout());
        // Crear y configurar el JLabel que mostrará el texto
        texto = new JLabel("En un lugar de la Mancha de cuyo nombre...");
        texto.setFont(new Font("Serif", Font.PLAIN, 12));
        add(texto, BorderLayout.CENTER);

        // Crear el panel para los botones de radio y el grupo de botones
        lamina_botones = new JPanel();
        migrupo = new ButtonGroup();

        // Añadir los botones de radio al panel y al grupo
        colocarBotones("Pequeño", false, 10);
        colocarBotones("Mediano", true, 12);
        colocarBotones("Grande", false, 18);
        colocarBotones("Muy Grande", false, 26);

        // Añadir el panel de botones de radio a la parte inferior de la lámina principal
        add(lamina_botones, BorderLayout.SOUTH);
    }

    // Método para crear y añadir botones de radio
    public void colocarBotones(String nombre, boolean seleccionado, int tamagno) {
        // Crear el botón de radio con el nombre y selección especificados
        JRadioButton boton = new JRadioButton(nombre, seleccionado);
        // Añadir el botón al grupo de botones y al panel
        migrupo.add(boton);
        lamina_botones.add(boton);

        // Crear un ActionListener para cambiar el tamaño de la fuente del texto cuando se seleccione el botón
        ActionListener mievento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el tamaño de la fuente del texto
                texto.setFont(new Font("Serif", Font.PLAIN, tamagno));
            }
        };
        // Añadir el ActionListener al botón de radio
        boton.addActionListener(mievento);
    }
}
