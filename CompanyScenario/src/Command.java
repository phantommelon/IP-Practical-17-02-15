
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

/**
 * Contains a command and it's help information.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.4
 */
public class Command {
    
    private String commandName;
    private Map<String, Command> subCommands = new HashMap<>();
    private List<Command> previousCommands = new ArrayList<>();
    private boolean keepLooping = true;
    
    public Command() {
        this.commandName = "main";
        subCommands.put("exit", new ExitCommand());
        subCommands.put("add", new AddCommand());
    }
    
    public Command(String commandName) {
        this.commandName = commandName;
    }
    
    //Don't think these are needed
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
     * @param lastCommand
     * @param company
     * @throws InvalidCommandException 
     */
    private void processCommand(List<String> userInput, Map<String, Command> commands,
            List<Command> previousCommands, Company company) throws InvalidCommandException {
        
        Command command = commands.get(userInput.get(0));
        Command previousCommand = previousCommands.get(previousCommands.size() - 1);
        
        //these specific cases are not needed
        if(userInput.get(0).equals("help")) {
            this.help();
            return;
        }
        
        if(command == null) {
            throw new InvalidCommandException(previousCommand);
        }
        
        else if(userInput.size() == 1) {
            command.execute(company, previousCommands);
        }
        
        //perhaps not needed if a HelpCommand is created
        else if(userInput.size() == 2 && userInput.get(1).equals("help")) {
            command.help();
        }
        
        else {
            userInput.remove(0);
            processCommand(userInput, command.getSubCommands(), previousCommands, company);
        }
        
    }
    
    public void getInput(Command command, Company company) {
        while(keepLooping) {
            ArrayList<String> commandStrings = new ArrayList<>();
            this.previousCommands.add(command);
            
            Scanner scanner = new Scanner(System.in);
            String commands = scanner.nextLine();
            commandStrings.addAll(Arrays.asList(commands.split(" ")));
            
            if(!commandStrings.get(0).equals("")) {
                
                try {
                    command.processCommand(commandStrings, command.getSubCommands(),
                            previousCommands, company);
                } 
                
                catch (InvalidCommandException ex) {
                    
                    Command previousCommand = ex.getPreviousCommand();
                    
                    System.out.println("Unknown command: " + commandStrings.get(0));
                    System.out.print("Valid commands are: ");
                    System.out.print(previousCommand.getSubCommands().keySet());
                    System.out.println("\n");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        Company company = new Company();
        
        Command console = new Command();
        System.out.println("Company Scenario V1.0 - Please enter a valid command: \n");
        
        console.getInput(console, company);
        
    }
    
    /**
     * Returns the Command to which the String input commandName is mapped,
     * or null if the subCommands Map contains no mapping for commandName.
     * @param commandName
     * @return 
     */
    public Command getCommand(String commandName) {
        return subCommands.get(commandName);
    }
    
    public void addSubCommand(Command command) {
        subCommands.put(command.getName(), command);
    }
    
    public String getName() {
        return commandName;
    }
    
    public Map<String, Command> getSubCommands() {
        return subCommands;
    }
    
    public void help() {
        System.out.println("The valid commands are:");
        
        for(String thisCommandName : subCommands.keySet()) {
            System.out.print(thisCommandName + " ");
        }
        
        System.out.println();
    }

    public void execute(Company company, List<Command> previousCommands) {
        this.help();
    }
    
    public void setLoop(boolean state) {
        this.keepLooping = state;
    }

}
