package edu.umg.programacion2.proyecto.ui;


import javax.swing.SwingUtilities;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
		
		
	}

}
