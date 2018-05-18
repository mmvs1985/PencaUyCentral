package entidades;

import java.io.Serializable;
import javax.persistence.*;

import entidades.Fase;
import entidades.Torneo;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Torneo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date comienzo;

	private String nombre;

	private String tipo;

	private List<Fase> fases;

	public Torneo() {
	}
	
	public Torneo(String nombre, String tipo, Date comienzo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.comienzo = comienzo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getComienzo() {
		return this.comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Fase> getFases() {
		return this.fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

	public Fase addFase(Fase fase) {
		getFases().add(fase);
		fase.setTorneo(this);

		return fase;
	}

	public Fase removeFase(Fase fase) {
		getFases().remove(fase);
		fase.setTorneo(null);

		return fase;
	}
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Torneo other = (Torneo) obj;
	        if (!Objects.equals(this.id, other.id)) {
	            return false;
	        }
	        return true;
	    }

}