package entidades;

import java.io.Serializable;

import entidades.Penca;


public class Participante implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer puntos;

	private String usuario;

	private Penca penca;

	public Participante() {
	}

	public Integer getId() {
		return this.id;
	}

	/*public void setId(Integer id) {
		this.id = id;
	}*/

	public Integer getPuntos() {
		return this.puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Penca getPenca() {
		return this.penca;
	}

	public void setPenca(Penca penca) {
		this.penca = penca;
	}

}