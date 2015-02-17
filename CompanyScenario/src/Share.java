
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
 * Information about a Person's Shares.
 * 
 * @author Alistair Madden <phantommelon@gmail.com> 
 * @version 1.1
 */

public class Share {
    
    private int numberOfShares;
    private double dividend;
    
    public Share(int numberOfShares, double dividend) {
        this.numberOfShares = numberOfShares;
        this.dividend = dividend;
    }
    
    public int getNumberOfShares() {
        return numberOfShares;
    }
    
    public double getDividend() {
        return dividend;
    }
    
    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
    
    public void setDividend(double dividend) {
        this.dividend = dividend;
    }
}
