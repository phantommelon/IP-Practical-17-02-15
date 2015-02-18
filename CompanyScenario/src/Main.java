
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
import java.util.Scanner;

/**
 * Initiates and runs the CompanyScenario based on user input.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.1
 */
public class Main {
    
    private ArrayList<Command> commands;
    
    public Main() {
        commands.add(new Command("exit"));
    }
    
    public static void main(String[] args) {
        
        Main main = new Main();
        System.out.println("Company Scenario V1.0 - Please enter a valid command: \n" );
        
        Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()) {
                String token = scanner.next();
                if(scanner.hasNext()) {
                    
                }
            }
        
    }
}
