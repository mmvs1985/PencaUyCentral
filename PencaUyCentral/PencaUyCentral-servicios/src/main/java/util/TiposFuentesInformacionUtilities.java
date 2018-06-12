package util;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import beans.TiposFuenteInformacionPersistence;
import beans.interfaces.TiposFuenteInformacionPersistenceRemote;

public class TiposFuentesInformacionUtilities {
	public static TiposFuenteInformacionPersistenceRemote doLookup() {
		try {
			Properties props = new Properties();
			props.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(props);
			String appName = "PencaUyCentral-ear";
			String moduleName = "PencaUyCentral-persistencia";
			String distinctName = "";
			String beanName = TiposFuenteInformacionPersistence.class.getSimpleName();
			String interfaceName = TiposFuenteInformacionPersistenceRemote.class.getName();
			String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
					+ interfaceName;
			return (TiposFuenteInformacionPersistenceRemote) context.lookup(name);
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
