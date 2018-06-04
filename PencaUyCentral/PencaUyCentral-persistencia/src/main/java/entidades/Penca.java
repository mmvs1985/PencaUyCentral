package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Pencas" database table.
 * 
 */
@Entity
@Table(name="\"Pencas\"")
@NamedQueries({
	@NamedQuery(name="Penca.findAll", query="SELECT p FROM Penca p"),
	@NamedQuery(name = "Penca.findByNombre", query = "SELECT p FROM Penca p WHERE p.nombre = :nombre"),
	@NamedQuery(name = "Penca.findByNombreAndOrganizacion", query = "SELECT p FROM Penca p WHERE p.nombre = :nombre AND p.organizacion = :organizacion"),
	@NamedQuery(name = "Penca.findByOrganizacion", query = "SELECT p FROM Penca p WHERE p.organizacion = :organizacion")
})
public class Penca implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="\"Id\"")
	private Integer id;
	
	@Column(name="\"Nombre\"")
	private String nombre;

	//bi-directional many-to-one association to Participante
	@OneToMany(mappedBy="penca")
	private List<Participante> participantes;

	//bi-directional many-to-one association to Organizacione
	@ManyToOne
	@JoinColumn(name="\"OrganizacionId\"")
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