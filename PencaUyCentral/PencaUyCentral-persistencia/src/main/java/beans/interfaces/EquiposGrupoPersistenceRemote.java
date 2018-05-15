package beans.interfaces;

import javax.ejb.Remote;

@Remote
public interface EquiposGrupoPersistenceRemote {
	
	public boolean agregarEquiposGrupo(int equipo,int grupo);
	
}
