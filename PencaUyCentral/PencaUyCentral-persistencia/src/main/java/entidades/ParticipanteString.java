package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ParticipanteString implements Serializable{
	


		private static final long serialVersionUID = 1L;


		private Integer id;

		private Integer puntos;


		private String usuario;


		private String penca;
		
		private String organizacion;


		public String getOrganizacion() {
			return organizacion;
		}


		public void setOrganizacion(String organizacion) {
			this.organizacion = organizacion;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Integer getPuntos() {
			return puntos;
		}


		public void setPuntos(Integer puntos) {
			this.puntos = puntos;
		}


		public String getUsuario() {
			return usuario;
		}


		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}


		public String getPenca() {
			return penca;
		}


		public void setPenca(String penca) {
			this.penca = penca;
		}

}
