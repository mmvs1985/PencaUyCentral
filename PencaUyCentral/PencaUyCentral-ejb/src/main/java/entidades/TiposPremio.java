package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


public class TiposPremio implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;


	public TiposPremio() {
	}

	public Integer getId() {
		return this.id;
	}

	/*public void setId(Integer id) {
		this.id = id;
	}*/

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}