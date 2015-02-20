
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
import java.util.HashMap;
import java.util.Map;

/**
 * Contains a command and it's help information.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.0
 */

public class Command {
    
    //All commands will be lower case.
    private String commandName;
    private Map<String, Command> subCommands = new HashMap<>();
    
    public Command(String commandName) {
        this.commandName = commandName;
    }
    
    public Command(String commandName, Command subCommand) {
        this.commandName = commandName;
        subCommands.put(subCommand.getName(), subCommand);
    }
    
    public Command(String commandName, ArrayList<Command> subCommands) {
        this.commandName = commandName;
        for(Command subCommand : subCommands) {
            this.subCommands.put(subCommand.getName(), subCommand);
        }
    }
    
    public boolean isFinal() {
        if(subCommands.isEmpty()) {
            return true;
        }
        else {
            return false;
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
        if(!subCommands.isEmpty()) {
            System.out.print(commandName + " has subcommands " + subCommands.keySet());
            System.out.println();
        }
        else {
            System.out.println("This command has not been implemented yet.");
        }
    }
}
