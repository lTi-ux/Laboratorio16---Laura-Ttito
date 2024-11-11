import java.util.*;
public class Reino {
	private String nombre;
	private List<String> territoriosBonificados;
	
	public Reino(String nombre) {
		this.nombre = nombre;
		this.territoriosBonificados = new ArrayList<>();
	}
	public void agregarTerritorioBonificado(String territorio) {
		territoriosBonificados.add(territorio);
	}
	public boolean tieneBonus(String territorio) {
		return territoriosBonificados.contains(territorio);
	}
		public String getNombre() {
		return nombre;
	}
}
