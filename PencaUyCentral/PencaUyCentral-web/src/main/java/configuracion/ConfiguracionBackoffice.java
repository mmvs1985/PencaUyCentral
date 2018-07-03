package configuracion;

public class ConfiguracionBackoffice {

	private static final String PROTOCOLO = "http";
	private static final String DOMINIO = "localhost";
	private static final int PUERTO = 8180;
	private static final String URL_SERVICIO = "/PencaUyLocal-Backoffice-servicios/rest/api/";
	private static final String URL = PROTOCOLO + "://" + DOMINIO + ":" + PUERTO + URL_SERVICIO;
	private static ConfiguracionBackoffice instancia = null;

	private ConfiguracionBackoffice() {};

	public static ConfiguracionBackoffice getInstancia() {
		if(instancia == null) {
			instancia = new ConfiguracionBackoffice();
		}
		return instancia;
	}

	public String getURL() {
		return URL;
	}


}
