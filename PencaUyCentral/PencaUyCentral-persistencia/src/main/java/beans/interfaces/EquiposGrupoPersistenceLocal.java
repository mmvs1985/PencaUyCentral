package beans.interfaces;

import javax.ejb.Local;

@Local
public interface EquiposGrupoPersistenceLocal {
	
	public boolean agregarEquiposGrupo(int equipo,int grupo);
	
}
