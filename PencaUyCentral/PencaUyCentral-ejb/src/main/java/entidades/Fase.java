package entidades;

import java.io.Serializable;
import java.util.List;

import entidades.Grupo;
import entidades.Torneo;

public class Fase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private Torneo torneo;

	private List<Grupo> grupos;

	public Fase() {
	}
	
	public Fase(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Torneo getTorneo() {
		return this.torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setFase(this);
		return grupo;		
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setFase(null);
		return grupo;
	}

}