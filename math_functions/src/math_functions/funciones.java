package math_functions;

public class funciones {

	public static void main(String[] args) {
		double x = 10.5;
        double y = 5.2;
        
        System.out.println("Valor absoluto de x: " + Math.abs(x));
        System.out.println("Valor absoluto de y: " + Math.abs(y));
        System.out.println("Máximo entre x e y: " + Math.max(x, y));
        System.out.println("Mínimo entre x e y: " + Math.min(x, y));
        System.out.println("Potencia de x elevado a y: " + Math.pow(x, y));
        System.out.println("Raíz cuadrada de x: " + Math.sqrt(x));
        System.out.println("Seno de x: " + Math.sin(x));
        System.out.println("Coseno de x: " + Math.cos(x));
        System.out.println("Tangente de x: " + Math.tan(x));
        System.out.println("Arcoseno de x: " + Math.asin(x));
        System.out.println("Arcocoseno de x: " + Math.acos(x));
        System.out.println("Arcotangente de x: " + Math.atan(x));
        System.out.println("Logaritmo natural de x: " + Math.log(x));
        System.out.println("Logaritmo base 10 de x: " + Math.log10(x));
        System.out.println("Valor redondeado de x: " + Math.round(x));
        System.out.println("Valor entero más cercano y no mayor a x: " + Math.floor(x));
        System.out.println("Valor entero más cercano y no menor a x: " + Math.ceil(x));
        System.out.println("Parte entera de x: " + Math.floor(x));
        System.out.println("Parte fraccionaria de x: " + (x - Math.floor(x)));

	}

}
