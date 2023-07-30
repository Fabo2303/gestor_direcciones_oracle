package application.registros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import application.componentes.Proyecto;
import application.utilidades.DatabaseConexion;

public class ProyectoReg {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public ProyectoReg() {
		con = DatabaseConexion.getConneccion();
		ps = null;
		rs = null;
	}
	
	public ArrayList<Proyecto> extraerProyectos(){
		ArrayList<Proyecto> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConexion.getConneccion();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM proyecto_cod_nombre");
			while (resultado.next()) {
				int id = resultado.getInt("codpyto");
				String nombre = resultado.getString("nompyto");
				Proyecto c1 = new Proyecto(id, nombre);
				registros.add(c1);
			}
			resultado.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registros;
	}
}
