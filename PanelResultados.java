import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelResultados extends JPanel{

	private String[] nombres,
						RFCs,
						utilidadBrutas,
						montoDeducibles,
						utilidadNetas,
						montoMinimo,
						montoMaximo;
	private int cont;
	
	
	public PanelResultados(String nombre, String rfc,String utilidadBruta,String montoDeducible,String utilidadNeta,String montoMaximo,String montoMinimo){
		super();
		this.cont=0;
		this.setPreferredSize(new Dimension(400,400));
		this.nombres=nombre.split(",");
		this.RFCs=rfc.split(",");
		this.utilidadBrutas=utilidadBruta.split(",");
		this.montoDeducibles=montoDeducible.split(",");
		this.utilidadNetas=utilidadNeta.split(",");
		this.montoMinimo=montoMinimo.split(",");
		this.montoMaximo=montoMaximo.split(",");
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("Nombre: "+this.nombres[cont], 10, 20);
		g.drawString("RFC: "+this.RFCs[cont], 10, 40);
		g.drawString("Utilidad Bruta: "+this.utilidadBrutas[cont], 10,100);
		g.drawString("Monto Deducible: "+this.montoDeducibles[cont], 10, 120);
		g.drawLine(10, 130, 100, 130);
		g.drawString("Total a Pagar: "+this.utilidadNetas[cont], 10, 150);
		
		g.drawString("Monto Maximo Permitido: "+this.montoMaximo[cont], 200, 100);
		g.drawString("Monto Maximo Retiro: "+this.montoMinimo[cont], 200, 120);
		g.drawLine(200, 130, 290, 130);
		g.drawString("Monto Deducible: "+this.montoDeducibles[cont] , 200, 150);
	}
	
	public void next(){
		if(this.cont<this.nombres.length-1){
			this.cont+=1;
		}
		this.repaint();
	}
	public void back(){
		if(this.cont!=0){
			this.cont-=1;
		}
		this.repaint();
	}
}