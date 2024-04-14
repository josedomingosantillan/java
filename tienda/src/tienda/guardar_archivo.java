package tienda;

import java.io.File;
import java.io.FileWriter;

public class guardar_archivo {

public String nombre;
public String cantidad;
public String precio;


public Boolean escribirArchivo(){
    try {
        FileWriter escritura=new FileWriter(nombre+".txt");
        escritura.write("Nombre: "+nombre.toUpperCase() + "\n");
        escritura.write("Cantidad: "+cantidad.toUpperCase()+ "\n");
        escritura.write("Precio: "+precio.toUpperCase());
        escritura.close();
        return true;
    } catch (Exception e) {
        return false;
    }
}

public Boolean eliminarArchivo() {
	try {
		File eliminar= new File(nombre+".txt");
		eliminar.delete();
		return true;
	} catch (Exception e) {
		return false;
	}
}
}
