package com.labs.config;

import picocli.CommandLine.Command;

@Command(name = "config", description = "Configuration commands")
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Usage: alfresco config [COMMAND]");
        System.out.println("Commands:");
        System.out.println("  acs  Set configuration for ACS.");
    }
}
