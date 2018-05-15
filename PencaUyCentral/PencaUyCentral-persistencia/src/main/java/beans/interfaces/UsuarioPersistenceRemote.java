package beans.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entidades.Usuario;

@Remote
public interface UsuarioPersistenceRemote {	
	public boolean agregarUsuario(String nombre, String apellido, String email, String nickname, String password, Date fechaNac);
	public Usuario obtenerUsuario(int id);	
	public List<Usuario> obtenerUsuarios();	
	public boolean usuarioValido(Usuario u);
	public boolean eliminarUsuario(int id);

}
