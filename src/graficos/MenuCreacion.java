package graficos;

import javax.swing.*;
import java.awt.*;

/*
 * –CONSTRUCCIÓN MENÚS
 *      JMenuBar © → menú principal
 *      JMenu © → cada uno de los elementos el menú principal
 *      JMenuItem © → items de cada elemento del menú principal
 *      SEPARADORES: addSeparator() (m) → agregar separadores entre elementos de menú
 */
public class MenuCreacion {

    public static void main(String[] args) {
        // Crear y configurar el marco principal de la aplicación
        MenuFrame mimarco = new MenuFrame();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

// Clase que define el marco principal de la aplicación
class MenuFrame extends JFrame {
    public MenuFrame() {
        // Configurar las dimensiones y la posición del marco
        setBounds(500, 300, 500, 350);
        // Crear y añadir la lámina principal al marco
        MenuLamina milamina = new MenuLamina();
        add(milamina);
        // Hacer visible el marco
        setVisible(true);
    }
}

// Clase que define la lámina principal donde se colocarán los componentes del menú
class MenuLamina extends JPanel {
    public MenuLamina() {
        // Crear la barra de menú principal
        JMenuBar mibarra = new JMenuBar();

        // Crear los menús principales
        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edición");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu opciones = new JMenu("Opciones"); // Crear un submenú

        // Crear los elementos del menú (items)
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardar_como = new JMenuItem("Guardar como");
        JMenuItem cortar = new JMenuItem("Cortar");
        JMenuItem copiar = new JMenuItem("Copiar");
        JMenuItem pegar = new JMenuItem("Pegar");
        JMenuItem generales = new JMenuItem("Generales");

        // Añadir los elementos al menú "Archivo"
        archivo.add(guardar);
        archivo.add(guardar_como);

        // Añadir los elementos al menú "Edición"
        edicion.add(cortar);
        edicion.add(copiar);
        edicion.addSeparator(); // Añadir un separador entre "Copiar" y "Pegar"
        edicion.add(pegar);

        // Añadir los elementos al menú "Herramientas"
        herramientas.add(generales);

        // Añadir los menús principales a la barra de menú
        mibarra.add(archivo);
        mibarra.add(edicion);
        mibarra.add(herramientas);

        // Crear los elementos del submenú "Opciones"
        JMenuItem opcion1 = new JMenuItem("Opción 1");
        JMenuItem opcion2 = new JMenuItem("Opción 2");

        // Añadir los elementos al submenú "Opciones"
        opciones.add(opcion1);
        opciones.add(opcion2);

        // Añadir el submenú "Opciones" al menú "Edición"
        edicion.add(opciones);

        // Añadir la barra de menú a la lámina
        add(mibarra);
    }
}
