package beans.interfaces;

import java.util.List;

import javax.ejb.Local;
@Local
public interface RandomLocal {
	public List<Integer> random();

}
