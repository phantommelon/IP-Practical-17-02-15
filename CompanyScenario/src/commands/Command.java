
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

package commands;


import company.Company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains a command and it's help information.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.5
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
        subCommands.put("help", new HelpCommand());
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
        System.out.println("At command " + this.getName() + ".");
        System.out.println("The valid commands are:");
        System.out.println(this.getSubCommands().keySet());
        System.out.println();
    }

    public void execute(Company company) {
        this.help();
    }
    
    public boolean getLoop() {
        return keepLooping;
    }
    
    public void setLoop(boolean state) {
        this.keepLooping = state;
    }
    
    public List<Command> getPreviousCommands() {
        return previousCommands;
    }
    
    public Command getPreviousCommand() {
        
        if(previousCommands.size() > 0) {
            return previousCommands.get(previousCommands.size() - 1);
        }
        else {
            return null;
        }
    }
    
    public void addPreviousCommand(Command command) {
        previousCommands.add(command);
    }
    
    public void addPreviousCommands(List<Command> previousCommands) {
        this.previousCommands.addAll(previousCommands);
    }
    
    public void resetPreviousCommands() {
        this.previousCommands.clear();
    }

}
