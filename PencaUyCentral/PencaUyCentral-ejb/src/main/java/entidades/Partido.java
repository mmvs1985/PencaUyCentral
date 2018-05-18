package entidades;

import java.io.Serializable;
import javax.persistence.*;

import entidades.Equipo;
import entidades.Grupo;

import java.util.Date;


public class Partido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String estado;

	private Date fecha;

	private Integer golesEquipoLocal;

	private Integer golesEquipoVisita;

	private Equipo equipoGanador;

	private Equipo equipoVisita;

	private Equipo equipoLocal;

	private Grupo grupo;


	public Partido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
/*
	public Integer getEquipoGanadorId() {
		return this.equipoGanadorId;
	}

	public void setEquipoGanadorId(Integer equipoGanadorId) {
		this.equipoGanadorId = equipoGanadorId;
	}

	public Integer getEquipoVisitaId() {
		return this.equipoVisitaId;
	}

	public void setEquipoVisitaId(Integer equipoVisitaId) {
		this.equipoVisitaId = equipoVisitaId;
	}

	public Integer getEqupoLocalId() {
		return this.equpoLocalId;
	}

	public void setEqupoLocalId(Integer equpoLocalId) {
		this.equpoLocalId = equpoLocalId;
	}
*/
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getGolesEquipoLocal() {
		return this.golesEquipoLocal;
	}

	public void setGolesEquipoLocal(Integer golesEquipoLocal) {
		this.golesEquipoLocal = golesEquipoLocal;
	}

	public Integer getGolesEquipoVisita() {
		return this.golesEquipoVisita;
	}

	public void setGolesEquipoVisita(Integer golesEquipoVisita) {
		this.golesEquipoVisita = golesEquipoVisita;
	}

	/*public Integer getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}
*/
	public Equipo getEquipoGanador() {
		return this.equipoGanador;
	}

	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	public Equipo getEquipoVisitante() {
		return this.equipoVisita;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisita = equipoVisitante;
	}

	public Equipo getEquipLocal() {
		return this.equipoLocal;
	}

	public void setEquipLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
/*
	public Grupo getGrupoId2() {
		return this.grupos2;
	}

	public void setGrupoId2(Grupo grupos2) {
		this.grupos2 = grupos2;
	}
*/
}