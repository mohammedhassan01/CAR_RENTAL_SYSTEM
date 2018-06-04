import java.util.ArrayList;
import java.util.List;

public class JSONArray {
	private List<Object> jsonArray = new ArrayList<Object>();
	public void put(Object object)
	{
		jsonArray.add(object);
	}
	public List<Object> getJsonArray() {
		return jsonArray;
	}
	public void setJsonArray(List<Object> jsonArray) {
		this.jsonArray = jsonArray;
	}

}
