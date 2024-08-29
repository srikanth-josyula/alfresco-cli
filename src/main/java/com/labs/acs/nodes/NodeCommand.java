package com.labs.acs.nodes;

import com.labs.acs.nodes.actions.DownloadCommand;
import picocli.CommandLine.Command;

@Command(
    name = "node",
    description = "Alfresco Node Commands",
    subcommands = {DownloadCommand.class},
    mixinStandardHelpOptions = true,
    usageHelpAutoWidth = true
)
public class NodeCommand implements Runnable {

    @Override
    public void run() {
        // Display the help message for the node command
        new picocli.CommandLine(this).usage(System.out);
    }
}
