import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.*;

public class PanelLabel extends JPanel implements ActionListener{
	private JLabel errorsin,
			errorSupport;
	private PanelProyecto pp;
	private JTextField tfEscritor;
	private JButton bConfirma;
	private JButton buscarLector;
	private String[] errores;// array con posibles errores en input de datos de usuario
	private File destino;
	//BufferedReader br;
	public PanelLabel(PanelProyecto pp){
		super();
		this.setPreferredSize(new Dimension(250,700));
		this.pp=pp;
		this.errores= new String[]{"Se debe de llenar al bloque de nombre",
				"Se debe de llenar el bloque de RFC",
				"El campo 'sueldo mensual' solo debe de tener digitos",
				"El campo 'Aguinaldo' solo debe de tener digitos",
				"El campo de 'prima Vacacional' solo debe de tener digitos",
				"El campo de 'Dediccion Medico' solo debe de tener digitos",
				"El campo 'Deduccion gastos funerarios' solo debe de tener digitos",
				"El campo 'Primas por seguro de gastos medicos' solo debe de tener digitos",
				"El campo 'Creditos Hipotecarios' solo debe de tener digitos",
				"El campo 'Donativos' solo debe de tener digitos",
				"El campo 'Apor. de subcuentas de retiro' solo debe de tener digitos",
				"El campo 'Transporte Escolar de hijos' solo debe de tener digitos",
				"El campo 'Colegiaturas Pagadas' solo debe de tener digitos",
				"Un nivel educativo debe de ser seleccionado o Colegiaturas pagadas debe de ser 0",
				"El campo'Sueldo mensual' debe ser mayor a 0"
				};// explicacion de los errores
		errorsin =new JLabel("");
		errorSupport= new JLabel("");
		tfEscritor= new JTextField(20);
		buscarLector = new JButton("Calcular desde Archivo");
		bConfirma= new JButton("Calcular");
		bConfirma.setPreferredSize(new Dimension(200,200));
		destino= null;
		
		
		this.tfEscritor.setEditable(false);
		this.add(errorsin);
		this.add(errorSupport);
		this.add(buscarLector);
		this.add(tfEscritor);
		this.add(new PanelRes());
		this.add(bConfirma);
		
		
		this.buscarLector.addActionListener(this);
		this.bConfirma.addActionListener(this);
	}
	//----------------------------------------------------------------------------------
	public void setError(String msg){// para el extra label cuando salgan los errores de info
		JOptionPane.showMessageDialog(null,msg);
		
	}
	//--------------------------------------------------------------------------------------
	public File buscarArchivo(){
		JFileChooser choser= new JFileChooser("Busca Documento");
		choser.setCurrentDirectory(new java.io.File("."));
		choser.setVisible(true);
		int returnValue = choser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			destino=choser.getCurrentDirectory();
			return choser.getSelectedFile();
		}
		else{
			return null;
		}
	}
	//--------------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		File destinoTemporal;
		if(e.getSource()==buscarLector){
			destinoTemporal=this.buscarArchivo();
			if(destinoTemporal!=null){
				//reader y writer con el destino, poner info que tiene el archivo csv en otro csv(o la suma de todos?)
			}
		}
		else if(e.getSource()==bConfirma){
			int errorNumber= pp.validRes();
			if (errorNumber==15){
				//que mande los datos a clase que necesite
		}
		else{
			this.setError(errores[errorNumber]);
			System.out.println(errores[errorNumber]);	
		}
		}
	}
	//---------------------------------------------------------------------------------
}
