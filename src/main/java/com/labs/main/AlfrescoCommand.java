package com.labs.main;

import org.springframework.stereotype.Component;

import com.labs.acs.AcsCommand;
import com.labs.config.ConfigCommand;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Component
@Command(
    name = "alfresco",
    description = "Alfresco CLI tool",
    subcommands = {ConfigCommand.class, AcsCommand.class},
    mixinStandardHelpOptions = true,
    version = "1.0",
    usageHelpAutoWidth = true
)
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
			new picocli.CommandLine(this).usage(System.out);
		} else if (versionHelpRequested) {
			new picocli.CommandLine(this).usage(System.out);
		}
	}
}
