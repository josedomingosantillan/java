import java.util.HashMap;
import java.util.Map;

public class Dias {
    public String dia;

    public void validarDia() {
        Map<String, String> dias = new HashMap<String, String>();
        dias.put("L", "Lunes");
        dias.put("M", "Martes");
        dias.put("X", "Miercoles");
        dias.put("J", "Jueves");
        dias.put("V", "Viernes");
        dias.put("S", "Sabado");
        dias.put("D", "Domingo");

        if (dias.containsKey(dia)) {
            System.out.println("el día es " + dias.get(dia));
        } else {

            System.out.println("El día no existe");
        }
    }
}
