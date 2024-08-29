package com.labs.command;

import org.springframework.context.annotation.Configuration;

import com.labs.config.AcsCommand;
import com.labs.config.ConfigCommand;

import picocli.CommandLine.Command;
import picocli.CommandLine.ScopeType;

@Configuration
@Command(
    name = "alfresco",
    scope = ScopeType.INHERIT,
    mixinStandardHelpOptions = true,
    version = "1.0",
    description = "Alfresco CLI tool",
    exitCodeOnExecutionException = 1, 
    showDefaultValues = true, 
    usageHelpAutoWidth = true,
    subcommands = { ConfigCommand.class, AcsCommand.class }
)
public class AlfrescoCommand implements Runnable {

    @Override
    public void run() {
        // Default action when no subcommand is provided
        System.out.println("Usage: alfresco [-hV] [COMMAND]");
        System.out.println("Commands:");
        System.out.println("  config  Configuration commands");
        System.out.println("  acs     Alfresco Content Services commands");
    }
}
