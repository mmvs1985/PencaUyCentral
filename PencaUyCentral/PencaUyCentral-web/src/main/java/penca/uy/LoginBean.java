package penca.uy;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.interfaces.UsuarioBusinessRemote;

@ManagedBean(name = "LoginBean")
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB UsuarioBusinessRemote loginBean;
	
	private String usuario;
	private String password;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void login() {
		if (loginBean.usuarioValido(usuario, password)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Existe el usuario " + usuario));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Verifique usuario y/o password."));
		}
	}
	
}
