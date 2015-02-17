
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

/**A JUnit test for the Company class.
 *
 * @author Alistair Madden <phantommelon@gmail.com>
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompanyTest {
    
    public CompanyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addPerson method, of class Company.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson" + "\n");
        Person person = new ContractedWorker("Bob Williams", "1 Sutton Street", 
        "Sales", 24601, new CommissionSalary(500, "weekly", 0.4));
        Company instance = new Company();
        instance.addPerson(person);
        instance.getInformation("Bob Williams");
    }

    /**
     * Test of listAllPeople method, of class Company.
     */
    @Test
    public void testListAllPeople() {
        System.out.println("listAllPeople" + "\n");
        Person person = new ContractedWorker("Bob Williams", "1 Sutton Street", 
        "Sales", 24601, new CommissionSalary(500, "weekly", 0.4));
        Company instance = new Company();
        instance.addPerson(person);
        instance.listAllPeople();
    }

    /**
     * Test of calculatePayment method, of class Company.
     */
    @Test
    public void testCalculatePayment() {
        System.out.println("calculatePayment" + "\n");
        Person person = new ContractedWorker("Bob Williams", "1 Sutton Street", 
        "Sales", 24601, new CommissionSalary(500, "weekly", 0.4));
        Company instance = new Company();
        instance.addPerson(person);
        instance.calculatePayment();
    }
    
}
