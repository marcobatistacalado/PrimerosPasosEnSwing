package graficos;

import javax.swing.*;
import java.awt.*;
/*
 * FlowLayout ©  → por defecto se usa este con la posición center.
	BorderLayout ©
	GridLayout (rejillas-celdas) ©
	Container © → setLayout (m)
 */
public class Layouts {

    public static void main(String[] args) {
        // Creación y configuración del marco principal
        Marco_Layout mimarco = new Marco_Layout();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }

}

// Clase del marco principal que extiende JFrame
class Marco_Layout extends JFrame {
    public Marco_Layout() {
        setTitle("Prueba Acciones"); // Título del marco principal
        setBounds(600, 350, 600, 300); // Posición y tamaño del marco principal

        // Creación de dos paneles con diferentes layouts
        Panel_Layout lamina = new Panel_Layout();
        Panel_Layout2 lamina2 = new Panel_Layout2();

        // Agregar los paneles al marco principal con posiciones específicas
        add(lamina, BorderLayout.SOUTH); // Panel lamina en la parte inferior
        add(lamina2, BorderLayout.NORTH); // Panel lamina2 en la parte superior
    }
}

class Panel_Layout extends JPanel{
	public Panel_Layout() {
		/*
		//CAMBIAR UBICACIÓN ELEMENTOS CON FlowLayout
		FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT, 75, 100); //ELIGES LA POSICION QUE QUIERES
		//POR DEFECTO DEJA UN ESPACIO ENTRE BOTONES Y LA CAJA, PODEMOS CON COMAS EL ESPACIO QUE QUERAMOS.
		setLayout(disposicion);
		*/
		
		setLayout(new BorderLayout()); // Establecer el layout BorderLayout para el panel
		// Agregar botones en diferentes regiones del BorderLayout
		add(new JButton("Amarillo"),BorderLayout.NORTH); //elegir en que zona queremos que este
		add (new JButton("Rojo"), BorderLayout.SOUTH);
		add (new JButton ("Azul"), BorderLayout.WEST);
		add (new JButton("Verde"), BorderLayout.EAST);
		add (new JButton("Negro"), BorderLayout.CENTER);
	}
}

//si queremos dos disposiciones diferentes = 2 laminas
class Panel_Layout2 extends JPanel {
    public Panel_Layout2() {
        setLayout(new FlowLayout(FlowLayout.LEFT)); // Establecer el layout FlowLayout con alineación a la izquierda

        // Agregar botones al panel con FlowLayout
        add(new JButton("Amarillo")); // Botón en FlowLayout
        add(new JButton("Rojo")); // Botón en FlowLayout
    }
}