package practica7;
import java.util.Scanner;


public class practica {

    private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Practica7();
	}
	static void Practica7() {
        int opc;
        do {
            System.out.println("\t Menú de Programación\n");
            System.out.println("1.-Programa ¿Mayor a 100?");
            System.out.println("2.-Programa Dia del mes");
            System.out.println("3.-Programa Solamente tres nuemros");
            System.out.println("4.-Programa Menu hasta que N");
            System.out.println("5.-Programa Contraseñas");
            System.out.println("6.-Programa Ahorrar");
            System.out.println("7.-Programa Negativo final");
            System.out.println("8.-Programa Buscar una letra en la frase");
            System.out.println("9.-Programa Precios");
            System.out.println("10.-Programa Numeros a Promediar");
            System.out.println("11.-Programa Hasta cero y cual es el mayor");
            System.out.println("12.-Programa Orden creciente");
            System.out.println("13.-Salir");

            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("\t \t1.-Programa ¿Mayor a 100?");
                    Mayora100();
                    break;
                case 2:
                    System.out.println("\t \t2.-Programa Dia del mes");
                    DiadelMes();
                    break;
                case 3:
                    System.out.println("\t \t3.-Programa Solamente tres nuemros");
                    TresNumeros();
                    break;
                case 4:
                    System.out.println("\t \t4.-Programa Menu hasta que N");
                    MenuHastaQueNo();
                    break;
                case 5:
                    System.out.println("\t \t5.-Programa Contraseñas");
                    Password();
                    break;
                case 6:
                    System.out.println("\t \t6.-Programa Ahorrar");
                    Ahorrar();
                    break;
                case 7:
                    System.out.println("\t \t7.-Programa Negativo final");
                    NegativoAlFinal();
                    break;
                case 8:
                    System.out.println("\t \t8.-Programa Buscar una letra en la frase");
                    LaLetra();
                    break;
                case 9:
                    System.out.println("\t \t9.-Programa Precios");
                    Precios();
                    break;
                case 10:
                    System.out.println("\t \t10.-Programa Numeros a Promediar");
                    Promedio();
                    break;
                case 11:
                    System.out.println("\t \t11.-Programa Hasta cero y cual es el mayor");
                    HastaCero();
                    break;
                case 12:
                    System.out.println("\t \t12.-Programa Orden creciente");
                    Creciente();
                    break;
                case 13:
                    System.out.println("\t \tSalir");
                    System.out.println("Adios y Gracias");
                    break;
                default:
                    System.out.println("\n Opción Invalida");
                    break;

            }

        } while (opc != 13);
    }

    static public void Mayora100() {
        int number = 0;
        while (number <= 100) {
            System.out.println("Introduce un número: ");
            number = teclado.nextInt();
        }
        System.out.println("El número " + number + " es mayor a 100.");
    }

    static public void DiadelMes() {
        int month;
        do {
            System.out.println("Introduce el número de mes: ");
            month = teclado.nextInt();
            int days = 0;
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;
                    break;
                case 2:
                    days = 28;
                    break;
                default:
                    System.out.println("Mes no válido.");
                    break;
            }
            if (days != 0) {
                System.out.println("El mes " + month + " tiene " + days + " días.");
            }
        } while (month < 1 || month > 12);
    }

    static public void TresNumeros() {
        int sum = 0;
        int count = 0;
        while (count < 3) {
            System.out.println("Introduce un número: ");
            int number = teclado.nextInt();
            sum += number;
            count++;
        }
        System.out.println("La suma de los tres números es: " + sum);
    }

    static public void MenuHastaQueNo() {
        String answer;
        do {
            System.out.println("¿Deseas continuar con el programa? (s/n): ");
            answer = teclado.next();
        } while (!answer.equalsIgnoreCase("n"));
    }

    static public void Password() {
        String password1, password2;
        do {
            System.out.println("Introduce la contraseña: ");
            password1 = teclado.next();
            System.out.println("Vuelve a introducir la contraseña: ");
            password2 = teclado.next();
        } while (!password1.equals(password2));
        System.out.println("Las contraseñas coinciden.");
    }

    static public void Ahorrar() {
        System.out.println("Introduce la cantidad que deseas ahorrar: ");
        double goal = teclado.nextDouble();
        double totalSaved = 0;
        while (totalSaved < goal) {
            System.out.println("Introduce la cantidad que vas a ahorrar: ");
            double amount = teclado.nextDouble();
            if (amount >= 0) {
                totalSaved += amount;
            } else {
                System.out.println("No se aceptan montos en negativo.");
            }
        }
        System.out.println("¡Objetivo alcanzado! Has ahorrado " + totalSaved + ".");
    }

    static public void NegativoAlFinal() {
        double sum = 0;
        double number;
        do {
            System.out.println("Introduce un número positivo: ");
            number = teclado.nextDouble();
            if (number >= 0) {
                sum += number;
            }
        } while (number >= 0);
        System.out.println("La suma de los números positivos es: " + sum);
    }

    static public void LaLetra() {
        System.out.println("Ingrese una frase:");
        String frase = teclado.next();

        System.out.println("Ingrese una letra:");
        char letra = teclado.next().charAt(0);

        int posicion = buscarLetra(frase, letra);

        if (posicion == -1) {
            System.out.println("No se encontró la letra en la frase.");
        } else {
            System.out.println("La letra se encontró en la posición: " + posicion);
        }
    }
    public static int buscarLetra(String frase, char letra) {
        int posicion = 0;
        int longitud = frase.length();
        boolean encontrado = false;
        while (posicion < longitud && !encontrado) {
            if (frase.charAt(posicion) == letra) {
                encontrado = true;
            } else {
                System.out.println("No hay coincidencia en la posición " + posicion);
                posicion++;
            }
        }
        if (!encontrado) {
            posicion = -1;
        }
        return posicion;
    }

    static public void Precios() {
        int cantidad;
        double precio;
        double total = 0.0;

        System.out.println("Ingrese la cantidad vendida (0 para finalizar):");
        cantidad = teclado.nextInt();

        while (cantidad != 0) {
            System.out.println("Ingrese el precio del producto:");
            precio = teclado.nextDouble();
            total += cantidad * precio;

            System.out.println("Ingrese la cantidad vendida (0 para finalizar):");
            cantidad = teclado.nextInt();
        }
        System.out.println("El total de la factura es: " + total);
    }
   
    static public void Promedio() {
       int n = 0;
        double sum = 0;
        double average = 0;
        int count = 0;

        System.out.print("Ingrese un número (o -1 para salir): ");
        n = teclado.nextInt();

        while (n != -1) {
            sum += n;
            count++;
            System.out.print("Ingrese un número (o -1 para salir): ");
            n = teclado.nextInt();
        }

        if (count > 0) {
            average = sum / count;
            System.out.println("El promedio es: " + average);
        } else {
            System.out.println("No se ingresaron números.");
        }
    }

    static public void HastaCero() {
      int numero;
        int mayor = Integer.MIN_VALUE;

        System.out.println("Ingrese una serie de números (0 para finalizar):");

        do {
            numero = teclado.nextInt();
            if (numero > mayor) {
                mayor = numero;
            }
        } while (numero != 0);

        if (mayor != Integer.MIN_VALUE) {
            System.out.println("El número mayor ingresado es: " + mayor);
        } else {
            System.out.println("No se ingresaron números válidos.");
        }
    }

    static public void Creciente() {
         int numero1, numero2;

        do {
            System.out.println("Ingrese el primer número:");
            numero1 = teclado.nextInt();

            System.out.println("Ingrese el segundo número:");
            numero2 = teclado.nextInt();

            if (numero1 > numero2) {
                System.out.println("El primer número es mayor que el segundo. Vuelva a ingresar los números.");
            }
        } while (numero1 > numero2);

        System.out.println("Números en orden creciente.");
    }

}
