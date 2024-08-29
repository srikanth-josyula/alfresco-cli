package com.labs.acs.nodes;

import com.labs.model.ConfigModel;
import com.labs.model.ConfigStore;

import picocli.CommandLine.Command;

@Command(name = "node", description = "Node commands")
public class NodeCommand implements Runnable {

    @Override
    public void run() {
        // Retrieve the configuration from the ConfigStore
        ConfigModel authModel = ConfigStore.getInstance().getConfigModel();
        
        if (authModel != null) {
            System.out.println(authModel.getAlfrescoUrl());
            System.out.println(authModel.getBase64Credentials());
        } else {
            System.out.println("No configuration found. Please run the 'config' command first.");
        }
    }
}
