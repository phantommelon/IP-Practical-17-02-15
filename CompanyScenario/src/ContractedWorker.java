
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
 * Describes an Employee with a contract of any kind.
 * 
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.4
 */

public class ContractedWorker extends Employee {
    
    private Salary salary;
    
    public ContractedWorker(String name, String address, String role, int employeeNumber,
            Salary salary) {
        
        super(name, address, role, employeeNumber);
        this.salary = salary;
    }
    
    public ContractedWorker(String name, String address, Share share, String role, 
            int employeeNumber, Salary salary) {
        
        super(name, address, share, role, employeeNumber);
        this.salary = salary;
    }
    
    public Salary getSalary() {
        return salary;
    }
    
    public void setSalary(double salaryAmount, String salaryPaymentSchedule) {
        salary = new Salary(salaryAmount, salaryPaymentSchedule);
    }
    
    @Override
    public String getDescription() {
        
        String description = super.getDescription();
        
        description += "Paid: " + Character.toUpperCase(salary.getPaymentSchedule().charAt(0)) + 
                salary.getPaymentSchedule().substring(1) + "\n";
        
        return description;
    }
}
