public class Operaciones {
    public double num1;
    public double num2;

    public void suma(){
        System.out.println("La suma es: " + (this.num1 + this.num2));
    }

    public void resta(){
        System.out.println("La resta es: " + (this.num1 - this.num2));
    }

    public void multiplicacion(){
        System.out.println("La multiplicacion es: " + (this.num1 * this.num2));
    }

    public void division(){
        System.out.println("La division es: " + (this.num1 / this.num2));
    }

    public void operaciones(){
        this.suma();
        this.resta();
        this.multiplicacion();
        this.division();
    }
}
