package com.paymentapp.transactions.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.paymentapp.transactions.enums.Status;
import com.paymentapp.transactions.model.CommandLine;
import com.paymentapp.transactions.model.Transaction;
import com.paymentapp.transactions.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public Iterable<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Transaction getTransactionById(long id) {
		return transactionRepository.findById(id).get();
	}

	public Transaction saveTransaction(Transaction transaction) {
		Transaction savedTransaction = transactionRepository.save(transaction);
		savedTransaction.setStatus(Status.NEW);
		return savedTransaction;
		/*
		 * switch (transaction.getStatus()) { case NEW: Transaction savedTransaction =
		 * transactionRepository.save(transaction); return savedTransaction; case
		 * AUTHORIZED: throw new
		 * RuntimeException("Status should be NEW not AUTHORIZED");
		 * 
		 * case CAPTURED: throw new
		 * RuntimeException("Status should be NEW not CAPTURED"); default: throw new
		 * RuntimeException("Operation not supported"); }
		 */
	}

	public Transaction updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction)
			throws Exception {
		Transaction transactionData = transactionRepository.findById(id)
				.orElseThrow(() -> new Exception("Transaction Not Found for the Id :: " + id));

		transactionData.setAmount(transaction.getAmount());
		transactionData.setType(transaction.getType());
		transactionData.setStatus(transaction.getStatus());

		if (transaction.getCommands() != null) {
			List<CommandLine> commands = new ArrayList<CommandLine>();

			for (CommandLine transactionCommandLine : transaction.getCommands()) {

				CommandLine command = new CommandLine();
				command.setProduct(transactionCommandLine.getProduct());
				command.setQuantity(transactionCommandLine.getQuantity());
				command.setPrice(transactionCommandLine.getPrice());

				commands.add(command);
			}

			transactionData.setCommands(commands);
		}
		final Transaction updatedTransaction = transactionRepository.save(transactionData);
		return updatedTransaction;
	}

	public void deleteById(long id) {
		transactionRepository.deleteById(id);
	}

	public void deleteAllTransactions() {
		transactionRepository.deleteAll();
	}

}
