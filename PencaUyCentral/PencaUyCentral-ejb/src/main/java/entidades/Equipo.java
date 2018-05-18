package entidades;

import java.io.Serializable;
import javax.persistence.*;

import entidades.EquiposGrupo;
import entidades.Partido;

import java.util.List;

public class Equipo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private List<EquiposGrupo> equiposGrupo;

	private List<Partido> partidosEquipoGanador;

	private List<Partido> partidosEquipoVisita;

	private List<Partido> partidosEquipoLocal;

	public Equipo() {
	}

	public Integer getId() {
		return this.id;
	}

	/*public void setId(Integer id) {
		this.id = id;
	}*/

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EquiposGrupo> getEquiposGrupos() {
		return this.equiposGrupo;
	}

	public void setEquiposGrupos(List<EquiposGrupo> equiposGrupos) {
		this.equiposGrupo = equiposGrupos;
	}

	public EquiposGrupo addEquiposGrupo(EquiposGrupo equiposGrupo) {
		getEquiposGrupos().add(equiposGrupo);
		equiposGrupo.setEquipo(this);

		return equiposGrupo;
	}

	public EquiposGrupo removeEquiposGrupo(EquiposGrupo equiposGrupo) {
		getEquiposGrupos().remove(equiposGrupo);
		equiposGrupo.setEquipo(null);

		return equiposGrupo;
	}

	public List<Partido> getPartidosEquipoGanador() {
		return this.partidosEquipoGanador;
	}

	public void setPartidosEquipoGanador(List<Partido> partidosEquipoGanador) {
		this.partidosEquipoGanador = partidosEquipoGanador;
	}

	public Partido addPartidosEquipoGanador(Partido partidosEquipoGanador) {
		getPartidosEquipoGanador().add(partidosEquipoGanador);
		partidosEquipoGanador.setEquipoGanador(this);
		return partidosEquipoGanador;
	}

	public Partido removePartidosEquipoGanador(Partido partidosEquipoGanador) {
		getPartidosEquipoGanador().remove(partidosEquipoGanador);
		partidosEquipoGanador.setEquipoGanador(null);
		return partidosEquipoGanador;
	}

	public List<Partido> getPartidosEquipoVisitante() {
		return this.partidosEquipoVisita;
	}

	public void setPartidosEquipoVisitante(List<Partido> partidosEquipoVisitante) {
		this.partidosEquipoVisita = partidosEquipoVisitante;
	}

	public Partido addPartidosEquipoVisitante(Partido partidosEquipoVisitante) {
		getPartidosEquipoVisitante().add(partidosEquipoVisitante);
		partidosEquipoVisitante.setEquipoVisitante(this);
		return partidosEquipoVisitante;
	}

	public Partido removePartidosEquipoVisitante(Partido partidosEquipoVisitante) {
		getPartidosEquipoVisitante().remove(partidosEquipoVisitante);
		partidosEquipoVisitante.setEquipoVisitante(null);
		return partidosEquipoVisitante;
	}

	public List<Partido> getPartidosEquipoLocal() {
		return this.partidosEquipoLocal;
	}

	public void setPartidosEquipoLocal(List<Partido> partidosEquipoLocal) {
		this.partidosEquipoLocal = partidosEquipoLocal;
	}

	public Partido addPartidosEquipoLocal(Partido partidosEquipoLocal) {
		getPartidosEquipoLocal().add(partidosEquipoLocal);
		partidosEquipoLocal.setEquipLocal(this);
		return partidosEquipoLocal;
	}

	public Partido removePartidosEquipoLocal(Partido partidosEquipoLocal) {
		getPartidosEquipoLocal().remove(partidosEquipoLocal);
		partidosEquipoLocal.setEquipLocal(null);
		return partidosEquipoLocal;
	}

}