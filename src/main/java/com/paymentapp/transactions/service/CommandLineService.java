package com.paymentapp.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentapp.transactions.model.CommandLine;
import com.paymentapp.transactions.repository.CommandLineRepository;

@Service
public class CommandLineService {

	@Autowired
	private CommandLineRepository commandLineRepository;
	
	public Iterable<CommandLine> getAllCommandLines() {
		return commandLineRepository.findAll();
	}
	
	public CommandLine getCommandLineById(long id) {
		return commandLineRepository.findById(id).get();
	}
	
	public CommandLine saveCommandLine(CommandLine command) {
		CommandLine savedCommandLine = commandLineRepository.save(command);
		return savedCommandLine;
	}
	
	public CommandLine updateCommandLine(long id, CommandLine commandDetails) throws Exception {
		CommandLine command = commandLineRepository.findById(id).orElseThrow(() -> new Exception("Command Line Not Found for the Id :: " + id));
		
		command.setProduct(commandDetails.getProduct());
		command.setQuantity(commandDetails.getQuantity());
		command.setPrice(commandDetails.getPrice());
		
		final CommandLine updatedCommandLine = commandLineRepository.save(command);
		return updatedCommandLine;
	}
	
	public void deleteCommandLineById(long id) {
		commandLineRepository.deleteById(id);
	}
	
	public void deleteAllCommandLines() {
		commandLineRepository.deleteAll();
	}

}
