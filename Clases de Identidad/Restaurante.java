import java.util.ArrayList;
import java.io.File;

public class Restaurante{
	
	private ArrayList<Categoria> lista;
	private String nombre;
	public File foto;
	
	public Restaurante(String n, String path){
		this.nombre=n;
		this.foto= new File(path);
		lista = new ArrayList<Categoria>();
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String n){
		this.nombre=n;
	}
	
	public ArrayList<Categoria> getLista(){
		return lista;
	}
	
	public void agregar(Categoria p){
		lista.add(p);
	}
	
	public void eliminar(Categoria p){
		lista.remove(p);
	}
	
	public int size(){
		return lista.size();
	}
	
	public void vaciar(){
		lista.clear();
	}
	
}