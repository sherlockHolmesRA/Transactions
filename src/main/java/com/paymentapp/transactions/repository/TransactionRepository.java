package com.paymentapp.transactions.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paymentapp.transactions.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
