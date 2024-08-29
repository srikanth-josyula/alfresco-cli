package com.labs.acs.nodes;

import picocli.CommandLine.Command;

@Command(name = "node", description = "Node commands")
public class NodeCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Node command executed.");
    }
}
