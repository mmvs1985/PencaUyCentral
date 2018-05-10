package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Equipos" database table.
 * 
 */
@Entity
@Table(name="\"Equipos\"")  
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"Id\"")
	private Integer id;

	@Column(name="\"Nombre\"")
	private String nombre;

	//bi-directional many-to-one association to Equipos_Grupo
	@OneToMany(mappedBy="equipo")
	private List<Equipos_Grupo> equiposGrupo;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipoGanador")
	private List<Partido> partidosEquipoGanador;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipoVisita")
	private List<Partido> partidosEquipoVisita;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipoLocal")
	private List<Partido> partidosEquipoLocal;

	public Equipo() {
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

	public List<Equipos_Grupo> getEquiposGrupos() {
		return this.equiposGrupo;
	}

	public void setEquiposGrupos(List<Equipos_Grupo> equiposGrupos) {
		this.equiposGrupo = equiposGrupos;
	}

	public Equipos_Grupo addEquiposGrupo(Equipos_Grupo equiposGrupo) {
		getEquiposGrupos().add(equiposGrupo);
		equiposGrupo.setEquipo(this);

		return equiposGrupo;
	}

	public Equipos_Grupo removeEquiposGrupo(Equipos_Grupo equiposGrupo) {
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