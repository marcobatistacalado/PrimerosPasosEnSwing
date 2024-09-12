package practicaProcesadorTexto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Procesador {

    public static void main(String[] args) {
        // Crear y configurar el marco principal
        MenuProcesador_II mimarco = new MenuProcesador_II();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// Clase que crea el marco principal del procesador de texto
class MenuProcesador_II extends JFrame {
    public MenuProcesador_II() {
        setBounds(500, 300, 500, 350); // Posición y tamaño del marco
        LaminaProcesador_II milamina = new LaminaProcesador_II();
        add(milamina); // Añadir la lámina al marco
        setVisible(true); // Hacer visible el marco
    }
}

// Clase que crea la lámina con el contenido del procesador de texto
class LaminaProcesador_II extends JPanel {
    private JTextPane miarea; // Área de texto
    private JMenu fuente, estilo, tamagno; // Menús para fuente, estilo y tamaño
    private Font letras; // Fuente actual del texto

    public LaminaProcesador_II() {
        setLayout(new BorderLayout()); // Layout de la lámina
        JPanel laminamenu = new JPanel();
        JMenuBar mibarra = new JMenuBar(); // Barra de menú
        
        // Inicialización de los menús
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamagno = new JMenu("Tamaño");
        
        // Configuración de los elementos del menú de fuente
        configura_menu("Verdana", "fuente", "Verdana", 9, 10);
        configura_menu("Courier", "fuente", "Courier", 9, 10);
        configura_menu("Arial", "fuente", "Arial", 9, 10);
        
        // Configuración de los elementos del menú de estilo
        configura_menu("Negrita", "estilo", "", Font.BOLD, 1);
        configura_menu("Cursiva", "estilo", "", Font.ITALIC, 1);
        
        // Configuración de los elementos del menú de tamaño
        configura_menu("12", "tamagno", "", 9, 12);
        configura_menu("16", "tamagno", "", 9, 16);
        configura_menu("20", "tamagno", "", 9, 20);
        configura_menu("24", "tamagno", "", 9, 24);
        
        // Añadir los menús a la barra de menú
        mibarra.add(fuente);
        mibarra.add(estilo);
        mibarra.add(tamagno);
        
        // Añadir la barra de menú a la lámina
        laminamenu.add(mibarra);
        add(laminamenu, BorderLayout.NORTH);
        
        // Crear y añadir el área de texto a la lámina
        miarea = new JTextPane();
        add(miarea);
    }

    // Método para configurar los elementos del menú
    public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam) {
        JMenuItem elem_menu = new JMenuItem(rotulo); // Crear un elemento de menú
        if (menu.equals("fuente")) {
            fuente.add(elem_menu); // Añadir al menú de fuente
        } else if (menu.equals("estilo")) {
            estilo.add(elem_menu); // Añadir al menú de estilo
        } else if (menu.equals("tamagno")) {
            tamagno.add(elem_menu); // Añadir al menú de tamaño
        }
        
        // Añadir el ActionListener al elemento de menú
        elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
    }

    // Clase interna que gestiona los eventos de los elementos del menú
    private class Gestiona_Eventos implements ActionListener {
        String tipo_texto, menu;
        int estilo_letra, tamagno_letra;

        public Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra) {
            tipo_texto = texto2;
            estilo_letra = estilo2;
            tamagno_letra = tam_letra;
            menu = elemento;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener la fuente actual del área de texto
            letras = miarea.getFont();
            
            // Comprobar si el menú seleccionado es una fuente
            if (menu.equals("Arial") || menu.equals("Courier") || menu.equals("Verdana")) {
                // Mantener el estilo y tamaño actuales
                estilo_letra = letras.getStyle();
                tamagno_letra = letras.getSize();
            } else if (menu.equals("Cursiva") || menu.equals("Negrita")) {
                // Comprobar si el estilo actual es negrita o cursiva y establecer el nuevo estilo
                if (letras.getStyle() == Font.BOLD || letras.getStyle() == Font.ITALIC) {
                    estilo_letra = Font.BOLD | Font.ITALIC;
                }
                tipo_texto = letras.getFontName();
                tamagno_letra = letras.getSize();
            } else if (menu.equals("12") || menu.equals("16") || menu.equals("20") || menu.equals("24")) {
                // Mantener el estilo y fuente actuales
                estilo_letra = letras.getStyle();
                tipo_texto = letras.getFontName();
            }
            
            // Establecer la nueva fuente del área de texto
            miarea.setFont(new Font(tipo_texto, estilo_letra, tamagno_letra));
        }
    }
}

