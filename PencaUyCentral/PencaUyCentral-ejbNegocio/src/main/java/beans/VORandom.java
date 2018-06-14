package beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VORandom {

private List<Integer> data = null;
private String completionTime;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public List<Integer> getData() {
return data;
}

public void setData(List<Integer> data) {
this.data = data;
}

public String getCompletionTime() {
return completionTime;
}

public void setCompletionTime(String completionTime) {
this.completionTime = completionTime;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}