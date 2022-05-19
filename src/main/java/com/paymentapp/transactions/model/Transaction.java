package com.paymentapp.transactions.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.paymentapp.transactions.enums.PaymentType;
import com.paymentapp.transactions.enums.Status;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "type")
	private PaymentType type;

	@Column(name = "status")
	private Status status;

	@Column(name = "command_lines")
	@OneToMany(cascade=CascadeType.ALL)
	private List<CommandLine> commands = new ArrayList<CommandLine>();

	public Transaction(){
		
	}
	
	public Transaction(BigDecimal amount, PaymentType type, Status status, List<CommandLine> commands) {
	//public Transaction(BigDecimal amount, PaymentType type, Status status) {
		this.amount = amount;
		this.type = type;
		this.status = status;
		this.commands = commands;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
/**/
	public List<CommandLine> getCommands() {
		return commands;
	}

	public void setCommands(List<CommandLine> commands) {
		this.commands = commands;
	}

}
