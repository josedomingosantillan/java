package fechas;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class fecha {

	public static void main(String[] args) {
		LocalDateTime fechaActual = LocalDateTime.now();
		
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formato);
		System.out.println("Esta es la fecha del día actual: "+ fechaFormateada);
		
		DateTimeFormatter formatohora = DateTimeFormatter.ofPattern("HH:MM:SS");
		String hora = fechaActual.format(formatohora);
		System.out.println("Esta es la fecha y hora  del día actual: "+ hora );
		
		DateTimeFormatter formatomes = DateTimeFormatter.ofPattern("MM");
		String mes = fechaActual.format(formatomes);
		System.out.println("Esta es el mes actual: "+ mes );
		
		DateTimeFormatter formatodia = DateTimeFormatter.ofPattern("dd");
		String dia = fechaActual.format(formatodia);
		System.out.println("Esta es el día actual: "+ dia );
		
		DateTimeFormatter formatoanio = DateTimeFormatter.ofPattern("YYYY");
		String anio = fechaActual.format(formatoanio);
		System.out.println("Esta es el día actual: "+ anio );
		
		LocalDate fechaActuall = LocalDate.now();
        LocalDate primerDiaDelMes = fechaActuall.withDayOfMonth(1);
        System.out.println("El primer día del mes es: " + primerDiaDelMes);
        
        LocalDate fechaActualll = LocalDate.now();
        LocalDate ultimoDiaDelMes = fechaActualll.withDayOfMonth(fechaActualll.lengthOfMonth());
        System.out.println("El último día del mes es: " + ultimoDiaDelMes);
        
        LocalDate fechaInicio = LocalDate.of(2023, 6, 1);
        LocalDate fechaFin = LocalDate.of(2023, 6, 30);
        
        long numeroSemanas = ChronoUnit.WEEKS.between(fechaInicio, fechaFin);
        
        System.out.println("El número de semanas entre las fechas es: " + numeroSemanas);
        
        LocalDate fechaActual15 = LocalDate.now();
        LocalDate fechaNueva = fechaActual15.plusDays(15);
        LocalDate fechaNuevaM = fechaActual15.plusMonths(3);
        System.out.println("Fecha después de agregar 15 días: " + fechaNueva);
        
        System.out.println("Fecha después de agregar 3 mesus: " + fechaNuevaM);
        
        LocalDate fechacumpleaños = LocalDate.of(1998, 4, 28);
        LocalDate fechaNuC = fechacumpleaños.plusYears(25);
        
        System.out.println("Fecha después de agregar mis 25 años: " + fechaNuC);
        
        long diferenciaEnanios = ChronoUnit.YEARS.between(fechacumpleaños,fechaActuall);
        
        System.out.println("tú edad es: " + diferenciaEnanios);

	}

}
