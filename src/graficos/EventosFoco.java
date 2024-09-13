package graficos;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
/*
 * *EVENTOS DE FOCO
	FocusListener (i) → FocusAdapter ©
		-focusGained(Focusevent e)
		-focusLost(FocusEvent e)
	
	En el caso de que manejemos eventos con ventanas:
	windowsFocusListener(i) →WindowAdapter © 
		-windowGainedFocus(Focusevent e)
		-windowLostFocus(FocusEvent e)

 */

public class EventosFoco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoFoco mimarco = new MarcoFoco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class MarcoFoco extends JFrame{
	public MarcoFoco() {
		setVisible(true);
		setBounds(300,300,600,450);
		add(new LaminaFoco());
	}
}
class LaminaFoco extends JPanel{
	JTextField cuadro1;
	JTextField cuadro2;
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		//Layout--> disposición que tienen los elementos en una ventana
		//invalidamos está disposición
		setLayout(null); //no hay disposición por defecto. Y puedo colocarlos donde me de la gana
		
		//Cuadros de texto
		cuadro1 = new JTextField();
		cuadro2 = new JTextField();
		cuadro1.setBounds(120, 10, 150, 20);
		cuadro2.setBounds(120, 50, 150, 20);
		add(cuadro1);
		add(cuadro2);
		
		LanzaFocos elFoco = new LanzaFocos();
		cuadro1.addFocusListener(elFoco);
	}
	
	private class LanzaFocos implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("Has ganado el foco");
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			String email = cuadro1.getText();
			boolean comprobacion = false;
			for (int i=0; i<email.length();i++) {
				if (email.charAt(i)=='@') {
					comprobacion = true;
				}
			}
			if (comprobacion) {
				System.out.println("Correcto");
			}else {
				System.out.println("Incorrecto");
			}
		}
		
	}

}