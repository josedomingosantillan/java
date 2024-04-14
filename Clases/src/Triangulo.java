public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    public void setLados(double l1, double l2, double l3) {
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
    }

    public void isEquilatero() {
        if (this.lado1 == this.lado2 && this.lado2 == this.lado3) {
            System.out.println("Es un triangulo equilatero");
        } else {
            System.out.println("No es un triangulo equilatero y su lado más grande es: " + masGrande());
        }
    }

    public double masGrande() {
        double[] lados = {this.lado1, this.lado2, this.lado2};
        double mayor = lados[0];
        for (int i = 1; i < lados.length; i++) {
            if (lados[i] > mayor) {
                mayor = lados[i];
            }
        }
        return mayor;
    }
}
