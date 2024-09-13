package graficos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
/*
 * –CAMBIOS EN UN CAMPO DE TEXTO:
 * JTextComponent (A) © 
	JTextField © → construir cuadro de texto de una línea
	getDocument() (m) → Document (i) → addDocumentListener (m) → documentEvent() (e)
		ReceptoraEvento ©→ DocumentListener (i)
			removeUpdate()
			insertUpdate()
			changedUpdate()

 */
public class EventosCuadroTexto {

    public static void main(String[] args) {
        // Crear una instancia de MarcoPrueba y configurarlo para que se cierre al salir
        MarcoPrueba mimarco = new MarcoPrueba();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoPrueba extends JFrame {
    public MarcoPrueba() {
        // Establecer el tamaño y la posición del marco
        setBounds(500, 300, 500, 350);
        
        // Crear una instancia de LaminaPrueba y añadirla al marco
        LaminaPrueba milamina = new LaminaPrueba();
        add(milamina);
        
        // Hacer visible el marco
        setVisible(true);
    }
}

class LaminaPrueba extends JPanel {
    public LaminaPrueba() {
        // Crear un campo de texto con un tamaño de 20 columnas
        JTextField micampo = new JTextField(20);

        // Crear una instancia del oyente de eventos de documento
        EscuchaTexto el_evento = new EscuchaTexto();

        // Obtener el documento del campo de texto
        Document midoc = micampo.getDocument();

        // Añadir el oyente de eventos de documento al documento del campo de texto
        midoc.addDocumentListener(el_evento);

        // Añadir el campo de texto al panel
        add(micampo);
    }

    // Clase interna para manejar los eventos del documento
    private class EscuchaTexto implements DocumentListener {

        // Método llamado cuando se inserta texto en el documento
        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("Has insertado texto.");
        }

        // Método llamado cuando se elimina texto del documento
        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("Has borrado texto.");
        }

        // Método llamado cuando se cambia un atributo del documento
        @Override
        public void changedUpdate(DocumentEvent e) {
            System.out.println("Has cambiado texto.");
        }
    }
}
