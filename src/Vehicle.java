public class Vehicle {
	private String makeAndModel;
	private VehicleType vehicleType;

	public Vehicle(String makeAndModel, VehicleType vehicleType) {
		this.makeAndModel = makeAndModel;
		this.vehicleType = vehicleType;
	}

	public String getMakeAndModel() {
		return makeAndModel;
	}

	public void setMakeAndModel(String makeAndModel) {
		this.makeAndModel = makeAndModel;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

}
