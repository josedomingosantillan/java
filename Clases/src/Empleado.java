import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Empleado {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private LocalDate fecha;

    public void setempleado(String nombre, String apellidoP, String apellidoM, LocalDate fecha) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fecha = fecha;
    }

    public void getEmpleado(){
        System.out.println("El nombre del empleado es: " + (this.nombre + " " + this.apellidoP + " " + this.apellidoM));
        LocalDate fechaActuall = LocalDate.now();
        long diferenciaEnanios = ChronoUnit.YEARS.between(this.fecha,fechaActuall);
        System.out.println("Y su edad actual es: " + diferenciaEnanios);
    }
}
