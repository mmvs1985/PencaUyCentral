package penca.uy;

import java.util.List;

public class GrupoString {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String nombre;
	private List<String> equipos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<String> equipos) {
		this.equipos = equipos;
	}

}
