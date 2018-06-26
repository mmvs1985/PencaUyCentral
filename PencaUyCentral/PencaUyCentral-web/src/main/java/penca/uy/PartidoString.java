package penca.uy;

import java.util.Date;

import entidades.Equipo;
import entidades.Grupo;

public class PartidoString {

	private int id;
	private String estado;
	private Date fecha;
	private String hora;
	private Integer golesEquipoLocal;
	private Integer golesEquipoVisita;
	private String equipoGanador;
	private String equipoVisita;
	private String equipoLocal;
	private String grupo;
	private int grupoId;
	public int getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getGolesEquipoLocal() {
		return golesEquipoLocal;
	}
	public void setGolesEquipoLocal(Integer golesEquipoLocal) {
		this.golesEquipoLocal = golesEquipoLocal;
	}
	public Integer getGolesEquipoVisita() {
		return golesEquipoVisita;
	}
	public void setGolesEquipoVisita(Integer golesEquipoVisita) {
		this.golesEquipoVisita = golesEquipoVisita;
	}
	public String getEquipoGanador() {
		return equipoGanador;
	}
	public void setEquipoGanador(String equipoGanador) {
		this.equipoGanador = equipoGanador;
	}
	public String getEquipoVisita() {
		return equipoVisita;
	}
	public void setEquipoVisita(String equipoVisita) {
		this.equipoVisita = equipoVisita;
	}
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
}
