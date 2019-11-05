package Model;

import java.io.Serializable;
import java.util.Date;

import Model.Enums.TransactionMethod;

public class Transaction implements Serializable {
	private final Integer transaction_ID;
	private Double amount;
	private Date date;
	private TransactionMethod transactionMethod;
	
	public Transaction(Integer transaction_ID, Double amount, Date date, TransactionMethod transactionMethod) {
		this.transaction_ID = transaction_ID;
		this.amount = amount;
		this.date = date;
		this.transactionMethod = transactionMethod; 
	}
	
	// transaction_ID
	public Integer getTransaction_ID() {
		return transaction_ID;
	}
	
	// amount
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	// date
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	// transactionMethod
	public TransactionMethod getTransactionMethod() {
		return transactionMethod;
	}
	public void setTransactionMethod(TransactionMethod transactionMethod) {
		this.transactionMethod = transactionMethod;
	}
}
