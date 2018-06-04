
public class FormatType {
	private int typeId ;
	public static final FormatType PLAIN_TEXT = new FormatType(1);
    public static final FormatType JSON = new FormatType(0);

    
    public FormatType(int typeId)
    {
    	this.typeId = typeId;
    }
    public int getTypeId()
    {
    	return typeId;
    }
}
