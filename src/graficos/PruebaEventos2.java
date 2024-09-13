package graficos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*AHORA QUEREMOS HACERLO DE OTRA FORMA DEJANDO DE SER LA LAMINA EL OBJETO LISTENER 
 * Y PASE A SER EL PROPIO COLOR DE FONDO.
*/

public class PruebaEventos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoBotones mimarco = new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoBotones2 extends JFrame{
	public MarcoBotones2(){
		setTitle("Botones y Eventos");
		setBounds(700,300,500,300);
		LaminaBotones milamina = new LaminaBotones();
		add(milamina);
		
	}
}

class LaminaBotones2 extends JPanel{ //lamina = OBJETO listener
	//incluir boton
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");
	
	public LaminaBotones2() {
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		
		ColorFondo Amarillo = new ColorFondo (Color.yellow);
		ColorFondo Azul = new ColorFondo (Color.blue);
		ColorFondo Rojo = new ColorFondo (Color.red);
		
		botonAzul.addActionListener(Azul);
		botonRojo.addActionListener(Rojo);
		botonAmarillo.addActionListener(Amarillo);
		
	}
	
	private class ColorFondo implements ActionListener{
		private Color colorDeFondo;
		public ColorFondo(Color c) {
			colorDeFondo = c;
		}
		public void actionPerformed(ActionEvent e) {
			setBackground(colorDeFondo);
		}
	}

}

