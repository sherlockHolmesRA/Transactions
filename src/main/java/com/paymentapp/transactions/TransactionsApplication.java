package com.paymentapp.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.paymentapp.transactions.service.TransactionService;

@SpringBootApplication
public class TransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}
	
	@Autowired
	private TransactionService transactionService;
	
	public void run(String... args) throws Exception {
		/*
		List<CommandLine> commands = new ArrayList<CommandLine>();
		CommandLine command1 = new CommandLine("PC", 120, new BigDecimal("254.23"));
		CommandLine command2 = new CommandLine("iPhone", 120, new BigDecimal("254.23"));
		CommandLine command3 = new CommandLine("iPad", 120, new BigDecimal("254.23"));

		commands.add(command1);
		commands.add(command2);
		commands.add(command3);

		//this.transactionService.saveTransaction(new Transaction(new BigDecimal("54.80"), PaymentType.CREDIT_CARD, Status.NEW, commands));
	*/
	}

}
