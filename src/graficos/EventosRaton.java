package graficos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/*
 * *EVENTOS DE RATÓN
	MouseListener (i) → MouseAdapter © → si solo queremos un método deberemos heredar está clase en vez de implementar la interfaz.
		-mousedPressed(MouseEvent e)
		-mousedReleased(MouseEvent e)
		-mousedClicked(MouseEvent e)
		-mousedEntered(MouseEvent e)
		-mousedExisted(MouseEvent e)
	MouseEvent ©
		-BUTTON1_DOWN_MASK
		-BUTTON2_DOWN_MASK
		-BUTTON3_DOWN_MASK
		-getX() → posición del ratón
		-getY()
		-getModifiersEx() → si se ha usado boton derecho, izquierdo o rueda
		-getClickCount() → cuántos clics ha hecho el usuario

 */
public class EventosRaton {

	public static void main(String[] args) {
		// Crea una instancia de MarcoRaton y la hace visible
		MarcoRaton mimarco = new MarcoRaton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoRaton extends JFrame {
	public MarcoRaton() {
		setVisible(true); // Hace visible la ventana
		setBounds(700, 300, 600, 450); // Establece la posición y tamaño de la ventana

		// Crea una instancia de EventosDeRaton (MouseMotionListener) y la añade al JFrame
		EventosDeRaton eventos = new EventosDeRaton();
		addMouseMotionListener(eventos); // Añade el listener de movimiento del ratón a la ventana
	}
}


/*
class EventosDeRaton implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Has hecho click"); //3º
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de presionar"); //1º
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de levantar"); //2º
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de entrar");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Acabas de salir");
	}
	
}
*/

/*
 * si solo quisiesemos usar uno de los métodos debemos heredar de MouseAdapter
 */
/*
class EventosDeRaton extends MouseAdapter{
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Cordenada X: "+e.getX()+ " Coordenada Y: "+e.getY());
		System.out.println(e.getClickCount());
	}
	public void mousePressed(MouseEvent e) {
		if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("Has pulsado el botón izquierdo.");
		}else if (e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
			System.out.println("Has usado la rueda del ratón");
		}else if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("Has pulsado el botón derecho");
		}
	}
}
*/

class EventosDeRaton implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// Se llama cuando el ratón se arrastra (se mueve con un botón presionado)
		System.out.println("Estás arrastrando en X: " + e.getX() + ", Y: " + e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Se llama cuando el ratón se mueve (sin botones presionados)
		System.out.println("Estás moviendo en X: " + e.getX() + ", Y: " + e.getY());
	}

}