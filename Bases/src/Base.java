import java.sql.*;
public class Base {
private String login= "root";
private String pass= "12345";
private String url= "jdbc:mysql://localhost/ejemplo";
private String mensaje;
Connection con = null;
private int id;
private int edad;
private String nombre;

int getId() {
	return id;
}
void setId(int id) {
	this.id = id;
}

int getEdad() {
	return edad;
}
void setEdad(int edad) {
	this.edad = edad;
}
String getNombre() {
	return nombre;
}

void setNombre(String nombre) {
	this.nombre = nombre;
}

String getMensaje() {
	return mensaje;
}
private void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}

public void conectar() {
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con=DriverManager.getConnection(url,login,pass);
		if(con!=null) {
			setMensaje("Conexión exitosa.");
		}
	} catch (Exception e) {
		setMensaje("Ocurrio un error " + e);
	}
}

public void insertar() {
	try {
		PreparedStatement stmt= con.prepareStatement("insert into persona values ("+id+","+nombre+","+edad+")");
	} catch (Exception e) {
		// TODO: handle exception
	}
}

}
