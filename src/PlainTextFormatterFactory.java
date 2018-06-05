
public class PlainTextFormatterFactory {

	public static Formatter getFormatter(Object object) {
		if (object.getClass() == Customer.class) {
			return new CustomerPlainTextFormtter();
		}
		return null;
	}

}
