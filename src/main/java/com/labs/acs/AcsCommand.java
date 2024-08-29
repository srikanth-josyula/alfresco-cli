package com.labs.acs;

import com.labs.acs.nodes.NodeCommand;
import picocli.CommandLine.Command;

@Command(
    name = "acs",
    description = "Alfresco Content Services Commands",
    subcommands = {NodeCommand.class},
    mixinStandardHelpOptions = true,
    usageHelpAutoWidth = true
)
public class AcsCommand implements Runnable {

    @Override
    public void run() {
        // Display the help message for the ACS command
        new picocli.CommandLine(this).usage(System.out);
    }
}
