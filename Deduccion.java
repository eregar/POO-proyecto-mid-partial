
public class Deduccion {
	
	private Double	deducir1,
					deducir2,
					totalDeducible,
					UtilidadNeta;
	
	
	public Deduccion (Persona persona1) {
		this.deducir1 = calculaAguinaldo(persona1.getAguinaldo(), persona1.getSalarioMensual()) + calculaPrimaVacacional(persona1.getPrimaVacacional()) + persona1.getHonorarios() + persona1.getGastosFunerarios() + persona1.getPrimasSGM() + persona1.getInteresesDevengados() + persona1.getDonativos() + persona1.getTransporteEscolar() + calculaColegiatura(persona1.getColegiatura(),persona1.getNivelEducativo());
		deducir2 = calculaAFORE(persona1.getAFORE(), persona1.getSalarioMensual());
		this.totalDeducible = this.deducir1 + this.deducir2;
		this.UtilidadNeta = calculoImpuestos (this.totalDeducible, (persona1.getSalarioMensual() * 12));
		
		// falta hacer lo de el panel y subirselo a edgar por git hub mas a parte checar lo del aguinaldo y eso (creo que eso se suma, no se resta)
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
 	
 	public Double calculoImpuestos(Double totalDeducible, Double salarioAnual) {
 		Double utilidadAntesDeImpuestos = 0.0,
 			   excedenteGanancias = 0.0,
 			   montoAPagarExcedente = 0.0,
 			   utilidadNeta = 0.0;
 	//		   porcentaje = 0.0;
 		
 		
 		utilidadAntesDeImpuestos = salarioAnual - totalDeducible;
 		
 		if (utilidadAntesDeImpuestos <= 5952.84) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 0.01;
 	//		porcentaje = 01.92;
 			montoAPagarExcedente = excedenteGanancias * .0192;
 			utilidadNeta = montoAPagarExcedente + 0.0;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 5952.84) && (utilidadAntesDeImpuestos <= 50524.92)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 5952.85;
 	//		porcentaje = 6.40;
 			montoAPagarExcedente = excedenteGanancias * .0640;
 			utilidadNeta = montoAPagarExcedente + 114.29;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 50524.92) && (utilidadAntesDeImpuestos <= 88793.04)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 50524.93;
 	//		porcentaje = 10.88;
 			montoAPagarExcedente = excedenteGanancias * .1088;
 			utilidadNeta = montoAPagarExcedente + 2966.91;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 88793.04) && (utilidadAntesDeImpuestos <= 103218.00)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 88793.05;
 	//		porcentaje = 16.00;
 			montoAPagarExcedente = excedenteGanancias * .16;
 			utilidadNeta = montoAPagarExcedente + 7130.48;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 103218.00) && (utilidadAntesDeImpuestos <= 123580.20)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 103218.01;
 	//		porcentaje = 17.92;
 			montoAPagarExcedente = excedenteGanancias * .1792;
 			utilidadNeta = montoAPagarExcedente + 9438.47;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 123580.20) && (utilidadAntesDeImpuestos <= 249243.48)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 123580.21;
 	//		porcentaje = 21.36;
 			montoAPagarExcedente = excedenteGanancias * .2136;
 			utilidadNeta = montoAPagarExcedente + 13087.37;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 249243.48) && (utilidadAntesDeImpuestos <= 392841.96)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 249243.49;
 	//		porcentaje = 23.52;
 			montoAPagarExcedente = excedenteGanancias * .2352;
 			utilidadNeta = montoAPagarExcedente + 39929.05;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 392841.96) && (utilidadAntesDeImpuestos <= 750000.00)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 392841.97;
 	//		porcentaje = 30.0;
 			montoAPagarExcedente = excedenteGanancias * .30;
 			utilidadNeta = montoAPagarExcedente + 73703.41;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 750000.00) && (utilidadAntesDeImpuestos <= 1000000.00)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 750000.01;
 	//		porcentaje = 32.0;
 			montoAPagarExcedente = excedenteGanancias * .32;
 			utilidadNeta = montoAPagarExcedente + 180850.82;
 		}
 		
 		else if ((utilidadAntesDeImpuestos > 1000000.00) && (utilidadAntesDeImpuestos <= 3000000.00)) {
 			excedenteGanancias = utilidadAntesDeImpuestos - 1000000.01;
 	//		porcentaje = 34.0;
 			montoAPagarExcedente = excedenteGanancias * .34;
 			utilidadNeta = montoAPagarExcedente + 260850.81;
 		}
 		
 		else if (utilidadAntesDeImpuestos > 3000000.00){
 			excedenteGanancias = utilidadAntesDeImpuestos - 3000000.01;
 	//		porcentaje = 35.0;
 			montoAPagarExcedente = excedenteGanancias * .35;
 			utilidadNeta = montoAPagarExcedente + 940850.81;
 		}
		return utilidadNeta;
 	}

 	
 	
	
}