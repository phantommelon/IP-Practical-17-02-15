
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

package control;

import commands.Command;
import company.Company;
import exceptions.InvalidCommandException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a description of class Control here.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.3
 */
public class Control {
    
    /**
     * Given a List of Strings, executes the correct command (if valid).
     * 
     * @param userInput List of String objects representing Commands to be processed.
     * @param commands A Map containing the current Command's subcommands.
     * @param command The Command that requested this method.
     * @param company The Company to perform the Command on.
     * @throws InvalidCommandException 
     */
    public static void processCommand(List<String> userInput, Map<String, Command> commands,
            Command command, Company company) throws InvalidCommandException {
        
        Command newCommand = commands.get(userInput.get(0));
        
        if(newCommand == null) {
            throw new InvalidCommandException(command);
        }
        
        //If newCommand hasn't already been traversed (by help for example)
        if(newCommand.getPreviousCommands().isEmpty()) {
            newCommand.addPreviousCommands(command.getPreviousCommands());
            newCommand.addPreviousCommand(command);
        }
        
        if(userInput.size() == 1) {
            newCommand.execute(company);
        }
        
        else {
            userInput.remove(0);
            Control.processCommand(userInput, newCommand.getSubCommands(), newCommand, company);
        }
        
    }
    
    public static void getInput(Command command, Company company) {
        while(command.getLoop()) {
            System.out.print(command.getName() + "> ");
            
            ArrayList<String> commandStrings = new ArrayList<>();
            
            Scanner scanner = new Scanner(System.in);
            String commands = scanner.nextLine();
            commandStrings.addAll(Arrays.asList(commands.split(" ")));
            
            if(!commandStrings.get(0).equals("")) {
                
                try {
                    Control.processCommand(commandStrings, command.getSubCommands(),
                            command, company);
                } 
                
                catch (InvalidCommandException ex) {
                    
                    Command previousCommand = ex.getPreviousCommand();
                    
                    System.out.println("Unknown command: " + commandStrings.get(0));
                    System.out.print("Valid commands for " +
                            previousCommand.getName() + " are: ");
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
        
        Control.getInput(console, company);
        
    }
    
}
