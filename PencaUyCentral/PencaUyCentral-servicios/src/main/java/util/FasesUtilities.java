package util;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import beans.FasePersistence;
import beans.interfaces.FasePersistenceRemote;

public class FasesUtilities {
	public static FasePersistenceRemote doLookup() {
		try {
			Properties props = new Properties();
			props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(props);
			String appName = "PencaUyCentral-ear";
			String moduleName = "PencaUyCentral-persistencia";
			String distinctName = "";
			String beanName = FasePersistence.class.getSimpleName();
			String interfaceName = FasePersistenceRemote.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
					+ interfaceName;
			return (FasePersistenceRemote) context.lookup(name);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
