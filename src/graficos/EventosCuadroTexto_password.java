package graficos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
/*
 * JTextComponent (A) ©
	JTextField © → construir cuadro de texto de una línea
		getDocument() (m) → Document (i) → addDocumentListener (m) → documentEvent() (e)
		ReceptoraEvento ©→ DocumentListener (i)
			removeUpdate()
			insertUpdate()
			changedUpdate()
 */
public class EventosCuadroTexto_password {

    public static void main(String[] args) {
        // Crear una instancia de MarcoPassword y configurarlo para que se cierre al salir
        MarcoPassword mimarco = new MarcoPassword();
        mimarco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

// Clase que representa el marco principal de la aplicación
class MarcoPassword extends JFrame {
    public MarcoPassword() {
        // Establecer el tamaño y la posición del marco
        setBounds(500, 300, 500, 350);
        
        // Crear una instancia de LaminaPassword y añadirla al marco
        LaminaPassword milamina = new LaminaPassword();
        add(milamina);
        
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que representa el panel principal de la aplicación
class LaminaPassword extends JPanel {
    private JPasswordField c_contra;  // Campo de contraseña

    public LaminaPassword() {
        // Establecer el layout del panel
        setLayout(new BorderLayout());

        // Crear un panel superior con un grid layout de 2x2
        JPanel lamina_superior = new JPanel();
        lamina_superior.setLayout(new GridLayout(2, 2));
        add(lamina_superior, BorderLayout.NORTH);

        // Crear etiquetas y campos de texto para usuario y contraseña
        JLabel etiqueta1 = new JLabel("Usuario");
        JLabel etiqueta2 = new JLabel("Contraseña");
        JTextField c_usuario = new JTextField(15);
        c_contra = new JPasswordField(15);

        // Añadir un oyente de eventos de documento al campo de contraseña
        Comprueba_pass mievento = new Comprueba_pass();
        c_contra.getDocument().addDocumentListener(mievento);

        // Añadir los componentes al panel superior
        lamina_superior.add(etiqueta1);
        lamina_superior.add(c_usuario);
        lamina_superior.add(etiqueta2);
        lamina_superior.add(c_contra);

        // Crear un botón de enviar y añadirlo al sur del panel principal
        JButton enviar = new JButton("Enviar");
        add(enviar, BorderLayout.SOUTH);
    }

    // Clase interna para manejar los eventos del documento del campo de contraseña
    private class Comprueba_pass implements DocumentListener {

        // Método llamado cuando se inserta texto en el documento
        @Override
        public void insertUpdate(DocumentEvent e) {
            verificarContrasena();
        }

        // Método llamado cuando se elimina texto del documento
        @Override
        public void removeUpdate(DocumentEvent e) {
            verificarContrasena();
        }

        // Método llamado cuando se cambia un atributo del documento (no se usa en este caso)
        @Override
        public void changedUpdate(DocumentEvent e) {
            // No se utiliza en este caso
        }

        // Método para verificar la longitud de la contraseña y cambiar el color de fondo del campo
        private void verificarContrasena() {
            char[] contrasena = c_contra.getPassword();  // Obtener la contraseña
            if (contrasena.length < 8 || contrasena.length > 12) {
                c_contra.setBackground(Color.red);  // Color rojo si la longitud no es válida
            } else {
                c_contra.setBackground(Color.white);  // Color blanco si la longitud es válida
            }
        }
    }
}
