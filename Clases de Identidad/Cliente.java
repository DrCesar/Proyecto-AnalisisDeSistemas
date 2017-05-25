
public class Cliente {
	
	private String nombre, apellido, usuario, contraseña, email;
	
	public Cliente(String n, String a, String u, String c, String e){
		this.nombre=n;
		this.apellido=a;
		this.usuario=u;
		this.contraseña=c;
		this.email=e;
	}
	
	private void setNombre(String n){
		this.nombre=n;
	}
	private void setApellido(String a){
		this.apellido=a;
	}
	private void setUsuario(String u){
		this.usuario=u;
	}
	private void setContraseña(String c){
		this.contraseña=c;
	}
	private void setEmail(String e){
		this.email=e;
	}
	
	public String getNombre(){
		return nombre;	
	}
	public String getApellido(){
		return apellido;	
	}
	public String getUsuario(){
		return usuario;	
	}
	public String getContraseña(){
		return contraseña;	
	}
	
}
