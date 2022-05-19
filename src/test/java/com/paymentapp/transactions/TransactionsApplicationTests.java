package com.paymentapp.transactions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.paymentapp.transactions.enums.PaymentType;
import com.paymentapp.transactions.enums.Status;
import com.paymentapp.transactions.model.CommandLine;
import com.paymentapp.transactions.model.Transaction;
import com.paymentapp.transactions.service.CommandLineService;
import com.paymentapp.transactions.service.TransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TransactionsApplicationTests {

	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private CommandLineService commandLineService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	//@Rollback(false)
	void testCreateTransaction() {
		Status status = Status.NEW;
		PaymentType type = PaymentType.CREDIT_CARD;
		List<CommandLine> commands = new ArrayList<CommandLine>();

		CommandLine command1 = new CommandLine("pair of Ski gluves", 4, new BigDecimal("10.00"));
		CommandLine command2 = new CommandLine("wool hat", 1, new BigDecimal("14.80"));
		
		commandLineService.saveCommandLine(command1);
		commandLineService.saveCommandLine(command2);
		
		commands.add(command1);
		commands.add(command2);
		
		Transaction transaction = new Transaction(new BigDecimal("54.80"), type, status, commands);
		transactionService.saveTransaction(transaction);
		
		assertNotNull(transaction);
	}
	
	@Test
	public void testFindTransactionByIdExist() {
		long id = 1;
		Transaction transaction = transactionService.getTransactionById(id);
		
		assertEquals(transaction.getId(), id);
	}
	
	@Test
	public void testFindTransactionByIdNotExist() {
		long id = 1;
		Transaction transaction = transactionService.getTransactionById(id);
		
		assertNull(transaction);	
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		Status status = Status.AUTHORIZED;
		Status newStatus = Status.CAPTURED;
		Transaction oldTransaction = new Transaction(new BigDecimal("54.80"), PaymentType.CREDIT_CARD, status, null);
		oldTransaction.setStatus(newStatus);
		
		Transaction updatedTransaction = transactionService.updateTransaction(1, oldTransaction);
		
		assertEquals(updatedTransaction.getStatus(), Status.CAPTURED);
		
	}
	/**/
	/*
	@Test
	public Iterable<Transactions> testFindAllTransactions(){
		
	}*/
	

}
