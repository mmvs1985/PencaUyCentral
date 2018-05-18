package penca.uy;
 
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import beans.interfaces.ParticipanteBusinessRemote;
import entidades.Participante;
 
@ManagedBean(name="TablaParticipantesView")
//@ViewScoped
public class TablaParticipantesView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Participante> participantes;
     
    @EJB
    ParticipanteBusinessRemote participanteBean;
 
    @PostConstruct
    public void init() {
        participantes = participanteBean.obtenerParticipantes();
    }
     
    public List<Participante> getParticipantes() {
        return participantes;
    }
 
}