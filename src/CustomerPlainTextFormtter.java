
public class CustomerPlainTextFormtter implements Formatter<Customer> {

	@Override
	public String getValue(Customer customer) {
		return customer.statement();
	}
	
}
