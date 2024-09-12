package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosVariosOyentes {

	public static void main(String[] args) {
		// Creación y configuración del marco principal
		Marco_Principal mimarco = new Marco_Principal();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

// Clase del marco principal que extiende JFrame
class Marco_Principal extends JFrame {
	public Marco_Principal() {
		setTitle("Prueba Varios"); // Título del marco principal
		setBounds(1300, 100, 300, 200); // Posición y tamaño del marco principal
		Lamina_Principal lamina = new Lamina_Principal(); // Creación de la lámina principal
		add(lamina); // Agregar la lámina al marco principal
	}
}

// Clase de la lámina principal que extiende JPanel
class Lamina_Principal extends JPanel {
	JButton boton_cerrar; // Declaración del botón que se utilizará en otros métodos

	public Lamina_Principal() {
		JButton boton_nuevo = new JButton("Nuevo"); // Creación de un botón "Nuevo"
		add(boton_nuevo); // Agregar el botón "Nuevo" a la lámina

		boton_cerrar = new JButton("Cerrar todo"); // Creación del botón "Cerrar todo"
		add(boton_cerrar); // Agregar el botón "Cerrar todo" a la lámina

		OyenteNuevo miOyente = new OyenteNuevo(); // Creación de un oyente para el botón "Nuevo"
		boton_nuevo.addActionListener(miOyente); // Asignar el oyente al botón "Nuevo"
	}

	// Clase interna para manejar el evento del botón "Nuevo"
	private class OyenteNuevo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Método que se ejecuta cuando se presiona el botón "Nuevo"
			Marco_Emergente marco = new Marco_Emergente(boton_cerrar); // Creación de una ventana emergente
			marco.setVisible(true); // Hacer visible la ventana emergente
		}

	}
}

// Clase para la ventana emergente que extiende JFrame
class Marco_Emergente extends JFrame {
	private static int contador = 0; // Contador estático para contar las ventanas emergentes

	public Marco_Emergente(JButton boton_de_principal) {
		contador++; // Incrementar el contador cada vez que se crea una nueva ventana emergente
		setTitle("Ventana " + contador); // Título de la ventana emergente con número consecutivo
		setBounds(40 * contador, 40 * contador, 350, 150); // Posición y tamaño de la ventana emergente

		CierraTodos oyenteCerrar = new CierraTodos(); // Creación de un oyente para el botón "Cerrar todo"
		boton_de_principal.addActionListener(oyenteCerrar); // Asignar el oyente al botón "Cerrar todo"
	}

	// Clase interna para manejar el evento del botón "Cerrar todo"
	private class CierraTodos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Método que se ejecuta cuando se presiona el botón "Cerrar todo"
			dispose(); // Cerrar la ventana emergente
		}

	}
}
