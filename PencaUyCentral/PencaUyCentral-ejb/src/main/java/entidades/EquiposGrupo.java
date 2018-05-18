package entidades;

import java.io.Serializable;

import entidades.Equipo;
import entidades.Grupo;

public class EquiposGrupo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Equipo equipo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Grupo grupo;

	private Integer golenContra;

	private Integer golesFavor;

	private Integer partidosEmpatados;

	private Integer partidosGanados;

	private Integer partidosJugados;

	private Integer partidosPerdidos;

	private Integer posicion;

	private Integer puntos;

	
	public EquiposGrupo() {
	}

	public Integer getGolenContra() {
		return this.golenContra;
	}

	public void setGolenContra(Integer golenContra) {
		this.golenContra = golenContra;
	}

	public Integer getGolesFavor() {
		return this.golesFavor;
	}

	public void setGolesFavor(Integer golesFavor) {
		this.golesFavor = golesFavor;
	}

	public Integer getPartidosEmpatados() {
		return this.partidosEmpatados;
	}

	public void setPartidosEmpatados(Integer partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}

	public Integer getPartidosGanados() {
		return this.partidosGanados;
	}

	public void setPartidosGanados(Integer partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public Integer getPartidosJugados() {
		return this.partidosJugados;
	}

	public void setPartidosJugados(Integer partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public Integer getPartidosPerdidos() {
		return this.partidosPerdidos;
	}

	public void setPartidosPerdidos(Integer partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public Integer getPosicion() {
		return this.posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public Integer getPuntos() {
		return this.puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}