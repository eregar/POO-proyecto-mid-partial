import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VentanaISR extends JFrame{
	private PanelLabel ePanel;
	private PanelProyecto pp;
	
	public VentanaISR(){
		
		super("Calculo Impuestos");
		this.setSize(new Dimension(600,600));
		this.ePanel= new PanelLabel(new PanelProyecto(ePanel));// pa que no se tire alv
		this.pp=new PanelProyecto(ePanel);
		this.ePanel= new PanelLabel(pp);
		JScrollPane scroll = new JScrollPane(pp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(scroll,BorderLayout.EAST);
		this.add(this.ePanel,BorderLayout.WEST);
		//this.pack();
		
		this.setVisible(true);
	}
	public static void main(String[] args){
		VentanaISR venti= new VentanaISR();
	}
}