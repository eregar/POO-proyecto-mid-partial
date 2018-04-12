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
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelLabel extends JPanel implements ActionListener{
	private JLabel errorsin,
			errorSupport;
	private String deducir1,
					deducir2,
					totalDeducible,
					totalImpuestos;
	
	private Deduccion D1;
	
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
		choser.setAcceptAllFileFilterUsed(false);
		choser.setFileFilter(new FileNameExtensionFilter("CSV File","csv"));
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
		Deduccion calcular;
		String linea;
		String[] elementos;
		//StringTokenizer st;
		if(e.getSource()==buscarLector){
			destinoTemporal=this.buscarArchivo();
			if(destinoTemporal!=null){
				try {
					BufferedReader br= new BufferedReader(new FileReader(destinoTemporal));
					tfEscritor.setText(destino.toString());
					while((linea=br.readLine()) !=null){
						//st=new StringTokenizer(linea,",");
						elementos= linea.split(",");
					//String nombre, String RFC, String nivelEducativo, Double salarioMensual, Double Aguinaldo, Double primaVacacional, Double honorarios, Double gastosFunerarios, Double primasSGM, Double interesesDevengados, Double donativos, Double transporteEscolar, Double colegiatura
						// constructor de reduccion guardada en una variable temporal
						//get the shit
						//make the csv
						//guardar en un string temporal y mandarlo a la otra ventana
					}
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null,"El archivo no se encontró o fue removido");
					this.destino=null;
					tfEscritor.setText("");
				}  catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"No se pudo leer el archivo");
					this.destino=null;
					tfEscritor.setText("");
				}
				
			}
		}
		else if(e.getSource()==bConfirma){
			JTextField[] textos = this.pp.getTextos();
			
			int errorNumber= pp.validRes();
			if (errorNumber==15){
				//que mande los datos a clase que necesite
				Persona sujeto1 = new Persona(textos[0].getText(), textos[1].getText(), "Aqui va el nivel Educativo", Double.parseDouble(textos[2].getText()), Double.parseDouble(textos[3].getText()), Double.parseDouble(textos[4].getText()), Double.parseDouble(textos[5].getText()), Double.parseDouble(textos[6].getText()), Double.parseDouble(textos[7].getText()), Double.parseDouble(textos[8].getText()), Double.parseDouble(textos[9].getText()), Double.parseDouble(textos[10].getText()), Double.parseDouble(textos[11].getText()), Double.parseDouble(textos[12].getText()));
				//Aqui se crea la persona para poder luego meterla en la clase Deduccion (lugar donde se calculan los impuestos)
				D1 = new Deduccion (sujeto1);
				
				
				// con D1 se le puede sacar ahora si los resultados que se necesitan (en este caso con solo llamar a D1 puedes a los resultados de el calculo del impuesto (puede que necesitemos hacer gets de la clase Deducción.))
		}
		else{
			this.setError(errores[errorNumber]);
			System.out.println(errores[errorNumber]);	
		}
		}
	}
	//---------------------------------------------------------------------------------
}