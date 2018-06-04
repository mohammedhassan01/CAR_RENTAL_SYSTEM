import java.lang.reflect.Field;

public class JSON{
	public static JSONObject toJSON(Object input) throws IllegalAccessException, InstantiationException{
		JSONObject results= new JSONObject();
		Class inputClass = input.getClass();
		Field fields[] = inputClass.getDeclaredFields();
		
		for(Field curField : fields){
			String fieldName = curField.getName();
			JSONField annotation = (JSONField)curField.getAnnotation(JSONField.class);
/*			if(annotation == null){
				continue;
			}*/
			if(curField.getType().isArray()){
				//First, check if this is an optional field that doesn't exist.  If so, ignore it
				if(annotation.optional() && curField.get(input) == null){
					continue;
				}

				//Handling an array requires us to allocate the array, stuff each index into the array, and set the results at the end
				JSONArray jsonArray = new JSONArray();
				Object javaArray[] = (Object[])curField.get(input);
				for(Object curObject : javaArray){
					jsonArray.put(toJSONArrayIndex(curObject));
				}
				results.put(fieldName,  jsonArray);
			}
			else{
				Object fieldResult = toJSONField(input, curField);
				if(fieldResult != null){
					results.put(fieldName, fieldResult);
				}
			}
		}
		
		return results;
	}
	
    //Helper function to convert tp a single JSON field	
	private static Object toJSONField(Object input, Field curField) throws IllegalAccessException, InstantiationException {
		String fieldType = curField.getType().getName();
		curField.setAccessible(true);
		
		//See if this is annotated as an optional member.  If it is, return NULL if it does not exist
		//Otherwise the use of getXXX below will throw an exception on non-existance
		JSONField annotation = (JSONField)curField.getAnnotation(JSONField.class);
	/*	if(annotation == null){
			return null;
		}
		if(annotation.optional() && curField.get(input) == null){
			return null;
		}*/
		if(fieldType.equals("java.lang.Boolean") || fieldType.equals("java.lang.Double") || fieldType.equals("java.lang.Integer") ||
				fieldType.equals("java.lang.Long") || fieldType.equals("java.lang.String")){
			return curField.get(input);
		}
		else{
			//Not a java primitive.  Run this recursively.
			Object fieldObject = curField.get(input);
			return toJSON(fieldObject);
		}
		
		
	}
	
	//Helper function to convert to a single index in a JSON array
	private static Object toJSONArrayIndex(Object curObject) throws  IllegalAccessException, InstantiationException{
		Class baseType = curObject.getClass();
		String baseTypeName = baseType.getName();
		if(baseTypeName.equals("java.lang.Boolean") || baseTypeName.equals("java.lang.Double") || baseTypeName.equals("java.lang.Integer") ||
				baseTypeName.equals("java.lang.Long") || baseTypeName.equals("java.lang.String")){
			return curObject;
		}
		else{
			//Not a JSON primitive.  Run this recursively.
			return toJSON(curObject);
		}
	}
	
}
