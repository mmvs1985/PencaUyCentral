package beans.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entidades.Usuario;

@Remote
public interface UsuarioPersistenceRemote {
	
	boolean agregarUsuario(String nombre, String apellido, String email, String nickname, String password, Date fechaNac);

	Usuario obtenerUsuario(int id);
	
	List<Usuario> obtenerUsuarios();
	
	boolean usuarioValido(Usuario u);

	boolean eliminarUsuario(int id);

}
