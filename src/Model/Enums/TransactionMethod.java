package Model.Enums;

public enum TransactionMethod {
	DEBIT_CREDIT("DEBIT_CREDIT"), E_WALLET("E_WALLET"), QR_CODE("QR_CODE");

	private String string;
	TransactionMethod(String string)
	{
		this.string = string;
	}

	public static TransactionMethod getValue(String value)
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
