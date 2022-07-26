package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class CalculatorHomeworkTest {

        private mavenTestNGHomework.Calculator calculator;

        @Test
        public void testSum(){
            int actualResult = calculator.sum(5, 3);
            int expectedResult = 8;
            //Assert.assertEquals(actualResult, expectedResult);
            System.out.println("Saskaitīšanas tests");
            Assert.assertEquals(calculator.sum(-5, 3), -2);
            Assert.assertEquals(calculator.sum(10, 8), 18);
            Assert.assertEquals(calculator.sum(5, 5), 10);
        }

        @Test
        public void testdalisana(){
            System.out.println("Dalīšanas tests");
            Assert.assertEquals(calculator.dalisana (8.2,2.0), 4.1);
        }

        @Test
        public void testreizinasana(){
            System.out.println("Reizināšanas tests");
            Assert.assertEquals(calculator.reizinasana (2,2), 4);
            Assert.assertEquals(calculator.reizinasana (5,2), 10);
            Assert.assertEquals(calculator.reizinasana (-5,3), -15);

        }

        @Test
        public void testatnemsana(){
            System.out.println("Atņemšanas tests");
            Assert.assertEquals(calculator.atnemsana (2,2), 0);
            Assert.assertEquals(calculator.atnemsana (5,-2), 7);
            Assert.assertEquals(calculator.atnemsana (-5,3), -8);

        }

        @BeforeClass
        public void beforeClass(){
            this.calculator = new Calculator();
        }
        @BeforeMethod
        public void izpilditPirmsKatraTesta(){
            System.out.println("Izpildas before test.");
        }
    }
