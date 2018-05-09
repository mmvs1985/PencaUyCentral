package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Fases" database table.
 * 
 */
@Entity
@Table(name="\"Fases\"")
@NamedQuery(name="Fas.findAll", query="SELECT f FROM Fas f")
public class Fas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"Id\"")
	private Integer id;

	@Column(name="\"Nombre\"")
	private String nombre;

	//bi-directional many-to-one association to Torneo
	@ManyToOne
	@JoinColumn(name="\"TorneoId\"")
	private Torneo torneo;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="fas")
	private List<Grupo> grupos;

	public Fas() {
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
		grupo.setFas(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setFas(null);

		return grupo;
	}

}