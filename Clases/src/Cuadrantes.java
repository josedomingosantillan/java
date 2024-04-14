public class Cuadrantes {
    private double x;
    private double y;

    public void setCuadrantes(double x, double y){
        this.x=x;
        this.y=y;
    }

    public void getCuadrantes(){
        if (this.x >0 && this.y>0){
            System.out.println("Esta en el cuadrante 1");
        } else if (this.x >0 && this.y<0) {
            System.out.println("Esta en el cuadrante 2");
        }else if (this.x <0 && this.y<0) {
            System.out.println("Esta en el cuadrante 3");
        }else if (this.x <0 && this.y>0) {
            System.out.println("Esta en el cuadrante 4");
        }else{
            System.out.println("Esta en el punto 0");
        }
    }

}
