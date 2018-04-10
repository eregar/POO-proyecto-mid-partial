
public class Persona {
	private String nombre,
				   RFC,
				   nivelEducativo;
	private int salarioMensual,
				Aguinaldo,
				primaVacacional,
				honorarios,
				gastosFunerarios,
				primasSGM,
				interesesDevengados,
				donativos,
				transporteEscolar,
				colegiatura,
				AFORE;
	
	public Persona () {
		this.nombre = "";
		this.RFC = "";
	}
	
	
	public Persona (String nombre, String RFC, String nivelEducativo, int salarioMensual, int Aguinaldo, int primaVacacional, int honorarios, int gastosFunerarios, int primasSGM, int interesesDevengados, int donativos ,int transporteEscolar, int colegiatura) {
		this.nombre = nombre;
		this.RFC = RFC;
		this.nivelEducativo = nivelEducativo;
		this.salarioMensual = salarioMensual;
		this.Aguinaldo = Aguinaldo;
		this.primaVacacional = primaVacacional;
		this.honorarios = honorarios;
		this.gastosFunerarios = gastosFunerarios;
		this.primasSGM = primasSGM;
		this.interesesDevengados = interesesDevengados;
		this.donativos = donativos;
		this.transporteEscolar = transporteEscolar;
		this.colegiatura = colegiatura;
	
	}
	
	
	
	
	public int getAguinaldo () {
		return this.Aguinaldo;
	}
	
	public int getSalarioMensual() {
		return this.salarioMensual;
	}
	
	public int getPrimaVacacional() {
		return this.primaVacacional;
	}
	
	public int getHonorarios() {
		return this.honorarios;
	}
	
	public int getGastosFunerarios() {
		return this.gastosFunerarios;
	}
	
	public int getPrimasSGM() {
		return this.primasSGM;
	}
	
	public int getInteresesDevengados() {
		return this.interesesDevengados;
	}
	
	public int getDonativos() {
		return this.donativos;
	}
	
	public int getTransporteEscolar() {
		return this.transporteEscolar;
	}
	
	public int getColegiatura() {
		return this.colegiatura;
	}
	
	public int getAFORE() {
		return this.AFORE;
	}
	
	public String getNivelEducativo() {
		return this.nivelEducativo;
	}
	
}
