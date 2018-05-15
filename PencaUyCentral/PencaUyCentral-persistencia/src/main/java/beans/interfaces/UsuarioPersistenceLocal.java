package beans.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entidades.Usuario;

@Local
public interface UsuarioPersistenceLocal {	
	public boolean agregarUsuario(String nombre, String apellido, String email, String nickname, String password, Date fechaNac);
	public Usuario obtenerUsuario(int id);	
	public List<Usuario> obtenerUsuarios();	
	public boolean usuarioValido(Usuario u);
	public boolean eliminarUsuario(int id);
}
