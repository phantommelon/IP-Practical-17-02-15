
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
import company.Person;
import company.Share;
import java.util.Scanner;

/**
 * Command to add a Person to the Company.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.0
 */

public class AddPersonCommand extends AddCommand {

    public AddPersonCommand() {
        super("person");
        this.addSubCommand(new HelpCommand());
        this.addSubCommand(new CancelCommand());
        this.addSubCommand(new StepBackCommand());
    }
    
    @Override
    public void execute(Company company) {
        boolean successful = false;
        
        System.out.println();
        System.out.print("Name: ");
        
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        
        if(this.checkNotCancel(name)) {
            System.out.println();
            return;
        }
        
        System.out.print("Address: ");
        String address = scanner.nextLine();
         
        if(this.checkNotCancel(address)) {
            System.out.println();
            return;
        }
        
        int numberOfShares = -1;
        
        do{
            System.out.print("Number of shares: ");
            String shares = scanner.nextLine();
            
            if(this.checkNotCancel(shares)) {
                System.out.println();
                return;
            }
            
            try {
                numberOfShares = Integer.valueOf(shares);
                successful = true;
            }
            catch(NumberFormatException ex) {
                System.out.println("You entered " + shares + ".");
                System.out.println("The number of shares should be entered as an " +
                        "integer, i.e. 60.");
                System.out.println("Please try again." + "\n");
            }
        }
        while(successful == false);
        
        successful = false;
        double dividendPerShare = -1;
        
        //In an ideal world, the share dividend would be updated based on the
        //current stock price.
        do{
            System.out.print("Dividend per share: ");
            String dividend = scanner.nextLine();
            
            if(this.checkNotCancel(dividend)) {
                System.out.println();
                return;
            }
            
            try {
                dividendPerShare = Double.valueOf(dividend);
                successful = true;
            }
            catch(NumberFormatException ex) {
                System.out.println("You entered " + dividend + ".");
                System.out.println("The dividend should be entered as a " +
                        "decimal i.e. 0.43.");
                System.out.println("Please try again." + "\n");
            }
        }
        while(successful == false);
        
        
        company.addPerson(new Person(name, address, new Share(numberOfShares,
                dividendPerShare)));
        
        System.out.print("\n" + "Created person " + name + "\n" + "\n");
    }

    private boolean checkNotCancel(String input) {
        if(input.equals("cancel")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public void help() {
        System.out.println("The add person command adds a person to the company.");
        System.out.println("This command will ask for name, address and share " +
                "information of the person to be added to the company files.");
        System.out.println();
    }
    
}
