package application.componentes;

public class Pdf {
	private int id;
	private String titulo;
	private String descripcion;
	private int id_proy;
	private int id_cia;
	private String url;
	private int visualizacion;
	
	public Pdf() {
		this.id = 99999;
		this.titulo = "NA";
		this.descripcion = "NA";
		this.id_proy = 99999;
		this.id_cia = 99999;
		this.url = "NA";
		this.visualizacion = 1;
	}
	
	public Pdf(int id_, String titulo_, String descripcion_, int id_proy_, int id_cia_, String url_, int virtualizacion_) {
		this.id = id_;
		this.titulo = titulo_;
		this.descripcion = descripcion_;
		this.id_proy = id_proy_;
		this.id_cia = id_cia_;
		this.url = url_;
		this.visualizacion = virtualizacion_;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_proy() {
		return id_proy;
	}

	public void setId_proy(int id_proy) {
		this.id_proy = id_proy;
	}

	public int getId_cia() {
		return id_cia;
	}

	public void setId_cia(int id_cia) {
		this.id_cia = id_cia;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVisualizacion() {
		return visualizacion;
	}

	public void setVisualizacion(int visualizacion) {
		this.visualizacion = visualizacion;
	}
}
