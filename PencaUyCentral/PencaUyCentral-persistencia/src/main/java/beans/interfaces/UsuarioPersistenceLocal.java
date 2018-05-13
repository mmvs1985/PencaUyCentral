package beans.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entidades.Usuario;

@Local
public interface UsuarioPersistenceLocal {
	
	boolean agregarUsuario(String nombre, String apellido, String email, String nickname, String password, Date fechaNac);

	Usuario obtenerUsuario(int id);
	
	List<Usuario> obtenerUsuarios();
	
	boolean usuarioValido(Usuario u);

	boolean eliminarUsuario(int id);

}
