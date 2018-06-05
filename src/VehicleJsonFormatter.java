
public class VehicleJsonFormatter implements Formatter<Vehicle> {

	@Override
	public String getValue(Vehicle vehicle) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		stringBuilder.append("\"model\":" + "\"" + vehicle.getMakeAndModel() + "\"");
		stringBuilder.append(", \"type id\":" + "\"" + vehicle.getVehicleType().getTypeId() + "\"");
		stringBuilder.append("}");
		return stringBuilder.toString();
	}

}
