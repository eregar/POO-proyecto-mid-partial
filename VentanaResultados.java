import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaResultados extends JFrame {
	private PanelRes panel;
	private PanelResultados panelArriba;
	private JButton bSig,bAnt;
	
	public VentanaResultados(String nombre, String rfc,String utilidadBruta,String montoDeducible,String utilidadNeta,String montoMaximo,String montoMinimo){
		super("Resultados del calculo de impuestos");
		this.panel= new PanelRes(400,50);
		panelArriba= new PanelResultados(nombre,rfc,utilidadBruta,montoDeducible,utilidadNeta,montoMaximo,montoMinimo);
		this.bSig= new JButton("Siguiente");
		this.bAnt= new JButton("Anterior");
		
		this.add(panelArriba,BorderLayout.NORTH);
		this.add(this.panel,BorderLayout.SOUTH);
		this.panel.add(bAnt);
		this.panel.add(bSig);
		
		this.bAnt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelArriba.back();
			}
			
		});
		this.bSig.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				panelArriba.next();
			}
			
		});
		this.pack();
		this.setVisible(true);
	}
	
	
}
