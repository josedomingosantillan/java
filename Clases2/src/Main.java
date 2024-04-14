import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            Dias dia = new Dias();
            System.out.println("Ingresa un día: L,M,X,J,V,S,D");
            dia.dia = teclado.next();
            dia.validarDia();

            Translate trans = new Translate();
            System.out.println("Ingresa una palabra");
            trans.palabra = teclado.next();
            trans.translate();

            Media med = new Media();
            med.setMetrica();

            Longitudes longi= new Longitudes();
            System.out.println("Ingresa una cadena");
            longi.cadena= teclado.next();
            System.out.println("La longitud de la cadena es: " + longi.cadena.length());
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}