package com.labs.config;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "config", description = "Configuration commands")
public class ConfigCommand implements Runnable {

    @Parameters(index = "0", 
    		paramLabel = "<alfresco-url>", 
    		description = "The URL of the Alfresco server.")
    private String alfrescoUrl;

    @Parameters(index = "1", 
    		paramLabel = "<username>", 
    		description = "The username for authentication.")
    private String username;

    @Parameters(index = "2", 
    		paramLabel = "<password>", 
    		description = "The password for authentication.")
    private String password;

    @Override
    public void run() {
        if (alfrescoUrl == null || username == null || password == null) {
            new CommandLine(this).usage(System.out);
            return;
        }

        // Add your configuration logic here
        System.out.println("Configuring with:");
        System.out.println("Alfresco URL: " + alfrescoUrl);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
