import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("<<<<<<<<<<<<<<<<<<< Ejercicio 1 >>>>>>>>>>>>>>>>>>");
            Triangulo tri = new Triangulo();
            tri.setLados(23.0, 43.5, 10.5);
            tri.isEquilatero();

            System.out.println("<<<<<<<<<<<<<<<<<<< Ejercicio 2 >>>>>>>>>>>>>>>>>>");
            Cuadrantes cuad = new Cuadrantes();
            cuad.setCuadrantes(3.5, 2);
            cuad.getCuadrantes();

            System.out.println("<<<<<<<<<<<<<<<<<<< Ejercicio 3 >>>>>>>>>>>>>>>>>>");
            Cuadrado cua = new Cuadrado();
            cua.lados = 4;
            cua.perimetro();
            cua.area();

            System.out.println("<<<<<<<<<<<<<<<<<<< Ejercicio 4 >>>>>>>>>>>>>>>>>>");
            Operaciones ope = new Operaciones();
            ope.num1 = 25;
            ope.num2 = 10;
            ope.operaciones();

            System.out.println("<<<<<<<<<<<<<<<<<<< Ejercicio 5 >>>>>>>>>>>>>>>>>>");
            LocalDate fechacumpleaños = LocalDate.of(1998, 4, 28);
            Empleado emp = new Empleado();
            emp.setempleado("Jose Domingo", "Santillan", "Rodriguez", fechacumpleaños);
            emp.getEmpleado();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}