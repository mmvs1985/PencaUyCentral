package entidades;

import java.io.Serializable;
import javax.persistence.*;

import entidades.EquiposGrupo;
import entidades.Fase;
import entidades.Partido;

import java.util.List;

public class Grupo implements Serializable {
	
	private static final long serialVersionUID = 1L;	

	private Integer id;

	private String nombre;

	private List<EquiposGrupo> equiposGrupo;

	private Fase fase;

	private List<Partido> partidos;


	public Grupo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
/*
	public Integer getFaseId() {
		return this.faseId;
	}
	public void setFaseId(Integer faseId) {
		this.faseId = faseId;
	}
*/
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EquiposGrupo> getEquiposGrupos() {
		return this.equiposGrupo;
	}

	public void setEquiposGrupos(List<EquiposGrupo> equiposGrupo) {
		this.equiposGrupo = equiposGrupo;
	}

	public EquiposGrupo addEquiposGrupo(EquiposGrupo equiposGrupo) {
		getEquiposGrupos().add(equiposGrupo);
		equiposGrupo.setGrupo(this);
		return equiposGrupo;
	}

	public EquiposGrupo removeEquiposGrupo(EquiposGrupo equiposGrupo) {
		getEquiposGrupos().remove(equiposGrupo);
		equiposGrupo.setGrupo(null);
		return equiposGrupo;
	}

	public Fase getFase() {
		return this.fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public List<Partido> getPartidos() {
		return this.partidos;
	}

	public void setPartido(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public void addPartido(Partido partido) {
		getPartidos().add(partido);
		partido.setGrupo(this);
	}

	public void removePartido(Partido partido) {
		getPartidos().remove(partido);
		partido.setGrupo(null);
	}

/*
	public List<Partido> getPartidos2() {
		return this.partidos2;
	}
	public void setPartidos2(List<Partido> partidos2) {
		this.partidos2 = partidos2;
	}
	public Partido addPartidos2(Partido partidos2) {
		getPartidos2().add(partidos2);
		partidos2.setGrupo2(this);
		return partidos2;
	}
	public Partido removePartidos2(Partido partidos2) {
		getPartidos2().remove(partidos2);
		partidos2.setGrupo2(null);
		return partidos2;
	}
*/
}