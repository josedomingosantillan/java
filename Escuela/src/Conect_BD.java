import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Conect_BD {
	
	public static Connection conectar() {
	 String url = "jdbc:mysql://localhost:3306/escuela_patito";
     String usuario = "root";
     String contraseña = "12345";
     
     Connection connection = null;
     
     try {
         connection = DriverManager.getConnection(url, usuario, contraseña);     
     }  catch (SQLException e) {
         System.out.println("Error al establecer la conexión a la base de datos");
         e.printStackTrace();
     }
     return connection;
	}
	
	public static Boolean login(String user, String pass) {
		
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM users where username= " +"'" +user+"'" + " and pass= " +"'"+ pass+"'";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	            return true;
	        }
		} catch (Exception e) {
			
		}
		
		return false;
	}
	
	public static void getUsers(JLabel label) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM users";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	            label.setText("Nombre: " + resultSet.getString("nombre") + "Apellido Paterno: " + resultSet.getString("apellido_p") + " username: " + resultSet.getString("username"));
	        }
		} catch (Exception e) {
			
		}
	}
	
	public static void getCarreras(JComboBox<String> comboBox) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM carreras";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	        while (resultSet.next()) {
	        	comboBoxModel.addElement(resultSet.getString("nombre"));
	        }
	        
	        comboBox.setModel(comboBoxModel);
		} catch (Exception e) {
			
		}
	}
	
	public static void getCarreras_update(JComboBox<String> comboBox) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM carreras";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	        while (resultSet.next()) {
	        	comboBoxModel.addElement(resultSet.getString("id")+" - "+resultSet.getString("nombre"));
	        }
	        
	        comboBox.setModel(comboBoxModel);
		} catch (Exception e) {
			
		}
	}
	
	public static void getAlumnos_update(JComboBox<String> comboBox) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM alumnos";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	        while (resultSet.next()) {
	        	comboBoxModel.addElement(resultSet.getString("id")+" - "+resultSet.getString("nombre"));
	        }
	        
	        comboBox.setModel(comboBoxModel);
		} catch (Exception e) {
			
		}
	}
	
	public static void getMaestros_update(JComboBox<String> comboBox) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM maestros";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	        while (resultSet.next()) {
	        	comboBoxModel.addElement(resultSet.getString("id")+" - "+resultSet.getString("nombre"));
	        }
	        
	        comboBox.setModel(comboBoxModel);
		} catch (Exception e) {
			
		}
	}
	
	public static void getUsuarios_update(JComboBox<String> comboBox) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM users";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	        while (resultSet.next()) {
	        	comboBoxModel.addElement(resultSet.getString("id")+" - "+resultSet.getString("nombre"));
	        }
	        
	        comboBox.setModel(comboBoxModel);
		} catch (Exception e) {
			
		}
	}
	
	
	public static void getCarrera(int id, JTextField nombre, JTextField clave) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM carreras where id = '" + id + "';";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	        
	        		nombre.setText(resultSet.getString("nombre"));
	        		clave.setText(resultSet.getString("clave"));
	        		
	        }
		} catch (Exception e) {
			
		}
	}
	
	public static void getAlumnoselect(int id, JTextField nombre, JTextField ape_p, JTextField ape_m) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM alumnos where id = '" + id + "';";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	        
	        		nombre.setText(resultSet.getString("nombre"));
	        		ape_p.setText(resultSet.getString("apellido_p"));
	        		ape_m.setText(resultSet.getString("apellido_m"));
	        		
	        }
		} catch (Exception e) {
			
		}
	}
	
	public static void getMaestrosselect(int id, JTextField nombre, JTextField ape_p, JTextField ape_m) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM maestros where id = '" + id + "';";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	        
	        		nombre.setText(resultSet.getString("nombre"));
	        		ape_p.setText(resultSet.getString("apellido_p"));
	        		ape_m.setText(resultSet.getString("apellido_m"));
	        		
	        }
		} catch (Exception e) {
			
		}
	}
	
	public static void getUsersselect(int id, JTextField nombre, JTextField ape_p, JTextField ape_m, JTextField pass) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM users where id = '" + id + "';";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	        
	        		nombre.setText(resultSet.getString("nombre"));
	        		ape_p.setText(resultSet.getString("apellido_p"));
	        		ape_m.setText(resultSet.getString("apellido_m"));
	        		pass.setText(resultSet.getString("pass"));
	        		
	        }
		} catch (Exception e) {
			
		}
	}
	
	public static void getAlumnoInicio(int id, JTextField nombre, JTextField ape_p, JTextField ape_m) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM alumnos where id = '" + id + "';";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	        
	        		nombre.setText(resultSet.getString("nombre"));
	        		ape_p.setText(resultSet.getString("apellido_p"));
	        		ape_m.setText(resultSet.getString("apellido_m"));
	        		
	        }
		} catch (Exception e) {
			
		}
	}
	
	public static void getMaestroInicio(int id, JTextField nombre, JTextField ape_p, JTextField ape_m) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM maestros where id = '" + id + "';";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	        
	        		nombre.setText(resultSet.getString("nombre"));
	        		ape_p.setText(resultSet.getString("apellido_p"));
	        		ape_m.setText(resultSet.getString("apellido_m"));
	        		
	        }
		} catch (Exception e) {
			
		}
	}
	
	public static void getUsuarioInicio(int id, JTextField nombre, JTextField ape_p, JTextField ape_m, JTextField pass) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM users where id = '" + id + "';";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        while (resultSet.next()) {
	        
	        		nombre.setText(resultSet.getString("nombre"));
	        		ape_p.setText(resultSet.getString("apellido_p"));
	        		ape_m.setText(resultSet.getString("apellido_m"));
	        		pass.setText(resultSet.getString("pass"));
	        		
	        }
		} catch (Exception e) {
			
		}
	}
	
	
	public static Boolean insertUsers(String username, String contraseña, String name, String ape_p, String ape_m, int departamento, int sexo) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "insert into users values (" +null+","+ "'" + username+"'" + "," + "'"+contraseña+"'" + "," + "'"+name+"'"  + "," + "'"+ape_p+"'" + "," + "'"+ape_m+"'" + "," + "'"+departamento+"'"  + "," + "'"+sexo+"'"   +");";
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Boolean updateCarreras(int id, String name, String clave) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "update carreras set nombre = '" + name + "',clave='"+clave+"' where id = " + id+";";
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Boolean updateAlumno(int id, String name, String apep,String apem) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "update alumnos set nombre = '" + name + "',apellido_p='"+apep+"',apellido_m='"+apem+"' where id = " + id+";";
	 		System.out.println(consultaSQL);
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Boolean updateMaestro(int id, String name, String apep,String apem) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "update maestros set nombre = '" + name + "',apellido_p='"+apep+"',apellido_m='"+apem+"' where id = " + id+";";
	 		System.out.println(consultaSQL);
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Boolean updateUsers(int id, String name, String apep,String apem,String pass) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "update users set nombre = '" + name + "',apellido_p='"+apep+"',apellido_m='"+apem+"',pass='"+ pass+"' where id = " + id+";";
	 		System.out.println(consultaSQL);
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
	public static Boolean insertCarrera(String name, String clave) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "insert into carreras values (" +null+","+ "'" +name+"','" + clave +"');" ;
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Boolean insertMaestro(String name, String apellido_p, String apellido_m, String carrera) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "insert into maestros values (" +null+","+ "'" +name+"','" + apellido_p +"','" + apellido_m + "','" + carrera +"');" ;
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Boolean insertAlumno(String name, String apellido_p, String apellido_m, String carrera) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "insert into alumnos values (" +null+","+ "'" +name+"','" + apellido_p +"','" + apellido_m + "','" + carrera +"');" ;
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static Boolean elimarAlumno(int id) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "delete from alumnos where id = " +id;
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static Boolean elimarMaestros(int id) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "delete from maestros where id = " +id;
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static Boolean elimarCarrera(int id) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "delete from carreras where id = " +id;
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static Boolean elimarUsuario(int id) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "delete from users where id = " +id;
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static Boolean elimarUsers(int id) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "delete from users where id = " +id;
	 		statement.executeUpdate(consultaSQL);
	        
	 		return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static void getUsers(JTable tables) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM users";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultTableModel table = new DefaultTableModel();
	        table.addColumn("id");
	        table.addColumn("username");
	        table.addColumn("Nombre");
	        
	        tables.setModel(table);
	        String[] datos= new String[3];
	        while (resultSet.next()) {
	        	datos[0]= resultSet.getString("id");
	        	datos[1]= resultSet.getString("username");
	        	datos[2]= resultSet.getString("nombre") + " " + resultSet.getString("apellido_p") + " " + resultSet.getString("apellido_m");
	        	table.addRow(datos);
	        }
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public static void getCarreras(JTable tables) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM carreras";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultTableModel table = new DefaultTableModel();
	        table.addColumn("id");
	        table.addColumn("Nombre");
	        table.addColumn("Clave");
	        
	        tables.setModel(table);
	        String[] datos= new String[3];
	        while (resultSet.next()) {
	        	datos[0]= resultSet.getString("id");
	        	datos[1]= resultSet.getString("nombre");
	        	datos[2]= resultSet.getString("clave") ;
	        	table.addRow(datos);
	        }
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public static void getMaestros(JTable tables) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM maestros";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultTableModel table = new DefaultTableModel();
	        table.addColumn("id");
	        table.addColumn("Carrera");
	        table.addColumn("Nombre");
	        
	        tables.setModel(table);
	        String[] datos= new String[3];
	        while (resultSet.next()) {
	        	datos[0]= resultSet.getString("id");
	        	datos[1]= resultSet.getString("carrera");
	        	datos[2]= resultSet.getString("nombre") + " " + resultSet.getString("apellido_p") + " " + resultSet.getString("apellido_m");
	        	table.addRow(datos);
	        }
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public static void getAlumnos(JTable tables) {
		Connection conection = conectar();
		Statement statement = null;
	     ResultSet resultSet = null;
	     
	     try {
	 		statement = (Statement) conection.createStatement();
	 		String consultaSQL = "SELECT * FROM alumnos";
	        resultSet = ((java.sql.Statement) statement).executeQuery(consultaSQL);
	        
	        DefaultTableModel table = new DefaultTableModel();
	        table.addColumn("id");
	        table.addColumn("Carrera");
	        table.addColumn("Nombre");
	        
	        tables.setModel(table);
	        String[] datos= new String[3];
	        while (resultSet.next()) {
	        	datos[0]= resultSet.getString("id");
	        	datos[1]= resultSet.getString("carrera");
	        	datos[2]= resultSet.getString("nombre") + " " + resultSet.getString("apellido_p") + " " + resultSet.getString("apellido_m");
	        	table.addRow(datos);
	        }
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
