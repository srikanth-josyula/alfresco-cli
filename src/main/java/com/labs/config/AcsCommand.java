package com.labs.config;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "acs", description = "Alfresco Content Services commands")
public class AcsCommand implements Runnable {

	@Command(name = "acs", description = "Set configuration for ACS.")
	public Integer acs(
			@Parameters(index = "0", description = "Alfresco Content Services URL (example >> \"http://localhost:8080\")") String url,
			@Parameters(index = "1", description = "Alfresco Content Services Username") String username,
			@Parameters(index = "2", description = "Alfresco Content Services Password") String password) {

		System.out.println("Configuring ACS with:");
		System.out.println("URL: " + url);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		return 0;
	}

	@Override
	public void run() {
		System.out.println("Usage: alfresco acs [COMMAND]");
		System.out.println("Commands:");
		// List ACS specific commands here
	}
}
