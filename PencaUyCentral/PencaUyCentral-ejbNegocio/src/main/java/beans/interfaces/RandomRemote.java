package beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RandomRemote {
	
	public List<Integer> random();

}
