package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Premios" database table.
 * 
 */
@Entity
@Table(name="\"Premios\"")
@NamedQuery(name="Premio.findAll", query="SELECT p FROM Premio p")
public class Premio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"Id\"")
	private Integer id;

	@Column(name="\"Puesto1\"")
	private Integer puesto1;

	@Column(name="\"Puesto2\"")
	private Integer puesto2;

	@Column(name="\"Total\"")
	private Integer total;

	//bi-directional many-to-one association to TiposPremio
	@ManyToOne
	@JoinColumn(name="\"TipoPremioId\"")
	private TiposPremio tiposPremio;

	public Premio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPuesto1() {
		return this.puesto1;
	}

	public void setPuesto1(Integer puesto1) {
		this.puesto1 = puesto1;
	}

	public Integer getPuesto2() {
		return this.puesto2;
	}

	public void setPuesto2(Integer puesto2) {
		this.puesto2 = puesto2;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public TiposPremio getTiposPremio() {
		return this.tiposPremio;
	}

	public void setTiposPremio(TiposPremio tiposPremio) {
		this.tiposPremio = tiposPremio;
	}

}