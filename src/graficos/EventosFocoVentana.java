package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.*;

public class EventosFocoVentana extends JFrame implements WindowFocusListener {

	EventosFocoVentana marco1; // Instancia de la primera ventana
	EventosFocoVentana marco2; // Instancia de la segunda ventana
	
	public static void main(String[] args) {
		EventosFocoVentana mivv = new EventosFocoVentana();
		mivv.iniciar(); // Método para iniciar y configurar las ventanas
	}
	
	public void iniciar() {
		marco1 = new EventosFocoVentana();
		marco2 = new EventosFocoVentana();
		
		// Configuración de las ventanas
		marco1.setVisible(true);
		marco2.setVisible(true);
		marco1.setBounds(300, 100, 600, 350);
		marco2.setBounds(1200, 100, 600, 350);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Agregar el listener de foco a ambas ventanas
		marco1.addWindowFocusListener(this);
		marco2.addWindowFocusListener(this);
	}
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		// Método llamado cuando la ventana gana el foco
		if (e.getSource() == marco1) {
			marco1.setTitle("Tengo el foco!!");
		} else {
			marco2.setTitle("Tengo el foco!!");
		}
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// Método llamado cuando la ventana pierde el foco
		if (e.getSource() == marco1) {
			marco1.setTitle(""); // Limpiar el título si pierde el foco
		} else {
			marco2.setTitle(""); // Limpiar el título si pierde el foco
		}
	}

}
