
public class Deduccion {
	
	private Double	deducir1,
					deducir2,
					totalDeducible,
					totalImpuestos;
	private Persona persona1;
	
	
	public Deduccion (String nombre, String RFC, String nivelEducativo, Double salarioMensual, Double Aguinaldo, Double primaVacacional, Double honorarios, Double gastosFunerarios, Double primasSGM, Double interesesDevengados, Double donativos, Double transporteEscolar, Double colegiatura) {
		Persona persona1 = new Persona(nombre, RFC, nivelEducativo, salarioMensual, Aguinaldo, primaVacacional, honorarios, gastosFunerarios, primasSGM, interesesDevengados,donativos,transporteEscolar,colegiatura);
		this.deducir1 = calculaAguinaldo(this.persona1.getAguinaldo(), this.persona1.getSalarioMensual()) + calculaPrimaVacacional(this.persona1.getPrimaVacacional()) + this.persona1.getHonorarios() + this.persona1.getGastosFunerarios() + this.persona1.getPrimasSGM() + this.persona1.getInteresesDevengados() + this.persona1.getDonativos() + this.persona1.getTransporteEscolar() + calculaColegiatura(this.persona1.getColegiatura(),this.persona1.getNivelEducativo());
		deducir2 = calculaAFORE(this.persona1.getAFORE(), this.persona1.getSalarioMensual());
		this.totalDeducible = this.deducir1 + this.deducir2;
		
		
	}
	
	
	
	public Double calculaAguinaldo (Double aguinaldo, Double salarioMensual) {
		Double aguinaldoExcento = 0.0;
		if (aguinaldo <= salarioMensual/2) {
			aguinaldoExcento = aguinaldo;
		}
		else if (aguinaldo > salarioMensual/2){
			aguinaldoExcento = salarioMensual/2;
		}
		
		return aguinaldoExcento;
	}
	
	public Double calculaPrimaVacacional (Double primaVacacional) {
		Double primaVacacionalExcento = 0.0;
		if (primaVacacional < 1209) {
			primaVacacionalExcento = primaVacacional;
		}
		else if (primaVacacional >= 1209) {
			primaVacacionalExcento = 1209.0;
		}
		return primaVacacionalExcento;
	}
	
	public Double calculaAFORE(Double AFORE, Double salarioMensual) {	
		if (AFORE >= ((salarioMensual * 12) / 10 ) ) {
			return ((salarioMensual * 12) / 10 );
		}
		else {
			return AFORE;
		}
	}
	

 	public Double calculaColegiatura(Double colegiatura,String nivelEducativo) { 			
 		Double deducibleColegiatura = 0.0;
 		
 		if (nivelEducativo == "Preescolar") {
 			if (colegiatura >= 14200) {
 				deducibleColegiatura = 14200.0;
 			}
 			else {
 				deducibleColegiatura = colegiatura;
 			}
 		}
 		
 		else if(nivelEducativo == "Primaria") {
 			if (colegiatura >= 12900) {
 				deducibleColegiatura = 12900.0;
 			}
 			else {
 				deducibleColegiatura = colegiatura;
 			}
 		}
 		
 		else if(nivelEducativo == "Secundaria") {
 			if (colegiatura >= 19900) {
 				deducibleColegiatura = 19900.0;
 			}
 			
 			else {
 				deducibleColegiatura = colegiatura;
 			}
 		}
 		
 		else if(nivelEducativo == "Profesional Tecnico") {
 			if (colegiatura >= 17100) {
 				deducibleColegiatura = 17100.0;
 			}
 			
 			else {
 				deducibleColegiatura = colegiatura;
 			}
 		}
 		
 		else if(nivelEducativo == "Bachillerato") {
 			if (colegiatura >= 24500) {
 				deducibleColegiatura = 24500.0;
 			}
 			
 			else {
 				deducibleColegiatura = colegiatura;
 			}
 		}
 		return deducibleColegiatura;
	}
 	
 	public Double calculoImpuestos(Double totalDeducible, Double totalImpuestos) {
 		Double totalGanancias = 0.0,
 			   excedenteGanancias = 0.0,
 			   montoAPagarExcedente = 0.0,
 			   montoFinal = 0.0;
 	//		   porcentaje = 0.0;
 		
 		
 		totalGanancias = totalImpuestos - totalDeducible;
 		
 		if (totalGanancias <= 5952.84) {
 			excedenteGanancias = totalGanancias - 0.01;
 	//		porcentaje = 01.92;
 			montoAPagarExcedente = excedenteGanancias * .0192;
 			montoFinal = montoAPagarExcedente + 0.0;
 		}
 		
 		else if ((totalGanancias > 5952.84) && (totalGanancias <= 50524.92)) {
 			excedenteGanancias = totalGanancias - 5952.85;
 	//		porcentaje = 6.40;
 			montoAPagarExcedente = excedenteGanancias * .0640;
 			montoFinal = montoAPagarExcedente + 114.29;
 		}
 		
 		else if ((totalGanancias > 50524.92) && (totalGanancias <= 88793.04)) {
 			excedenteGanancias = totalGanancias - 50524.93;
 	//		porcentaje = 10.88;
 			montoAPagarExcedente = excedenteGanancias * .1088;
 			montoFinal = montoAPagarExcedente + 2966.91;
 		}
 		
 		else if ((totalGanancias > 88793.04) && (totalGanancias <= 103218.00)) {
 			excedenteGanancias = totalGanancias - 88793.05;
 	//		porcentaje = 16.00;
 			montoAPagarExcedente = excedenteGanancias * .16;
 			montoFinal = montoAPagarExcedente + 7130.48;
 		}
 		
 		else if ((totalGanancias > 103218.00) && (totalGanancias <= 123580.20)) {
 			excedenteGanancias = totalGanancias - 103218.01;
 	//		porcentaje = 17.92;
 			montoAPagarExcedente = excedenteGanancias * .1792;
 			montoFinal = montoAPagarExcedente + 9438.47;
 		}
 		
 		else if ((totalGanancias > 123580.20) && (totalGanancias <= 249243.48)) {
 			excedenteGanancias = totalGanancias - 123580.21;
 	//		porcentaje = 21.36;
 			montoAPagarExcedente = excedenteGanancias * .2136;
 			montoFinal = montoAPagarExcedente + 13087.37;
 		}
 		
 		else if ((totalGanancias > 249243.48) && (totalGanancias <= 392841.96)) {
 			excedenteGanancias = totalGanancias - 249243.49;
 	//		porcentaje = 23.52;
 			montoAPagarExcedente = excedenteGanancias * .2352;
 			montoFinal = montoAPagarExcedente + 39929.05;
 		}
 		
 		else if ((totalGanancias > 392841.96) && (totalGanancias <= 750000.00)) {
 			excedenteGanancias = totalGanancias - 392841.97;
 	//		porcentaje = 30.0;
 			montoAPagarExcedente = excedenteGanancias * .30;
 			montoFinal = montoAPagarExcedente + 73703.41;
 		}
 		
 		else if ((totalGanancias > 750000.00) && (totalGanancias <= 1000000.00)) {
 			excedenteGanancias = totalGanancias - 750000.01;
 	//		porcentaje = 32.0;
 			montoAPagarExcedente = excedenteGanancias * .32;
 			montoFinal = montoAPagarExcedente + 180850.82;
 		}
 		
 		else if ((totalGanancias > 1000000.00) && (totalGanancias <= 3000000.00)) {
 			excedenteGanancias = totalGanancias - 1000000.01;
 	//		porcentaje = 34.0;
 			montoAPagarExcedente = excedenteGanancias * .34;
 			montoFinal = montoAPagarExcedente + 260850.81;
 		}
 		
 		else if (totalGanancias > 3000000.00){
 			excedenteGanancias = totalGanancias - 3000000.01;
 	//		porcentaje = 35.0;
 			montoAPagarExcedente = excedenteGanancias * .35;
 			montoFinal = montoAPagarExcedente + 940850.81;
 		}
		return montoFinal;
 	}

 	
 	
	
}