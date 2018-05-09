package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TiposPremio" database table.
 * 
 */
@Entity
@Table(name="\"TiposPremio\"")
@NamedQuery(name="TiposPremio.findAll", query="SELECT t FROM TiposPremio t")
public class TiposPremio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"Id\"")
	private Integer id;

	@Column(name="\"Nombre\"")
	private String nombre;

	//bi-directional many-to-one association to Premio
	@OneToMany(mappedBy="tiposPremio")
	private List<Premio> premios;

	public TiposPremio() {
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

	public List<Premio> getPremios() {
		return this.premios;
	}

	public void setPremios(List<Premio> premios) {
		this.premios = premios;
	}

	public Premio addPremio(Premio premio) {
		getPremios().add(premio);
		premio.setTiposPremio(this);

		return premio;
	}

	public Premio removePremio(Premio premio) {
		getPremios().remove(premio);
		premio.setTiposPremio(null);

		return premio;
	}

}