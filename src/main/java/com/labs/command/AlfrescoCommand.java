package com.labs.command;

import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ScopeType;

import com.labs.config.AcsCommand;
import com.labs.config.ConfigCommand;

@Component
@Command(name = "alfresco", scope = ScopeType.INHERIT, mixinStandardHelpOptions = true, version = "1.0", description = "Alfresco CLI tool", exitCodeOnExecutionException = 1, showDefaultValues = true, usageHelpAutoWidth = true, subcommands = {
		ConfigCommand.class, AcsCommand.class })
public class AlfrescoCommand implements Runnable {

	@Option(names = { "-h", "--help" }, 
			description = "Show help message", 
			usageHelp = true)
	private boolean usageHelpRequested;

	@Option(names = { "-v", "--version" }, 
			description = "Show version information", 
			versionHelp = true)
	private boolean versionHelpRequested;

	@Override
	public void run() {
		if (usageHelpRequested) {
			new CommandLine(this).usage(System.out);
		} else if (versionHelpRequested) {
			 new CommandLine(this).printVersionHelp(System.out);
		}
	}
}
