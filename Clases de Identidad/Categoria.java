import java.io.File;
import java.util.ArrayList;

public class Categoria{
	
	private ArrayList<Platillo> lista;
	private String nombre;
	public File foto;
	
	public Categoria(String n, String Path){
		this.nombre=n;
		this.foto=new File(Path);
		lista = new ArrayList<Platillo>();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String n){
		this.nombre=n;
	}
	
	public ArrayList<Platillo> getLista(){
		return lista;
	}
	
	public void agregar(Platillo p){
		lista.add(p);
	}
	
	public void eliminar(Platillo p){
		lista.remove(p);
	}
	
	public int tamaño(){
		return lista.size();
	}
	
	public void vaciar(){
		lista.clear();
	}
	
	
}