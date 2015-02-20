
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Initiates and runs the CompanyScenario based on user input.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.1
 */
public class Main {
    
    private Map<String, Command> commands;
    
    public Main() {
        commands = new HashMap<>();
        //use class name in future
        commands.put("help", new Command("help"));
    }
    
    private void processCommand(List<String> userInput, Map<String, Command> commands) throws InvalidCommandException {
        
        Command command = commands.get(userInput.get(0));
        
        if(command == null) {
            throw new InvalidCommandException();
        }
        
        else if(userInput.size() == 1) {
            command.execute();
        }
        
        else {
            userInput.remove(0);
            processCommand(userInput, command.getSubCommands());
        }
        
    }
    
    public static void main(String[] args) throws InvalidCommandException {
        
        Main main = new Main();
        System.out.println("Company Scenario V1.0 - Please enter a valid command: \n" );
        
        while(true) {
            ArrayList<String> commandStrings = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);
            String commands = scanner.nextLine();
            commandStrings.addAll(Arrays.asList(commands.split(" ")));
            
            if(commandStrings.get(0).equals("exit")) {
                System.exit(0);
            }
            
            if(!commandStrings.get(0).equals("")) {
                main.processCommand(commandStrings, main.commands);
            }
        }
    }
    
}
