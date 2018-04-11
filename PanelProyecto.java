import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelProyecto extends JPanel {
	
	private JButton bConfirma;// boton de confirmar
	private JTextField[] textos;// array con todos los textfields en orden
	private JLabel[] labelTextos;//array con todos los labels correspondientes a los textfields
	private PanelLabel ePanel;
	private JRadioButton prim,
						sec,
						prep,
						pree,
						protec,
						ningun;
	private String nivel;
	//---------------------------------------------------------------------------------
	public PanelProyecto(PanelLabel panel){
		super();
		this.prim= new JRadioButton("Primaria");
		this.sec= new JRadioButton("Secundaria");
		this.prep= new JRadioButton("Prepa");
		this.pree=new JRadioButton("Preescolar");
		this.protec=new JRadioButton("Profesional Tecnico");
		this.ningun= new JRadioButton("Ninguno");
		
		ButtonGroup bg= new ButtonGroup();
		bg.add(prim);
		bg.add(sec);
		bg.add(prep);
		bg.add(pree);
		bg.add(protec);
		bg.add(ningun);
		
		this.textos = new JTextField[14];
		this.ePanel=panel;
		for (int i=0;i<textos.length;i++){// define los textfields dentro del array
			textos[i]=new JTextField(20);
		}
		this.setPreferredSize(new Dimension(250,700));
		this.bConfirma= new JButton("Calcular");
		
		this.add(new JLabel("Nombre Completo"));
		this.add(textos[0]);
		this.add(new JLabel("RFC"));
		this.add(textos[1]);
		this.add(new JLabel("Sueldo Mensual"));
		this.add(textos[2]);
		this.add(new JLabel("Aguinaldo recibido"));
		this.add(textos[3]);
		this.add(new JLabel("Prima Vacacional"));
		this.add(textos[4]);
		this.add(new JLabel("Deduccion Medico y Hospitalario"));
		this.add(textos[5]);
		this.add(new JLabel("Deduccion Gastos Funerarios"));
		this.add(textos[6]);
		this.add(new JLabel("Primas por seguro de gastos medicos"));
		this.add(textos[7]);
		this.add(new JLabel("Creditos hipotecarios"));
		this.add(textos[8]);
		this.add(new JLabel("Donativos"));
		this.add(textos[9]);
		this.add(new JLabel("Aportaciones de subcuenta de retiro"));
		this.add(textos[10]);
		this.add(new JLabel("Transporte escolar de hijos"));
		this.add(textos[11]);
		this.add(new JLabel("Colegiaturas pagadas"));
		this.add(textos[12]);
		//this.add(new JLabel("Nivel Educativo"));
		//this.add(textos[13]);//aaaaaaaaaaaaaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		this.add(pree);
		this.add(prim);
		this.add(sec);
		this.add(prep);
		this.add(protec);
		this.add(ningun);
	}
	//---------------------------------------------------------------------------------
	public int validRes(){// valida todos los tf, regresa el tf que este haciendo conflicto (solo uno)
		for (int i=0;i<2;i++){// valida 0-1 si hay algo
			if (this.textos[i].getText().equals("")){
				System.out.println("null!!");
				return i;
			}
			else{
				System.out.println("okay!");
			}
		}
		for (int i=2;i<13;i++){//valida 2-12 si es numero y si hay algo
			if (this.textos[i].getText().equals("")){
				this.textos[i].setText("0");
			}
			else{
				try{
					Double.parseDouble(this.textos[i].getText());
				}catch(NumberFormatException e){
					return i;
				}
			}
		}
		if(Double.parseDouble(this.textos[2].getText())<=0){
			return 14;
		}
		if(!this.textos[12].getText().equals("0")){//valida 13 si coincide con 12
			if(prim.isSelected()){
				setBackground(Color.RED);
				nivel="Primaria";
			}
			else if(sec.isSelected()){
				setBackground(Color.GREEN);
				nivel="Secundaria";
			}
			else if(prep.isSelected()){
				setBackground(Color.BLUE);
				nivel="Bachillerato";
			}
			else if (pree.isSelected()){
				nivel="Preescolar";
			}
			else if (protec.isSelected()){
				nivel="Profesional Tecnico";
			}
			else{
				return 13;
			}
		}
		else{
			nivel="ninguno";
		}
		return 15;// si es que no hay error regresa 15
	}
	//---------------------------------------------------------------------------------
	//necesarios: Nombre,RFC,Salario Mensual
}
