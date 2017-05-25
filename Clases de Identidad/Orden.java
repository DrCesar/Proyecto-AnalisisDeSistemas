import java.util.ArrayList;

public class Orden{
	
	private int num, costo;
	private String estado;
	private Cliente cliente;
	private ArrayList<Platillo> lista;
	
	public Orden(int n, String e, Cliente c){
		this.num=n;
		this.estado=e;
		this.cliente=c;
		lista = new ArrayList<Platillo>();
		costo = 0;
	}
	
	public void calcularCosto(){
		for (int i=0 ; i < lista.size() ; i++){
			Platillo p = lista.get(i);
			costo = costo + p.getCosto();
		}
	}
	
	public void setEstado(String e){
		estado = e;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public int getNum(){
		return num;
	}
	public int getCosto(){
		return costo;
	}
	public String getEstado(){
		return estado;
	}
	public ArrayList<Platillo> getLista(){
		return lista;
	}
	
	public int size(){
		return lista.size();
	}
}