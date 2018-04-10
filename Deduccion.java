
public class Deduccion {
	
	private int	deducir1,
				deducir2,
				totalDeducir;
	private Persona persona1;
	
	
	public Deduccion (String nombre, String RFC, String nivelEducativo, int salarioMensual, int Aguinaldo, int primaVacacional, int honorarios, int gastosFunerarios, int primasSGM, int interesesDevengados, int donativos ,int transporteEscolar, int colegiatura) {
		Persona persona1 = new Persona(nombre,RFC,nivelEducativo,salarioMensual,Aguinaldo,primaVacacional,honorarios,gastosFunerarios,primasSGM,interesesDevengados,donativos,transporteEscolar,colegiatura);
		this.deducir1 = calculaAguinaldo() + calculaPrimaVacacional() + this.persona1.getHonorarios() + this.persona1.getGastosFunerarios() + this.persona1.getPrimasSGM() + this.persona1.getInteresesDevengados() + this.persona1.getDonativos() + this.persona1.getTransporteEscolar() + calculaColegiatura("Preescolar");
		deducir2 = calculaAFORE();
		this.totalDeducir = this.deducir1 + this.deducir2;
	}
	
	
	public int calculaAguinaldo () {
		int aguinaldoExcento = 0;
		if (this.persona1.getAguinaldo() <= (this.persona1.getSalarioMensual() / 2)) {
			aguinaldoExcento = this.persona1.getAguinaldo();
		}
		else if (this.persona1.getAguinaldo() > (this.persona1.getSalarioMensual() / 2)){
			aguinaldoExcento = this.persona1.getSalarioMensual() / 2;
		}
		return aguinaldoExcento;
	}
	
	public int calculaPrimaVacacional () {
		int primaVacacionalExcento = 0;
		if (this.persona1.getPrimaVacacional() < 1209) {
			primaVacacionalExcento = this.persona1.getPrimaVacacional();
		}
		else if (this.persona1.getPrimaVacacional() >= 1209) {
			primaVacacionalExcento = 1209;
		}
		return primaVacacionalExcento;
	}
	
	public int calculaAFORE() {												// el afore es lo de aportaciones subcuenta (se puede deducir hasta el 10% extra)
		if (this.persona1.getAFORE() >= ((this.persona1.getSalarioMensual() * 12) / 10 ) ) {
			return ((this.persona1.getSalarioMensual() * 12) / 10 );
		}
		else {
			return this.persona1.getAFORE();
		}
	}
	

 	public int calculaColegiatura(String nivelEducativo) { 			// aqui en lugar de que le entre al metodo el string del nivel educativo, llamamos dentro del metodo
 		int gastoColegiatura = this.persona1.getColegiatura();		// el nivel educativo. Se me ocurria que para elegir su nivel educativo lo podriamos hacer con radio
 		if (nivelEducativo == "Preescolar") {						// botones.
 			if (this.persona1.getColegiatura() >= 14200) {			// Cuando se haga este cambio hay que cambiar el constructor de deduccion en la parte de calculaColegiatura
 				gastoColegiatura = 14200;
 			}
 			else {
 				gastoColegiatura = this.persona1.getColegiatura();
 			}
 		}
 		
 		else if(nivelEducativo == "Primaria") {
 			if (this.persona1.getColegiatura() >= 12900) {
 				gastoColegiatura = 12900;
 			}
 			else {
 				gastoColegiatura = this.persona1.getColegiatura();
 			}
 		}
 		
 		else if(nivelEducativo == "Secundaria") {
 			if (this.persona1.getColegiatura() >= 19900) {
 				gastoColegiatura = 19900;
 			}
 			
 			else {
 				gastoColegiatura = this.persona1.getColegiatura();
 			}
 		}
 		
 		else if(nivelEducativo == "Profesional Tecnico") {
 			if (this.persona1.getColegiatura() >= 17100) {
 				gastoColegiatura = 17100;
 			}
 			
 			else {
 				gastoColegiatura = this.persona1.getColegiatura();
 			}
 		}
 		
 		else if(nivelEducativo == "Bachillerato") {
 			if (this.persona1.getColegiatura() >= 24500) {
 				gastoColegiatura = 24500;
 			}
 			
 			else {
 				gastoColegiatura = this.persona1.getColegiatura();
 			}
 		}
 		return gastoColegiatura;
	}

 	
 	
	
}
