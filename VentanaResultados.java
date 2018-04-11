import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaResultados extends JFrame {
	
	public VentanaResultados(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.add(new PanelResultados());
		this.setVisible(true);

	}
}
