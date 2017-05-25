import java.io.File;
class Platillo{
	
	private int costo;
	private String nombre, comentarios;
	public File foto;
	
	public Platillo(int costo, String nombre, String comentarios, String Path){
		this.costo = costo;
		this.nombre = nombre;
		this.comentarios = comentarios;
		foto = new File(Path);
	}
	
	public void setCosto(int c){
		this.costo=c;
	}
	public void setNombre(String n){
		this.nombre=n;
	}
	public void setComentarios(String c){
		this.comentarios=c;
	}
	
	public int getCosto(){
		return costo;
	}
	public String getNombre(){
		return nombre;
	}
	public String getComentarios(){
		return comentarios;
	}
}