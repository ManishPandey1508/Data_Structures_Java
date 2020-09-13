package Temp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class GumballMachineTest {

	GumballMachine gm1;
	GumballMachine gm2;
	GumballMachine gm3;

	@BeforeAll
	void createGumballMachines() {
		System.out.println(" Before each Test case, Gumball Machine 1,2 and 3 object will be created and intialized with size 5");
	}

	@BeforeEach
	void resetGumballCount() {
		gm1 = new GumballMachine(5, 25, 0);
		gm1.setQuarterCount(0);
		gm1.setDimeCount(0);
		gm1.setNickelCount(0);
	
		gm2 = new GumballMachine(5, 50, 1);
		gm2.setQuarterCount(0);
		gm2.setDimeCount(0);
		gm2.setNickelCount(0);
		
		gm3 = new GumballMachine(5, 50, 2);
		gm3.setQuarterCount(0);
		gm3.setDimeCount(0);
		gm3.setNickelCount(0);
	}

	@Test
	void testGumBallMachine1Test1() {

		System.out.println("################################# Machine 1 Test Case 1 ################################");
		System.out.println("Test Case 1: Turning crank without inserting quarter For Machine 1 ");
		assertEquals(gm1.turnCrank(), "Please insert a valid Coin to collect a Gumball");
		assertEquals(5, gm1.getNum_gumballs());
	}

	@Test
	void testGumballMachine1Test2() {
		System.out.println("################################# Machine 1 Test Case 2 ################################");

		System.out.println("Test Case 2: Turning crank after inserting Quarter");
		gm1.insertCoin(25);
		assertEquals(gm1.turnCrank(), "Collect your Gumball");
		assertEquals(4, gm1.getNum_gumballs());

	}

	@Test
	void testGumballMachine1Test3() {
		System.out.println("################################# Machine 1 Test Case 3 ################################");
		System.out
				.println("Test Case 3: Turning crank after inserting Nikel which is ivalid coin for Gumball Machine1");
		gm1.insertCoin(5);
		assertEquals(gm1.turnCrank(), "Please insert a valid Coin to collect a Gumball");
		assertEquals(5, gm1.getNum_gumballs());
	}

	@Test
	void testGumballMachine1Test4() {
		System.out.println("################################# Machine 1 Test Case 4 ################################");
		System.out.println("Test Case 4: creating an Empty Gumball Machine1, insert quarter and turn crank ");
		List<Integer> den = new ArrayList<>();
		den.add(25);
		gm1 = new GumballMachine(0, 25, 0);
		gm1.insertCoin(25);
		assertEquals(gm1.turnCrank(), "Sorry!! No Gumballs left");
		assertEquals(0, gm1.getNum_gumballs());
	}

	@Test
	void testGumBallMachine2Test1() {

		System.out.println("################################# Machine 2 Test Case 1 ################################");
		System.out.println("Test Case 1: Turning crank without inserting quarter For Machine 2");
		assertEquals(gm2.turnCrank(), "Please insert a valid Coin to collect a Gumball");
		assertEquals(5, gm2.getNum_gumballs());
	}

	@Test
	void testGumballMachine2Test2() {
		System.out.println("################################# Machine 2 Test Case 2 ################################");

		System.out.println("Test Case 2: Turning crank after inserting 1 Quarter");
		gm2.insertCoin(25);
		assertEquals(gm2.turnCrank(), "Insert one more quarter to get Gumball");
		assertEquals(5, gm2.getNum_gumballs());

	}

	@Test
	void testGumballMachine2Test3() {
		System.out.println("################################# Machine 2 Test Case 3 ################################");
		System.out.println("Test Case 2: Turning crank after inserting 2 Quarter");
		gm2.insertCoin(25);
		gm2.insertCoin(25);
		assertEquals(gm2.turnCrank(), "Collect your Gumball");
		assertEquals(4, gm2.getNum_gumballs());

	}

	@Test
	void testGumballMachine2Test4() {
		System.out.println("################################# Machine 2 Test Case 4 ################################");
		System.out.println("Test Case 3: Turning crank after inserting Nikel which is invalid coin for Gumball Machine1");
		gm2.insertCoin(5);
		assertEquals(gm2.turnCrank(), "Please insert a valid Coin to collect a Gumball");
		assertEquals(5, gm2.getNum_gumballs());
	}

	@Test
	void testGumballMachine2Test5() {
		System.out.println("################################# Machine 2 Test Case 5 ################################");
		System.out.println("Test Case 4: creating an Empty Gumball Machine1, insert 2 quarters and turn crank ");
		gm2 = new GumballMachine(0, 50, 1);
		gm2.insertCoin(25);
		gm2.insertCoin(25);
		assertEquals(gm2.turnCrank(), "Sorry!! No Gumballs left");
		assertEquals(0, gm2.getNum_gumballs());
	}

	@Test
	void testGumBallMachine3Test1() {

		System.out.println("################################# Machine 3 Test Case 1 ################################");
		System.out.println("Test Case 1: Turning crank without inserting any coin For Machine 3");
		assertEquals(gm3.turnCrank(), "Please insert a valid Coin to collect a Gumball");
		assertEquals(5, gm3.getNum_gumballs());
	}

	@Test
	void testGumballMachine3Test2() {
		System.out.println("################################# Machine 3 Test Case 2 ################################");

		System.out.println("Test Case 2: Turning crank after inserting 1 Quarter 1 Dime 1 Nickel");
		gm3.insertCoin(25);
		gm3.insertCoin(10);
		gm3.insertCoin(5);
		assertEquals(gm3.turnCrank(), "Insert " + 10 + " to get Gumball");
		assertEquals(5, gm3.getNum_gumballs());

	}

	@Test
	void testGumballMachine3Test3() {
		System.out.println("################################# Machine 3 Test Case 3 ################################");
		System.out.println("Test Case 2: Turning crank after inserting 2 Quarter");
		gm3.insertCoin(25);
		gm3.insertCoin(25);
		assertEquals(gm3.turnCrank(), "Collect your Gumball");
		assertEquals(4, gm3.getNum_gumballs());

	}

	@Test
	void testGumballMachine3Test4() {
		System.out.println("################################# Machine 3 Test Case 4 ################################");
		System.out
				.println("Test Case 3: Turning crank after inserting 9 Nickel and 1 Dime ");
		gm3.insertCoin(5);
		gm3.insertCoin(5);
		gm3.insertCoin(5);
		gm3.insertCoin(5);
		gm3.insertCoin(5);
		gm3.insertCoin(5);
		gm3.insertCoin(5);
		gm3.insertCoin(5);
		gm3.insertCoin(5);
		gm3.insertCoin(10);
		assertEquals(gm3.turnCrank(), "Collect your Gumball");
		assertEquals(4, gm3.getNum_gumballs());
	}

	@Test
	void testGumballMachine3Test5() {
		System.out.println("################################# Machine 3 Test Case 5 ################################");
		System.out.println("Test Case 4: creating an Empty Gumball Machine1, insert 2 quarters and turn crank ");
		gm3 = new GumballMachine(0, 50, 1);
		gm3.insertCoin(25);
		gm3.insertCoin(25);
		assertEquals(gm3.turnCrank(), "Sorry!! No Gumballs left");
		assertEquals(0, gm3.getNum_gumballs());
	}

}
