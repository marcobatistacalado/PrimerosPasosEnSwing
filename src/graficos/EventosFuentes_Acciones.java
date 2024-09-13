package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*
 * *EVENTOS: MÚLTIPLES FUENTES
	Action (i) → hereda → actionPerformed(ActionEvent evento) (m)
		-setEnabled(boolean b) (m) → activar/desactivar
		-isEnabled(boolean b) (m) → preguntar por el estado
		-putValue(String clave, Object valor) (m) → almacenar pares clave, valor
		-getValue(String clave, Object valor) (m)
		-addPropertyChangedListener(PropertyChangeListener oyente) (m)
		-removePropertyChangedListed (PropertyChangeListener oyente) (m)
	AbstractAction ©  → heredamos de aquí para obtener todos estos métodos anteriores, y así no tienes que escribirlos.
	
	EJEMPLO PRÁCTICO: 3 botones y que puedas clickarlos o mandar un comando como CTRL + A.
	
	ASIGNANDO ACCIONES A TECLADO:
		-KeyStroke © 
			static getKeyStroke(String s) (m)
		-InputMap ©  
			put (KeyStroke, Object) (m)
		-JPanel © 
			getInputMap(int condición) (m)
		-ActionMap © 
		put (Object, acción) (m)
		1)Crear mapa de entrada: ¿cuál va a ser el objeto en el que tiene que incidir la entrada?
		2)Crear combinación de teclas
		3)Asignar combinación de teclas a objeto
		4)Asignar objeto a acción

 */
public class EventosFuentes_Acciones {

    public static void main(String[] args) {
        MarcoAccion mimarco = new MarcoAccion();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class MarcoAccion extends JFrame {
    public MarcoAccion() {
        setTitle("Prueba Acciones");
        setBounds(600, 350, 600, 300);
        PanelAccion lamina = new PanelAccion();
        add(lamina);
    }
}

class PanelAccion extends JPanel {
    public PanelAccion() {
        // Creación de acciones para cambiar el color de fondo
        AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/bolaAmarilla.jpg"), Color.yellow);
        AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/bolaAzul.jpg"), Color.blue);
        AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/bolaRoja.jpg"), Color.red);

        // Creación de botones que utilizan las acciones creadas
        JButton botonAmarillo = new JButton(accionAmarillo);
        JButton botonAzul = new JButton(accionAzul);
        JButton botonRojo = new JButton(accionRojo);
        add(botonAmarillo);
        add(botonAzul);
        add(botonRojo);
        
        // Mapeo de combinaciones de teclas a acciones
        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); // Para capturar eventos de teclado
        KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A"); // Ctrl + A para amarillo
        KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl B"); // Ctrl + B para azul
        KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl R"); // Ctrl + R para rojo
        mapaEntrada.put(teclaAmarillo, "fondo_amarillo"); // Asocia la combinación a un nombre de acción
        mapaEntrada.put(teclaAzul, "fondo_azul");
        mapaEntrada.put(teclaRojo, "fondo_rojo");

        // Asociación de nombres de acción a las acciones correspondientes
        ActionMap mapaAccion = getActionMap();
        mapaAccion.put("fondo_amarillo", accionAmarillo); // Asocia el nombre de acción a la acción de color correspondiente
        mapaAccion.put("fondo_azul", accionAzul);
        mapaAccion.put("fondo_rojo", accionRojo);
    }

    private class AccionColor extends AbstractAction {
        public AccionColor(String nombre, Icon icono, Color color_boton) {
            putValue(Action.NAME, nombre); // Nombre del color
            putValue(Action.SMALL_ICON, icono); // Icono asociado al color
            putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre); // Descripción corta
            putValue("Color_de_fondo", color_boton); // Color de fondo asociado a la acción
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color_de_fondo"); // Obtiene el color de fondo de la acción
            setBackground(c); // Establece el color de fondo del panel
            System.out.println("Nombre: " + getValue(Action.NAME) + " Descripción: " + getValue(Action.SHORT_DESCRIPTION));
        }
    }
}

