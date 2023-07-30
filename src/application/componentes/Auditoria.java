package application.componentes;

public class Auditoria {
	private String accion;
	private String fecha; //→DD/MM/AA
	private int id;
	private String origen;
	
	public Auditoria(int id, String origen,String fecha, String accion) {
		this.id = id;
		this.origen = origen;
		this.fecha = fecha;		
		this.accion = accion;
	}
	
	public String getOrigen() {
		return origen;
	}
	
	public String getAccion() {
		return accion;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public int getId() {
		return id;
	}
}
