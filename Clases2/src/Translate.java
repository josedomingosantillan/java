import java.util.HashMap;
import java.util.Map;

public class Translate {
    public String palabra;

    public void translate(){
        Map<String,String> palabras= new HashMap<String,String>();
        palabras.put("computer","Computadora");
        palabras.put("mouse","Ratón");
        palabras.put("keyboard","Teclado");
        palabras.put("printer","Impresora");
        palabras.put("webcam","Camara web");

        if (palabras.containsKey(palabra)) {
            System.out.println("La traducción de "+palabra + " es " + palabras.get(palabra));
        } else {
            System.out.println("La traducción no existe");
        }
    }
}
