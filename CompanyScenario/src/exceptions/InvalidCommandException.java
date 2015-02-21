
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

package exceptions;


import commands.Command;

/**
 * A custom exception thrown when user input does not match a command phrase.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.1
 */
public class InvalidCommandException extends Exception {

    private Command command;
    
    public InvalidCommandException(Command command) {
        this.command = command;
    }

    public Command getPreviousCommand() {
        return command;
    }
}
