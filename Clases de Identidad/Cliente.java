
public class Cliente {
	
	private String nombre, apellido, usuario, contrase�a, email;
	
	public Cliente(String n, String a, String u, String c, String e){
		this.nombre=n;
		this.apellido=a;
		this.usuario=u;
		this.contrase�a=c;
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
	private void setContrase�a(String c){
		this.contrase�a=c;
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
	public String getContrase�a(){
		return contrase�a;	
	}
	
}
