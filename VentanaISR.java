import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaISR extends JFrame{
	private PanelLabel ePanel;
	private PanelProyecto pp;
	public VentanaISR(){
		super();
		this.ePanel= new PanelLabel(new PanelProyecto(ePanel));// pa que no se tire alv
		this.pp=new PanelProyecto(ePanel);
		this.ePanel= new PanelLabel(pp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.pp,BorderLayout.EAST);
		this.add(this.ePanel,BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args){
		VentanaISR venti= new VentanaISR();
	}
}
