package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * ÁREAS DE TEXTO
 * JTextArea ©
 *  - getText() (m): Obtener el texto del área.
 *  - setLineWrap(boolean) (m): Establecer si debe haber saltos de línea automáticos.
 *  - getLineWrap() (m): Obtener el estado de los saltos de línea automáticos.
 */
public class AreaTexto2 {

    public static void main(String[] args) {
        // Crear una instancia de MarcoPruebaArea y configurarla para que se cierre al salir
        MarcoPruebaArea mimarco = new MarcoPruebaArea();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

// Clase que representa el marco principal de la aplicación
class MarcoPruebaArea extends JFrame {
    private JPanel laminaBotones;          // Panel para los botones
    private JButton botonInsertar;         // Botón para insertar texto
    private JButton botonSaltoLinea;       // Botón para alternar salto de línea
    private JTextArea areaTexto;           // Área de texto
    private JScrollPane laminaConBarras;   // Panel con barras de desplazamiento para el área de texto

    public MarcoPruebaArea() {
        // Establecer el título, tamaño y posición del marco
        setTitle("Probando Área de texto");
        setBounds(500, 300, 500, 350);
        setLayout(new BorderLayout());

        // Crear el panel de botones y añadir los botones
        laminaBotones = new JPanel();

        // Crear y configurar el botón "Insertar"
        botonInsertar = new JButton("Insertar");
        botonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Añadir texto al área de texto
                areaTexto.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme...");
            }
        });
        laminaBotones.add(botonInsertar);

        // Crear y configurar el botón "Salto Línea"
        botonSaltoLinea = new JButton("Salto Línea");
        botonSaltoLinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alternar el estado de los saltos de línea en el área de texto
                boolean saltar = !areaTexto.getLineWrap();
                areaTexto.setLineWrap(saltar);

                // Cambiar el texto del botón según el estado de los saltos de línea
                if (saltar) {
                    botonSaltoLinea.setText("Quitar salto");
                } else {
                    botonSaltoLinea.setText("Salto Línea");
                }
            }
        });
        laminaBotones.add(botonSaltoLinea);

        // Añadir el panel de botones al marco
        add(laminaBotones, BorderLayout.SOUTH);

        // Crear el área de texto y el panel de desplazamiento
        areaTexto = new JTextArea(8, 20);
        laminaConBarras = new JScrollPane(areaTexto);

        // Añadir el panel de desplazamiento al marco
        add(laminaConBarras, BorderLayout.CENTER);
    }
}

// Clase que representa un panel con un área de texto y un botón
class LaminaPruebaArea extends JPanel {
    private JTextArea miarea;  // Área de texto

    public LaminaPruebaArea() {
        // Crear un área de texto con 8 filas y 20 columnas
        miarea = new JTextArea(8, 20);

        // Establecer que el área de texto tenga saltos de línea automáticos
        miarea.setLineWrap(true);

        // Crear un panel de desplazamiento para el área de texto
        JScrollPane laminaBarras = new JScrollPane(miarea);

        // Añadir el panel de desplazamiento al panel principal
        add(laminaBarras);

        // Crear un botón (no se usa en esta clase pero está declarado)
        JButton miboton = new JButton("Dale");
    }
}


