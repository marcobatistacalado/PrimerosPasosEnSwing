package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarcoMenuConImagen {

    public static void main(String[] args) {
        // Crear y configurar el marco principal
    	MarcoConMenuImagen mimarco = new MarcoConMenuImagen();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConMenuImagen extends JFrame {

    public MarcoConMenuImagen() {
        setTitle("Ejemplo de Menú con Imágenes");
        setBounds(500, 300, 400, 300); // Posición y tamaño del marco
        LaminaMenuConImagen milamina = new LaminaMenuConImagen();
        add(milamina); // Añadir la lámina al marco
        setVisible(true); // Hacer visible el marco
    }
}

class LaminaMenuConImagen extends JPanel {

    public LaminaMenuConImagen() {
        setLayout(new BorderLayout()); // Layout de la lámina

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crear el menú
        JMenu archivoMenu = new JMenu("Archivo");
        menuBar.add(archivoMenu);

        // Crear elementos de menú con imágenes
        JMenuItem nuevoItem = new JMenuItem("Nuevo", new ImageIcon("bin/imgMenu/nuevo.png"));
        JMenuItem abrirItem = new JMenuItem("Abrir", new ImageIcon("bin/imgMenu/abrir.png"));
        JMenuItem guardarItem = new JMenuItem("Guardar", new ImageIcon("bin/imgMenu/guardar.png"));
        JMenuItem salirItem = new JMenuItem("Salir", new ImageIcon("bin/imgMenu/salir.png"));

        // Añadir elementos al menú
        archivoMenu.add(nuevoItem);
        archivoMenu.add(abrirItem);
        archivoMenu.add(guardarItem);
        archivoMenu.addSeparator(); // Separador
        archivoMenu.add(salirItem);

        // Añadir la barra de menú a la lámina
        add(menuBar, BorderLayout.NORTH);

        // Añadir ActionListener a los elementos del menú
        nuevoItem.addActionListener(new GestionaMenu("Nuevo archivo creado"));
        abrirItem.addActionListener(new GestionaMenu("Archivo abierto"));
        guardarItem.addActionListener(new GestionaMenu("Archivo guardado"));
        salirItem.addActionListener(e -> System.exit(0)); // Salir de la aplicación
    }

    // Clase interna que gestiona los eventos de los elementos del menú
    private class GestionaMenu implements ActionListener {
        private String mensaje;

        public GestionaMenu(String mensaje) {
            this.mensaje = mensaje;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar mensaje correspondiente a la opción seleccionada
            JOptionPane.showMessageDialog(LaminaMenuConImagen.this, mensaje);
        }
    }
}
