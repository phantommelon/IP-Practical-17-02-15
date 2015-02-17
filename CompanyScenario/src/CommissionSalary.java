
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
 * Salary with fixed commission.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.0
 */

public class CommissionSalary extends Salary {
    
    private double commission;
    private int sales;

    public CommissionSalary(double amount, String paymentSchedule, double commission) {
        
        super(amount, paymentSchedule);
        this.commission = commission;
        sales = 0;
    }
    
    public CommissionSalary(double amount, String paymentSchedule, double commission, 
            int sales) {
        
        super(amount, paymentSchedule);
        this.commission = commission;
        this.sales = sales;
    }
    
    public double getCommission() {
        return commission;
    }
    
    public int getSales() {
        return sales;
    }
    
    public void setCommission(double commission) {
        this.commission = commission;
    }
    
    public void setSales(int sales) {
        this.sales = sales;
    }
    
}
