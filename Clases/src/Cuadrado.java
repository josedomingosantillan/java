public class Cuadrado {
    public double lados;

    public void perimetro() {
        System.out.println("El perimetro del cuadrado es: " + (this.lados * 4));
    }

    public void area() {
        System.out.println("El area del cuadrado es: " + (this.lados * this.lados));
    }
}
