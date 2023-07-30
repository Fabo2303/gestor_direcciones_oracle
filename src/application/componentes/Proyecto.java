package application.componentes;

// Solo se tomara en cuenta para extraer el codpyto y el Nompyto 
public class Proyecto {
	private int codPyto;
	private String nomPyto;
	
	public Proyecto(int codPyto, String nomPyto) {
		super();
		this.codPyto = codPyto;
		this.nomPyto = nomPyto;
	}
	public int getCodPyto() {
		return codPyto;
	}
	public void setCodPyto(int codPyto) {
		this.codPyto = codPyto;
	}
	public String getNomPyto() {
		return nomPyto;
	}
	public void setNomPyto(String nomPyto) {
		this.nomPyto = nomPyto;
	}
	
	public Proyecto buscarProyecto(String nom) {
		if(nomPyto.equals(nom))
			return this;
		return null;
	}
}
