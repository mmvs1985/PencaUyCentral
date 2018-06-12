package util;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import beans.EquipoPersistence;
import beans.interfaces.EquipoPersistenceRemote;

public class EquiposUtilities {
	public static EquipoPersistenceRemote doLookup() {
		try {
			Properties props = new Properties();
			props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(props);
			String appName = "PencaUyCentral-ear";
			String moduleName = "PencaUyCentral-persistencia";
			String distinctName = "";
			String beanName = EquipoPersistence.class.getSimpleName();
			String interfaceName = EquipoPersistenceRemote.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
					+ interfaceName;
			return (EquipoPersistenceRemote) context.lookup(name);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
