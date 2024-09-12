package graficos;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoMenuConCheckBox_RadioButton {

    public static void main(String[] args) {
        // Crear y configurar el marco principal
        MarcoConCheckboxRadioMenu mimarco = new MarcoConCheckboxRadioMenu();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConCheckboxRadioMenu extends JFrame {

    public MarcoConCheckboxRadioMenu() {
        setTitle("Ejemplo de Menú con JCheckBox y JRadioButton");
        setBounds(500, 300, 400, 300); // Posición y tamaño del marco
        LaminaConCheckboxRadioMenu milamina = new LaminaConCheckboxRadioMenu();
        add(milamina); // Añadir la lámina al marco
        setVisible(true); // Hacer visible el marco
    }
}

class LaminaConCheckboxRadioMenu extends JPanel {

    public LaminaConCheckboxRadioMenu() {
        setLayout(new BorderLayout()); // Layout de la lámina

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear el menú
        JMenu opcionesMenu = new JMenu("Opciones");
        menuBar.add(opcionesMenu);

        // Crear elementos de menú con JCheckBoxMenuItem
        JCheckBoxMenuItem verBarraEstadoItem = new JCheckBoxMenuItem("Ver barra de estado");
        opcionesMenu.add(verBarraEstadoItem);

        // Crear grupo de JRadioButtonMenuItem
        JMenu coloresMenu = new JMenu("Colores");
        ButtonGroup grupoColores = new ButtonGroup();
        JRadioButtonMenuItem rojoItem = new JRadioButtonMenuItem("Rojo");
        JRadioButtonMenuItem verdeItem = new JRadioButtonMenuItem("Verde");
        JRadioButtonMenuItem azulItem = new JRadioButtonMenuItem("Azul");
        grupoColores.add(rojoItem);
        grupoColores.add(verdeItem);
        grupoColores.add(azulItem);
        coloresMenu.add(rojoItem);
        coloresMenu.add(verdeItem);
        coloresMenu.add(azulItem);
        opcionesMenu.add(coloresMenu);

        // Añadir la barra de menú a la lámina
        add(menuBar, BorderLayout.NORTH);

        // Crear el área de texto
        JTextPane miarea = new JTextPane();
        add(miarea, BorderLayout.CENTER);

        // Añadir ActionListener a los elementos del menú
        verBarraEstadoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean seleccionado = verBarraEstadoItem.isSelected();
                JOptionPane.showMessageDialog(LaminaConCheckboxRadioMenu.this, 
                    "Ver barra de estado: " + (seleccionado ? "Activado" : "Desactivado"));
            }
        });

        rojoItem.addActionListener(new GestionaColores(miarea, Color.RED));
        verdeItem.addActionListener(new GestionaColores(miarea, Color.GREEN));
        azulItem.addActionListener(new GestionaColores(miarea, Color.BLUE));
    }

    // Clase interna que gestiona los eventos de los JRadioButtonMenuItem
    private class GestionaColores implements ActionListener {
        private JTextPane area;
        private Color color;

        public GestionaColores(JTextPane area, Color color) {
            this.area = area;
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            area.setForeground(color); // Cambiar el color del texto en el área de texto
        }
    }
}
