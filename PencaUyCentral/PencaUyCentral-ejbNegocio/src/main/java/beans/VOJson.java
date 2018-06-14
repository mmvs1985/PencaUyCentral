package beans;


public class VOJson {	
	
	private String jsonrpc;
	private String method;
	private VOParams params;
	private int id;
	
	
	
	public String getJsonrpc() {
		return jsonrpc;
	}
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public VOParams getParams() {
		return params;
	}
	public void setParams(VOParams params) {
		this.params = params;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	

	
	

}
