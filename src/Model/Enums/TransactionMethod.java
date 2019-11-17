package Model.Enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum TransactionMethod classifies the method that the customer uses to make payment for booking.
 */
public enum TransactionMethod {
	
	 /** The debit credit method. */
	 DEBIT_CREDIT("DEBIT_CREDIT"), 
	 /** The e wallet method. */
	 E_WALLET("E_WALLET"), 
	 /** The qr code method. */
	 QR_CODE("QR_CODE");

	/** The string to identify the transaction method. */
	private String string;
	
	/**
	 * Instantiates a new transaction method in string.
	 *
	 * @param string the string
	 */
	TransactionMethod(String string)
	{
		this.string = string;
	}

	/**
	 * Gets the transaction method based on the string parameter.
	 *
	 * @param value the value
	 * @return the value transaction method
	 */
	public static TransactionMethod getValueTransactionMethod(String value)
	{
		value = value.toUpperCase();
		if(value.equals("DEBIT_CREDIT"))
		{
			return DEBIT_CREDIT;
		}
		else if(value.equals("E_WALLET"))
		{
			return E_WALLET;
		}
		else if(value.equals("QR_CODE"))
		{
			return QR_CODE;
		}
		else 
		{
			return null;
		}
	}
}