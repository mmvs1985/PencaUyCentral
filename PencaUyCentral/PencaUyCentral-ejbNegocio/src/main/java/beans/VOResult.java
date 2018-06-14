package beans;

import java.util.HashMap;
import java.util.Map;



public class VOResult {


private VORandom random;

private Integer bitsUsed;

private Integer bitsLeft;

private Integer requestsLeft;

private Integer advisoryDelay;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();


public VORandom getRandom() {
return random;
}

public void setRandom(VORandom random) {
this.random = random;
}

public Integer getBitsUsed() {
return bitsUsed;
}

public void setBitsUsed(Integer bitsUsed) {
this.bitsUsed = bitsUsed;
}

public Integer getBitsLeft() {
return bitsLeft;
}

public void setBitsLeft(Integer bitsLeft) {
this.bitsLeft = bitsLeft;
}

public Integer getRequestsLeft() {
return requestsLeft;
}

public void setRequestsLeft(Integer requestsLeft) {
this.requestsLeft = requestsLeft;
}

public Integer getAdvisoryDelay() {
return advisoryDelay;
}

public void setAdvisoryDelay(Integer advisoryDelay) {
this.advisoryDelay = advisoryDelay;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}