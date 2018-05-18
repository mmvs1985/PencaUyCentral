package entidades;

import java.io.Serializable;
import java.util.List;

import entidades.Organizacion;
import entidades.Participante;


public class Penca implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private List<Participante> participantes;

	private Organizacion organizacion;

	public Penca() {
	}

	public Integer getId() {
		return this.id;
	}

	/*public void setId(Integer id) {
		this.id = id;
	}*/
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setPenca(this);
		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setPenca(null);
		return participante;
	}

	public Organizacion getOrganizacion() {
		return this.organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}

}