package util;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import beans.PartidoPersistence;
import beans.interfaces.PartidoPersistenceRemote;

public class PartidosUtilities {
	public static PartidoPersistenceRemote doLookup() {
		try {
			Properties props = new Properties();
			props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(props);
			String appName = "PencaUyCentral-ear";
			String moduleName = "PencaUyCentral-persistencia";
			String distinctName = "";
			String beanName = PartidoPersistence.class.getSimpleName();
			String interfaceName = PartidoPersistenceRemote.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
					+ interfaceName;
			return (PartidoPersistenceRemote) context.lookup(name);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
