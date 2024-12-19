package cortarconexión;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Facturarepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/cie1";
	static final String USER = "root";
	static final String PASS = "";
	static final String QUERY = "SELECT * from Facturas";

	public void insertar(int numero, String concepto, double importe) {

		try {
			Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("insert into facturas values ('" + numero + "','" + concepto + "'," + importe + ")");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void borrar(String numero) {
		try {
			Connection conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("DELETE FROM `facturas` WHERE  nombre= '" + numero + "'");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Factura> buscarTodos() {

		ResultSet rs=null;
		Connection conexion=null;
		ArrayList<Factura> lista= new ArrayList<Factura>();
		try {
			//conecto a la base de datos
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			//preparo la sentencia
			Statement sentencia = conexion.createStatement();
			//ejecuto
			rs = sentencia.executeQuery("select * from Facturas");
			while (rs.next()) {
				
				Factura f= new Factura(rs.getInt("numero"),
						rs.getString("concepto"), rs.getDouble("importe"));
				
				lista.add(f);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if (conexion!=null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lista;
	}
	

}

