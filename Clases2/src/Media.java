import java.util.Scanner;

public class Media {
    public double numeros;

    public void setMetrica() {
        Scanner teclado = new Scanner(System.in);
        boolean agregar = true;
        double suma = 0;
        int contador = 0;

        do {
            System.out.println("Ingresa un numero");
            suma += teclado.nextDouble();
            contador++;

            System.out.println("Desea agregar otro numero Y/N");
            String opc = teclado.next();
            if (opc.equalsIgnoreCase("N")) {
                agregar = false;
            }
        } while (agregar == true);

        System.out.println("La media es: " + (suma / contador));
    }
}
