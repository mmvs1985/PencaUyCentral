package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Organizaciones" database table.
 * 
 */
@Entity
@Table(name="\"Organizaciones\"")
@NamedQuery(name="Organizacione.findAll", query="SELECT o FROM Organizacione o")
public class Organizacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"Id\"")
	private Integer id;

	@Column(name="\"Nombre\"")
	private String nombre;

	//bi-directional many-to-one association to Penca
	@OneToMany(mappedBy="organizacion")
	private List<Penca> pencas;

	public Organizacione() {
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

	public List<Penca> getPencas() {
		return this.pencas;
	}

	public void setPencas(List<Penca> pencas) {
		this.pencas = pencas;
	}

	public Penca addPenca(Penca penca) {
		getPencas().add(penca);
		penca.setOrganizacion(this);

		return penca;
	}

	public Penca removePenca(Penca penca) {
		getPencas().remove(penca);
		penca.setOrganizacion(null);

		return penca;
	}

}