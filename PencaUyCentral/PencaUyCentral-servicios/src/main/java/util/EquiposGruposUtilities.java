package util;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import beans.EquiposGrupoPersistence;
import beans.interfaces.EquiposGrupoPersistenceRemote;

public class EquiposGruposUtilities {
	public static EquiposGrupoPersistenceRemote doLookup() {
		try {
			Properties props = new Properties();
			props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(props);
			String appName = "PencaUyCentral-ear";
			String moduleName = "PencaUyCentral-persistencia";
			String distinctName = "";
			String beanName = EquiposGrupoPersistence.class.getSimpleName();
			String interfaceName = EquiposGrupoPersistenceRemote.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
					+ interfaceName;
			return (EquiposGrupoPersistenceRemote) context.lookup(name);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
