package ifs;
import java.util.Scanner;

public class sentencias {
private static Scanner dato= new Scanner(System.in);
	public static void main(String[] args) {
		try {
			boolean activo= true;
			while (activo) {
				System.out.println("Menú");
				System.out.println("1. Mayor de edad");
				System.out.println("2. Validar contraseña");
				System.out.println("3. Realizar una división");
				System.out.println("4. Números pares e impares");
				System.out.println("5. Validar pago de impuestos");
				System.out.println("6. Número mayor y menor");
				System.out.println("7. Diferencia de años");
				System.out.println("8. Números multiplos");
				System.out.println("9. Números iguales");
				System.out.println("10. Clasificar estudiantes");
				System.out.println("11. Salir");
		
				int opcion= dato.nextInt();
				
				switch (opcion) {
				case 1:
					mayor_edad();
					break;
				case 2:
					password();
					break;
				case 3:
					division();
					break;
				case 4:
					par_impar();
					break;
				case 5:
					impuestos();
					break;
				case 6:
					mayor_que();
					break;
				case 7:
					dif_años();
					break;
				case 8:
					multiplos();
					break;
				case 9:
					num_iguales();
					break;
				case 10:
					clasificar_nombres();
					break;
				case 11:
					activo= false;
					break;
				default:
					System.err.print("Opción invalida");
					activo= false;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Ocurrio un error");
		}
	}
	
	public static void mayor_edad() {
		System.out.println("Ingresa tu edad");
		int edad= dato.nextInt();
		
		if(edad>17) {
			System.out.println("Mayor de edad");
		}else if(edad <=0){
			System.out.println("Opción invalida");
		}else {
			System.out.println("Menor de edad");
		}
	}
	
	public static void password() {
		String pass= "Isc301vESperTino";
		System.out.println("Ingresa la contraseña a validar");
		String pass_val= dato.next();
		
		if(pass.equalsIgnoreCase(pass_val)) {
			System.out.println("La contraseña es la misma");
		}else {
		 System.out.println("Contraseña incorrecta"); 
		}
	}
	
	public static void division() {
		System.out.println("Ingresa el primer número");
		int num_uno= dato.nextInt();
		
		System.out.println("Ingresa el primer número");
		int num_dos= dato.nextInt();
		
		double division= num_uno/num_dos;
		
		if(num_dos==0 || num_uno == 0) {
			System.out.println("Error");
		}else {
			System.out.println("El resultado de la operación es: " + division);
		}
	}
	
	public static void par_impar() {
		System.out.println("Ingresa un número");
		int num_uno= dato.nextInt();
		
		
		if(num_uno%2==0) {
			System.out.println("El número es par");
		}else {
			System.out.println("El número es impar");
		}
	}
	
	public static void impuestos() {
		System.out.println("Ingresa tu edad");
		int edad= dato.nextInt();
		
		System.out.println("Ingresa tu sueldo");
		double sueldo= dato.nextDouble();
		
		
		if(edad>=18 && sueldo>=2000) {
			System.out.println("Tienes que pagar impuestos");
		}else {
			System.out.println("No pagas impuestos");
		}
	}
	
	public static void mayor_que() {
		System.out.println("Ingresa el primer valor:");
		int num_uno= dato.nextInt();
		
		System.out.println("Ingresa el segundo valor:");
		int num_dos= dato.nextInt();
		
		if(num_uno>num_dos) {
			System.out.println("El valor " + num_uno +" es el número mayor y el número menor es " + num_dos);
		}else if(num_uno<num_dos) {
			System.out.println("El valor " + num_dos +" es el número mayor y el número menor es " + num_uno);
		}else {
			System.out.println("El valor " + num_uno +" y el valor " + num_dos + " son iguales");
		}
	}

	public static void dif_años() {
		System.out.println("Ingresa un año:");
		int anio= dato.nextInt(), year= 2023;
		
		if(year>anio) {
		System.out.println("Han pasado " + (year - anio) + "año(s)");	
		}else {
			System.out.println("Hacen falta " + (anio - year) + "año(s)");
		}
	}

	public static void multiplos() {
		System.out.println("Ingresa el primer valor:");
		int num_uno= dato.nextInt();
		
		System.out.println("Ingresa el segundo valor:");
		int num_dos= dato.nextInt();
		
		if(num_uno <0 || num_dos<0) {
			System.out.println("No se aceptan números negativos");
		}else {
			if(num_uno> num_dos) {
				if(num_uno%num_dos ==0) {
					System.out.println("El número " + num_uno + " es multiplo del número " + num_dos);
				}else {
					System.out.println("El número " + num_uno + " no es multiplo del número " + num_dos);
				}
			}else {
				if(num_dos%num_uno ==0) {
					System.out.println("El número " + num_dos + " es multiplo del número " + num_uno);
				}else {
					System.out.println("El número " + num_dos + " no es multiplo del número " + num_uno);
				}
			}
		}
	}
	
	public static void num_iguales() {
		System.out.println("Ingresa el primer valor:");
		int num_uno= dato.nextInt();
		
		System.out.println("Ingresa el segundo valor:");
		int num_dos= dato.nextInt();
		
		System.out.println("Ingresa el tercer valor:");
		int num_tres= dato.nextInt();
		

		if(num_uno == num_dos && num_dos== num_tres) {
			System.out.println("Los números son iguales");
		}else if(num_uno == num_dos || num_dos==num_tres || num_tres==num_uno) {
			System.out.println("Hay dos números iguales");
		}else {
			System.out.println("Los tres números son diferentes");
		}
	}
	
	public static void clasificar_nombres() {
		System.out.println("Ingresa tu nombre:");
		String nombre= dato.next();
		
		System.out.println("Ingresa tu sexo M/F:");
		String sexo= dato.next();
		
		String grupo;
        
        
        if ((sexo.equalsIgnoreCase("F") && nombre.compareToIgnoreCase("M") < 0) || 
            (sexo.equalsIgnoreCase("M") && nombre.compareToIgnoreCase("N") > 0)) {
            grupo = "A";
        } else {
            grupo = "B";
        }
        
        System.out.println("Usted pertenece al grupo " + grupo);
	}
	
}
