package beans;


import java.util.HashMap;
import java.util.Map;



public class VOReturn {


private String jsonrpc;

private VOResult result;

private Integer id;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();


public String getJsonrpc() {
return jsonrpc;
}


public void setJsonrpc(String jsonrpc) {
this.jsonrpc = jsonrpc;
}


public VOResult getResult() {
return result;
}


public void setResult(VOResult result) {
this.result = result;
}


public Integer getId() {
return id;
}


public void setId(Integer id) {
this.id = id;
}


public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}


public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}