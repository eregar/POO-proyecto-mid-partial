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
	JLabel errorsin,
			errorSupport;
	
	JTextField //tfLector,
				tfEscritor;
	
	JButton buscarLector,
			//buscarEscritor,
			pushInfoButton;
	File destino;
	//BufferedReader br;
	public PanelLabel(){
		super();
		this.setPreferredSize(new Dimension(250,700));
		errorsin =new JLabel("");
		errorSupport= new JLabel("");
		//tfLector= new JTextField(20);
		tfEscritor= new JTextField(20);
		buscarLector = new JButton("Calcular desde Archivo");
		//buscarEscritor = new JButton("Guardar en nuevo Archivo");
		pushInfoButton= new JButton("añadir informacion al archivo elegido");
		
		destino= null;
		//this.tfLector.setEditable(true);
		this.tfEscritor.setEditable(false);
		this.pushInfoButton.setEnabled(false);
		this.add(errorsin);
		this.add(errorSupport);
		this.add(buscarLector);
		//this.add(tfLector);
		//this.add(buscarEscritor);
		this.add(tfEscritor);
		this.add(pushInfoButton);
		this.add(new PanelRes());
		this.add(new JLabel("Resultado:"));
		this.add(new JTextField(20));
		
		
		this.buscarLector.addActionListener(this);
		//this.buscarEscritor.addActionListener(this);
	}
	public void setError(String msg){// para el extra label cuando salgan los errores de info
		errorsin.setText(msg);
	}
	public String getError(){// no c para que sirve
		return errorsin.getText();
	}
	public void support(boolean activate){// activa o no el extra label
		if (activate){
			this.errorSupport.setText("solo debe de tener digitos");
		}
		else{
			this.errorSupport.setText("");
		}
	}
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		File destinoTemporal;
			if(e.getSource()==buscarLector){
				destinoTemporal=this.buscarArchivo();
				if(destinoTemporal!=null){
					//reader y writer con el destino, poner info que tiene el archivo csv en otro csv(o la suma de todos?)
				}
			}
			/*else{
				this.destino= buscarArchivo();
				this.tfEscritor.setText(this.destino.toString());//tira null pointer exe
				pushInfoButton.setEnabled(true);
			}*/
		
	}
	
}
