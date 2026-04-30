package com.crio.xlido.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInvoker {

    private Map<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void executeCommand(String input) {
        List<String> tokens = List.of(input.split(" "));
        String commandName = tokens.get(0);

        Command command = commandMap.get(commandName);

        if (command != null) {
            command.execute(tokens);
        } else {
            System.out.println("Invalid Command");
        }
    }
}