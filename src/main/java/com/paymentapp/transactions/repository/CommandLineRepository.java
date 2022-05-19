package com.paymentapp.transactions.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.paymentapp.transactions.model.CommandLine;

@Repository
public interface CommandLineRepository extends CrudRepository<CommandLine, Long>{

}
