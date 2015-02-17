
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

/**
 * Describes an Employee of the company.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.4
 */

public class Employee extends Person {
    
    private String role;
    private int employeeNumber;
    private double hoursWorked;
    
    public Employee(String name, String address, String role, int employeeNumber) {
        
        super(name, address);
        this.role = role;
        this.employeeNumber = employeeNumber;
        hoursWorked = 0;
    }
    
    public Employee(String name, String address, Share share, String role, 
            int employeeNumber) {
        
        super(name, address, share);
        this.role = role;
        this.employeeNumber = employeeNumber;
        hoursWorked = 0;
    }

    public Employee(String name, String address, String role, int employeeNumber,
            double hoursWorked) {
        
        super(name, address);
        this.role = role;
        this.employeeNumber = employeeNumber;
        this.hoursWorked = hoursWorked;
    }
    
    public Employee(String name, String address, String role, int employeeNumber, 
            Share share, double hoursWorked) {
        
        super(name, address, share);
        this.role = role;
        this.employeeNumber = employeeNumber;
        this.hoursWorked = hoursWorked;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    public String getRole() {
        return role;
    }
    
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    @Override
    public String getDescription() {
        
        String description = super.getDescription();
        
        description += "Employee Number: " + employeeNumber + "\n" + "Role: " + 
                role + "\n" + "Worked " + hoursWorked + " hours" + "\n";
        
        return description;
    }
}
