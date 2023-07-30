package application.registros;

import java.sql.*;
import java.util.ArrayList;

import application.componentes.Imagen;
import application.utilidades.ClobConverter;
import application.utilidades.DatabaseConnection;

public class ImagenReg {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public ImagenReg() {
		con = DatabaseConnection.getConnection();
		ps = null;
		rs = null;
	}

	public void agregar(Imagen v) {
		try {
			CallableStatement statement = con.prepareCall("{call inserts.insertar_imagen(?, ?, ?, ?, ?)}");
			Clob cadenaLarga = con.createClob();
			cadenaLarga.setString(1, v.getDescripcion());
			statement.setString(1, v.getTitulo());
			statement.setClob(2, cadenaLarga);
			statement.setInt(3, v.getId_proy());
			statement.setString(4, v.getUrl());
			statement.setInt(5, 1);
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(Imagen v) {
		try {
			CallableStatement statement = con.prepareCall("{call updates.update_imagen(?, ?, ?, ?, ?, ?, ?)}");
			Clob cadenaLarga = con.createClob();
			cadenaLarga.setString(1, v.getDescripcion());
			statement.setInt(1, v.getId());
			statement.setString(2, v.getTitulo());
			statement.setClob(3, cadenaLarga);
			statement.setInt(4, v.getId_proy());
			statement.setInt(5, v.getId_cia());
			statement.setString(6, v.getUrl());
			statement.setInt(7, v.getVisualizacion());
			statement.execute();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Imagen> extraerRegistros(){
		ArrayList<Imagen> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConnection.getConnection();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM imagen_todo");
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String descripcion = ClobConverter.clobToString(resultado.getClob("descripcion"));
				int id_proy = resultado.getInt("id_proy");
				int id_cia = resultado.getInt("id_cia");
				String url = resultado.getString("url");
				int visualizacion = resultado.getInt("visualizacion");
				Imagen c1 = new Imagen(id, titulo, descripcion, id_proy, id_cia, url, visualizacion);
				registros.add(c1);
			}
			resultado.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registros;
	}
	
	public ArrayList<Imagen> extraerVisualizables(){
		ArrayList<Imagen> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConnection.getConnection();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM imagen_visual_uno");
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String descripcion = ClobConverter.clobToString(resultado.getClob("descripcion"));
				int id_proy = resultado.getInt("id_proy");
				int id_cia = resultado.getInt("id_cia");
				String url = resultado.getString("url");
				int visualizacion = resultado.getInt("visualizacion");
				Imagen c1 = new Imagen(id, titulo, descripcion, id_proy, id_cia, url, visualizacion);
				registros.add(c1);
			}
			resultado.close();
			statement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registros;
	}
	
	public ArrayList<Imagen> extraerNoVisualizables(){
		ArrayList<Imagen> registros = new ArrayList<>();
		try {
			Connection conexion = DatabaseConnection.getConnection();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM imagen_visual_cero");
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				String descripcion = ClobConverter.clobToString(resultado.getClob("descripcion"));
				int id_proy = resultado.getInt("id_proy");
				int id_cia = resultado.getInt("id_cia");
				String url = resultado.getString("url");
				int visualizacion = resultado.getInt("visualizacion");
				Imagen c1 = new Imagen(id, titulo, descripcion, id_proy, id_cia, url, visualizacion);
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
