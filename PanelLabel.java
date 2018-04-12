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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelLabel extends JPanel implements ActionListener{
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
		tfEscritor= new JTextField(20);
		buscarLector = new JButton("Calcular desde Archivo");
		bConfirma= new JButton("Calcular");
		bConfirma.setPreferredSize(new Dimension(200,200));
		destino= null;
		
		
		this.tfEscritor.setEditable(false);
		this.add(buscarLector);
		this.add(tfEscritor);
		this.add(new PanelRes(250,200));
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
		String linea,
				nombre,
				rfc,
				utilidadBruta,
				montoDeducible,
				totalAPagar,
				montoMaximo,
				montoMinimo;
		String[] elementos;
		
		
		nombre="";
		rfc="";
		utilidadBruta="";
		montoDeducible="";
		totalAPagar="";
		montoMaximo="";
		montoMinimo="";
		if(e.getSource()==buscarLector){
			destinoTemporal=this.buscarArchivo();
			if(destinoTemporal!=null){
				try {
					BufferedReader br= new BufferedReader(new FileReader(destinoTemporal));
					tfEscritor.setText(destino.toString());
					//aquiiii
					FileWriter fw= new FileWriter(destino.toString()+"\\Empresa.csv");
					PrintWriter pw=new PrintWriter(fw);
					pw.println("Nombre,RFC,Sueldo Mensual,Sueldo Anual,Aguinaldo,Aguinaldo Excento, Aguinaldo Grabado, Prima Vacacional, Prima Vacacional Excenta, Prima Vacacional Grabado, Total ingresos gravan, Honorarios, Gastos Funerarios, Primas de SGM, Hipotecarios, Donativos,Subcuenta de retiro, Transporte escolar, Nivel educativo, Maximo a deducir colegiatura, colegiatura pagada, total deducciones(sin retiro), deduccion permitida 10%, Monto ISR, Cuota fija, Porcentaje excedente, Pago excedente, Total a pagar");
					while((linea=br.readLine()) !=null){
						elementos= linea.split(",");
						System.out.println(elementos.length);
						Persona person = new Persona(elementos[0], elementos[1],elementos[12], Double.parseDouble(elementos[2]), Double.parseDouble(elementos[3]), Double.parseDouble(elementos[4]), Double.parseDouble(elementos[5]), Double.parseDouble(elementos[6]), Double.parseDouble(elementos[7]), Double.parseDouble(elementos[8]), Double.parseDouble(elementos[9]), Double.parseDouble(elementos[10]), Double.parseDouble(elementos[11]), Double.parseDouble(elementos[13]));
						calcular= new Deduccion(person);
						nombre+=person.getNombre()+",";
						rfc+=person.getRFC()+",";
						utilidadBruta+=calcular.getUtilidadBruta()+",";
						montoDeducible+=calcular.getTotalDeducible()+",";
						totalAPagar+=calcular.getTotalAPagar()+",";
						montoMaximo+=calcular.getDeduccionPermitida()+",";
						montoMinimo+=calcular.getAFORE()+",";
						
						pw.println(person.getNombre()+","+person.getRFC()+","+person.getSalarioMensual()+","+person.getSalarioMensual()*12+","+person.getAguinaldo()+","+calcular.getAguinaldoEscento()+","+(person.getAguinaldo()-calcular.getAguinaldoEscento())+","+person.getPrimaVacacional()+","+calcular.getPrimaVacacionalExcenta()+","+(person.getPrimaVacacional()-calcular.getPrimaVacacionalExcenta())+","+calcular.getUtilidadBruta()+","+person.getHonorarios()+","+person.getGastosFunerarios()+","+person.getPrimasSGM()+","+person.getInteresesDevengados()+","+person.getDonativos()+","+person.getAFORE()+","+person.getTransporteEscolar()
						+","+elementos[12]+","+calcular.getDeduciColegiatura()+","+person.getColegiatura()+","+calcular.getDeducir1()+","+calcular.getDeduccionPermitida()+","+calcular.getTotalDeducible()+","+calcular.getQuotaFija()+","+calcular.getPorcentaje()+","+calcular.getMontoAPagar()+","+calcular.getTotalAPagar());
						System.out.println(elementos.length);	
					}
					pw.close();
					br.close();
					JOptionPane.showMessageDialog(null, "Archivo scv creado en el mismo directorio!!!");
					new VentanaResultados(nombre,rfc,utilidadBruta,montoDeducible,totalAPagar,montoMaximo,montoMinimo);
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
				Persona person = new Persona(textos[0].getText(), textos[1].getText(), this.pp.getNivel(), Double.parseDouble(textos[2].getText()), Double.parseDouble(textos[3].getText()), Double.parseDouble(textos[4].getText()), Double.parseDouble(textos[5].getText()), Double.parseDouble(textos[6].getText()), Double.parseDouble(textos[7].getText()), Double.parseDouble(textos[8].getText()), Double.parseDouble(textos[9].getText()), Double.parseDouble(textos[10].getText()), Double.parseDouble(textos[11].getText()), Double.parseDouble(textos[12].getText()));
				//Aqui se crea la persona para poder luego meterla en la clase Deduccion (lugar donde se calculan los impuestos)
				calcular = new Deduccion (person);
				nombre=person.getNombre();
				rfc=person.getRFC();
				utilidadBruta=calcular.getUtilidadBruta();
				montoDeducible=calcular.getTotalDeducible();
				totalAPagar=calcular.getTotalAPagar();
				montoMaximo=calcular.getAFORE();
				montoMinimo=calcular.getDeducir1();
				
				new VentanaResultados(nombre,rfc,utilidadBruta,montoDeducible,totalAPagar,montoMaximo,montoMinimo);
				
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