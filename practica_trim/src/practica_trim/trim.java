package practica_trim;

public class trim {

	public static void main(String[] args) {
		String quitar_espacion= " Hola como estas   ";
		
		System.out.println("Quitar espacio => " + quitar_espacion.trim());
		
		System.out.println("Convertir a minusculas => " + quitar_espacion.toLowerCase());
		
		System.out.println("Convertir a mayusculas => " +quitar_espacion.toUpperCase());
		
		System.out.println("Extraer caracteres => " +quitar_espacion.substring(0, 5));
	
		System.out.println("Reemplazar caracteres => " + quitar_espacion.replace("como estas","que onda"));
		
		System.out.println("Longitud de una cadena => " + quitar_espacion.length());
		
		System.out.println("Equals => " + quitar_espacion.equals("Hola"));
		
		System.out.println("Equals ignore case => " + quitar_espacion.trim().equalsIgnoreCase("Hola cOmO EsTAs"));
		
	}

}
