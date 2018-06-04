import java.util.HashMap;
import java.util.Map;

public class JSONObject {
	private Map<String,Object> keyValueObject = new HashMap<>();

	public Map<String, Object> getKeyValueObject() {
		return keyValueObject;
	}

	public void setKeyValueObject(Map<String, Object> keyValueObject) {
		this.keyValueObject = keyValueObject;
	}
	
	public void put(String filedName, Object objectValue)
	{
		keyValueObject.put(filedName, objectValue);
	}
	

}
