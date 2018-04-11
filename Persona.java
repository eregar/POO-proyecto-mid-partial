public class Persona {
	private String nombre,
				   RFC,
				   nivelEducativo;
	private Double salarioMensual,
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
	
/*
	public Persona () {
		this.nombre = "";
		this.RFC = "";
	}
*/
	
	public Persona (String nombre, String RFC, String nivelEducativo, Double salarioMensual, Double Aguinaldo, Double primaVacacional, Double honorarios, Double gastosFunerarios, Double primasSGM, Double interesesDevengados, Double donativos, Double transporteEscolar, Double colegiatura) {
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
	
	
	
	
	public Double getAguinaldo () {
		return this.Aguinaldo;
	}
	
	public Double getSalarioMensual() {
		return this.salarioMensual;
	}
	
	public Double getPrimaVacacional() {
		return this.primaVacacional;
	}
	
	public Double getHonorarios() {
		return this.honorarios;
	}
	
	public Double getGastosFunerarios() {
		return this.gastosFunerarios;
	}
	
	public Double getPrimasSGM() {
		return this.primasSGM;
	}
	
	public Double getInteresesDevengados() {
		return this.interesesDevengados;
	}
	
	public Double getDonativos() {
		return this.donativos;
	}
	
	public Double getTransporteEscolar() {
		return this.transporteEscolar;
	}
	
	public Double getColegiatura() {
		return this.colegiatura;
	}
	
	public Double getAFORE() {
		return this.AFORE;
	}
	
	public String getNivelEducativo() {
		return this.nivelEducativo;
	}
	
}