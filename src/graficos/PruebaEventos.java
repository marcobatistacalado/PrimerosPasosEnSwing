package graficos;

import java.awt.*; // Importa todas las clases de java.awt
import java.awt.event.ActionEvent; // Importa la clase ActionEvent para manejar eventos de acción
import java.awt.event.ActionListener; // Importa la interfaz ActionListener
import javax.swing.*; // Importa todas las clases de javax.swing para trabajar con Swing

public class PruebaEventos {

    public static void main(String[] args) {
        // Crea una instancia de MarcoBotones y lo hace visible
        MarcoBotones mimarco = new MarcoBotones();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación de cierre
    }
}

class MarcoBotones extends JFrame {
    public MarcoBotones() {
        setTitle("Botones y Eventos"); // Establece el título de la ventana
        setBounds(700, 300, 500, 300); // Establece la posición y el tamaño de la ventana
        LaminaBotones milamina = new LaminaBotones(); // Crea una instancia de LaminaBotones
        add(milamina); // Añade la lámina a la ventana
    }
}

class LaminaBotones extends JPanel implements ActionListener { // La lámina implementa la interfaz ActionListener
    // Declara los botones
    JButton botonAzul = new JButton("Azul");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");

    public LaminaBotones() {
        // Añade los botones a la lámina
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);
        
        // Añade ActionListeners a los botones
        botonAzul.addActionListener(this); // Registra la lámina como el listener para el botón azul
        botonRojo.addActionListener(this); // Registra la lámina como el listener para el botón rojo
        botonAmarillo.addActionListener(this); // Registra la lámina como el listener para el botón amarillo
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Maneja el evento de acción
        Object botonPulsado = e.getSource(); // Obtiene la fuente del evento
        if (botonPulsado == botonAzul) { // Comprueba si el botón azul fue pulsado
            setBackground(Color.blue); // Cambia el fondo a azul
        } else if (botonPulsado == botonAmarillo) { // Comprueba si el botón amarillo fue pulsado
            setBackground(Color.yellow); // Cambia el fondo a amarillo
        } else { // Por descarte, el botón rojo fue pulsado
            setBackground(Color.red); // Cambia el fondo a rojo
        }
    }
}

// AHORA QUEREMOS HACERLO DE OTRA FORMA DEJANDO DE SER LA LAMINA EL OBJETO LISTENER Y PASE A SER EL PROPIO COLOR DE FONDO.
