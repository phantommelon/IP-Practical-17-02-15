
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
import java.util.List;

/**
 * This Command cancels what the user was doing and returns to the beginning of
 * the command tree.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.1
 */
public class CancelCommand extends Command {
    
    /** 
     * Constructs a new CancelCommand object giving the superclass the name 
     * cancel by default.
     */
    public CancelCommand() {
        super("cancel");
        this.addSubCommand(new HelpCommand());
    }
    
    /**
     * Performs the functionality of the CancelCommand.
     * 
     * @param company
     */
    @Override
    public void execute(Company company) {
        
        List<Command> previousCommands = this.getPreviousCommands();
        //Start from i = 1 as not to break out of the last while loop (at the
        //beginning of the program).
        for(int i = 1; i < previousCommands.size(); i++) {
            previousCommands.get(i).setLoop(false);
        }
        System.out.println();
    }
    
    @Override
    public void help() {
        System.out.println("Cancels the current action returning the program to"
                + " the beginning." + "\n");
    }
}
