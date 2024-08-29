package com.labs.acs;

import com.labs.acs.nodes.NodeCommand;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
    name = "acs",
    description = "Alfresco Content Services commands",
    subcommands = {
        NodeCommand.class,      // Add other subcommands here
    },
    mixinStandardHelpOptions = true,
    usageHelpAutoWidth = true,
    subcommandsRepeatable = true
)
public class AcsCommand implements Runnable {

    @Override
    public void run() {
        CommandLine cmd = new CommandLine(this);
        cmd.usage(System.out);
    }
}

