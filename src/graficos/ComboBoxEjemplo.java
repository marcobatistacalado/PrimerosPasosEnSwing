package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * –COMBOBOX
 *  JComboBox © 
 *      addItem() (m) → agregar elementos al desplegable
 *      getSelectedItem() (m)→ devolver el elemento seleccionado
 */
public class ComboBoxEjemplo {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        MarcoCombo mimarco = new MarcoCombo();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que define el marco principal de la aplicación
class MarcoCombo extends JFrame {
    public MarcoCombo() {
        // Configurar las dimensiones y la posición del marco
        setBounds(500, 300, 500, 350);
        // Crear y añadir la lámina principal al marco
        LaminaCombo milamina = new LaminaCombo();
        add(milamina);
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que define la lámina principal donde se colocarán los componentes
class LaminaCombo extends JPanel {
    // Componentes de la lámina
    private JLabel texto;
    private JComboBox micombo;

    public LaminaCombo() {
        // Configurar el diseño de la lámina principal
        setLayout(new BorderLayout());
        // Crear y configurar el JLabel que mostrará el texto
        texto = new JLabel("En un lugar de la Mancha cuyo nombre... ");
        texto.setFont(new Font("Serif", Font.PLAIN, 18));
        add(texto, BorderLayout.CENTER);

        // Crear el panel para el JComboBox
        JPanel lamina_norte = new JPanel();
        // Crear y configurar el JComboBox
        micombo = new JComboBox();
        micombo.setEditable(true); // Permitir al usuario escribir en el JComboBox
        // Añadir elementos al JComboBox
        micombo.addItem("Serif");
        micombo.addItem("SansSerif");
        micombo.addItem("Monospaced");
        micombo.addItem("Dialog");

        // Crear y registrar el manejador de eventos para el JComboBox
        Evento_combo mievento = new Evento_combo();
        micombo.addActionListener(mievento);

        // Añadir el JComboBox al panel y el panel a la lámina principal
        lamina_norte.add(micombo);
        add(lamina_norte, BorderLayout.NORTH);
    }

    // Clase interna que maneja los eventos del JComboBox
    private class Evento_combo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Cambiar la fuente del texto cuando se selecciona un elemento en el JComboBox
            texto.setFont(new Font((String) micombo.getSelectedItem(), Font.PLAIN, 18));
        }
    }
}
