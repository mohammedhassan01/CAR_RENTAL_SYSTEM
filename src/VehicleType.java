
public class VehicleType {
	private int typeId;
	public static final VehicleType SUV = new VehicleType(2);
	public static final VehicleType SEDAN = new VehicleType(0);
	public static final VehicleType FOURxFOUR = new VehicleType(1);

	public VehicleType(int typeId) {
		this.typeId = typeId;
	}

	public int getTypeId() {
		return typeId;
	}

}
