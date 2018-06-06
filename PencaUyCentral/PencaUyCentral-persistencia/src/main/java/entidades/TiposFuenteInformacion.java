package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the "TiposFuenteInformacion" database table.
 *
 */
@Entity
@Table(name="\"TiposFuenteInformacion\"")
@NamedQueries({
	@NamedQuery(name = "TiposFuenteInformacion.findAll", query="SELECT t FROM TiposFuenteInformacion t"),
	@NamedQuery(name = "TiposFuenteInformacion.findByNombre",query = "SELECT t FROM TiposFuenteInformacion t WHERE t.nombre = :nombre")
})
public class TiposFuenteInformacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="\"Id\"")
	private Integer id;

	@Column(name="\"Nombre\"")
	private String nombre;

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
