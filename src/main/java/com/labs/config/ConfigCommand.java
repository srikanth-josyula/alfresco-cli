package com.labs.config;

import java.util.Base64;

import com.labs.model.ConfigModel;
import com.labs.model.ConfigStore;

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
            // Print usage help if any parameter is missing
    		 new picocli.CommandLine(this).usage(System.out);
            return;
        }

        String credentials = username + ":" + password;
        String base64Credentials = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

        ConfigModel configModel = new ConfigModel(alfrescoUrl, base64Credentials);
        // Store the configuration in the ConfigStore
        ConfigStore.getInstance().setConfigModel(configModel);
        
        System.out.println(configModel);
    }
}
