package application.registros;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import application.componentes.Auditoria;
import application.utilidades.ClobConverter;
import application.utilidades.DatabaseConexion;

public class AuditoriaReg {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public AuditoriaReg() {
		con = DatabaseConexion.getConneccion();
		ps = null;
		rs = null;
	}
	
	public ArrayList<Auditoria> extraerRegistros(String vista){
		ArrayList<Auditoria> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConexion.getConneccion();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM vista_" + vista);
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String origen = resultado.getString("tabla_afectada");
				Date fecha = resultado.getDate("fecha_accion"); 
				String accion = resultado.getString("accion");
				Auditoria c1 = new Auditoria(id, origen, fecha.toString(), accion);
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
