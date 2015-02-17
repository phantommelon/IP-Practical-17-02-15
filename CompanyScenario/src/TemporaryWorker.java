
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
 * Describes a ContractedWorker having an end date to their employment.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.1
 */

import java.time.*;

public class TemporaryWorker extends ContractedWorker {
    
    LocalDate contractEndDate;
    
    public TemporaryWorker(String name, String address, int employeeNumber,
            Salary salary, int day, int month, int year) {
        
        super(name, address, "Temporary Worker", employeeNumber, checkSalary(salary));
        contractEndDate = LocalDate.of(year, month, day);
    }
    
    public TemporaryWorker(String name, String address, Share share, int employeeNumber,
            Salary salary, int day, int month, int year) {
        
        super(name, address, share, "Temporary Worker", employeeNumber, checkSalary(salary));
        contractEndDate = LocalDate.of(year, month, day);
    }
    
    private static Salary checkSalary(Salary salary) {
        
        try {
            
           salary = (CommissionSalary) salary;
           throw new IllegalArgumentException("Temporary workers cannot have" + 
                   "a CommissionSalary");
        }
        
        catch(ClassCastException ex) {
            return salary;
        }
    }
    
    public LocalDate getContractEndDate() {
        return contractEndDate;
    }
    
    public void setContractEndDate(int day, int month, int year) {
        contractEndDate = LocalDate.of(year, month, day);
    }
    
    @Override
    public String getDescription() {
        
        String description = super.getDescription();
        
        description += "\t" + "- Contract terminates " + contractEndDate.toString() + 
                "\n";
        
        return description;
    }

}
