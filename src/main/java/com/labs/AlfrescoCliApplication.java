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
    public void run(String... args) {
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
                    String[] words = input.split("\\s+");
                    if (words.length > 0) {
                        String firstWord = words[0];
                        if ("alfresco".equals(firstWord)) {
                            // Parse the remaining arguments and execute
                            String[] remainingArgs = new String[words.length - 1];
                            System.arraycopy(words, 1, remainingArgs, 0, remainingArgs.length);
                            CommandLine commandLine = new CommandLine(alfrescoCommand);
                            commandLine.execute(remainingArgs);
                        } else {
                            System.out.println("Type 'alfresco --help' for global help.");
                        }
                    }
                }
            }
        }
    }
}
