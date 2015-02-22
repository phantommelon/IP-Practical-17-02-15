
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

/**
 * Steps the user back one Command.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.0
 */
public class StepBackCommand extends Command {
    
    /**
     * Constructs a new StepBackCommand object giving the superclass the name
     * stepback by default.
     */
    public StepBackCommand() {
        super("stepback");
        this.addSubCommand(new HelpCommand());
    }
    
    /**
     * Performs the functionality of the StepBack command.
     * 
     * @param company
     */
    @Override
    public void execute(Company company) {
        this.getPreviousCommand().setLoop(false);
        System.out.println();
    }
    
    @Override
    public void help() {
        System.out.println("Cancels the current action and returns to the " +
                "previous command. \n");
    }
}
