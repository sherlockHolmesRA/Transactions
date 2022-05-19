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

import com.paymentapp.transactions.model.CommandLine;
import com.paymentapp.transactions.service.CommandLineService;

@RestController
@RequestMapping("/api")
public class CommandLineController {
	
	@Autowired
	private CommandLineService commandLineService;
	
	
	@GetMapping("/commands")
	public Iterable<CommandLine> getAllCommandLines() {
		return commandLineService.getAllCommandLines();
	}
	
	@GetMapping("/commands/{id}")
	public CommandLine getCommandLineById(@PathVariable(value = "id") long id){
		return commandLineService.getCommandLineById(id);
	}
	
	@PostMapping("/commands")
	public CommandLine postCommandLine(@RequestBody CommandLine command) {
		CommandLine _command = commandLineService.saveCommandLine(command);
		return _command;
	}
	
	@PutMapping("/commands/{id}")
	public CommandLine changeCommandLine(@PathVariable(value = "id") long id, @RequestBody CommandLine command) throws Exception {
		CommandLine updatedCommand = commandLineService.updateCommandLine(id, command);
		return updatedCommand;
	}
	
	@DeleteMapping("/commands")
	public void deleteCommandLines() {
		commandLineService.deleteAllCommandLines();
	}
	
	@DeleteMapping("/commands/{id}")
	public void deleteCommandLineById(@PathVariable(value = "id") long id) {
		commandLineService.deleteCommandLineById(id);
	}

}
