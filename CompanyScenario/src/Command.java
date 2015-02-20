
/*
 * Copyright 2015 Alistair Madden <phantommelon@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Contains a command and it's help information.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.3
 */

public class Command {
    
    private String commandName;
    private Map<String, Command> subCommands = new HashMap<>();
    
    public Command() {
        subCommands.put("exit", new ExitCommand());
    }
    
    public Command(String commandName) {
        this.commandName = commandName;
    }
    
    public Command(String commandName, Command subCommand) {
        this.commandName = commandName;
        subCommands.put(subCommand.getName(), subCommand);
    }
    
    public Command(String commandName, List<Command> subCommands) {
        this.commandName = commandName;
        for(Command subCommand : subCommands) {
            this.subCommands.put(subCommand.getName(), subCommand);
        }
    }
    
    /**
     * Given a List of Strings, executes the correct command (if valid).
     * 
     * @param userInput List of String objects representing Commands to be processed.
     * @param commands A Map containing the current Command's subcommands.
     * @throws InvalidCommandException 
     */
    private void processCommand(List<String> userInput, Map<String, Command> commands,
            Command lastCommand) throws InvalidCommandException {
        
        Command command = commands.get(userInput.get(0));
        
        if(userInput.get(0).equals("help")) {
            this.help();
            return;
        }
        
        if(command == null) {
            throw new InvalidCommandException(lastCommand);
        }
        
        else if(userInput.size() == 1) {
            command.execute();
        }
        
        else if(userInput.size() == 2 && userInput.get(1).equals("help")) {
            command.help();
        }
        
        else {
            userInput.remove(0);
            processCommand(userInput, command.getSubCommands(), command);
        }
        
    }
    
    public static void main(String[] args) {
        
        Command console = new Command();
        System.out.println("Company Scenario V1.0 - Please enter a valid command: \n");
        
        while(true) {
            ArrayList<String> commandStrings = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);
            String commands = scanner.nextLine();
            commandStrings.addAll(Arrays.asList(commands.split(" ")));
            
            if(!commandStrings.get(0).equals("")) {
                
                try {
                    console.processCommand(commandStrings, console.getSubCommands(),
                            null);
                } 
                
                catch (InvalidCommandException ex) {
                    
                    Command previousCommand = ex.getPreviousCommand();
                    
                    System.out.println("Unknown command: " + commandStrings.get(0));
                    System.out.print("Valid commands are: ");
                    
                    if(previousCommand == null) {
                        System.out.print(console.getSubCommands().keySet());
                    }
                    else {
                        System.out.print(previousCommand.getSubCommands().keySet());
                    }
                    
                    System.out.println("\n");
                }
            }
        }
    }
    
    public Command getCommand(String commandName) {
        return subCommands.get(commandName);
    }
    
    public String getName() {
        return commandName;
    }
    
    public Map<String, Command> getSubCommands() {
        return subCommands;
    }

    public void execute() {
        this.help();
    }
    
    public void help() {
        System.out.println("The valid commands are:");
        
        for(String thisCommandName : subCommands.keySet()) {
            System.out.print(thisCommandName + " ");
        }
        
        System.out.println();
    }

}
