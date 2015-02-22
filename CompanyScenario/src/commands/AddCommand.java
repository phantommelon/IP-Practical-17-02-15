
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
import control.Control;

/**
 * Superclass for all Commands that add to the program.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.2
 */
public class AddCommand extends Command {
    
    public AddCommand() {
        super("add");
        this.addSubCommand(new CancelCommand());
        this.addSubCommand(new ExitCommand());
        this.addSubCommand(new HelpCommand());
    }
    
    @Override
    public void execute(Company company) {
        this.setLoop(true);
        
        System.out.println("Add what?");
        System.out.println(this.getSubCommands().keySet());
        System.out.println();
        
        Control.getInput(this, company);
    }
    
    @Override
    public void help() {
        System.out.println("The add command can be used to add to the company.");
        System.out.println("usage: add " + this.getSubCommands().keySet());
        System.out.println("To find out more about any given command, type: ");
        System.out.println("add [command] help");
        System.out.println();
    }
}
