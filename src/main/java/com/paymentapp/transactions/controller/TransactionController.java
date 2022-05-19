package com.paymentapp.transactions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentapp.transactions.model.Transaction;
import com.paymentapp.transactions.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transactions")
	public Iterable<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}

	@GetMapping("/transactions/{id}")
	public Transaction getTransactionById(@PathVariable(value = "id") long id) {
		return transactionService.getTransactionById(id);
	}

	@PostMapping("/transactions")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		Transaction _transaction = transactionService.saveTransaction(transaction);
		return _transaction;
	}

	@PutMapping("/transactions/{id}") 
	public Transaction updateTransaction(@PathVariable("id") long id, @RequestBody Transaction
	  transaction) throws Exception {
		return transactionService.updateTransaction(id, transaction);		
	}

	@DeleteMapping("/transactions/{id}")
	public void deleteTransaction(@PathVariable(value = "id") long id) {
		transactionService.deleteById(id);
	}

	@DeleteMapping("/transactions")
	public void deleteAllTransactions() {
		transactionService.deleteAllTransactions();
	}
}
