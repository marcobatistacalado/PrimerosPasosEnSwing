package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * CHECKBOX
 * JCheckBox ©
 *  - isSelected() (m): Verifica si el checkbox está seleccionado.
 *  - setSelected(boolean) (m): Establece el estado de selección del checkbox.
 */
public class CheckBoxEjemplo {

    public static void main(String[] args) {
        // Crear una instancia de MarcoCheck y configurarla para que se cierre al salir
        MarcoCheck mimarco = new MarcoCheck();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que representa el marco principal de la aplicación
class MarcoCheck extends JFrame {
    public MarcoCheck() {
        // Establecer el tamaño y posición del marco
        setBounds(500, 300, 500, 350);
        
        // Crear una instancia de LaminaCheck y añadirla al marco
        LaminaCheck milamina = new LaminaCheck();
        add(milamina);
        
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que representa el panel con los elementos de la interfaz
class LaminaCheck extends JPanel {
    private JLabel texto;           // Etiqueta que muestra el texto
    private JCheckBox check1, check2; // Checkboxes para aplicar estilos al texto

    public LaminaCheck() {
        // Establecer el layout del panel
        setLayout(new BorderLayout());
        
        // Crear y configurar la fuente del texto
        Font miletra = new Font("Serif", Font.PLAIN, 24);
        
        // Crear y configurar la etiqueta de texto
        texto = new JLabel("En un lugar de la Mancha cuyo nombre...");
        texto.setFont(miletra);
        
        // Crear un panel para contener la etiqueta de texto
        JPanel laminatexto = new JPanel();
        laminatexto.add(texto);
        
        // Añadir el panel de texto al centro del panel principal
        add(laminatexto, BorderLayout.CENTER);
        
        // Crear y configurar los checkboxes
        check1 = new JCheckBox("Negrita");
        check2 = new JCheckBox("Cursiva");
        
        // Añadir los listeners a los checkboxes
        check1.addActionListener(new ManejaChecks());
        check2.addActionListener(new ManejaChecks());
        
        // Crear un panel para contener los checkboxes
        JPanel laminaChecks = new JPanel();
        laminaChecks.add(check1);
        laminaChecks.add(check2);
        
        // Añadir el panel de checkboxes al sur del panel principal
        add(laminaChecks, BorderLayout.SOUTH);
    }

    // Clase que maneja los eventos de los checkboxes
    private class ManejaChecks implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Inicializar el tipo de fuente
            int tipo = 0;
            
            // Verificar si el checkbox de negrita está seleccionado
            if (check1.isSelected()) tipo += Font.BOLD; // Font.BOLD es una constante = 1
            
            // Verificar si el checkbox de cursiva está seleccionado
            if (check2.isSelected()) tipo += Font.ITALIC; // Font.ITALIC es una constante = 2
            
            // Aplicar el nuevo estilo de fuente al texto
            texto.setFont(new Font("Serif", tipo, 24));
        }
    }
}

