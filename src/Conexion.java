import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;


public class Conexion {
	
	public Conexion(){
	}
	
	public void conectar()	{
		Connection con = null;

		try {
			//se cargan los driver de mysql en memoria
			Class.forName("com.mysql.jdbc.Driver");
			
			// se crea un string con la ruta del motor de mysql
			String s = "jdbc:mysql://localhost:3306/mibase";
			
			//me conecto a la base con el string + usuario + contraseña
			con = DriverManager.getConnection(s,"root","");
			System.out.println("Se conecto correctamente");
			
			//puedo crear consultas de tipo insert, drop, delete, update
			//PreparedStatement st =  (PreparedStatement) con.prepareStatement("Insert into mitabla (id,nombre,apellido,dni) values(3,'Lucas', 'Garcia', '14546')");
			//genero la consulta anterior
			//st.execute();
			
			//genero una consulta de tipo select que devuelve un resultado de tipo result
			PreparedStatement st =  con.prepareStatement("select * from mitabla");
			//PreparedStatement st =  con.prepareStatement("select * from mitabla where id = ?");
			//el signo de pregunta luego toma el valor asiendo st.setInt(1, VALOR) tambien se puede hacer con setString
			//ademas se puede poner la cantidad de signos que quiera
			ResultSet query = st.executeQuery();
			
			List<Alumno> alumnos = new ArrayList<>();
			
			//recorro la query y recupero los datos de cada alumno que existe en la base de datos
			while(query.next()){
			Alumno unAlumno = new Alumno();
			unAlumno.setId(query.getInt(1));
			unAlumno.setNombre(query.getString(2));
			unAlumno.setApellido(query.getString(3));
			unAlumno.setDni(query.getInt(4));
			alumnos.add(unAlumno);
			}
			
			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString());
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
