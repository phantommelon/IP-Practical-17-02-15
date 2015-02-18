
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

/**
 * Contains a command and it's help information.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.0
 */

public class Command {
    
    //All commands will be lower case.
    private String command;
    private ArrayList<Command> subCommands = new ArrayList<>();
    
    public Command(String command) {
        this.command = command;
    }
    
    public Command(String command, Command subCommand) {
        this.command = command;
        subCommands.add(subCommand);
    }
    
    public Command(String command, ArrayList<Command> subCommands) {
        this.command = command;
        subCommands.addAll(subCommands);
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
        for(Command command : subCommands) {
            if(command.command.equals(commandName)) {
                return command;
            }
        }
        
        //Maybe not the best?
        return null;
    }
}
