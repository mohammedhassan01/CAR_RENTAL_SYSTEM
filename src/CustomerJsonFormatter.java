
public class CustomerJsonFormatter implements Formatter<Customer> {

	@Override
	public String getValue(Customer customer) {
		Formatter<Rental> formatter = FormatterFactory.getFormatter(customer.getRentalsList().get(0));
		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder stringBuilder2 = new StringBuilder();
		stringBuilder.append("\"name\":" + "\"" + customer.getName() + "\"");
		stringBuilder.append("\"totalRentalAmount\":" + "\"" + String.valueOf(customer.getTotalRentalAmount()) + "\"");
		stringBuilder
				.append("\"totalRewardAmount\":" + "\"" + String.valueOf(customer.getTotalRentalRewardPoints()) + "\"");

		for (Rental rental : customer.getRentalsList()) {

			stringBuilder2.append(formatter.getValue(rental) + ", ");
		}

		stringBuilder.append("rentalList:[" + stringBuilder2 + "]");
		return stringBuilder.toString();
	}

}
