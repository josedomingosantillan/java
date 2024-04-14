/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1;
import java.util.Scanner;

public class Practica1 {

    private static Scanner dato= new Scanner(System.in);
    public static void main(String[] args) {
    	
    	boolean salir= false;
    	
    	while (!salir) {
    		try {
        		System.out.println("Menu");
            	System.out.println("1. Numeros");
            	System.out.println("2. Bienvenida");
            	System.out.println("3. Doble y triple de un numero");
            	System.out.println("4. Area de un triangulo");
            	System.out.println("5. Nombre Completo");
            	System.out.println("6. Salir");
            	
            	int opcion= dato.nextInt();
            	
            	switch (opcion) {
        		case 1: {
        			mostrar_numeros();
        			break;
        		}
        		case 2: {
        			mostrar_nombre();
        			break;
        		}
        		case 3: {
        			mostrar_doble();
        			break;
        		}
        		case 4: {
        			mostrar_area();
        			break;
        		}
        		case 5: {
        			mostrar_nombre_completo();
        			break;
        		}
        		case 6:{
        			System.out.println("Programa terminado");
        			System.exit(1);
        			
        			break;
        		}
        		default:
        			System.out.println("Opcion invalida");
        		}
    		} catch (Exception e) {
    			System.out.println(e);
    		}
    	}
       
    }
     
    public static void mostrar_numeros() {
    	
    	System.out.println("Ingresa el primer número");
    	int num= dato.nextInt();
    	
    	
    	System.out.println("Ingresa el segundo número");
    	int num_dos= dato.nextInt();
    	
    	
    	System.out.println("Los números ingresados son: " + num +" y " + num_dos);
    	
    }
    
    public static void mostrar_nombre() {
    	
    	System.out.println("Ingresa tu nombre");
    	
    	String name= dato.next();
    	
    	System.out.println("Bienvenido " + name);
    	
    }
    
    public static void mostrar_doble() {
    	
    	System.out.println("Ingresa un numero");
    	
    	int numero= dato.nextInt();
    	
    	System.out.println("El doble del numero es  " + (numero*2) + " el triple del numero es: " + (numero*3));
    	
    }
    
    public static void mostrar_area() {
    	
    	System.out.println("Ingresa la base");
    	
    	double numero= dato.nextInt();
    	
    	System.out.println("Ingresa la altura");
    	
    	double numero_dos= dato.nextInt();
    	
    	System.out.println("El area del triangulo es: " + ((numero*numero_dos)/2));
    	
    }
    
    public static void mostrar_nombre_completo() {
    	System.out.println("Ingresa tu nombre");
    	
    	String name= dato.next();
    	
    	System.out.println("Ingresa tu apellido paterno");
    	
    	String apelli= dato.next();
    	
    	System.out.println("Ingresa tu apellido materno");
    	
    	String a_materno= dato.next();
    	
    	System.out.println(name + " " + apelli+ " " + a_materno);
    	
    }
    
    
}
