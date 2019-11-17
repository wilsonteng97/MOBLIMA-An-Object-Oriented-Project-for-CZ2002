package Model;

import java.io.Serializable;
import java.util.Date;

import Model.Enums.TransactionMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class Transaction.
 * This class shows the information of transaction.
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Transaction implements Serializable {
	
	/** The transaction ID. */
	private final String transaction_ID;
	/** The price amount. */
	private Double amount;
	/** The date of transaction. */
	private Date date;
	/** The transaction method. */
	private TransactionMethod transactionMethod;
	
	/**
	 * Instantiates a new transaction.
	 *
	 * @param transaction_ID the transaction ID
	 * @param amount the amount
	 * @param date the date
	 * @param transactionMethod the transaction method
	 */
	public Transaction(String transaction_ID, Double amount, Date date, TransactionMethod transactionMethod) {
		this.transaction_ID = transaction_ID;
		this.amount = amount;
		this.date = date;
		this.transactionMethod = transactionMethod; 
	}
	
	/**
	 * Gets the transaction ID.
	 *
	 * @return the transaction ID
	 */
	// transaction_ID
	public String getTransaction_ID() {
		return transaction_ID;
	}
	
	/**
	 * Gets the price amount.
	 *
	 * @return the amount
	 */
	// amount
	public Double getAmount() {
		return amount;
	}
	
	/**
	 * Sets the price amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	/**
	 * Gets the transaction date.
	 *
	 * @return the date
	 */
	// date
	public Date getDate() {
		return date;
	}
	
	/**
	 * Sets the transaction date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Gets the transaction method.
	 *
	 * @return the transaction method
	 */
	// transactionMethod
	public TransactionMethod getTransactionMethod() {
		return transactionMethod;
	}
	
	/**
	 * Sets the transaction method.
	 *
	 * @param transactionMethod the new transaction method
	 */
	public void setTransactionMethod(TransactionMethod transactionMethod) {
		this.transactionMethod = transactionMethod;
	}
}