package ciclos;

import java.util.Iterator;
import java.util.Scanner;

public class ciclos {
	private static Scanner teclado= new Scanner(System.in);
	public static void main(String[] args) {
		
		
		vocales();
	}

	public static void cero_veinte() {
		for(int i=0; i<=20; i++) {
			if(i%2!=0) {
			System.out.println(i);
			}
		}
	}
	
	public static void tabla() {
		
		System.out.println("Ingresa un número por favor");
		int num= teclado.nextInt();
		
		for(int i=1; i <=10; i++) {
			System.out.println(i + " x " + num +" = " + (i*num));
		}
	}

	public static void suma_multiplicacion() {
		int suma=0;
		double multiplicacion=2;
		for(int i = 1 ; i<=100; i++) {
			if(i%2==0) {
				suma+=i;
				if(i!=2) {
					multiplicacion= multiplicacion* i;
				}
				
			}
		}
		System.out.println("La suma de los números pares del 1 al 100 es: " + suma);
		System.out.println("La multiplicación de los números pares del 1 al 100 es: " + multiplicacion);
	}

	public static void patron_imprimir() {
		int n = 5;

        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
	}
	
	public static void divisores() {
		System.out.println("Ingresa un número");
		int num= teclado.nextInt();
		
		if(num>0) {
			 for(int i = 1 ; i <=num ; i++){
			        if(num%i==0){
			            System.out.println(i);
			        }
			    }
		}else {
			System.out.println("Error.");
		}
	}

	public static void numeros_mayores() {
		
        System.out.print("Ingrese la cantidad de números a introducir: ");
        int cantidadNumeros = teclado.nextInt();

        
        System.out.print("Ingrese el primer número: ");
        int primerNumero = teclado.nextInt();

        for (int i = 1; i < cantidadNumeros; i++) {
            System.out.print("Ingrese el número #" + (i + 1) + ": ");
            int numero = teclado.nextInt();

            if (numero <= primerNumero) {
                System.out.println("El número ingresado no es mayor que el primero.");
            }
        }
	}
	
	public static void numeros_negativos() {

        System.out.print("Ingrese la cantidad de números a introducir: ");
        int cantidadNumeros = teclado.nextInt();

        int contadorNegativos = 0;


        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print("Ingrese el número #" + (i + 1) + ": ");
            int numero = teclado.nextInt();

            if (numero < 0) {
                contadorNegativos++;
            }
        }


        System.out.println("Ha introducido " + contadorNegativos + " número(s) negativo(s).");

	}
	
	public static void suma_decimales() {
		System.out.print("Ingrese la cantidad de números que va a introducir: ");
        int cantidadNumeros = teclado.nextInt();

        double suma = 0.0;

        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.print("Ingrese un número: ");
            double numero = teclado.nextDouble();
            suma += numero;
        }

        System.out.println("La suma de los números es: " + suma);
	}

	public static void tres_en_tres() {
		for (int i = 1; i <= 30; i++) {
            System.out.print(i + " ");
            if (i % 3 == 0) {
                System.out.println();
            }
		}
	}
	
	public static void vocales() {
		System.out.print("Ingrese una frase: ");
        String frase = teclado.nextLine();

        int contadorVocales = contarVocales(frase);

        System.out.println("La cantidad de vocales en la frase es: " + contadorVocales);

	}
	
	public static int contarVocales(String frase) {
        int contador = 0;
        frase = frase.toLowerCase();

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }

        return contador;
    }
}
