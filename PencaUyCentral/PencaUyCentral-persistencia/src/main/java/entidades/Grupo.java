package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Grupos" database table.
 * 
 */
@Entity
@Table(name="\"Grupos\"")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"Id\"")
	private Integer id;
/*
	@Column(name="\"FaseId\"")
	private Integer faseId;
*/
	@Column(name="\"Nombre\"")
	private String nombre;

	//bi-directional many-to-one association to Equipos_Grupo
	@OneToMany(mappedBy="grupo")
	private List<Equipos_Grupo> equiposGrupos;

	//bi-directional many-to-one association to Fas
	@ManyToOne
	@JoinColumn(name="\"FaseId\"")
	private Fase fase;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="grupoId_de_Partidos")
	private List<Partido> partidosGrupoId_de_Partidos;

/*
	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="grupo2")
	private List<Partido> partidos2;
*/
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

	public List<Equipos_Grupo> getEquiposGrupos() {
		return this.equiposGrupos;
	}

	public void setEquiposGrupos(List<Equipos_Grupo> equiposGrupos) {
		this.equiposGrupos = equiposGrupos;
	}

	public Equipos_Grupo addEquiposGrupo(Equipos_Grupo equiposGrupo) {
		getEquiposGrupos().add(equiposGrupo);
		equiposGrupo.setGrupo(this);
		return equiposGrupo;
	}

	public Equipos_Grupo removeEquiposGrupo(Equipos_Grupo equiposGrupo) {
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

	public List<Partido> getPartidosGrupoId_de_Partidos() {
		return this.partidosGrupoId_de_Partidos;
	}

	public void setPartidosGrupoId_de_Partidos(List<Partido> partidosGrupoId_de_Partidos) {
		this.partidosGrupoId_de_Partidos = partidosGrupoId_de_Partidos;
	}

	public Partido addPartidosGrupoId_de_Partidos(Partido partidosGrupoId_de_Partidos) {
		getPartidosGrupoId_de_Partidos().add(partidosGrupoId_de_Partidos);
		partidosGrupoId_de_Partidos.setGrupoId_de_Partidos(this);
		return partidosGrupoId_de_Partidos;
	}

	public Partido removePartidosGrupoId_de_Partidos(Partido partidosGrupoId_de_Partidos) {
		getPartidosGrupoId_de_Partidos().remove(partidosGrupoId_de_Partidos);
		partidosGrupoId_de_Partidos.setGrupoId_de_Partidos(null);
		return partidosGrupoId_de_Partidos;
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