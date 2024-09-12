package graficos;

import java.awt.Frame;
import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miMarco marco1 = new miMarco();
		
		//ESTOS MÉTODOS PODRÍA HABERLOS PUESTO EN EL CONSTRUCTOR TAMBIÉN
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminar la app cuando cerremos el marco
		//.HIDE_ON_CLOSE -->si tuviesemos varias ventanas es decir que no acaba en el momento que cierras.
	}

}

class miMarco extends JFrame{
	public miMarco(){
		//PONER TAMAÑO VENTANA
		//setSize (500,300); 
		
		//POSICIONAR VENTANA
		//por defecto la ubicación: esquina superior izuqierda.
		//setLocation(500,300); //eje de cordenadas X,Y
		//el punto 0,0: es la esquina superior izquierda
	
		//CON ESTE HACEMOS AMBAS
		setBounds(500,300,550,250); //(pos x,pos y, tamaño x, tamaño y)
		
		//NO PERMITIR REDIMENSIÓN
		//setResizable(false);
		
		//PANTALLA COMPLETA
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		
		//PONER TITULO VENTANA
		setTitle("Mi ventana");
	}
}
