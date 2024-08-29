package com.labs.acs.nodes.actions;

import com.labs.model.ConfigModel;
import com.labs.model.ConfigStore;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "download", description = "Download a node from Alfresco using its node ID.")
public class DownloadCommand implements Runnable {

	@Parameters(index = "0", paramLabel = "<node-id>", description = "The ID of the node to download.")
	private String nodeId;
	
	@Override
    public void run() {

		// Retrieve the configuration from the ConfigStore
        ConfigModel authModel = ConfigStore.getInstance().getConfigModel();
        
        if (authModel != null) {
            System.out.println("Downloading node with ID: " + nodeId);
            System.out.println("Using Alfresco URL: " + authModel.getAlfrescoUrl());
            System.out.println("Base64 Auth Credentials: " + authModel.getBase64Credentials());

           //TODO http Request
            
        } else {
            System.out.println("No configuration found. Please run the 'config' command first.");
        }
    }
}
