package com.labs;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.labs.command.AlfrescoCommand;

import picocli.CommandLine;

@SpringBootApplication
public class AlfrescoCliApplication implements CommandLineRunner {

    @Autowired
    private AlfrescoCommand alfrescoCommand;

    public static void main(String[] args) {
        SpringApplication.run(AlfrescoCliApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Type 'exit' to terminate the application.");

			while (true) {
				System.out.print("> ");
				String input = scanner.nextLine().trim();

				if ("exit".equalsIgnoreCase(input)) {
					System.out.println("Exiting...");
					break;
				}

				if (!input.isEmpty()) {
					String[] argsArray = input.split("\\s+");
                    System.out.println("Command: " + String.join(" ", argsArray));
                    CommandLine commandLine = new CommandLine(alfrescoCommand);
                    commandLine.execute(args);
				}
			}
		}
        
    }
}
